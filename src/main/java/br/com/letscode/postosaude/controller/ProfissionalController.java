package br.com.letscode.postosaude.controller;

import br.com.letscode.postosaude.model.Profissional;
import br.com.letscode.postosaude.services.ProfissionalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

/*
*     ✅ Cadastro de Vacinação Efetuada, que engloba:

         ☑️ Cadastro de Pessoa(paciente), caso ela ainda não esteja cadastrada no sistema;

    ✅ Listagem de Profissionais Ativos;

        ☑️ Deletar Profissional (Soft delete)
* */