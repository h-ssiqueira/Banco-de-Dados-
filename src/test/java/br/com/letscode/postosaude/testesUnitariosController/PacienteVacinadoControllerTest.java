package br.com.letscode.postosaude.testesUnitariosController;

import br.com.letscode.postosaude.model.PacienteVacinado;
import br.com.letscode.postosaude.repository.PacienteVacinadoRepositorio;
import br.com.letscode.postosaude.controller.PacienteVacinadoController;
import br.com.letscode.postosaude.services.PacienteService;
import br.com.letscode.postosaude.services.PacienteVacinadoService;
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
public class PacienteVacinadoControllerTest {

    @MockBean
    private PacienteVacinadoService pacienteVacinadoService;

    @Test
    @DisplayName("Teste criar PacienteVacinado controller")
    void criarPacienteVacinadoControllerTest() throws Exception{

    }

    @Test
    @DisplayName("Teste atualizar PacienteVacinado controller")
    void updatePacienteVacinadoControllerTest() throws Exception{

    }

    @Test
    @DisplayName("Teste consultar PacienteVacinado controller")
    void consultarPacienteVacinadoControllerTest() throws Exception{

    }

    @Test
    @DisplayName("Teste remover PacienteVacinado controller")
    void deletarPacienteVacinadoControllerTest() throws Exception{

    }
}
