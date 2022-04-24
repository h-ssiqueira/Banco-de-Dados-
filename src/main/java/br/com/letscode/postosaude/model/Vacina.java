package br.com.letscode.postosaude.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="\"VACINA\"")
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

    @Column
    private LocalDate deleted_at;

    @Column
    private String deleted_by;

    public Vacina(Integer codigoVacina, String fabricante, Integer posto_saude) {
        this.codigoVacina = codigoVacina;
        this.fabricante = fabricante;
        this.posto_saude = posto_saude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacina vacina = (Vacina) o;
        return Objects.equals(codigoVacina, vacina.codigoVacina) && Objects.equals(fabricante, vacina.fabricante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoVacina, fabricante);
    }
}