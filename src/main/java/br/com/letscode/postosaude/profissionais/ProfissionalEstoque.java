package br.com.letscode.postosaude.profissionais;

import br.com.letscode.postosaude.vacina.Vacina;
import br.com.letscode.postosaude.vacina.VacinaRepositorio;
import org.springframework.stereotype.Component;

@Component
public class ProfissionalEstoque extends Profissional {

    private final VacinaRepositorio vacinaRepositorio;

    public ProfissionalEstoque (VacinaRepositorio vacinaRepositorio) {
        this.vacinaRepositorio = vacinaRepositorio;
    }

    public void cadastrarVacina(Vacina vacina) {
        this.vacinaRepositorio.save(vacina);
    }

    private void alterarDadosVacina() {

    }

    private void deletarDadosVacina() {

    }
}
