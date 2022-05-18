package br.com.letscode.postosaude.testesUnitariosController;

import br.com.letscode.postosaude.exception.ProfissionalNaoEncontradoException;
import br.com.letscode.postosaude.model.Profissional;
import br.com.letscode.postosaude.model.Vacina;
import br.com.letscode.postosaude.repository.VacinaRepositorio;
import br.com.letscode.postosaude.controller.VacinaController;
import br.com.letscode.postosaude.services.PacienteService;
import br.com.letscode.postosaude.services.VacinaService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@ContextConfiguration
@ExtendWith(MockitoExtension.class)
public class VacinaControlerTest {

    @MockBean
    private VacinaService vacinaService;

    @Test
    @DisplayName("Teste atualizar a Vacina Controller")
    void updateVacinaControllerTest() throws Exception{

    }

    @Test
    @DisplayName("Teste de deletar a vacina Controller")
    void deleteVacinaControllerTest() throws Exception{
        
    }

}
