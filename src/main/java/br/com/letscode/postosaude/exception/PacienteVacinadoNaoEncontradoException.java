package br.com.letscode.postosaude.exception;

public class PacienteVacinadoNaoEncontradoException extends RuntimeException{
    public PacienteVacinadoNaoEncontradoException(){
        super("Paciente Vacinado não encontrado!");
    }
}
