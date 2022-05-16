package br.com.letscode.postosaude.testesUnitariosController;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import br.com.letscode.postosaude.controller.PacienteController;
import br.com.letscode.postosaude.services.PacienteService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ContextConfiguration
@ExtendWith(MockitoExtension.class)
public class PacienteControllerTest {

    @MockBean
    private PacienteService pacienteService;
    @Mock
    private PacienteRepositorio pacienteRepository;

    @Test
    @DisplayName("Teste criar Paciente controller")
    void criaPacienteControllerTest() throws Exception{
        List<Paciente> pacientesList = new ArrayList<>();
        pacientesList.add(new Paciente("Marina", LocalDate.parse("2003-02-13"), SexoEnum.FEMININO));
        pacientesList.add(new Paciente("Rhuan", LocalDate.parse("2001-05-24"), SexoEnum.MASCULINO));
        pacientesList.add(new Paciente("Henrique", LocalDate.parse("2001-05-24"), SexoEnum.MASCULINO));

        /*Mockito.when(pacienteRepository.())
                .thenReturn(pacientesList);*/
    }

    @Test
    @DisplayName("Teste atualizar Paciente controller")
    void updatePacienteControllerTest() throws Exception{

    }

    @Test
    @DisplayName("Teste deletar Paciente controller")
    void deletePacienteControllerTest() throws Exception{

    }

    @Test
    @DisplayName("Teste consultar Paciente por nome controller")
    void consultaPacienteNControllerTest() throws Exception{

    }

    @Test
    @DisplayName("Teste consultar Paciente por genero controller")
    void consultaPacienteGControllerTest() throws Exception{

    }
}
