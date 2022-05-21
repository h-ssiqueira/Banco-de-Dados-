package br.com.letscode.postosaude.testesIntegracaoService;

import br.com.letscode.postosaude.model.CargosEnum;
import br.com.letscode.postosaude.model.Profissional;
import br.com.letscode.postosaude.services.ProfissionalService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfissionalServiceIntegTest {

    @Autowired
    ProfissionalService profissionalService;

    public Profissional profissionalTeste;

    @BeforeAll
    static void iniciaTestesAll() {
        System.out.println("Iniciando teste de todos");
    }

    @BeforeEach
    public void iniciaTestesEach(){
        System.out.println("Iniciando model");
        profissionalTeste = new Profissional();
        profissionalTeste.setId(1);
        profissionalTeste.setCargo(CargosEnum.PROFISSIONAL_SAUDE);
        profissionalTeste.setCodigoRegistro("123");
        profissionalTeste.setDeleted_at(null);
        profissionalTeste.setDeleted_by(null);
    }

    @Test
    @DisplayName("Teste consulta profissional service com sucesso")
    public void consultaListaProfissionalIntegracaoTeste(){}
    @Test
    @DisplayName("Teste atualizar Profissional service com sucesso")
    public void updateProfissionalIntegracaoTeste(){}

    @Test
    @DisplayName("Teste consulta Profissional service sem cadastros")
    void consultaListaProfissionalSemCadastrosTeste(){


    }

    @Test
    @DisplayName("Teste remover (softDelete) Profissional service com Id inexistente")
    void removeListaProfissionalComIdInexistenteTeste(){

    }
}
