package br.com.letscode.postosaude.profissionais;

import org.springframework.stereotype.Component;

@Component
public class ProfissionalRh extends Profissional {

    private final ProfissionalRepositorio profissionalRepositorio;

    public ProfissionalRh (ProfissionalRepositorio profissionalRepositorio) {
        this.profissionalRepositorio = profissionalRepositorio;
    }

    public void cadastrarProfissional(ProfissionalEstoque profissionalRepositorio) {
        this.profissionalRepositorio.save(profissionalRepositorio);
    }

    private void alterarDadosProfissional() {

    }

    private void deletarDadosProfissional() {

    }
}
