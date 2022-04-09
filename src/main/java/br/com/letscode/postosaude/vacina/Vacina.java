package br.com.letscode.postosaude.vacina;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="\"VACINA\"", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "CODIGO_VACINA"),
        @UniqueConstraint(columnNames = "FABRICANTE"),
        @UniqueConstraint(columnNames = "POSTO_SAUDE")
})
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(nullable = false, name = "CODIGO_VACINA")
    private Integer codigoVacina;

    @Column(nullable = false, name = "FABRICANTE")
    private String fabricante;

    @Column(nullable = false, name = "POSTO_SAUDE")
    private Integer posto_saude;

    public Vacina(Integer codigoVacina, String fabricante, Integer posto_saude) {
        this.codigoVacina = codigoVacina;
        this.fabricante = fabricante;
        this.posto_saude = posto_saude;
    }
}