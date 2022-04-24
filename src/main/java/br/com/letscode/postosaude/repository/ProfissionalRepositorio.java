package br.com.letscode.postosaude.repository;

import br.com.letscode.postosaude.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProfissionalRepositorio extends JpaRepository<Profissional, Integer> {
    Optional<Profissional> findOneByCodigoRegistro(String codigoRegistro);
}