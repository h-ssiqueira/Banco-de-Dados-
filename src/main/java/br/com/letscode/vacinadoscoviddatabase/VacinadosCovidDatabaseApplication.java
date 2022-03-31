package br.com.letscode.vacinadoscoviddatabase;

import br.com.letscode.vacinadoscoviddatabase.Pessoa.Pessoa;
import br.com.letscode.vacinadoscoviddatabase.Pessoa.PessoaRepositorio;
import br.com.letscode.vacinadoscoviddatabase.Pessoa.SexoEnum;
import br.com.letscode.vacinadoscoviddatabase.Vacina.Vacina;
import br.com.letscode.vacinadoscoviddatabase.Vacina.VacinaRepositorio;
import br.com.letscode.vacinadoscoviddatabase.pessoavacinada.PessoaVacinada;
import br.com.letscode.vacinadoscoviddatabase.pessoavacinada.PessoaVacinadaRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VacinadosCovidDatabaseApplication implements CommandLineRunner {

	private final PessoaRepositorio pessoaRepositorio;
	private final VacinaRepositorio vacinaRepositorio;
	private final PessoaVacinadaRepositorio pessoaVacinadaRepositorio;

	public VacinadosCovidDatabaseApplication(
			PessoaRepositorio pessoaRepositorio, VacinaRepositorio vacinaRepositorio,
			PessoaVacinadaRepositorio pessoaVacinadaRepositorio) {
		this.pessoaRepositorio = pessoaRepositorio;
		this.vacinaRepositorio = vacinaRepositorio;
		this.pessoaVacinadaRepositorio = pessoaVacinadaRepositorio;
	}

	public static void main(String[] args) {
		SpringApplication.run(VacinadosCovidDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pessoa pessoa = new Pessoa(1, "Isadora Oliveira Rogieri", LocalDate.of(1995,9,15), SexoEnum.F);
		Vacina vacina = new Vacina(1, "Butantan");
		PessoaVacinada pessoaVacinada = new PessoaVacinada(1,pessoa,vacina, LocalDate.now());
		this.pessoaRepositorio.save(pessoa);
		this.vacinaRepositorio.save(vacina);
		this.pessoaVacinadaRepositorio.save(pessoaVacinada);
		List<PessoaVacinada> resultList = this.pessoaVacinadaRepositorio.findAll();
		resultList.forEach(System.out::println);

	}
}
