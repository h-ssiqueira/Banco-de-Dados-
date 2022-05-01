package br.com.letscode.postosaude.controller;

import br.com.letscode.postosaude.exception.PacienteNaoEncontradoException;
import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.services.PacienteService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/paciente")
@Slf4j
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity criaPaciente(@Valid @RequestBody Paciente paciente){
        ResponseEntity responseErro = new ResponseEntity("Paciente já existente/Id não identificado!", HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity responseCreated = new ResponseEntity("Paciente criado com sucesso!", HttpStatus.CREATED);
        try{
            this.pacienteService.criarPaciente(paciente);
        }catch (Exception e){
            log.info("Paciente já existente/Id não identificado!");
            return responseErro;
        }
        return responseCreated;
    }

    @PutMapping("{id}")
    public ResponseEntity updatePaciente(@Valid @PathVariable("id") Integer id, @RequestBody Paciente paciente){
        ResponseEntity responseErro = new ResponseEntity("Nome inválido", HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity responseUpdate = new ResponseEntity("Paciente atualizado com sucesso", HttpStatus.OK);
        try{
            this.pacienteService.updatePaciente(id, paciente);
        }catch (Exception e){
            log.info("Nome inválido");
            return responseErro;
        }
        return responseUpdate;
    }

    @Transactional
    @DeleteMapping("delete/{id}")
    public ResponseEntity deletePaciente(@PathVariable("id") Integer id){
        this.pacienteService.deletePaciente(id);
        return ResponseEntity.ok("Paciente deletado com sucesso");
    }

    @GetMapping("{nome}")
    public ResponseEntity consultaPacienteN(@PathVariable("nome") String nome){
        Paciente paciente = this.pacienteService.consultaPacienteN(nome);
        if(paciente!=null){
            ResponseEntity response = new ResponseEntity(paciente, HttpStatus.OK);
            return  response;
        }
        log.info(String.valueOf(new PacienteNaoEncontradoException()));
        return tratarPacienteNaoEncontrado(new PacienteNaoEncontradoException());
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity consultaPacienteG(@PathVariable("genero") SexoEnum genero){
        List<Paciente> paciente = this.pacienteService.consultaPacienteG(genero);
        if(!paciente.isEmpty()){
            ResponseEntity response = new ResponseEntity(paciente, HttpStatus.OK);
            return response;
        }
        log.info(String.valueOf(new PacienteNaoEncontradoException()));
        return tratarPacienteNaoEncontrado(new PacienteNaoEncontradoException());
    }

    @ExceptionHandler
    private ResponseEntity tratarPacienteNaoEncontrado(PacienteNaoEncontradoException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        log.info("Paciente não encontrado!");
        return response;
    }

}