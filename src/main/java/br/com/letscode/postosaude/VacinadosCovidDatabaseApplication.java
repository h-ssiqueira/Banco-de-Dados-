package br.com.letscode.postosaude;

import br.com.letscode.postosaude.model.*;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import br.com.letscode.postosaude.repository.PacienteVacinadoRepositorio;
import br.com.letscode.postosaude.repository.ProfissionalRepositorio;
import br.com.letscode.postosaude.repository.VacinaRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		/*
		//CREATE -  VACINAÇÃO
		Paciente paciente = new Paciente("JOANA SILVA SOUZA", LocalDate.of(1990,9,25), SexoEnum.FEMININO);
		Profissional profSaude = new Profissional("69955983", CargosEnum.PROFISSIONAL_SAUDE);
		Vacina vc = new Vacina(326402, "FUNDACAO OSWALDO CRUZ",2249278);
		PacienteVacinado pv = new PacienteVacinado(paciente, profSaude,vc, LocalDate.now(), 2);
		this.pacienteVacinadoRepositorio.save(pv);

		//READ - BUSCAR PACIENTE
		Optional<Paciente> buscarPaciente = this.pacienteRepositorio.findOneByNome("VALDIR DALLA MONTA");
		System.out.println("Resultado da busca: " + buscarPaciente.get());

		//READ com filtros por nome do paciente ou por dose ou por sexo
		List<Paciente> busca = this.pacienteVacinadoRepositorio.findAll().stream()
				//.filter( p  -> p.getPaciente().getNome().contains("VALDIR"))
				//.filter( p  -> p.getDose().equals(2)
				.filter( p  -> p.getPaciente().getSexo().equals(SexoEnum.FEMININO))
				.map(PacienteVacinado::getPaciente)
				.collect(Collectors.toList());
		System.out.println("Resultado da busca:");
		busca.stream().forEach(System.out::println);

		//UPDATE - PACIENTE
		Optional<Paciente> pacienteParaAlterar = this.pacienteRepositorio.findOneByNome("IDIANA ANGELINA BERTOTTI");
		Paciente pacienteAlterado = pacienteParaAlterar.get();
		pacienteAlterado.setData_nascimento(LocalDate.of(1974, 05, 18));
		this.pacienteRepositorio.save(pacienteAlterado);


		// UPDATE em qualquer dado do paciente vacinado
		Optional<PacienteVacinado> pacVacParaAlterar = this.pacienteVacinadoRepositorio.findOneById(20);
		PacienteVacinado pacVacAlterado = pacVacParaAlterar.get();
		pacVacAlterado.getVacina().setCodigoVacina(10500);
		//alterando o profissional que vacinou o paciente
		pacVacAlterado.setProfissional( profissionalRepositorio.findOneByCodigoRegistro("2096981").get());
		//altera o codigo de registo do Profissional que vacinou
		//pacVacAlterado.getProfissional().setCodigoRegistro("1234");
		pacVacAlterado.getPaciente().setNome("ADAO ADALBERTO LIEBGOTTI");
		this.pacienteVacinadoRepositorio.save(pacVacAlterado);


		//DELETE - HARD DELETE PACIENTE
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

		//READ - BUSCAR PROFISSIONAIS ATIVOS
		List<Profissional> profAtivosList = this.profissionalRepositorio.findAll().stream()
				    .filter(p -> p.getDeleted_at() == null )
					.collect(Collectors.toList());
		System.out.println("Resultado da busca PROFISSIONAIS ATIVOS:");
		profAtivosList.stream().forEach(System.out::println);
*/
	}
}