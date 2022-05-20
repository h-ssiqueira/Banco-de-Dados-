package br.com.letscode.postosaude.testesIntegracaoController;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.controller.PacienteController;
import br.com.letscode.postosaude.services.PacienteService;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
    @DisplayName("Teste criar Paciente controller")
    void criaPacienteControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste atualizar Paciente controller")
    void updatePacienteControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste deletar Paciente controller")
    void deletePacienteControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste consultar Paciente por nome controller")
    void consultaPacienteNControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste consultar Paciente por genero controller")
    void consultaPacienteGControllerIntegracaoTest(){}

}
