package br.com.letscode.postosaude.controller;
import br.com.letscode.postosaude.model.PacienteVacinado;
import br.com.letscode.postosaude.services.PacienteVacinadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pacientevacinado")
public class PacienteVacinadoController {
    private final PacienteVacinadoService pacienteVacinadoService;

    public PacienteVacinadoController(PacienteVacinadoService pacienteVacinadoService){
        this.pacienteVacinadoService = pacienteVacinadoService;
    }

    @PostMapping
    public ResponseEntity criaPacienteVacinado(@Valid @RequestBody PacienteVacinado pacienteVacinado, BindingResult result){
        ResponseEntity responseErro = new ResponseEntity("ERRO 500!", HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity responseCreated = new ResponseEntity("PacienteVacinado criado com sucesso!", HttpStatus.CREATED);
        if(result.hasErrors()){
            return responseErro;
        }
        this.pacienteVacinadoService.criarPacienteVacinado(pacienteVacinado);
        return responseCreated;
    }

    @PutMapping("{id}")
    public ResponseEntity updatePacientevacinado(@PathVariable("id") Integer id, @RequestBody PacienteVacinado pacienteVacinado){
        this.pacienteVacinadoService.updatePacienteVacinado(id, pacienteVacinado);
        ResponseEntity response = new ResponseEntity("Paciente vacinado alterado com sucesso", HttpStatus.OK);
        return response;
    }
    //@Transactional
    @DeleteMapping("{id}")
    public ResponseEntity deletePacientevacinado(@PathVariable("id") Integer id){
        this.pacienteVacinadoService.deletarPacienteVacinado(id);
        return ResponseEntity.ok("PacienteVacinado deletado com sucesso");
    }

    @GetMapping("{dose}")
    public ResponseEntity consultarPacientevacinado(@PathVariable("dose") Integer dose){
        List<PacienteVacinado> pacientes = this.pacienteVacinadoService.consultarPacienteVacinado(dose);
        ResponseEntity response = new ResponseEntity(pacientes, HttpStatus.OK);
        return response;
    }
}