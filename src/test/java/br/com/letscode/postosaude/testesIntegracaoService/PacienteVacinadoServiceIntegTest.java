package br.com.letscode.postosaude.testesIntegracaoService;

import br.com.letscode.postosaude.model.*;
import br.com.letscode.postosaude.services.PacienteVacinadoService;
import br.com.letscode.postosaude.repository.PacienteVacinadoRepositorio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;

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
    @DisplayName("Teste criar PacienteVacinado service")
    public void criarPacienteVacinadoIntegracaoTeste(){}

    @Test
    @DisplayName("Teste atualizar PacienteVacinado service")
    public void updatePacienteVacinadoIntegracaoTeste(){}

    @Test
    @DisplayName("Teste Consulta PacienteVacinado service")
    public void consultaPacienteVacinadoIntegracaoTeste(){}

    @Test
    @DisplayName("Teste deletar PacienteVacinado service")
    public void deletarPacienteVacinadoIntegracaoTeste(){}
}
