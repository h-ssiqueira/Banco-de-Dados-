package br.com.letscode.postosaude.exception;

public class ProfissionalNaoEncontradoException extends RuntimeException{
    public ProfissionalNaoEncontradoException(){
        super("Profissional não encontrado!");
    }
}
