package br.com.letscode.postosaude.testesUnitariosController;

import br.com.letscode.postosaude.controller.PacienteVacinadoController;
import br.com.letscode.postosaude.model.*;
import br.com.letscode.postosaude.services.PacienteVacinadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PacienteVacinadoController.class)
public class PacienteVacinadoControllerTest {

    @MockBean
    private PacienteVacinadoService pacienteVacinadoService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

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
        List<PacienteVacinado> pacientesVacinados = new ArrayList<>();
        pacientesVacinados.add(new PacienteVacinado(
                1,
                new Paciente(1,"Jessica", LocalDate.parse("1980-01-01"), SexoEnum.FEMININO),
                new Profissional("1", CargosEnum.PROFISSIONAL_SAUDE, null),
                new Vacina(1,123,"Hospital",333),
                LocalDate.parse("2022-05-16"),
                3
        ));
        pacientesVacinados.add(new PacienteVacinado(
                1,
                new Paciente(2,"Valdemar",LocalDate.parse("1980-01-01"),SexoEnum.MASCULINO),
                new Profissional("2",CargosEnum.PROFISSIONAL_SAUDE, null),
                new Vacina(2,1234,"Hospital das clínicas",323),
                LocalDate.parse("2022-05-17"),
                3
        ));
        pacientesVacinados.add(new PacienteVacinado(
                1,
                new Paciente(3,"Amélia",LocalDate.parse("1980-05-01"),SexoEnum.FEMININO),
                new Profissional("3",CargosEnum.PROFISSIONAL_SAUDE, null),
                new Vacina(3,1234,"Hospital das clínicas II",123),
                LocalDate.parse("2022-04-17"),
                3
        ));

        Mockito.when(pacienteVacinadoService.consultarPacienteVacinado(3))
                .thenReturn(pacientesVacinados);

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/pacientevacinado/3")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
            )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(pacientesVacinados.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", Matchers.is(pacientesVacinados.get(0).getDose()), Long.class));

    }

    @Test
    @DisplayName("Teste remover PacienteVacinado controller")
    void deletarPacienteVacinadoControllerTest() throws Exception{

    }
}
