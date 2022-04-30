package br.com.letscode.postosaude.controller;

import br.com.letscode.postosaude.model.Vacina;
import br.com.letscode.postosaude.repository.VacinaRepositorio;
import br.com.letscode.postosaude.services.VacinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vacina")
public class VacinaController {
    private final VacinaService vacinaService;

    public VacinaController(VacinaService vacinaService){
        this.vacinaService = vacinaService;
    }

    @PutMapping("{id}")
    public ResponseEntity updateVacina(@PathVariable("id") Integer id, @RequestBody Vacina vacina){
        this.vacinaService.updateVacina(id, vacina);
        ResponseEntity response = new ResponseEntity("Vacina atualizada com sucesso", HttpStatus.OK);
        return response;
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteVacina(@PathVariable("id") Integer id){
        this.vacinaService.deleteVacina(id);
        return ResponseEntity.ok("Vacina deletada com sucesso");
    }
}
