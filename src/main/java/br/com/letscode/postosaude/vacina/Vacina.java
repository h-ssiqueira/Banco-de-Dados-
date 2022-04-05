package br.com.letscode.postosaude.vacina;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Integer codigoVacina;

    @Column(nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private Integer posto_saude;

    public Vacina(Integer codigoVacina, String fabricante, Integer posto_saude) {
        this.codigoVacina = codigoVacina;
        this.fabricante = fabricante;
        this.posto_saude = posto_saude;
    }

}

