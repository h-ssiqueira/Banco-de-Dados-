package br.com.letscode.postosaude.services;

import br.com.letscode.postosaude.exception.PacienteCadastradoException;
import br.com.letscode.postosaude.exception.PacienteNaoEncontradoException;
import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import br.com.letscode.postosaude.repository.PacienteVacinadoRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PacienteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);
    private final PacienteRepositorio pacienteRepositorio;
    private final PacienteVacinadoRepositorio pacienteVacinadoRepositorio;


    public PacienteService(PacienteRepositorio pacienteRepositorio, PacienteVacinadoRepositorio pacienteVacinadoRepositorio){
        this.pacienteRepositorio = pacienteRepositorio;
        this.pacienteVacinadoRepositorio = pacienteVacinadoRepositorio;
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
        this.pacienteVacinadoRepositorio.deleteByPacienteId(entidade.getId());
        this.pacienteRepositorio.delete(entidade);
    }

    public Paciente consultaPacienteN(String nome){
        Paciente entidade = this.pacienteRepositorio.findByNome(nome);
        return entidade;
    }

    public List<Paciente> consultaPacienteG(SexoEnum genero){
        return this.pacienteRepositorio.findAll().stream()
            .filter(p-> p.getSexo().equals(genero))
            .collect(Collectors.toList());
    }

    public Paciente updatePaciente(Integer id, Paciente paciente){
        Paciente entidade = this.selecionaPacienteById(id);
        entidade.setNome(paciente.getNome());
        return this.pacienteRepositorio.save(entidade);
    }

    private Paciente selecionaPacienteById(Integer id){
        return this.pacienteRepositorio.findById(id).orElseThrow(PacienteNaoEncontradoException::new);
    }
}
