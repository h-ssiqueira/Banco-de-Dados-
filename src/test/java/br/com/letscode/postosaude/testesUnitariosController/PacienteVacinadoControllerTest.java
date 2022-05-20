package br.com.letscode.postosaude.testesUnitariosController;

import br.com.letscode.postosaude.controller.PacienteVacinadoController;
import br.com.letscode.postosaude.model.*;
import br.com.letscode.postosaude.services.PacienteVacinadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
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

        PacienteVacinado pacienteVacinado = new PacienteVacinado(1,
                new Paciente(2,"Valdemar",LocalDate.parse("1980-01-01"),SexoEnum.MASCULINO),
                new Profissional("2",CargosEnum.PROFISSIONAL_SAUDE, null),
                new Vacina(2,1234,"Hospital das clínicas",323),
                LocalDate.parse("2022-05-17"),
                3);
        PacienteVacinado pacienteVacinadoRetorno = new PacienteVacinado(1,
                new Paciente(2,"Valdemar",LocalDate.parse("1980-01-01"),SexoEnum.MASCULINO),
                new Profissional("2",CargosEnum.PROFISSIONAL_SAUDE, null),
                new Vacina(2,1234,"Hospital das clínicas",323),
                LocalDate.parse("2022-05-17"),
                3);

        Mockito.when(pacienteVacinadoService.criarPacienteVacinado(pacienteVacinado))
                .thenReturn(pacienteVacinado);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/pacientevacinado")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(pacienteVacinadoRetorno))
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.equalTo("PacienteVacinado criado com sucesso!")));

        Assertions.assertEquals(pacienteVacinado.getPaciente(), pacienteVacinadoRetorno.getPaciente());
        Assertions.assertEquals(pacienteVacinado.getData_aplicacao(), pacienteVacinadoRetorno.getData_aplicacao());
        Assertions.assertEquals(pacienteVacinado.getId(), pacienteVacinadoRetorno.getId());
        Assertions.assertEquals(pacienteVacinado.getDose(), pacienteVacinadoRetorno.getDose());
        Assertions.assertEquals(pacienteVacinado.getVacina(), pacienteVacinadoRetorno.getVacina());
        Assertions.assertEquals(pacienteVacinado.getProfissional(), pacienteVacinadoRetorno.getProfissional());

        Mockito.verify(pacienteVacinadoService).criarPacienteVacinado(pacienteVacinado);
    }

    @Test
    @DisplayName("Teste atualizar PacienteVacinado controller")
    void updatePacienteVacinadoControllerTest() throws Exception{
        PacienteVacinado pacienteVacinado = new PacienteVacinado(1,
                new Paciente(5,"Dolores",LocalDate.parse("1980-01-01"),SexoEnum.FEMININO),
                new Profissional("20",CargosEnum.PROFISSIONAL_ESTOQUE, null),
                new Vacina(5,4321,"HC",975),
                LocalDate.parse("2022-05-07"),
                6);
        PacienteVacinado pacienteVacinadoRetorno = new PacienteVacinado(1,
                new Paciente(5,"Dolores",LocalDate.parse("1980-01-01"),SexoEnum.FEMININO),
                new Profissional("20",CargosEnum.PROFISSIONAL_ESTOQUE, null),
                new Vacina(5,4321,"HC",975),
                LocalDate.parse("2022-05-07"),
                6);

        Mockito.when(pacienteVacinadoService.updatePacienteVacinado(pacienteVacinado.getId(), pacienteVacinado))
                .thenReturn(pacienteVacinado);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/pacientevacinado/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(pacienteVacinadoRetorno))
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.equalTo("Paciente vacinado alterado com sucesso")));

        Mockito.verify(pacienteVacinadoService).updatePacienteVacinado(pacienteVacinado.getId(), pacienteVacinado);
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
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(pacientesVacinados.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].dose", Matchers.is(pacientesVacinados.get(0).getDose()), Integer.class))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].dose", Matchers.is(pacientesVacinados.get(1).getDose()), Integer.class))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[2].dose", Matchers.is(pacientesVacinados.get(2).getDose()), Integer.class));

        Mockito.verify(pacienteVacinadoService).consultarPacienteVacinado(3);
    }

    @Test
    @DisplayName("Teste remover PacienteVacinado controller")
    void deletarPacienteVacinadoControllerTest() throws Exception{
        PacienteVacinado pacienteVacinado = new PacienteVacinado(1,
                new Paciente(2,"Valdemar",LocalDate.parse("1980-01-01"),SexoEnum.MASCULINO),
                new Profissional("2",CargosEnum.PROFISSIONAL_SAUDE, null),
                new Vacina(2,1234,"Hospital das clínicas",323),
                LocalDate.parse("2022-05-17"),
                3);

        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/pacientevacinado/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.equalTo("PacienteVacinado deletado com sucesso")));

        Mockito.verify(pacienteVacinadoService).deletarPacienteVacinado(pacienteVacinado.getId());
    }
}
