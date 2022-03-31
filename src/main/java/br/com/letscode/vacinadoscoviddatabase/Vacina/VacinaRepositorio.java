package br.com.letscode.vacinadoscoviddatabase.Vacina;

import br.com.letscode.vacinadoscoviddatabase.Pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaRepositorio extends JpaRepository<Vacina, Integer> {

}
