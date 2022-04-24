package br.com.letscode.postosaude.exception;

public class PacienteVacinadoException extends RuntimeException{
    public PacienteVacinadoException(){
        super("Paciente Vacinado já cadastrado!");
    }
}
