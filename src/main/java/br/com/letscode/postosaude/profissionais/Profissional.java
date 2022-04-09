package br.com.letscode.postosaude.profissionais;

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
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "CARGO", discriminatorType = DiscriminatorType.STRING)
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column (nullable = true, name = "NOME")
    private String nome;

    @Column(nullable = false, name = "CODIGO_REGISTRO")
    private String codigoRegistro;

    @Enumerated(EnumType.STRING)
    @Column(name = "CARGO", insertable=false, updatable=false)
    private CargosEnum cargo;

    @Column
    private LocalDate deleted_at;

    @Column
    private String deleted_by;

    public Profissional(String nome, String codigoRegistro) {
        this.nome = nome;
        this.codigoRegistro = codigoRegistro;
        this.cargo = CargosEnum.PROFISSIONAL_SAUDE;
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