package br.com.letscode.vacinadoscoviddatabase.pessoavacinada;

import br.com.letscode.vacinadoscoviddatabase.Pessoa.Pessoa;
import br.com.letscode.vacinadoscoviddatabase.Vacina.Vacina;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class PessoaVacinada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn (name = "vacina_id", nullable = false)
    private Vacina vacina;


    @Column (nullable = false)
    private LocalDate data_aplicacao;

}
