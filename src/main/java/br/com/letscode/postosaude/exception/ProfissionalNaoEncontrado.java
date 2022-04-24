package br.com.letscode.postosaude.exception;

public class ProfissionalNaoEncontrado extends RuntimeException{
    public ProfissionalNaoEncontrado(){
        super("Profissional não encontrado!");
    }
}
