package br.com.letscode.postosaude.testesIntegracaoService;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.services.PacienteService;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;

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
    @Transactional
    @DisplayName("Teste criar paciente service")
    public void criarPacienteIntegracaoTeste(){}

    @Test
    @DisplayName("Teste deletar paciente service")
    public void deletePacienteIntegracaoTeste(){}

    @Test
    @DisplayName("Teste consulta paciente por nome service")
    public void consultaPacienteNIntegracaoTeste(){}

    @Test
    @DisplayName("Teste consulta paciente por genero service")
    public void consultaPacienteGIntegracaoTeste(){}

    @Test
    @DisplayName("Teste atualiza paciente service")
    public void updatePacienteIntegracaoTeste(){}

    // TODO: 20/05/2022 Ver se necessário a criação de um método para criar e listar ao mesmo tempo
}
