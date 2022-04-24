package br.com.letscode.postosaude.exception;

public class VacinaNaoEncontradaException extends RuntimeException{
    public VacinaNaoEncontradaException(){
        super("Vacina não encontrada!");
    }
}
