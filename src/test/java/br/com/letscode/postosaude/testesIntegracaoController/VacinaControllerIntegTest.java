package br.com.letscode.postosaude.testesIntegracaoController;

import br.com.letscode.postosaude.model.Vacina;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VacinaControllerIntegTest {
    public Vacina vacinaTeste;

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
    @DisplayName("Teste atualizar a Vacina Controller com sucesso")
    void updateVacinaControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste de deletar a vacina Controller com sucesso")
    void deleteVacinaControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste de deletar a vacina Controller com id inválido")
    void deleteVacinaControllerIdInvalidoTeste(){

    }

    @Test
    @DisplayName("Teste de atualizar a vacina Controller com id inválido")
    void updateVacinaControllerIdInvalidoTeste(){

    }

}
