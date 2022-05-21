package br.com.letscode.postosaude.testesIntegracaoService;

import br.com.letscode.postosaude.model.Vacina;
import br.com.letscode.postosaude.services.VacinaService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VacinaServiceIntegTest {

    @Autowired
    VacinaService vacinaService;

    public Vacina vacinaTeste;

    @BeforeAll
    static void iniciaTestesAll() {
        System.out.println("Iniciando teste de todos");
    }

    @BeforeEach
    public void iniciaTestesEach(){
        System.out.println("Iniciando model");
        vacinaTeste.setId(1);
        vacinaTeste.setDeleted_at(null);
        vacinaTeste.setDeleted_by(null);
        vacinaTeste.setCodigoVacina(10984);
        vacinaTeste.setFabricante("FUNDACAO BUTANTAN");
        vacinaTeste.setPosto_saude(2249278);
    }

    @Test
    @DisplayName("Teste deletar Vacina service com sucesso")
    public void deleteVacinaIntegracaoTeste(){}

    @Test
    @DisplayName("Teste atualizar Vacina service com sucesso")
    void updateVacinaIntegracaoTeste(){}

    @Test
    @DisplayName("Teste delete Vacina service com Id inexistente")
    void deleteVacinaComIdInexistenteTeste(){

    }

    @Test
    @DisplayName("Teste atualizar Vacina service com Id inválido")
    void atualizarVacinaComIdInvalidoTeste(){

    }

}
