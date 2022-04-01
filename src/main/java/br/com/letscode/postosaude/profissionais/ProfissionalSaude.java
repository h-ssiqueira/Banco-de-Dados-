package br.com.letscode.postosaude.profissionais;

import br.com.letscode.postosaude.paciente.PacienteVacinado;
import br.com.letscode.postosaude.paciente.PacienteVacinadoRepositorio;
import org.springframework.stereotype.Component;

@Component
public class ProfissionalSaude extends Profissional{

    private final PacienteVacinadoRepositorio pacienteVacinadoRepositorio;

    public ProfissionalSaude (PacienteVacinadoRepositorio pacienteVacinadoRepositorio) {
        this.pacienteVacinadoRepositorio = pacienteVacinadoRepositorio;
    }

    public void cadastrarVacinacao(PacienteVacinado pacienteVacinadoRepositorio) {
        this.pacienteVacinadoRepositorio.save(pacienteVacinadoRepositorio);
    }

    private void alterarDadosVacinacao() {

    }

    private void deletarDadosVacinacao() {

    }
}
