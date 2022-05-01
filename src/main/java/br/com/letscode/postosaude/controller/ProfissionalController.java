package br.com.letscode.postosaude.controller;

import br.com.letscode.postosaude.exception.ProfissionalNaoEncontradoException;
import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.Profissional;
import br.com.letscode.postosaude.services.ProfissionalService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profissional")
@Slf4j
public class ProfissionalController {
    private ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService){
        this.profissionalService = profissionalService;
    }

    @GetMapping
    public ResponseEntity selecionarTodos(){
        List<Profissional> profissionais = this.profissionalService.selecionarTodos();
        if(!profissionais.isEmpty()){
            ResponseEntity response = new ResponseEntity(profissionais, HttpStatus.OK);
            return response;
        }
        log.info(String.valueOf(new ProfissionalNaoEncontradoException()));
        return tratarProfissionalNaoEncontrado(new ProfissionalNaoEncontradoException());
    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity deleteProfissional(@PathVariable("id") Integer id, @RequestBody Profissional profissional){
        this.profissionalService.updateProfissional(id, profissional);
        return ResponseEntity.ok("Profissional deletado (soft) com sucesso");
    }
    @ExceptionHandler
    private ResponseEntity tratarProfissionalNaoEncontrado(ProfissionalNaoEncontradoException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        log.info("Profissional não encontrado!");
        return response;
    }
}