package br.com.letscode.postosaude.paciente;

import br.com.letscode.postosaude.profissionais.Profissional;
import br.com.letscode.postosaude.vacina.Vacina;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class PacienteVacinado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn (name = "profissional_id", nullable = false)
    private Profissional profissional;

    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn (name = "vacina_id", nullable = false)
    private Vacina vacina;

    @Column (nullable = false)
    private LocalDate data_aplicacao;

    @Column (nullable = false)
    private Integer dose;

    public PacienteVacinado(Paciente paciente, Profissional profissional, Vacina vacina, LocalDate data_aplicacao, Integer dose) {
        this.paciente = paciente;
        this.profissional = profissional;
        this.vacina = vacina;
        this.data_aplicacao = data_aplicacao;
        this.dose = dose;
    }
}

