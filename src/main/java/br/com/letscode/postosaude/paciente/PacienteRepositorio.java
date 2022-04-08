package br.com.letscode.postosaude.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findOneByNome(String nome);
    Optional<Paciente> deleteOneById(Integer id);
    Optional<Paciente> findOneById(Integer i);
    Optional<Paciente> removePacienteById(Integer id);
}