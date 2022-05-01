package br.com.letscode.postosaude.controller;

import br.com.letscode.postosaude.exception.PacienteNaoEncontradoException;
import br.com.letscode.postosaude.exception.VacinaNaoEncontradaException;
import br.com.letscode.postosaude.model.Vacina;
import br.com.letscode.postosaude.repository.VacinaRepositorio;
import br.com.letscode.postosaude.services.VacinaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vacina")
@Slf4j
public class VacinaController {
    private final VacinaService vacinaService;

    public VacinaController(VacinaService vacinaService){
        this.vacinaService = vacinaService;
    }

    @PutMapping("{id}")
    public ResponseEntity updateVacina(@PathVariable("id") Integer id, @RequestBody Vacina vacina){
        ResponseEntity responseErro = new ResponseEntity("Erro ao atualizar a vacina!", HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity response = new ResponseEntity("Vacina atualizada com sucesso", HttpStatus.OK);
        try{
            this.vacinaService.updateVacina(id, vacina);
        }catch (Exception e){
            log.info("Erro ao atualizar a vacina!");
            return responseErro;
        }
        return response;
    }
    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity deleteVacina(@PathVariable("id") Integer id){
        this.vacinaService.deleteVacina(id);
        return ResponseEntity.ok("Vacina deletada com sucesso");
    }

    @ExceptionHandler
    private ResponseEntity tratarVacinaNaoEncontrado(VacinaNaoEncontradaException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        log.info("Vacina não encontrada!");
        return response;
    }
}
