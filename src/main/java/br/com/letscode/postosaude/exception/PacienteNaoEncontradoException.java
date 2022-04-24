package br.com.letscode.postosaude.exception;

public class PacienteNaoEncontradoException extends RuntimeException{
    public PacienteNaoEncontradoException(){
        super("Paciente não encontrado!");
    }
}
