package br.com.letscode.postosaude.exception;

public class ProfissionalCadastradoException extends RuntimeException{
    public ProfissionalCadastradoException(){
        super("Profissional já cadastrado!");
    }
}
