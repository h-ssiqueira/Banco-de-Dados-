package br.com.letscode.postosaude.testesUnitariosController;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import br.com.letscode.postosaude.controller.PacienteController;
import br.com.letscode.postosaude.services.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.checkerframework.checker.units.qual.A;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PacienteController.class)
public class PacienteControllerTest {

    @MockBean
    private PacienteService pacienteService;
    @Mock
    private PacienteRepositorio pacienteRepository;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Teste criar Paciente controller")
    void criaPacienteControllerTest() throws Exception{

        /*Mockito.when(pacienteRepository.())
                .thenReturn(pacientesList);*/
    }

    @Test
    @DisplayName("Teste atualizar Paciente controller")
    void updatePacienteControllerTest() throws Exception{

    }

    @Test
    @DisplayName("Teste deletar Paciente controller")
    void    deletePacienteControllerTest() throws Exception{

    }

    @Test
    @DisplayName("Teste consultar Paciente por nome controller")
    void consultaPacienteNControllerTest() throws Exception{
        Paciente paciente = new Paciente("Rhuan", LocalDate.parse("2001-05-24"), SexoEnum.MASCULINO);

        Mockito.when(pacienteService.consultaPacienteN("Rhuan")).thenReturn(paciente);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/paciente/").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print());
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(paciente.getNome()),Long.class));

    }

    @Test
    @DisplayName("Teste consultar Paciente por genero controller")
    void consultaPacienteGControllerTest() throws Exception{
        List<Paciente> pacientesList = new ArrayList<>();

        pacientesList.add(new Paciente("Marina", LocalDate.parse("2003-02-13"), SexoEnum.FEMININO));
        pacientesList.add(new Paciente("Rhuan", LocalDate.parse("2001-05-24"), SexoEnum.MASCULINO));
        pacientesList.add(new Paciente("Henrique", LocalDate.parse("2001-05-24"), SexoEnum.MASCULINO));

        Mockito.when(pacienteService.consultaPacienteG(SexoEnum.FEMININO))
                .thenReturn(pacientesList);


    }
}
