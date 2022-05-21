package br.com.letscode.postosaude.services;

import br.com.letscode.postosaude.exception.PacienteVacinadoCadastradoException;
import br.com.letscode.postosaude.exception.PacienteVacinadoNaoEncontradoException;
import br.com.letscode.postosaude.model.PacienteVacinado;
import br.com.letscode.postosaude.repository.PacienteVacinadoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteVacinadoService {
    private final PacienteVacinadoRepositorio pacienteVacinadoRepository;

    public PacienteVacinadoService(PacienteVacinadoRepositorio pacienteVacinadoRepository){
        this.pacienteVacinadoRepository = pacienteVacinadoRepository;
    }

    public PacienteVacinado criarPacienteVacinado(PacienteVacinado pacienteVacinado) {
        if(!this.pacienteVacinadoRepository.existsById(pacienteVacinado.getId())){
            return this.pacienteVacinadoRepository.save(pacienteVacinado);
        }else {
            throw new PacienteVacinadoCadastradoException();
        }
    }

    public PacienteVacinado updatePacienteVacinado(Integer id, PacienteVacinado pacienteVacinado){
        PacienteVacinado entidade = this.selecionaPacienteVacinadoById(id);
        try {
            entidade.setData_aplicacao(pacienteVacinado.getData_aplicacao());
        }catch(Exception e){
            return null;
        }
        return this.pacienteVacinadoRepository.save(entidade);
    }

    private PacienteVacinado selecionaPacienteVacinadoById(Integer id){
        return this.pacienteVacinadoRepository.findById(id).orElseThrow(PacienteVacinadoNaoEncontradoException::new);
    }

    public List<PacienteVacinado> consultarPacienteVacinado(Integer dose) {
        return this.pacienteVacinadoRepository.findAll().stream()
            .filter(pv -> pv.getDose().equals(dose))
            .collect(Collectors.toList());
    }

    public void deletarPacienteVacinado(Integer id) {
        PacienteVacinado entidade = this.selecionaPacienteVacinadoById(id);
        this.pacienteVacinadoRepository.delete(entidade);
    }
}
