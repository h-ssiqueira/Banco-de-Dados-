package br.com.letscode.postosaude.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Objects;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="\"PACIENTE\"", uniqueConstraints = {
        @UniqueConstraint(columnNames = "NOME")
})
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column (nullable = false, unique=true, name = "NOME")
    @NotBlank(message = "Nome não informado")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Nome inválido")
    private String nome;

    @Column(nullable = false, name = "DATA_NASCIMENTO")
    private LocalDate data_nascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO")
    private SexoEnum sexo;

    @Column
    private LocalDate deleted_at;

    @Column
    private String deleted_by;

    public Paciente(String nome, LocalDate data_nascimento, SexoEnum sexo) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return nome.equals(paciente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}