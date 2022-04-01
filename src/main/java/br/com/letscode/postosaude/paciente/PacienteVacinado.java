package br.com.letscode.postosaude.paciente;

import br.com.letscode.postosaude.profissionais.CargosEnum;
import br.com.letscode.postosaude.profissionais.Profissional;
import br.com.letscode.postosaude.vacina.Vacina;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class PacienteVacinado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn (name = "profissional_id", nullable = false)
    private Profissional profissional;

    @ManyToOne
    @JoinColumn (name = "vacina_id", nullable = false)
    private Vacina vacina;

    @Column (nullable = false)
    private LocalDate data_aplicacao;

}
