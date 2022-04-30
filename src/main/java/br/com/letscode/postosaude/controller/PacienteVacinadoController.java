package br.com.letscode.postosaude.controller;
import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.PacienteVacinado;
import br.com.letscode.postosaude.services.PacienteService;
import br.com.letscode.postosaude.services.PacienteVacinadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/pacientevacinado")

public class PacienteVacinadoController {
//    private final PacienteVacinadoService pacienteVacinadoService;
//
//    public PacienteVacinadoController(PacienteVacinadoService pacienteVacinadoService){
//        this.pacienteVacinadoService = pacienteVacinadoService;
//    }
//
//    @PostMapping
//    public ResponseEntity criaPacienteVacinado(@Valid PacienteVacinado pacienteVacinado, BindingResult result){
//        ResponseEntity responseErro = new ResponseEntity("ERRO 500!", HttpStatus.INTERNAL_SERVER_ERROR);
//        ResponseEntity responseCreated = new ResponseEntity("PacienteVacinado criado com sucesso!", HttpStatus.CREATED);
//        if(result.hasErrors()){
//            return responseErro;
//        }
//        this.pacienteVacinadoService.criarPacienteVacinado(pacienteVacinado);
//        return responseCreated;
//
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity updatePacientevacinado(@PathVariable("id") Integer id, @RequestBody PacienteVacinado pacienteVacinado){
//        this.pacienteVacinadoService.updatePacienteVacinado(id, pacienteVacinado);
//        ResponseEntity response = new ResponseEntity("Paciente vacinado alterado com sucesso", HttpStatus.OK);
//        return response;
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity deletePacientevacinado(@PathVariable("id") Integer id){
//        this.pacienteVacinadoService.deletarPacientevacinado(id);
//        return ResponseEntity.ok("Paciente deletado com sucesso");
//    }
//
//    @GetMapping("{dose}")
//    public String consultarPacientevacinado(@PathVariable("dose") Integer dose){
//        this.pacienteVacinadoService.consultarPacientevacinado(dose);
//        return "redirect:/pacientevacinado";
//    }
}