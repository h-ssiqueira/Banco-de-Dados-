--- ddl

ALTER TABLE IF EXISTS public.paciente_vacinado DROP CONSTRAINT  IF EXISTS  paciente_fk;
ALTER TABLE IF EXISTS public.paciente_vacinado DROP CONSTRAINT  IF EXISTS  profissional_fk;
ALTER TABLE IF EXISTS public.paciente_vacinado DROP CONSTRAINT  IF EXISTS  vacina_fk;

DROP TABLE IF EXISTS public.paciente;
CREATE TABLE public.paciente (
     id serial4 NOT NULL,
     data_nascimento date NOT NULL,
     deleted_at date NULL,
     deleted_by varchar(255) NULL,
     nome varchar(255) NOT NULL,
     sexo varchar(255) NULL,
     CONSTRAINT paciente_pkey PRIMARY KEY (id),
     CONSTRAINT paciente_unico UNIQUE (nome)
);
DROP TABLE IF EXISTS public.profissional;
CREATE TABLE public.profissional (
     cargo varchar(31) NOT NULL,
     id serial4 NOT NULL,
     codigo_registro varchar(255) NOT NULL,
     deleted_at date NULL,
     deleted_by varchar(255) NULL,
--      nome varchar(255) NOT NULL,
     CONSTRAINT profissional_pkey PRIMARY KEY (id),
     CONSTRAINT cod_profissional_unico UNIQUE (codigo_registro)
);
DROP TABLE IF EXISTS public.vacina;
CREATE TABLE public.vacina (
    id serial4 NOT NULL,
    codigo_vacina int4 NOT NULL,
    deleted_at date NULL,
    deleted_by varchar(255) NULL,
    fabricante varchar(255) NOT NULL,
    posto_saude int4 NOT NULL,
    CONSTRAINT vacina_pkey PRIMARY KEY (id)
);
DROP TABLE IF EXISTS public.paciente_vacinado;
CREATE TABLE public.paciente_vacinado (
      id serial4 NOT NULL,
      data_aplicacao date NOT NULL,
      deleted_at date NULL,
      deleted_by varchar(255) NULL,
      dose int4 NOT NULL,
      paciente_id int4 NOT NULL,
      profissional_id int4 NOT NULL,
      vacina_id int4 NOT NULL,
      CONSTRAINT paciente_vacinado_pkey PRIMARY KEY (id),
      CONSTRAINT vacina_unica UNIQUE (vacina_id)
);
ALTER TABLE public.paciente_vacinado ADD CONSTRAINT paciente_fk FOREIGN KEY (paciente_id) REFERENCES public.paciente(id);
ALTER TABLE public.paciente_vacinado ADD CONSTRAINT profissional_fk FOREIGN KEY (profissional_id) REFERENCES public.profissional(id);
ALTER TABLE public.paciente_vacinado ADD CONSTRAINT vacina_fk FOREIGN KEY (vacina_id) REFERENCES public.vacina(id);