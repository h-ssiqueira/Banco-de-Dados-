-----------
## Projeto final - Módulo BANCO DE DADOS  :octocat:
-----------
 
Este é o repositório do nosso projeto final do Módulo de Banco de Dados do curso da Lets's Code.
A proposta é desenvolver sistema para cadastros de Vacinação dos Postos de Saúde.

```
Integrantes do grupo - Squad Verde :
-Camily Aleixo Randi 
-Everton Sebastião do Nascimento 
-Gabriela Trindade Ferreira 
-Isadora Oliveira Rogieri 
```

&nbsp;
Esse sistema possui:
 
        ✅ Cadastro de Vacinação Efetuada, que engloba:
 
             ☑️ Cadastro de Pessoa(paciente), caso ela ainda não esteja cadastrada no sistema;
 
        ✅ Listagem de Pacientes cadastrados;

             ☑️ Com Filtros (busca por nome, dose , gênero)
             
        ✅ Listagem de Profissionais Ativos;

        ✅ Alteração de cadastros previamente realizados;

             ☑️ Alterar dados da vacina
             ☑️ Alterar dados da Paciente
             ☑️ Alterar dados da Vacinação Realizada

        ✅ Deletar cadastros realizados;
        
            ☑️ Deletar Vacina
            ☑️ Deletar Paciente
            ☑️ Deletar histórico de vacinação
            ☑️ Deletar Profissional (Soft delete)
            
  
  _____________________________________________________________________________________________________________________________________

&nbsp;
Esse sistema possui as APIs:

        X POST:
             ✅️ Cadastro de Pessoa(paciente) (http://localhost:8080/paciente)
             ✅️ Cadastro de Vacinação; (http://localhost:8080/pacientevacinado)
 
        X GET;
             ✅️ busca por nome (http://localhost:8080/paciente/{nome})
             ✅️ busca por dose (http://localhost:8080/pacientevacinado/{dose})
             ✅️ busca por gênero (http://localhost:8080/paciente/{genero})
             ✅   Listagem de Profissionais Ativos; (http://localhost:8080/profissional)

        X PUT;
             X️ Alterar dados da vacina (http://localhost:8080/vacina/{id})
             X️ Alterar dados da Paciente (http://localhost:8080/paciente/{id})
             X️ Alterar dados da Vacinação Realizada (http://localhost:8080/{id})

        X Delete;
             X️ Deletar Vacina (http://localhost:8080/vacina/{id})
             X️ Deletar Paciente (http://localhost:8080/paciente/{id})
             X️ Deletar histórico de vacinação (http://localhost:8080/{id})
             X️ Deletar Profissional (Soft delete) (http://localhost:8080/)
        
 ### Planejamento
 
 
 *Modelagem inicial do Banco de dados*
 
 ![diagrama1](images_README/dbDiagrama.png)

 *Projeto inicial da Aplicação*
 
 ![diagrama2](images_README/aplicacaoDiagrama.png)

 
### ! Regras de negócio
* Cada pessoa pode tomar várias doses da vacina , mas será cadastrada apenas uma vez.
* Cada vacina só pode ser registrada em uma aplicação.
* Cada profissional da sáude pode aplicar várias vacinas.
* Possui os dois tipos de exclusão - Hard e Soft Delete.
_______________________________________________________________________________________________________________________________________


