package br.com.letscode.postosaude.profissionais;

import br.com.letscode.postosaude.paciente.Paciente;
import br.com.letscode.postosaude.paciente.PacienteRepositorio;
import org.springframework.stereotype.Component;

@Component
public class ProfissionalAdministrativo extends Profissional{

    private final PacienteRepositorio pacienteRepositorio;

    public ProfissionalAdministrativo (PacienteRepositorio pacienteRepositorio) {
        this.pacienteRepositorio = pacienteRepositorio;
    }

    public void cadastrarPaciente(Paciente paciente) {
        this.pacienteRepositorio.save(paciente);
    }

    private void alterarDadosPaciente() {

    }

    private void deletarDadosPaciente() {

    }


}
