package br.com.letscode.postosaude.testesIntegracaoService;

import br.com.letscode.postosaude.model.CargosEnum;
import br.com.letscode.postosaude.model.Profissional;
import br.com.letscode.postosaude.services.ProfissionalService;
import br.com.letscode.postosaude.repository.ProfissionalRepositorio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfissionalServiceIntegTest {

    @Autowired
    ProfissionalService profissionalService;

    public Profissional profissionalTeste;

    @BeforeAll
    static void iniciaTestesAll() {
        System.out.println("Iniciando teste de todos");
    }

    @BeforeEach
    public void iniciaTestesEach(){
        System.out.println("Iniciando model");
        profissionalTeste = new Profissional();
        profissionalTeste.setId(1);
        profissionalTeste.setCargo(CargosEnum.PROFISSIONAL_SAUDE);
        profissionalTeste.setCodigoRegistro("123");
        profissionalTeste.setDeleted_at(null);
        profissionalTeste.setDeleted_by(null);
    }

    @Test
    @DisplayName("Teste consulta profissional service")
    public void consultaListaProfissionalIntegracaoTeste(){
        List<Profissional> profissionalList = profissionalService.selecionarTodos();
        assertNotNull(profissionalList);
        assertTrue(profissionalList.size() > 0);
    }
    @Test
    @DisplayName("Teste atualizar Profissional service")
    public void updateProfissionalIntegracaoTeste(){
        Profissional profissional = profissionalService.updateProfissional(1,profissionalTeste);
        assertEquals(profissional.getDeleted_at(), LocalDate.parse("2022-05-21"));
        assertEquals(profissional.getDeleted_by(), profissionalTeste.getDeleted_by());
    }
}
