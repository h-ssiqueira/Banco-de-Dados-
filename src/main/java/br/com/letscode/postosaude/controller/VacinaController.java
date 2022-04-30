package br.com.letscode.postosaude.controller;

import br.com.letscode.postosaude.repository.VacinaRepositorio;

public class VacinaController {
    private VacinaRepositorio VacinaRepository;

    public VacinaController(VacinaRepositorio VacinaRepository){
        this.VacinaRepository = VacinaRepository;
    }
}
