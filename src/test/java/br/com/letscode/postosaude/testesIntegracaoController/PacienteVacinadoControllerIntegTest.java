package br.com.letscode.postosaude.testesIntegracaoController;

import br.com.letscode.postosaude.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PacienteVacinadoControllerIntegTest {
    public PacienteVacinado pacienteVacinadoTeste;

    @BeforeEach
    public void iniciaTestesEach(){
        System.out.println("Iniciando model");
        pacienteVacinadoTeste = new PacienteVacinado();
        pacienteVacinadoTeste.setPaciente(new Paciente("Rodrigo", LocalDate.now(), SexoEnum.MASCULINO));
        pacienteVacinadoTeste.setVacina(new Vacina(1,"Postinho",15));
        pacienteVacinadoTeste.setProfissional(new Profissional("Profissional 1", CargosEnum.PROFISSIONAL_SAUDE));
        pacienteVacinadoTeste.setData_aplicacao(LocalDate.now());
        pacienteVacinadoTeste.setDose(1);
        pacienteVacinadoTeste.setId(1);
        pacienteVacinadoTeste.setDeleted_at(null);
        pacienteVacinadoTeste.setDeleted_by(null);
    }

    @Test
    @DisplayName("Teste criar PacienteVacinado controller com sucesso")
    void criarPacienteVacinadoControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste atualizar PacienteVacinado controller com sucesso")
    void updatePacienteVacinadoControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste consultar PacienteVacinado controller com sucesso")
    void consultarPacienteVacinadoControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste remover PacienteVacinado controller com sucesso")
    void deletarPacienteVacinadoControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste criar PacienteVacinado controller com id inexistente")
    void criarPacienteVacinadoComIdInexistenteControllerTeste(){

    }

    @Test
    @DisplayName("Teste consultar PacienteVacinado controller com dose inexistente")
    void consultaPacienteVacinadoComDoseInexistenteControllerTeste(){

    }

    @Test
    @DisplayName("Teste remover PacienteVacinado controller com id inexistente")
    void deletePacienteVacinadoComIdInexistenteControllerTeste(){

    }

    @Test
    @DisplayName("Teste atualiza PacienteVacinado controller com data invalida")
    void atualizarPacienteVacinadoComDataInvalidaControllerTeste(){

    }
}
