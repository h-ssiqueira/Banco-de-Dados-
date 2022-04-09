package br.com.letscode.postosaude.vacina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VacinaRepositorio extends JpaRepository<Vacina, Integer> {
    Optional<Vacina> findOneById(Integer id);
}