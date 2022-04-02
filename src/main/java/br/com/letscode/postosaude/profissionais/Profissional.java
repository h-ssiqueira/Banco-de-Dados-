package br.com.letscode.postosaude.profissionais;

import lombok.*;

import javax.persistence.*;

import lombok.AllArgsConstructor;

@ToString
@Getter
@Setter
@Entity

public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String codigo_registro_profissional;
    @Column (nullable = false)
    private CargosEnum cargo;

    public Profissional(String codigo_registro_profissional, CargosEnum cargo) {
        this.codigo_registro_profissional = codigo_registro_profissional;
        this.cargo = cargo;
    }
}
