package br.com.letscode.postosaude.model;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="\"PROFISSIONAL\"", uniqueConstraints = {
        @UniqueConstraint(columnNames = "CODIGO_REGISTRO")
})
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(nullable = false, name = "CODIGO_REGISTRO")
    private String codigoRegistro;

    @Enumerated(EnumType.STRING)
    @Column(name = "CARGO", nullable = false)
    private CargosEnum cargo;

    @Column
    private LocalDate deleted_at;

    @Column
    private String deleted_by;

    public Profissional( String codigoRegistro, CargosEnum cargo) {
        this.codigoRegistro = codigoRegistro;
        this.cargo = cargo;
    }
    public Profissional( String codigoRegistro, CargosEnum cargo, LocalDate deleted_at) {
        this.codigoRegistro = codigoRegistro;
        this.cargo = cargo;
        this.deleted_at = null;
    }

    public Profissional( Integer id, String codigoRegistro, CargosEnum cargo, LocalDate deleted_at) {
        this.id = id;
        this.codigoRegistro = codigoRegistro;
        this.cargo = cargo;
        this.deleted_at = null;
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