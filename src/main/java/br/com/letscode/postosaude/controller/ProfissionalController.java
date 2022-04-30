package br.com.letscode.postosaude.controller;

import br.com.letscode.postosaude.model.Profissional;
import br.com.letscode.postosaude.services.ProfissionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profissional")
public class ProfissionalController {
    private ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService){
        this.profissionalService = profissionalService;
    }

    @GetMapping
    public List<Profissional> selecionarTodos(){
        return this.profissionalService.selecionarTodos();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteProfissional(@PathVariable("id") Integer id){
        this.profissionalService.deleteProfissional(id);
        return ResponseEntity.ok("Profissional deletado com sucesso");
    }
}