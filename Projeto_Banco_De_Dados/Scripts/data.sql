CREATE TABLE Pessoa (
    id int NOT NULL GENERATED ALWAYS AS IDENTITY,
    CONSTRAINT pessoa_pk PRIMARY KEY (id),
    nome varchar(200) NOT NULL,
    data_de_nascimento date NOT NULL,
    sexo char NOT NULL,
    deleted_at date,
    deleted_by varchar(200)
)

CREATE TABLE Profissional (
    id int NOT NULL GENERATED ALWAYS AS IDENTITY,
    CONSTRAINT aplicador_pk PRIMARY KEY (id),
    nome varchar(200) NOT NULL,
    cargo varchar(50) NOT NULL,
    codigo_registro int UNIQUE NOT NULL,
    deleted_at date,
    deleted_by varchar(200)
)

CREATE TABLE Vacina (
    id int NOT NULL GENERATED ALWAYS AS IDENTITY,
    CONSTRAINT vacina_pk PRIMARY KEY (id),
    codigo_da_vacina int UNIQUE NOT NULL,
    fabricante varchar(100) NOT NULL,
    deleted_at date,
    deleted_by varchar(200)
)

CREATE TABLE Pessoa_Vacinada (
     id int NOT NULL GENERATED ALWAYS AS IDENTITY,
     CONSTRAINT pessoa_vacinada_pk PRIMARY KEY (id),
     dose varchar(20) NOT NULL,
     data_de_aplicacao date NOT NULL,
     estabelecimento varchar(200) NOT NULL,
     vacina_id int NOT NULL,
     pessoa_id int NOT NULL,
     aplicador_id int NOT NULL,
     posto_de_saude varchar(200) NOT NULL,
     deleted_at date,
     deleted_by varchar(200),
     CONSTRAINT vacina_fk FOREIGN KEY (vacina_id) REFERENCES Vacina(id),
     CONSTRAINT pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES Pessoa(id),
     CONSTRAINT aplicador_fk FOREIGN KEY (aplicador_id) REFERENCES Profissional(id)
)