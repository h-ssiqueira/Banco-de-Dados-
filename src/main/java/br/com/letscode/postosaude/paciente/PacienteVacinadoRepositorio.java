package br.com.letscode.postosaude.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteVacinadoRepositorio extends JpaRepository<PacienteVacinado, Integer> {
}
