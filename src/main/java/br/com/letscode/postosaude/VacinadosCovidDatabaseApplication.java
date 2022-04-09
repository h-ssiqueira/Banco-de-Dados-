package br.com.letscode.postosaude;

import br.com.letscode.postosaude.paciente.*;
import br.com.letscode.postosaude.profissionais.*;
import br.com.letscode.postosaude.vacina.Vacina;
import br.com.letscode.postosaude.vacina.VacinaRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
@Transactional
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


		//CREATE -  VACINAÇÃO
		Paciente paciente = new Paciente("JOANA SILVA SOUZA", LocalDate.of(1990,9,25), SexoEnum.FEMININO);
		Profissional profSaude = new Profissional("José da Silva", "69955983");
		Vacina vc = new Vacina(326402, "FUNDACAO OSWALDO CRUZ",2249278);
		PacienteVacinado pv = new PacienteVacinado(paciente, profSaude,vc, LocalDate.now(), 2);
		this.pacienteVacinadoRepositorio.save(pv);

		//UPDATE - PACIENTE
		Optional<Paciente> pacienteParaAlterar = this.pacienteRepositorio.findOneByNome("IDIANA ANGELINA BERTOTTI");
		Paciente pacienteAlterado = pacienteParaAlterar.get();
		pacienteAlterado.setData_nascimento(LocalDate.of(1974, 05, 18));
		this.pacienteRepositorio.save(pacienteAlterado);

		//READ - BUSCAR PACIENTE

		// UPDATE em qualquer dado do paciente vacinado
		Optional<PacienteVacinado> pacVacParaAlterar = this.pacienteVacinadoRepositorio.findOneById(20);
		PacienteVacinado pacVacAlterado = pacVacParaAlterar.get();
		pacVacAlterado.getVacina().setCodigoVacina(10500);
		pacVacAlterado.getProfissional().setCodigoRegistro("1967984");
		pacVacAlterado.getPaciente().setNome("ADAO ADALBERTO LIEBGOTTI");
		this.pacienteVacinadoRepositorio.save(pacVacAlterado);

		//READ
		Optional<Paciente> buscarPaciente = this.pacienteRepositorio.findOneByNome("VALDIR DALLA MONTA");
		System.out.println("Resultado da busca: " + buscarPaciente.get());

		//DELETE - HARD DELETE PACIENTE
		//READ com filtros por nome do paciente ou por dose por sexo
		List<PacienteVacinado> repositorioAll = this.pacienteVacinadoRepositorio.findAll().stream()
				.collect(Collectors.toList());
		List<PacienteVacinado> buscar = repositorioAll.stream()
				//.filter(( PacienteVacinado p ) -> p.getPaciente().getNome().contains("VALDIR"))
				//.filter(( PacienteVacinado p ) -> p.getDose().equals(2)
				.filter(( PacienteVacinado p ) -> p.getPaciente().getSexo().equals(SexoEnum.FEMININO)
						).collect(Collectors.toList());
		System.out.println("Resultado da busca:");
		buscar.stream().forEach(System.out::println);




		//DELETE
		Optional<Paciente> consultaPaciente = this.pacienteRepositorio.findOneByNome("JOANA SILVA SOUZA");
		this.pacienteVacinadoRepositorio.deleteByPacienteId(consultaPaciente.get().getId());
		Optional<Paciente> verificaPacienteDeletado = this.pacienteRepositorio.findOneByNome("JOANA SILVA SOUZA");
		System.out.println("Ao deletar o paciente vacinado é verificado se ele também foi apagado do banco de dados, se sim, vai aparecer Optional.empty: " + verificaPacienteDeletado);

		//DELETE - SOFT DELETE PROFISSIONAL
		Optional<Profissional> profissionalParaAlterar = this.profissionalRepositorio.findOneByCodigoRegistro("1964981");
		Profissional profissional = profissionalParaAlterar.get();
		profissional.setDeleted_at(LocalDate.now());
		profissional.setDeleted_by("Camily");
		this.profissionalRepositorio.save(profissional);
	}
}