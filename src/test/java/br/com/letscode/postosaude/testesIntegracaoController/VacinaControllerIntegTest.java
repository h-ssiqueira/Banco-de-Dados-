package br.com.letscode.postosaude.testesIntegracaoController;

import br.com.letscode.postosaude.model.Vacina;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VacinaControllerIntegTest {

    @Autowired
    TestRestTemplate restTemplate;
    public Vacina vacinaTeste;

    @BeforeEach
    public void iniciaTestesEach(){
        System.out.println("Iniciando model");
        vacinaTeste = new Vacina();
        vacinaTeste.setId(1);
        vacinaTeste.setDeleted_at(null);
        vacinaTeste.setDeleted_by(null);
        vacinaTeste.setCodigoVacina(10984);
        vacinaTeste.setFabricante("FUNDACAO BUTANTAN");
        vacinaTeste.setPosto_saude(2249278);
    }

    @Test
    @DisplayName("Teste atualizar a Vacina Controller com sucesso")
    void updateVacinaControllerIntegracaoTest(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(vacinaTeste, httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/vacina/50", HttpMethod.PUT, httpEntity, Void.class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste de deletar a vacina Controller com sucesso")
    void deleteVacinaControllerIntegracaoTest(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/vacina/10", HttpMethod.DELETE, httpEntity, Void.class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

}
