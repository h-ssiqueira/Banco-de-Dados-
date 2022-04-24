package br.com.letscode.postosaude.repository;

import br.com.letscode.postosaude.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VacinaRepositorio extends JpaRepository<Vacina, Integer> {
}