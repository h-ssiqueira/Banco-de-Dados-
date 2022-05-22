package br.com.letscode.postosaude.testesUnitariosController;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import br.com.letscode.postosaude.controller.PacienteController;
import br.com.letscode.postosaude.services.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
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
    @DisplayName("Teste criar Paciente controller com sucesso")
    void criaPacienteControllerTest() throws Exception{
        Paciente paciente = new Paciente("Marina", LocalDate.parse("2001-05-24"), SexoEnum.FEMININO);

        Mockito.when(pacienteService.consultaPacienteN("Marina")).thenReturn(paciente);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/paciente")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(paciente)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.equalTo("Paciente criado com sucesso!")));

        Mockito.verify(pacienteService).criarPaciente(paciente);
    }

    @Test
    @DisplayName("Teste atualizar Paciente controller com sucesso")
    void updatePacienteControllerTest() throws Exception{
        Paciente paciente = new Paciente(1,"Marina", LocalDate.parse("2001-05-24"), SexoEnum.FEMININO);
        Paciente pacienteRetorno = new Paciente(2,"Creusa", LocalDate.parse("2001-05-24"), SexoEnum.FEMININO);

        Mockito.when(pacienteService.updatePaciente(paciente.getId(),pacienteRetorno)).thenReturn(paciente);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/paciente/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(pacienteRetorno))
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.equalTo("Paciente atualizado com sucesso")));

        Mockito.verify(pacienteService).updatePaciente(paciente.getId(),pacienteRetorno);

    }

    @Test
    @DisplayName("Teste deletar Paciente controller com sucesso")
    void deletePacienteControllerTest() throws Exception{
        Paciente paciente = new Paciente(1,"Marina", LocalDate.parse("2001-05-24"), SexoEnum.FEMININO);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/paciente/delete/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(paciente)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.equalTo("Paciente deletado com sucesso")));

        Mockito.verify(pacienteService).deletePaciente(paciente.getId());
    }

    @Test
    @DisplayName("Teste consultar Paciente por nome controller com sucesso")
    void consultaPacienteNControllerTest() throws Exception{
        Paciente paciente = new Paciente(1,"Rhuan", LocalDate.parse("2001-05-24"), SexoEnum.MASCULINO);

        Mockito.when(pacienteService.consultaPacienteN("Rhuan")).thenReturn(paciente);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/paciente/Rhuan").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(pacienteService).consultaPacienteN(paciente.getNome());
    }

    @Test
    @DisplayName("Teste consultar Paciente por genero controller com sucesso")
    void consultaPacienteGControllerTest() throws Exception{
        List<Paciente> pacientesList = new ArrayList<>();

        pacientesList.add(new Paciente("Marina", LocalDate.parse("2003-02-13"), SexoEnum.FEMININO));
        pacientesList.add(new Paciente("Rhuan", LocalDate.parse("2001-05-24"), SexoEnum.MASCULINO));
        pacientesList.add(new Paciente("Henrique", LocalDate.parse("2001-05-24"), SexoEnum.MASCULINO));

        Mockito.when(pacienteService.consultaPacienteG(SexoEnum.FEMININO)).thenReturn(pacientesList);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/paciente/genero/FEMININO").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(pacientesList.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", Matchers.is(pacientesList.get(0).getId()), Integer.class));

        Mockito.verify(pacienteService).consultaPacienteG(pacientesList.get(0).getSexo());
    }

    @Test
    @DisplayName("Teste criação de paciente controller com nome já existente")
    void criaPacienteComNomeExistenteControllerTeste() throws Exception{

    }

    @Test
    @DisplayName("Teste consultar paciente controller com nome inexistente")
    void consultaPacienteComNomeInexistenteControllerTeste() throws Exception{

    }

    @Test
    @DisplayName("Teste consulta de paciente controller com gênero não cadastrado")
    void consultaPacienteComGeneroNaoCadastradoControllerTeste() throws Exception{

    }

    @Test
    @DisplayName("Teste delete de paciente controller com id inexistente")
    void deletePacienteComIdInexistenteControllerTeste() throws Exception{

    }

    @Test
    @DisplayName("Teste atualiza paciente controller com nome já existente")
    void atualizaPacienteComNomeExistenteControllerTeste() throws Exception{


    }
}
