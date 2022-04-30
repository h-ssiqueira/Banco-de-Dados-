package br.com.letscode.postosaude.controller;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/paciente")

public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity criaPaciente(@Valid Paciente paciente, BindingResult result){
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

    @DeleteMapping("{id}")
    public ResponseEntity deletePaciente(@PathVariable("id") Integer id){
        this.pacienteService.deletePaciente(id);
        return ResponseEntity.ok("Paciente deletado com sucesso");
    }

    @GetMapping("{nome}")
    public String consultaPacienteN(@PathVariable("nome") String nome){
        this.pacienteService.consultaPacienteN(nome);
        return "redirect/paciente";
    }

    @GetMapping("{genero}")
    public String consultaPacienteG(@PathVariable("genero") SexoEnum genero){
        this.pacienteService.consultaPacienteG(genero);
        return "redirect/paciente";
    }


}