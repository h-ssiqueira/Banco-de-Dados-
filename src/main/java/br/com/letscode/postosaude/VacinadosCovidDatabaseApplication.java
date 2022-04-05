package br.com.letscode.postosaude;

import br.com.letscode.postosaude.data.BootstrapData;
import br.com.letscode.postosaude.paciente.Paciente;
import br.com.letscode.postosaude.paciente.PacienteRepositorio;
import br.com.letscode.postosaude.paciente.PacienteVacinado;
import br.com.letscode.postosaude.paciente.PacienteVacinadoRepositorio;
import br.com.letscode.postosaude.profissionais.*;
import br.com.letscode.postosaude.vacina.Vacina;
import br.com.letscode.postosaude.vacina.VacinaRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class VacinadosCovidDatabaseApplication implements CommandLineRunner {

	private final PacienteRepositorio pacienteRepositorio;
	private final VacinaRepositorio vacinaRepositorio;
	private final ProfissionalRepositorio profissionalRepositorio;
	private final PacienteVacinadoRepositorio pacienteVacinadoRepositorio;

	public VacinadosCovidDatabaseApplication(
											 PacienteRepositorio pacienteRepositorio,
											 VacinaRepositorio vacinaRepositorio,
											 ProfissionalRepositorio profissionalRepositorio,
											 PacienteVacinadoRepositorio pacienteVacinadoRepositorio) {


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

//		List<PacienteVacinado> vacinadosList = BootstrapData.buildPacienteVacinados();
//		List<Paciente> pacienteList = vacinadosList.stream()
//				.map(PacienteVacinado::getPaciente)
//				.distinct()
//				.collect(Collectors.toList());
//		this.pacienteRepositorio.saveAll(pacienteList);
//
//		List<Profissional> profissionalList = vacinadosList.stream()
//				.map(PacienteVacinado::getProfissional)
//				.distinct()
//				.collect(Collectors.toList());
//		this.profissionalRepositorio.saveAll(profissionalList);
//
//		List<Vacina> vacinaList = vacinadosList.stream()
//				.map(PacienteVacinado::getVacina)
//				.distinct()
//				.collect(Collectors.toList());
//		this.vacinaRepositorio.saveAll(vacinaList);
//
//
//
//		for (PacienteVacinado pv : vacinadosList){
//			Paciente pacienteBd = this.pacienteRepositorio.findOneByNome(pv.getPaciente().getNome()).orElseThrow();
//			pv.setPaciente(pacienteBd);
//			Profissional profBd = this.profissionalRepositorio.findOneByCodigoRegistro(pv.getProfissional().getCodigoRegistro()).orElseThrow();
//			pv.setProfissional(profBd);
//			Vacina vacBd = this.vacinaRepositorio.findOneById(pv.getVacina().getId()).orElseThrow();
//			pv.setVacina(vacBd);
//			System.out.println(pv);
//
//			PacienteVacinado pacVac = new PacienteVacinado(pacienteBd,profBd,vacBd, pv.getData_aplicacao(), pv.getDose());
//			this.pacienteVacinadoRepositorio.save(pacVac);
//
//
//		}




		/*Profissional profissional = new Profissional("123", CargosEnum.PROFISSIONAL_ESTOQUE, );

		Paciente paciente = new Paciente( "Isadora Oliveira Rogieri", LocalDate.of(1995,9,15), SexoEnum.FEMININO);
		Vacina vacina = new Vacina( 13, "Butantan", 2);

		PacienteVacinado pacienteVacinado = new PacienteVacinado( paciente, profissional, vacina, LocalDate.of(2021,5,23),1);


		this.pacienteRepositorio.cadastrarPaciente(paciente);
		this.profissionalEstoque.cadastrarVacina(vacina);
		this.profissionalRepositorio.cadastrarProfissional((ProfissionalEstoque) profissional);
		this.pacienteVacinadoRepositorio.cadastrarVacinacao(pacienteVacinado);

		String resultadoProfissional = this.profissionalEstoque.getNome();
		System.out.println(resultadoProfissional);*/

		//List<PacienteVacinado> resultList = this.pacienteVacinadoRepositorio.findAll();
		//resultList.forEach(System.out::println);

	}
}
