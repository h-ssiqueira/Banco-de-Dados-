package br.com.letscode.postosaude;

import br.com.letscode.postosaude.paciente.*;
import br.com.letscode.postosaude.profissionais.*;
import br.com.letscode.postosaude.vacina.Vacina;
import br.com.letscode.postosaude.vacina.VacinaRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.*;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class VacinadosCovidDatabaseApplication implements CommandLineRunner {

	@PersistenceContext
	private EntityManager manager;
	private final PacienteRepositorio pacienteRepositorio;
	private final VacinaRepositorio vacinaRepositorio;
	private final ProfissionalRepositorio profissionalRepositorio;
	private final PacienteVacinadoRepositorio pacienteVacinadoRepositorio;

	public VacinadosCovidDatabaseApplication(
											 PacienteRepositorio pacienteRepositorio,
											 VacinaRepositorio vacinaRepositorio,
											 ProfissionalRepositorio profissionalRepositorio,
											 PacienteVacinadoRepositorio pacienteVacinadoRepositorio)
		{
			this.pacienteRepositorio = pacienteRepositorio;
			this.vacinaRepositorio = vacinaRepositorio;
			this.profissionalRepositorio = profissionalRepositorio;
			this.pacienteVacinadoRepositorio = pacienteVacinadoRepositorio;
		}

	public static void main(String[] args) {
		SpringApplication.run(VacinadosCovidDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		//CREATE
		Paciente paciente = new Paciente("JOANA SILVA SOUZA", LocalDate.of(1990,9,25), SexoEnum.FEMININO);
		Profissional profSaude = new Profissional("69955983" , CargosEnum.PROFISSIONAL_SAUDE);
		Vacina vc = new Vacina(326402, "FUNDACAO OSWALDO CRUZ",2249278);
		PacienteVacinado pv = new PacienteVacinado(paciente, profSaude,vc, LocalDate.now(), 2);
		this.pacienteVacinadoRepositorio.save(pv);

		//UPDATE
		Optional<Paciente> pacienteParaAlterar = this.pacienteRepositorio.findOneByNome("IDIANA ANGELINA BERTOTTI");
		Paciente pacienteAlterado = pacienteParaAlterar.get();
		pacienteAlterado.setData_nascimento(LocalDate.of(1974, 05, 18));
		this.pacienteRepositorio.save(pacienteAlterado);

		//READ
		Optional<Paciente> readPaciente = this.pacienteRepositorio.findOneByNome("JOANA SILVA SOUZA");
		Paciente pacienteRead = readPaciente.get();
		Optional<PacienteVacinado> pacienteVacinado = this.pacienteVacinadoRepositorio.findOneById(2);
		PacienteVacinado vacinado = pacienteVacinado.get();
		Optional<Vacina> vacina1 = this.vacinaRepositorio.findOneById(1);
		Vacina readVacina = vacina1.get();

		//DELETE
		Optional<Paciente> deletePaciente = this.pacienteRepositorio.findOneById(1);
		Paciente deletarPaciente = deletePaciente.get();
		manager.remove(deletarPaciente);
//
//		@Cascade()
//		Optional<Paciente> pacienteDelete = this.pacienteRepositorio.findOneById(2);
//		Paciente deletePaciente = pacienteDelete.get();
//		this.pacienteRepositorio.deleteById(2);
//		this.pacienteRepositorio.save(deletePaciente);

//		Optional<Paciente> pacienteqq = this.pacienteRepositorio.findOneById(2);
//		Paciente pp = pacienteqq.get();
//		this.pacienteRepositorio.deleteById(2);
//		this.pacienteRepositorio.save(pp);
	}
}