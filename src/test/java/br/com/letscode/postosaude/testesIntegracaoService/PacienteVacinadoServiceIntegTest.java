package br.com.letscode.postosaude.testesIntegracaoService;

import br.com.letscode.postosaude.model.*;
import br.com.letscode.postosaude.services.PacienteVacinadoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PacienteVacinadoServiceIntegTest {

    @Autowired
    public PacienteVacinadoService pacienteVacinadoService;

    public PacienteVacinado pacienteVacinadoTeste;

    @BeforeAll
    static void iniciaTestesAll() {
        System.out.println("Iniciando teste de todos");
    }

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
    @Transactional
    @DisplayName("Teste criar PacienteVacinado service com sucesso")
    public void criarPacienteVacinadoIntegracaoTeste(){
        PacienteVacinado retorno = pacienteVacinadoService.criarPacienteVacinado(pacienteVacinadoTeste);

        assertNotNull(retorno.getId());
        assertEquals(retorno.getDose(), pacienteVacinadoTeste.getDose());
        assertEquals(retorno.getPaciente(), pacienteVacinadoTeste.getPaciente());
        assertEquals(retorno.getProfissional(), pacienteVacinadoTeste.getProfissional());
        assertEquals(retorno.getVacina(), pacienteVacinadoTeste.getVacina());
        assertEquals(retorno.getData_aplicacao(), pacienteVacinadoTeste.getData_aplicacao());
        assertEquals(retorno.getId(), pacienteVacinadoTeste.getId());
    }

    @Test
    @DisplayName("Teste atualizar PacienteVacinado service com sucesso")
    public void updatePacienteVacinadoIntegracaoTeste(){}

    @Test
    @DisplayName("Teste Consulta PacienteVacinado service com sucesso")
    public void consultaPacienteVacinadoIntegracaoTeste(){}

    @Test
    @DisplayName("Teste deletar PacienteVacinado service com sucesso")
    public void deletarPacienteVacinadoIntegracaoTeste(){}

    @Test
    @DisplayName("Teste criar PacienteVacinado service com id inexistente")
    void criarPacienteVacinadoComIdInexistenteTeste(){


    }

    @Test
    @DisplayName("Teste consultar PacienteVacinado service com dose inexistente")
    void consultaPacienteVacinadoComDoseInexistenteTeste(){


    }

    @Test
    @DisplayName("Teste remover PacienteVacinado service com id inexistente")
    void deletePacienteVacinadoComIdInexistenteTeste(){


    }

    @Test
    @DisplayName("Teste atualiza PacienteVacinado service com data invalida")
    void atualizarPacienteVacinadoComDataInvalidaTeste(){


    }
}
