package br.com.letscode.postosaude.exception;

public class VacinaCadastradaException extends RuntimeException{

    public VacinaCadastradaException(){
        super("Vacina já cadastrada!");
    }
}
