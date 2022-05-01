-----------
## Projeto final - Módulo Programação Web II :octocat:
-----------
A proposta é desenvolver as APIs baseadas nas regras de negócio do posto de vacinação.

```
Integrantes do grupo - Squad Vermelho :
-Edson Valentim Hernandes
-Henrique Sartori Siqueira
-Marina Linguanoto Gajego
-Rhuan Gabriel de Oliveira Martins
-Willian Cesar Visicati
```

&nbsp;
Esse sistema possui as APIs:

        ✅ POST:
             ✅️ Cadastro de Pessoa(paciente) (http://localhost:8080/paciente)
             ✅️ Cadastro de Vacinação; (http://localhost:8080/pacientevacinado)
 
        ✅ GET;
             ✅️ Busca por nome (http://localhost:8080/paciente/{nome})
             ✅️ Busca por dose (http://localhost:8080/pacientevacinado/{dose})
             ✅️ Busca por gênero (http://localhost:8080/paciente/genero/{genero})
             ✅  Listagem de Profissionais Ativos; (http://localhost:8080/profissional)

        ✅ PUT;
             ✅️ Alterar dados da vacina (http://localhost:8080/vacina/{id})
             ✅️ Alterar dados da Paciente (http://localhost:8080/paciente/{id})
             ✅️ Alterar dados da Vacinação Realizada (http://localhost:8080/pacientevacinado/{id})

        ✅ Delete;
             ✅️ Deletar Vacina (http://localhost:8080/vacina/{id})
             ✅️ Deletar Paciente (http://localhost:8080/paciente/delete/{id})
             ✅️ Deletar histórico de vacinação (http://localhost:8080/pacientevacinado/{id})
             ✅️ Deletar Profissional (Soft delete) (http://localhost:8080/profissional/{id})

### Formato das requisições
#### POST
&nbsp;
* POST Paciente (http://localhost:8080/paciente)
Cria um novo registro de paciente, utilizando o corpo de requisição no formato:

    {
        "id": integer,
        "nome": "String",
        "data_nascimento": "aaaa-MM-dd",
        "sexo": "Enum"
    }

&nbsp;
* POST Vacinação (http://localhost:8080/pacientevacinado)
Cria um novo registro de vacinação, utilizando o corpo de requisição no formato:

    {
        "id": integer,
        "paciente": {
            "id": integer,
            "nome": "string",
            "data_nascimento": "aaaa-MM-dd",
            "sexo": "Enum",
            "deleted_at": null,
            "deleted_by": null
        },
        "profissional": {
            "id": integer,
            "codigoRegistro": "string",
            "cargo": "string",
            "deleted_at": null,
            "deleted_by": null
        },
        "vacina": {
            "id": integer,
            "codigoVacina": integer,
            "fabricante": "string",
            "posto_saude": integer,
            "deleted_at": null,
            "deleted_by": null
        },
        "data_aplicacao": "aaaa-MM-dd",
        "dose": integer,
        "deleted_at": null,
        "deleted_by": null
    }

#### GET
* GET Paciente (http://localhost:8080/paciente/{nome})
Busca o paciente por nome.

* GET Paciente (http://localhost:8080/paciente/genero/{genero})
Busca todos os pacientes com base em um gênero.

* GET Vacinação (http://localhost:8080/pacientevacinado/{dose})
Busca todas as ocorrências por dose a partir da vacinação.

* GET Profissional (http://localhost:8080/profissional)
Busca todos os profissionais cadastrados.
#### PUT
* PUT Vacina (http://localhost:8080/vacina/{id})
Altera o posto de saúde cadastrado para uma vacina com base em um id.

    {
        "posto_saude": "string"
    }
&nbsp;
* PUT Paciente (http://localhost:8080/paciente/{id})
Altera o nome do paciente com base em um id.

    {
        "Nome": "string"
    }

* PUT Vacinação (http://localhost:8080/pacientevacinado/{id})
Altera a data de vacinação com base em um id.

    {
        "Data_aplicacao": "aaaa-MM-dd"
    }

#### DELETE
* DELETE Vacina (http://localhost:8080/vacina/{id})
Remove uma vacina com base no {id} passado pelo path.
* DELETE Paciente (http://localhost:8080/paciente/delete/{id})
Remove um paciente com base no {id} passado pelo path.
* DELETE Vacinação (http://localhost:8080/pacientevacinado/{id})
Remove uma vacinação com base no {id} passado pelo path.
* DELETE Profissional (Soft delete) (http://localhost:8080/profissional/{id})
Remove um profissional com base no {id} passado pelo path.


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
* Cada profissional da sáude pode aplicar várias vacinas.
* Possui os dois tipos de exclusão - Hard e Soft Delete.
_______________________________________________________________________________________________________________________________________


