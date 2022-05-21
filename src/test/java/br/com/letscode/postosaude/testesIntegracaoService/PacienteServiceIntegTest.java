package br.com.letscode.postosaude.testesIntegracaoService;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.services.PacienteService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PacienteServiceIntegTest {
    @Autowired
    public PacienteService pacienteService;

    public Paciente pacienteTeste;

    @BeforeAll
    static void iniciaTestesAll() {
        System.out.println("Iniciando teste de todos");
    }

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
    }

    @Test
    @DisplayName("Teste criar paciente service")
    public void criarPacienteIntegracaoTeste(){
        Paciente retorno = pacienteService.criarPaciente(pacienteTeste);

        assertNotNull(retorno.getId());
        assertEquals(retorno.getNome(), pacienteTeste.getNome());
        assertEquals(retorno.getSexo(), pacienteTeste.getSexo());
        assertEquals(retorno.getData_nascimento(), pacienteTeste.getData_nascimento());
    }

    @Test
    @DisplayName("Teste deletar paciente service")
    public void deletePacienteIntegracaoTeste(){
        pacienteService.deletePaciente(4);

    }

    @Test
    @DisplayName("Teste consulta paciente por nome service")
    public void consultaPacienteNIntegracaoTeste(){
        Paciente paciente = pacienteService.consultaPacienteN("ARCHIMEDES FELICIO GONSALVES");

        assertNotNull(paciente);
    }

    @Test
    @DisplayName("Teste consulta paciente por genero service")
    public void consultaPacienteGIntegracaoTeste(){
        List<Paciente> pacientes = pacienteService.consultaPacienteG(SexoEnum.MASCULINO);

        assertNotNull(pacientes);
        assertTrue(pacientes.size() > 0);
    }

    @Test
    @DisplayName("Teste atualiza paciente service")
    public void updatePacienteIntegracaoTeste(){
        Paciente paciente = pacienteService.updatePaciente(2,pacienteTeste);

        assertNotNull(paciente);
        assertEquals(pacienteTeste.getNome(), paciente.getNome());
        assertEquals(pacienteTeste.getData_nascimento(), paciente.getData_nascimento());
    }

    // TODO: 20/05/2022 Ver se necessário a criação de um método para criar e listar ao mesmo tempo

    @Test
    @DisplayName("Teste criação de paciente service com nome já existente")
    void criaPacienteComNomeExistenteTeste(){
        try {
            Paciente retorno = pacienteService.criarPaciente(pacienteTeste);
        } catch (Exception ex){
            assertEquals("Paciente já cadastrado!", ex.getMessage());
        }
    }

    @Test
    @DisplayName("Teste consultar paciente service com nome inexistente")
    void consultaPacienteComNomeInexistenteTeste(){
        Paciente paciente = pacienteService.consultaPacienteN("Josué");

        assertNotNull(paciente);
    }

    @Test
    @DisplayName("Teste consulta de paciente service com gênero não cadastrado")
    void consultaPacienteComGeneroNaoCadastradoTeste(){
        List<Paciente> pacientes = pacienteService.consultaPacienteG(SexoEnum.OUTRO);

        assertNotNull(pacientes);
        assertTrue(pacientes.size() == 0);

    }

    @Test
    @DisplayName("Teste delete de paciente service com id inexistente")
    void deletePacienteComIdInexistenteTeste(){


    }

    @Test
    @DisplayName("Teste atualiza paciente service com nome já existente")
    void atualizaPacienteComNomeExistenteTeste(){
        try{
            Paciente paciente = pacienteService.updatePaciente(2,pacienteTeste);
        } catch(Exception e){
            assertEquals("paciente não encontrado", e.getMessage());
        }

    }
}
