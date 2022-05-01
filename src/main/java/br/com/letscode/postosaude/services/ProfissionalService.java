package br.com.letscode.postosaude.services;

import br.com.letscode.postosaude.exception.PacienteNaoEncontradoException;
import br.com.letscode.postosaude.exception.ProfissionalNaoEncontradoException;
import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.Profissional;
import br.com.letscode.postosaude.repository.ProfissionalRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfissionalService {
    private final ProfissionalRepositorio profissionalRepository;

    public ProfissionalService(ProfissionalRepositorio profissionalRepository){
        this.profissionalRepository = profissionalRepository;
    }

    public List<Profissional> selecionarTodos(){
        return this.profissionalRepository.findAll().stream()
                .filter(p -> p.getDeleted_at() == null )
                .collect(Collectors.toList());
        //System.out.println("Resultado da busca PROFISSIONAIS ATIVOS:");
        //profAtivosList.stream().forEach(System.out::println);
        //return this.profissionalRepository.findAll();
    }

    public void deleteProfissional(Integer id){
        Profissional entidade = this.selecionaProfissionalById(id);
        this.profissionalRepository.delete(entidade);
    }

    public Profissional updateProfissional(Integer id, Profissional profissional){
        Profissional entidade = this.selecionaProfissionalById(id);
        entidade.setDeleted_by(profissional.getDeleted_by());
        entidade.setDeleted_at(LocalDate.now());
        return this.profissionalRepository.save(entidade);
    }

    private Profissional selecionaProfissionalById(Integer id){
        return this.profissionalRepository.findById(id).orElseThrow(ProfissionalNaoEncontradoException::new);
    }
}
