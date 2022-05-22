package br.com.letscode.postosaude.testesIntegracaoController;

import br.com.letscode.postosaude.model.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PacienteVacinadoControllerIntegTest {

    @Autowired
    TestRestTemplate restTemplate;
    public PacienteVacinado pacienteVacinadoTeste;

    @BeforeEach
    public void iniciaTestesEach(){
        System.out.println("Iniciando model");
        pacienteVacinadoTeste = new PacienteVacinado();
        pacienteVacinadoTeste.setPaciente(new Paciente(2011,"Rodrigo2", LocalDate.now(), SexoEnum.MASCULINO));
        pacienteVacinadoTeste.setVacina(new Vacina(2011,"Postinho",15));
        pacienteVacinadoTeste.setProfissional(new Profissional(2011,"Profissional 1", CargosEnum.PROFISSIONAL_SAUDE,null));
        pacienteVacinadoTeste.setData_aplicacao(LocalDate.now());
        pacienteVacinadoTeste.setDose(1);
        pacienteVacinadoTeste.setId(1000);
        pacienteVacinadoTeste.setDeleted_at(null);
        pacienteVacinadoTeste.setDeleted_by(null);
    }

    @Test
    @Transactional
    @Disabled
    @DisplayName("Teste criar PacienteVacinado controller com sucesso")
    void criarPacienteVacinadoControllerIntegracaoTest(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(pacienteVacinadoTeste, httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/pacientevacinado", HttpMethod.POST, httpEntity, Void.class);

        Assertions.assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste atualizar PacienteVacinado controller com sucesso")
    void updatePacienteVacinadoControllerIntegracaoTest(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(pacienteVacinadoTeste, httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/pacientevacinado/1", HttpMethod.PUT, httpEntity, Void.class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste consultar PacienteVacinado controller com sucesso")
    void consultarPacienteVacinadoControllerIntegracaoTest(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<PacienteVacinado[]> response = this.restTemplate
                .exchange("/pacientevacinado/1", HttpMethod.GET, httpEntity, PacienteVacinado[].class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNotEquals(0, response.getBody().length);
    }

    @Test
    @DisplayName("Teste remover PacienteVacinado controller com sucesso")
    void deletarPacienteVacinadoControllerIntegracaoTest(){

        pacienteVacinadoTeste.setId(13);

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(pacienteVacinadoTeste, httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/pacientevacinado/10", HttpMethod.DELETE, httpEntity, Void.class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
        pacienteVacinadoTeste.setId(1000);
    }

    @Test
    @DisplayName("Teste criar PacienteVacinado controller com id inexistente")
    void criarPacienteVacinadoComIdInexistenteControllerTeste(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(pacienteVacinadoTeste,httpHeaders);

        try {
            ResponseEntity response = this.restTemplate
                    .exchange("/pacientevacinado", HttpMethod.POST, httpEntity, Void.class);
        }catch(Exception ex) {
            Assertions.assertEquals("Paciente já existente no sistema!", ex.getMessage());
        }

    }

    @Test
    @DisplayName("Teste consultar PacienteVacinado controller com dose inexistente")
    void consultaPacienteVacinadoComDoseInexistenteControllerTeste(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        try {
            Optional<ResponseEntity<PacienteVacinado[]>> response = Optional.of(this.restTemplate
                    .exchange("/pacientevacinado/10", HttpMethod.GET, httpEntity, PacienteVacinado[].class));
        }catch(Exception ex){
            Assertions.assertEquals("Paciente Vacinado não encontrado!", ex.getMessage());
        }
    }

    @Test
    @DisplayName("Teste remover PacienteVacinado controller com id inexistente")
    void deletePacienteVacinadoComIdInexistenteControllerTeste(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(pacienteVacinadoTeste, httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/pacientevacinado/10000", HttpMethod.DELETE, httpEntity, Void.class);

        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste atualiza PacienteVacinado controller com data invalida")
    void atualizarPacienteVacinadoComDataInvalidaControllerTeste(){

        pacienteVacinadoTeste.setData_aplicacao(LocalDate.parse("2045-12-12"));
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(pacienteVacinadoTeste, httpHeaders);

        try {
            ResponseEntity response = this.restTemplate
                    .exchange("/pacientevacinado/10", HttpMethod.PUT, httpEntity, Void.class);
        }catch(Exception e) {
            Assertions.assertEquals("Data inválida", e.getMessage());
        }
    }
}
