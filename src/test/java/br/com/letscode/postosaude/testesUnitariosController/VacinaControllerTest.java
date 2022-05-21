package br.com.letscode.postosaude.testesUnitariosController;

import br.com.letscode.postosaude.model.Vacina;
import br.com.letscode.postosaude.controller.VacinaController;
import br.com.letscode.postosaude.services.VacinaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ContextConfiguration
@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = VacinaController.class)
public class VacinaControllerTest {

    @MockBean
    private VacinaService vacinaService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Teste atualizar a Vacina Controller com sucesso")
    void updateVacinaControllerTest() throws Exception{
        Vacina vacina = new Vacina(1,10984,"FUNDACAO BUTANTAN", 2249278);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/vacina/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(vacina)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.equalTo("Vacina atualizada com sucesso")));

        Mockito.verify(vacinaService).updateVacina(1,vacina);
    }

    @Test
    @DisplayName("Teste de deletar a vacina Controller com sucesso")
    void deleteVacinaControllerTest() throws Exception{
        Vacina vacina = new Vacina(1,10984,"FUNDACAO BUTANTAN", 2249278);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/vacina/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(vacina)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.equalTo("Vacina deletada com sucesso")));

        Mockito.verify(vacinaService).deleteVacina(vacina.getId());
    }

    @Test
    @DisplayName("Teste de deletar a vacina Controller com id inválido")
    void deleteVacinaControllerIdInvalidoTeste() throws Exception{

    }

    @Test
    @DisplayName("Teste de atualizar a vacina Controller com id inválido")
    void updateVacinaControllerIdInvalidoTeste() throws Exception{

    }
}
