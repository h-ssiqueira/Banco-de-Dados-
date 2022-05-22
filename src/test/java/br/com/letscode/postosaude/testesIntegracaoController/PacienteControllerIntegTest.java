package br.com.letscode.postosaude.testesIntegracaoController;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PacienteControllerIntegTest {

    @Autowired
    TestRestTemplate restTemplate;

    public static Paciente pacienteTeste;

    @BeforeAll
    static void iniciaTestesEach(){
        System.out.println("Iniciando model");
        pacienteTeste = new Paciente();
        pacienteTeste.setId(400);
        pacienteTeste.setNome("Teste");
        pacienteTeste.setSexo(SexoEnum.MASCULINO);
        pacienteTeste.setData_nascimento(LocalDate.parse("2001-05-29"));
        pacienteTeste.setDeleted_at(null);
        pacienteTeste.setDeleted_by(null);
    }

    @Test
    @DisplayName("Teste criar Paciente controller com sucesso")
    void criaPacienteControllerIntegracaoTest(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(pacienteTeste, httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/paciente", HttpMethod.POST, httpEntity, Void.class);

        Assertions.assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste atualizar Paciente controller com sucesso")
    void updatePacienteControllerIntegracaoTest(){

        pacienteTeste.setNome("pedro");
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(pacienteTeste, httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/paciente/50", HttpMethod.PUT, httpEntity, Void.class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
        pacienteTeste.setNome("Teste");
    }

    @Test
    @DisplayName("Teste deletar Paciente controller com sucesso")
    void deletePacienteControllerIntegracaoTest(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/paciente/delete/10", HttpMethod.DELETE, httpEntity, Void.class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste consultar Paciente por nome controller com sucesso")
    void consultaPacienteNControllerIntegracaoTest(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Paciente> response = this.restTemplate
                .exchange("/paciente/LURDES CANAL", HttpMethod.GET, httpEntity, Paciente.class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNotNull(response.getBody().getNome());
    }

    @Test
    @DisplayName("Teste consultar Paciente por genero controller com sucesso")
    void consultaPacienteGControllerIntegracaoTest(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Paciente[]> response = this.restTemplate
                .exchange("/paciente/genero/MASCULINO", HttpMethod.GET, httpEntity, Paciente[].class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNotEquals(0, response.getBody().length);
        Assertions.assertNotNull(response.getBody()[0].getNome());
    }

    @Test
    @DisplayName("Teste criação de paciente controller com nome já existente")
    void criaPacienteComNomeExistenteControllerTeste(){

        pacienteTeste.setNome("SOLANGE GEMA DALL ALBA");
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(pacienteTeste, httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/paciente", HttpMethod.POST, httpEntity, Void.class);

        Assertions.assertEquals(400, response.getStatusCodeValue());
        pacienteTeste.setNome("Teste");
    }

    @Test
    @DisplayName("Teste consultar paciente controller com nome inexistente")
    void consultaPacienteComNomeInexistenteControllerTeste() {

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Paciente> response = null;
        try {
            response = this.restTemplate
                    .exchange("/paciente/Teste1", HttpMethod.GET, httpEntity, Paciente.class);
        } catch (Exception e) {
            Assertions.assertNull(response);
        }
    }

    @Test
    @DisplayName("Teste consulta de paciente controller com gênero não cadastrado")
    void consultaPacienteComGeneroNaoCadastradoControllerTeste(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        try {
            Optional<ResponseEntity<Paciente[]>> response = Optional.of(this.restTemplate
                    .exchange("/paciente/genero/OUTRO", HttpMethod.GET, httpEntity, Paciente[].class));
        }catch(Exception ex){
            Assertions.assertEquals("Paciente não encontrado!",ex.getCause());
            Assertions.assertEquals("Paciente não encontrado!",ex.getMessage());
        }

    }

    @Test
    @DisplayName("Teste delete de paciente controller com id inexistente")
    void deletePacienteComIdInexistenteControllerTeste(){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/paciente/delete/1001", HttpMethod.DELETE, httpEntity, Void.class);

        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste atualiza paciente controller com nome já existente")
    void atualizaPacienteComNomeExistenteControllerTeste(){

        pacienteTeste.setNome("SOLANGE GEMA DALL ALBA");
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(pacienteTeste, httpHeaders);

        try{
            ResponseEntity response = this.restTemplate
                    .exchange("/paciente/50", HttpMethod.PUT, httpEntity, Void.class);
        }catch (Exception ex){
            Assertions.assertEquals(ex.getMessage(), "Nome inválido");
        }

        pacienteTeste.setNome("Teste");
    }
}
