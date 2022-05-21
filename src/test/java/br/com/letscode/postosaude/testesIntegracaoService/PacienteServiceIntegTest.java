package br.com.letscode.postosaude.testesIntegracaoService;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.services.PacienteService;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestMethod;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PacienteServiceIntegTest {
    @Autowired
    public PacienteService pacienteService;

    public static Paciente pacienteTeste;

    @BeforeAll
    static void iniciaTestesAll() {
        System.out.println("Iniciando teste de todos");
    }

    @BeforeAll
    public static void iniciaTestesEach(){
        System.out.println("Iniciando model");
        pacienteTeste = new Paciente();
        pacienteTeste.setId(322);
        pacienteTeste.setNome("Teste");
        pacienteTeste.setSexo(SexoEnum.MASCULINO);
        pacienteTeste.setData_nascimento(LocalDate.parse("2001-05-29"));
        pacienteTeste.setDeleted_at(null);
        pacienteTeste.setDeleted_by(null);
    }

    @Test
    @Transactional
    @DisplayName("Teste criar paciente service")
    public void criarPacienteIntegracaoTeste(){
        Paciente paciente = pacienteService.criarPaciente(pacienteTeste);
        assertNotNull(paciente.getId());
        assertEquals(pacienteTeste.getNome(), paciente.getNome());
    }

    @Test
    @Transactional
    @DisplayName("Teste deletar paciente service")
    public void deletePacienteIntegracaoTeste(){
        Paciente paciente = pacienteService.consultaPacienteN("SOLANGE GEMA DALL ALBA");
        assertNotNull(paciente);
        pacienteService.deletePaciente(1);
        Paciente pacienteDepois = pacienteService.consultaPacienteN("SOLANGE GEMA DALL ALBA");
        assertNull(pacienteDepois);
    }

    @Test
    @DisplayName("Teste consulta paciente por nome service")
    public void consultaPacienteNIntegracaoTeste(){
        Paciente paciente  = pacienteService.consultaPacienteN("PRISCILA BATTISTI");
        assertNotNull(paciente);
    }

    @Test
    @DisplayName("Teste consulta paciente por genero service")
    public void consultaPacienteGIntegracaoTeste(){
        List<Paciente> pacientes = pacienteService.consultaPacienteG(pacienteTeste.getSexo());
        assertNotNull(pacientes);
        assertTrue(pacientes.size()>0);
    }

    @Test
    @DisplayName("Teste atualiza paciente service")
    public void updatePacienteIntegracaoTeste(){
        Paciente paciente = pacienteService.updatePaciente(1, pacienteTeste);
        assertEquals(paciente.getNome(), pacienteTeste.getNome());
    }

}
