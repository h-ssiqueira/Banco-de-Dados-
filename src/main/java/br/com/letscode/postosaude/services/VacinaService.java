package br.com.letscode.postosaude.services;

import br.com.letscode.postosaude.exception.VacinaNaoEncontradaException;
import br.com.letscode.postosaude.model.Vacina;
import br.com.letscode.postosaude.repository.VacinaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class VacinaService {
    private final VacinaRepositorio vacinaRepositorio;

    public VacinaService(VacinaRepositorio vacinaRepositorio){

        this.vacinaRepositorio = vacinaRepositorio;
    }

    public void deleteVacina(Integer id){
        Vacina entidade = this.selecionaVacinaByid(id);
        this.vacinaRepositorio.delete(entidade);
        // TODO: 30/04/2022 Adicionar um update para atualizar quem deletou e quando
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
