-- DDL

CREATE TABLE public.paciente (
     id serial4 NOT NULL,
     data_nascimento date NOT NULL,
     nome varchar(255) NOT NULL,
     sexo varchar(255) NULL,
     CONSTRAINT paciente_pk PRIMARY KEY (id)
);

CREATE TABLE public.paciente_vacinado (
      id serial4 NOT NULL,
      data_aplicacao date NOT NULL,
      dose int4 NOT NULL,
      paciente_id int4 NOT NULL,
      profissional_id int4 NOT NULL,
      vacina_id int4 NOT NULL,
      CONSTRAINT paciente_vacinado_pk PRIMARY KEY (id)
);

CREATE TABLE public.profissional (
     id serial4 NOT NULL,
     cargo varchar(255) NULL,
     codigo_registro varchar(255) NOT NULL,
     CONSTRAINT profissional_pkey PRIMARY KEY (id)
);

CREATE TABLE public.vacina (
   id serial4 NOT NULL,
   codigo_vacina int4 NOT NULL,
   fabricante varchar(255) NOT NULL,
   posto_saude int4 NOT NULL,
   CONSTRAINT vacina_pkey PRIMARY KEY (id)
);

-- public.paciente_vacinado foreign keys

ALTER TABLE public.paciente_vacinado
    ADD CONSTRAINT profissional_fk FOREIGN KEY (profissional_id) REFERENCES public.profissional(id);
ALTER TABLE public.paciente_vacinado
    ADD CONSTRAINT paciente_fk FOREIGN KEY (paciente_id) REFERENCES public.paciente(id);
ALTER TABLE public.paciente_vacinado
    ADD CONSTRAINT vacina_fk FOREIGN KEY (vacina_id) REFERENCES public.vacina(id);
ALTER TABLE public.paciente ADD CONSTRAINT nome_unico UNIQUE (nome);
