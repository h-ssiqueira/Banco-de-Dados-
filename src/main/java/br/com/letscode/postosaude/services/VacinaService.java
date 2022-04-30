package br.com.letscode.postosaude.services;

import br.com.letscode.postosaude.repository.VacinaRepositorio;

public class VacinaService {
    private final VacinaRepositorio vacionaRepository;

    public VacinaService(VacinaRepositorio vacionaRepository){
        this.vacionaRepository = vacionaRepository;
    }
}
