package br.com.letscode.postosaude.model;

import br.com.letscode.postosaude.model.Profissional;
import br.com.letscode.postosaude.model.Vacina;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="\"PACIENTE_VACINADO\"", uniqueConstraints = {
        @UniqueConstraint(columnNames = "VACINA_ID")
})
public class PacienteVacinado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToOne
//    @JoinTable(name = "PACIENTE_VACINADO", joinColumns = {@JoinColumn(name = "PACIENTE_ID")}, inverseJoinColumns = {@JoinColumn(name = "ID")})
    @JoinColumn(name = "PACIENTE_ID", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn (name = "PROFISSIONAL_ID", nullable = false)
    private Profissional profissional;

    @OneToOne
    @JoinColumn (name = "VACINA_ID", nullable = false)
    private Vacina vacina;

    @Column (nullable = false, name = "DATA_APLICACAO")
    private LocalDate data_aplicacao;

    @Column (nullable = false, name = "DOSE")
    private Integer dose;

    @Column
    private LocalDate deleted_at;

    @Column
    private String deleted_by;

    public PacienteVacinado(Paciente paciente, Profissional profissional, Vacina vacina, LocalDate data_aplicacao, Integer dose) {
        this.paciente = paciente;
        this.profissional = profissional;
        this.vacina = vacina;
        this.data_aplicacao = data_aplicacao;
        this.dose = dose;
    }

    public PacienteVacinado(Integer id,Paciente paciente, Profissional profissional, Vacina vacina, LocalDate data_aplicacao, Integer dose) {
        this.id = id;
        this.paciente = paciente;
        this.profissional = profissional;
        this.vacina = vacina;
        this.data_aplicacao = data_aplicacao;
        this.dose = dose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacienteVacinado that = (PacienteVacinado) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}