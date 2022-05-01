package br.com.letscode.postosaude.controller;

import br.com.letscode.postosaude.exception.PacienteNaoEncontradoException;
import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity criaPaciente(@Valid @RequestBody Paciente paciente, BindingResult result){
        ResponseEntity responseErro = new ResponseEntity("ERRO 500!", HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity responseCreated = new ResponseEntity("Paciente criado com sucesso!", HttpStatus.CREATED);
        if(result.hasErrors()){
            return responseErro;
        }
        this.pacienteService.criarPaciente(paciente);
        return responseCreated;
    }

    @PutMapping("{id}")
    public ResponseEntity updatePaciente(@PathVariable("id") Integer id, @RequestBody Paciente paciente){
        this.pacienteService.updatePaciente(id, paciente);
        ResponseEntity response = new ResponseEntity("Paciente atualizado com sucesso", HttpStatus.OK);
        return response;
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
        ResponseEntity response = new ResponseEntity(paciente, HttpStatus.OK);
        return response;
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity consultaPacienteG(@PathVariable("genero") SexoEnum genero){
        List<Paciente> paciente = this.pacienteService.consultaPacienteG(genero);
        ResponseEntity response = new ResponseEntity(paciente, HttpStatus.OK);
        return response;
    }

    @ExceptionHandler
    public ResponseEntity tratarPacienteNaoEncontrado(PacienteNaoEncontradoException e){
            ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
            return  response;
    }

}