package br.com.letscode.postosaude.exception;

public class PacienteCadastradoException extends RuntimeException{
    public PacienteCadastradoException(){
        super("Paciente já cadastrado!");
    }
}
