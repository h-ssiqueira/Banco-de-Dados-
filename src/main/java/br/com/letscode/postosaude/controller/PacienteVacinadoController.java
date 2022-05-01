package br.com.letscode.postosaude.controller;
import br.com.letscode.postosaude.exception.PacienteVacinadoNaoEncontradoException;
import br.com.letscode.postosaude.model.PacienteVacinado;
import br.com.letscode.postosaude.services.PacienteVacinadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/pacientevacinado")
public class PacienteVacinadoController {
    private final PacienteVacinadoService pacienteVacinadoService;

    public PacienteVacinadoController(PacienteVacinadoService pacienteVacinadoService){
        this.pacienteVacinadoService = pacienteVacinadoService;
    }

    @PostMapping
    public ResponseEntity criaPacienteVacinado(@Valid @RequestBody PacienteVacinado pacienteVacinado){
        ResponseEntity responseErro = new ResponseEntity("PacienteVacinado já existente/Id não identificado!", HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity responseCreated = new ResponseEntity("PacienteVacinado criado com sucesso!", HttpStatus.CREATED);
        try{
            this.pacienteVacinadoService.criarPacienteVacinado(pacienteVacinado);
        }catch (Exception e){
            log.info("Paciente já existente no sistema!");
            return responseErro;
        }
        return responseCreated;
    }

    @PutMapping("{id}")
    public ResponseEntity updatePacientevacinado(@PathVariable("id") Integer id, @RequestBody PacienteVacinado pacienteVacinado){
        ResponseEntity responseErro = new ResponseEntity("Nome inválido", HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity response = new ResponseEntity("Paciente vacinado alterado com sucesso", HttpStatus.OK);
        try {
            this.pacienteVacinadoService.updatePacienteVacinado(id, pacienteVacinado);
        }catch (Exception e){
            log.info("Nome inválido");
            return responseErro;
        }
        return response;
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePacientevacinado(@PathVariable("id") Integer id){
        this.pacienteVacinadoService.deletarPacienteVacinado(id);
        return ResponseEntity.ok("PacienteVacinado deletado com sucesso");
    }

    @GetMapping("{dose}")
    public ResponseEntity consultarPacientevacinado(@PathVariable("dose") Integer dose){
        List<PacienteVacinado> pacientes = this.pacienteVacinadoService.consultarPacienteVacinado(dose);
        if(!pacientes.isEmpty()) {
            ResponseEntity response = new ResponseEntity(pacientes, HttpStatus.OK);
            return response;
        }
        log.info(String.valueOf(new PacienteVacinadoNaoEncontradoException()));
        return tratarPacienteVacinadoNaoEncontrado(new PacienteVacinadoNaoEncontradoException());
    }

    @ExceptionHandler
    private ResponseEntity tratarPacienteVacinadoNaoEncontrado(PacienteVacinadoNaoEncontradoException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        log.info("Cadastro de vacinação não encontrado.");
        return response;
    }
}