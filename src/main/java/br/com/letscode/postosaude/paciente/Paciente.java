package br.com.letscode.postosaude.paciente;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate data_nascimento;

    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;
}
