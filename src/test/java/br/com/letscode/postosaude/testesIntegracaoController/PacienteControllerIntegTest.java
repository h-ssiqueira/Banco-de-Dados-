package br.com.letscode.postosaude.testesIntegracaoController;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PacienteControllerIntegTest {

    public Paciente pacienteTeste;

    @BeforeEach
    public void iniciaTestesEach(){
        System.out.println("Iniciando model");
        pacienteTeste = new Paciente();
        pacienteTeste.setId(1);
        pacienteTeste.setNome("Teste");
        pacienteTeste.setSexo(SexoEnum.MASCULINO);
        pacienteTeste.setData_nascimento(LocalDate.parse("2001-05-29"));
        pacienteTeste.setDeleted_at(null);
        pacienteTeste.setDeleted_by(null);

        // TODO: 20/05/2022 Colocar o  HttpEntity aqui?
    }

    @Test
    @DisplayName("Teste criar Paciente controller com sucesso")
    void criaPacienteControllerIntegracaoTest(){
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(pacienteTeste, httpHeaders);

        ResponseEntity response = this.restTemplate
                .exchange("/paciente", HttpMethod.POST, httpEntity, Void.class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste atualizar Paciente controller com sucesso")
    void updatePacienteControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste deletar Paciente controller com sucesso")
    void deletePacienteControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste consultar Paciente por nome controller com sucesso")
    void consultaPacienteNControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste consultar Paciente por genero controller com sucesso")
    void consultaPacienteGControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste criação de paciente controller com nome já existente")
    void criaPacienteComNomeExistenteControllerTeste(){

    }

    @Test
    @DisplayName("Teste consultar paciente controller com nome inexistente")
    void consultaPacienteComNomeInexistenteControllerTeste(){

    }

    @Test
    @DisplayName("Teste consulta de paciente controller com gênero não cadastrado")
    void consultaPacienteComGeneroNaoCadastradoControllerTeste(){

    }

    @Test
    @DisplayName("Teste delete de paciente controller com id inexistente")
    void deletePacienteComIdInexistenteControllerTeste(){

    }

    @Test
    @DisplayName("Teste atualiza paciente controller com nome já existente")
    void atualizaPacienteComNomeExistenteControllerTeste(){


    }
}
