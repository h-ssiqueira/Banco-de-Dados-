package br.com.letscode.postosaude.testesIntegracaoService;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.model.Vacina;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import br.com.letscode.postosaude.services.PacienteService;
import br.com.letscode.postosaude.services.VacinaService;
import br.com.letscode.postosaude.repository.VacinaRepositorio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VacinaServiceIntegTest {

    @Autowired
    VacinaService vacinaService;

    public Vacina vacinaTeste;

    @BeforeAll
    static void iniciaTestesAll() {
        System.out.println("Iniciando teste de todos");
    }

    @BeforeEach
    public void iniciaTestesEach(){
        System.out.println("Iniciando model");
        vacinaTeste.setId(1);
        vacinaTeste.setDeleted_at(null);
        vacinaTeste.setDeleted_by(null);
        vacinaTeste.setCodigoVacina(10984);
        vacinaTeste.setFabricante("FUNDACAO BUTANTAN");
        vacinaTeste.setPosto_saude(2249278);
    }

    @Test
    @DisplayName("Teste deletar Vacina service")
    public void deleteVacinaIntegracaoTeste(){}

    @Test
    @DisplayName("Teste atualizar Vacina service")
    void updateVacinaIntegracaoTeste(){}

}
