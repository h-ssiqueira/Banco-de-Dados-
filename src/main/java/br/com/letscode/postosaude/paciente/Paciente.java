package br.com.letscode.postosaude.paciente;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity

public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false, unique=true)
    private String nome;

    @Column(nullable = false)
    private LocalDate data_nascimento;

    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;

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
