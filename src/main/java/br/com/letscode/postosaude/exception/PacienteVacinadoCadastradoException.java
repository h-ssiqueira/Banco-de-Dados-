package br.com.letscode.postosaude.exception;

public class PacienteVacinadoCadastradoException extends RuntimeException{
    public PacienteVacinadoCadastradoException(){
        super("Paciente Vacinado já cadastrado!");
    }
}
