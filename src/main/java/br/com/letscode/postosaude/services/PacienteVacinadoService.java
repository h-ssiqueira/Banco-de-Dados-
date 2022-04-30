package br.com.letscode.postosaude.services;

import br.com.letscode.postosaude.exception.PacienteNaoEncontradoException;
import br.com.letscode.postosaude.exception.PacienteVacinadoNaoEncontradoException;
import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.PacienteVacinado;
import br.com.letscode.postosaude.repository.PacienteVacinadoRepositorio;

public class PacienteVacinadoService {
    private final PacienteVacinadoRepositorio pacienteVacinadoRepository;

    public PacienteVacinadoService(PacienteVacinadoRepositorio pacienteVacinadoRepository){
        this.pacienteVacinadoRepository = pacienteVacinadoRepository;
    }

    public void criarPacienteVacinado(PacienteVacinado pacienteVacinado) {
    }

    public PacienteVacinado updatePacienteVacinado(Integer id, PacienteVacinado pacienteVacinado){
        PacienteVacinado entidade = this.selecionaPacienteVacinadoById(id);
        entidade.setPaciente(pacienteVacinado.getPaciente());
        return this.pacienteVacinadoRepository.save(entidade);
    }

    private PacienteVacinado selecionaPacienteVacinadoById(Integer id){
        return this.pacienteVacinadoRepository.findById(id).orElseThrow(PacienteVacinadoNaoEncontradoException::new);
    }
}
