package br.com.letscode.postosaude.profissionais;

import lombok.*;

import javax.persistence.*;

import lombok.AllArgsConstructor;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (nullable = false)
    private String nome;
    @Column (nullable = false)
    private CargosEnum cargo;
    @Column(nullable = false)
    private Integer codigo_registro_profissional;
}
