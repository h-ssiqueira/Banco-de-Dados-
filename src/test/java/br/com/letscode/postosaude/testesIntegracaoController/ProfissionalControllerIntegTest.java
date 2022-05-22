package br.com.letscode.postosaude.testesIntegracaoController;

import br.com.letscode.postosaude.model.CargosEnum;
import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.Profissional;
import org.apache.tomcat.jni.Local;
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

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfissionalControllerIntegTest {

    @Autowired
    TestRestTemplate restTemplate;
    public Profissional profissionalTeste;

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
    @DisplayName("Teste consultar todos os Profissionais controller com sucesso")
    void selecionarTodosControllerIntegracaoTest(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Profissional[]> response = this.restTemplate
                .exchange("/profissional", HttpMethod.GET, httpEntity, Profissional[].class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNotEquals(0, response.getBody().length);
    }

    @Test
    @DisplayName("Teste remover Profissional controller com sucesso")
    void deleteProfissionalControllerIntegracaoTest(){

        profissionalTeste.setDeleted_at(LocalDate.now());
        profissionalTeste.setDeleted_by("Solange");
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(profissionalTeste,httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/profissional/10", HttpMethod.DELETE, httpEntity, Void.class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
    }
}
