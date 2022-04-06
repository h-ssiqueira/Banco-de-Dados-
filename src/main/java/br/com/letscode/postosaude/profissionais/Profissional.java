package br.com.letscode.postosaude.profissionais;

import lombok.*;

import javax.persistence.*;

import java.util.Objects;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String codigoRegistro;

    @Enumerated(EnumType.STRING)
    private CargosEnum cargo;

    public Profissional(String codigoRegistro, CargosEnum cargo) {
        this.codigoRegistro = codigoRegistro;
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profissional that = (Profissional) o;
        return codigoRegistro.equals(that.codigoRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoRegistro);
    }
}
