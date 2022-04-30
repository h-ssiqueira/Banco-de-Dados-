package br.com.letscode.postosaude.repository;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findOneByNome(String nome);
    Paciente findByNome(String nome);
    Paciente findBySexo(SexoEnum genero);
}