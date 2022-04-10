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
 
        
 ### Planejamento
 
 
 *Modelagem inicial do Banco de dados*
 
 ![diagrama1](images_README/dbDiagrama.png)

 *Projeto inicial da Aplicação*
 
 ![diagrama2](images_README/aplicacaoDiagrama.png)

 
### ! Regras de negócio
* Cada pessoa pode tomar várias doses da vacina , mas será cadastrada apenas uma vez.
* Cada vacina só pode ser registrada em uma aplicação.
* Listagem de vacinas disponíveis não englobam aquelas que já foram usadas em aplicações anteriores, nem deletadas do sistema.
* Possui os dois tipos de exclusão - Hard e Soft Delete.
_______________________________________________________________________________________________________________________________________


