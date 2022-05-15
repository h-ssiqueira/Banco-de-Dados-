package br.com.letscode.postosaude.testesUnitariosController;

import br.com.letscode.postosaude.model.Profissional;
import br.com.letscode.postosaude.repository.ProfissionalRepositorio;
import br.com.letscode.postosaude.controller.ProfissionalController;
import br.com.letscode.postosaude.services.PacienteService;
import br.com.letscode.postosaude.services.ProfissionalService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@ExtendWith(MockitoExtension.class)
public class ProfissionalControllerTest {

    @MockBean
    private ProfissionalService profissionalService;

    @Test
    @DisplayName("Teste consultar todos os Profissionais controller")
    void selecionarTodosControllerTest() throws Exception{

    }

    @Test
    @DisplayName("Teste remover Profissional controller")
    void deleteProfissionalControllerTest() throws Exception{

    }

}
