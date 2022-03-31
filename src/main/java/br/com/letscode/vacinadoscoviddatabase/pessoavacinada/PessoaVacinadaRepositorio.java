package br.com.letscode.vacinadoscoviddatabase.pessoavacinada;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaVacinadaRepositorio extends JpaRepository<PessoaVacinada, Integer> {
}
