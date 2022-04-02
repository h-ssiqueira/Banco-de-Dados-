package br.com.letscode.postosaude.vacina;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Integer codigo_vacina;

    @Column(nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private Integer posto_saude;

    public Vacina(Integer codigo_vacina, String fabricante, Integer posto_saude) {
        this.codigo_vacina = codigo_vacina;
        this.fabricante = fabricante;
        this.posto_saude = posto_saude;
    }
}

