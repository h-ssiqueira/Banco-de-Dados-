package br.com.letscode.postosaude.testesIntegracaoService;

import br.com.letscode.postosaude.model.*;
import br.com.letscode.postosaude.services.PacienteVacinadoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PacienteVacinadoServiceIntegTest {

    @Autowired
    public PacienteVacinadoService pacienteVacinadoService;

    public static PacienteVacinado pacienteVacinadoTeste;

    @BeforeAll
    static void iniciaTestesAll() {
        System.out.println("Iniciando teste de todos");
    }

    @BeforeAll
    static void iniciaTestesEach(){
        System.out.println("Iniciando model");
        pacienteVacinadoTeste = new PacienteVacinado();
        pacienteVacinadoTeste.setId(400);
        pacienteVacinadoTeste.setPaciente(new Paciente(3,"Rodrigo", LocalDate.now(), SexoEnum.MASCULINO));
        pacienteVacinadoTeste.setVacina(new Vacina(1,"Postinho",15));
        pacienteVacinadoTeste.setProfissional(new Profissional(3,"Profissional 1", CargosEnum.PROFISSIONAL_SAUDE,null));
        pacienteVacinadoTeste.setData_aplicacao(LocalDate.now());
        pacienteVacinadoTeste.setDose(1);
        pacienteVacinadoTeste.setDeleted_at(null);
        pacienteVacinadoTeste.setDeleted_by(null);
    }

    @Test
    @Transactional
    @Disabled
    @DisplayName("Teste criar PacienteVacinado service com sucesso")
    public void criarPacienteVacinadoIntegracaoTeste(){
        PacienteVacinado retorno = pacienteVacinadoService.criarPacienteVacinado(pacienteVacinadoTeste);
        assertNotNull(retorno.getId());
        assertEquals(retorno.getDose(), pacienteVacinadoTeste.getDose());
        assertEquals(retorno.getPaciente(), pacienteVacinadoTeste.getPaciente());
        assertEquals(retorno.getProfissional(), pacienteVacinadoTeste.getProfissional());
        assertEquals(retorno.getVacina(), pacienteVacinadoTeste.getVacina());
        assertEquals(retorno.getData_aplicacao(), pacienteVacinadoTeste.getData_aplicacao());
    }

    @Test
    @DisplayName("Teste atualizar PacienteVacinado service com sucesso")
    public void updatePacienteVacinadoIntegracaoTeste(){
        PacienteVacinado pacienteVacinado = pacienteVacinadoService.updatePacienteVacinado(1, pacienteVacinadoTeste);
        assertNotNull(pacienteVacinado);
    }

    @Test
    @DisplayName("Teste Consulta PacienteVacinado service com sucesso")
    public void consultaPacienteVacinadoIntegracaoTeste(){
        List<PacienteVacinado> pacienteVacinados = pacienteVacinadoService.consultarPacienteVacinado(1);
        assertNotNull(pacienteVacinados);
        assertTrue(pacienteVacinados.size() > 0);
    }

    @Test
    @DisplayName("Teste deletar PacienteVacinado service com sucesso")
    public void deletarPacienteVacinadoIntegracaoTeste(){
        pacienteVacinadoService.deletarPacienteVacinado(1);
    }
}
