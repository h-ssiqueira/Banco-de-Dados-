package br.com.letscode.postosaude.services;

import br.com.letscode.postosaude.exception.PacienteCadastradoException;
import br.com.letscode.postosaude.exception.PacienteNaoEncontradoException;
import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);
    private final PacienteRepositorio pacienteRepositorio;

    PacienteService(PacienteRepositorio pacienteRepositorio){
        this.pacienteRepositorio = pacienteRepositorio;
    }

    public Paciente criarPaciente(Paciente paciente){
        if(!this.pacienteRepositorio.existsById(paciente.getId())){
            return this.pacienteRepositorio.save(paciente);
        }else {
            throw new PacienteCadastradoException();
        }
    }

    public void deletePaciente(Integer id){
        Paciente entidade = this.selecionaPacienteById(id);
        this.pacienteRepositorio.delete(entidade);
    }

    public void consultaPacienteN(String nome){
        Paciente entidade = this.pacienteRepositorio.findByNome(nome);
        this.pacienteRepositorio.delete(entidade);
    }

    public void consultaPacienteG(SexoEnum genero){
        Paciente entidade = this.pacienteRepositorio.findBySexo(genero);
        this.pacienteRepositorio.delete(entidade);
    }

    public Paciente updatePaciente(Integer id, Paciente paciente){
        Paciente entidade = this.selecionaPacienteById(id);
        entidade.setNome(paciente.getNome());
        return this.pacienteRepositorio.save(entidade);
    }

    private Paciente selecionaPacienteById(Integer id){
        return this.pacienteRepositorio.findById(id).orElseThrow(PacienteNaoEncontradoException::new);
    }

//
//    private Paciente selecionaPacienteByNome(String nome){
//        return this.pacienteRepositorio.findByNome(nome).orElseThrow(PacienteNaoEncontradoException::new);
//    }
//
}
