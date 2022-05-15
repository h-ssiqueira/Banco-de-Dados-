package br.com.letscode.postosaude.testesUnitariosService;

import br.com.letscode.postosaude.exception.ProfissionalNaoEncontradoException;
import br.com.letscode.postosaude.exception.VacinaNaoEncontradaException;
import br.com.letscode.postosaude.model.Profissional;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import br.com.letscode.postosaude.services.PacienteService;
import br.com.letscode.postosaude.services.VacinaService;
import br.com.letscode.postosaude.repository.VacinaRepositorio;
import br.com.letscode.postosaude.model.Vacina;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class VacinaServiceTest {

    @InjectMocks
    private VacinaService vacinaService;
    @Mock
    private VacinaRepositorio vacinaRepositorio;

    @Test
    @DisplayName("Teste deletar Vacina service")
    public void deleteVacinaTeste(){

    }

    @Test
    @DisplayName("Teste atualizar Vacina service")
    public void updateVacinaTeste(){
        Vacina entidade = this.vacinaRepositorio.findById(1).orElseThrow(VacinaNaoEncontradaException::new);

        entidade.setDeleted_at(LocalDate.now());
        Mockito.when(vacinaRepositorio.save(entidade)).thenReturn(entidade);

        Assertions.assertNotNull(entidade);
    }
}
