package br.com.letscode.postosaude.services;

import br.com.letscode.postosaude.exception.VacinaNaoEncontradaException;
import br.com.letscode.postosaude.model.Vacina;
import br.com.letscode.postosaude.repository.PacienteVacinadoRepositorio;
import br.com.letscode.postosaude.repository.VacinaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class VacinaService {
    private final VacinaRepositorio vacinaRepositorio;
    private final PacienteVacinadoRepositorio pacienteVacinadoRepositorio;

    public VacinaService(VacinaRepositorio vacinaRepositorio, PacienteVacinadoRepositorio pacienteVacinadoRepositorio){
        this.vacinaRepositorio = vacinaRepositorio;
        this.pacienteVacinadoRepositorio = pacienteVacinadoRepositorio;
    }

    public void deleteVacina(Integer id){
        Vacina entidade = this.selecionaVacinaByid(id);
        this.pacienteVacinadoRepositorio.deleteByVacinaId(entidade.getId());
        this.vacinaRepositorio.delete(entidade);
    }

    public Vacina updateVacina(Integer id, Vacina vacina){
        Vacina entidade = this.selecionaVacinaByid(id);
        entidade.setPosto_saude(vacina.getPosto_saude());
        return this.vacinaRepositorio.save(entidade);
    }

    private Vacina selecionaVacinaByid(Integer id){
        return this.vacinaRepositorio.findById(id).orElseThrow(VacinaNaoEncontradaException::new);
    }
}
