package br.com.letscode.postosaude;

import br.com.letscode.postosaude.paciente.Paciente;
import br.com.letscode.postosaude.paciente.PacienteVacinado;
import br.com.letscode.postosaude.paciente.SexoEnum;
import br.com.letscode.postosaude.profissionais.*;
import br.com.letscode.postosaude.vacina.Vacina;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VacinadosCovidDatabaseApplication implements CommandLineRunner {

	private final ProfissionalAdministrativo pacienteRepositorio;
	private final ProfissionalEstoque profissionalEstoque;
	private final ProfissionalRh profissionalRepositorio;
	private final ProfissionalSaude pacienteVacinadoRepositorio;

	public VacinadosCovidDatabaseApplication(
			ProfissionalAdministrativo pacienteRepositorio,
			ProfissionalEstoque profissionalEstoque,
			ProfissionalRh profissionalRepositorio,
			ProfissionalSaude pacienteVacinadoRepositorio) {
		this.pacienteRepositorio = pacienteRepositorio;
		this.profissionalEstoque = profissionalEstoque;
		this.profissionalRepositorio = profissionalRepositorio;
		this.pacienteVacinadoRepositorio = pacienteVacinadoRepositorio;
	}

	public static void main(String[] args) {
		SpringApplication.run(VacinadosCovidDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Profissional profissional = new Profissional(1, "Maria", CargosEnum.PROFISSIONAL_ESTOQUE, 1234);

		Paciente paciente = new Paciente(1, "Isadora Oliveira Rogieri", LocalDate.of(1995,9,15), SexoEnum.FEMININO);
		Vacina vacina = new Vacina(1, 13, "Butantan");

		PacienteVacinado pacienteVacinado = new PacienteVacinado(1, paciente, profissional, vacina, LocalDate.of(2021,5,23));
		this.pacienteRepositorio.cadastrarPaciente(paciente);
		this.profissionalEstoque.cadastrarVacina(vacina);
		this.profissionalRepositorio.cadastrarProfissional((ProfissionalEstoque) profissional);
		this.pacienteVacinadoRepositorio.cadastrarVacinacao(pacienteVacinado);

		String resultadoProfissional = this.profissionalEstoque.getNome();
		System.out.println(resultadoProfissional);

		List<PacienteVacinado> resultList = this.pacienteVacinadoRepositorio.findAll();
		resultList.forEach(System.out::println);

	}
}
