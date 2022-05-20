package br.com.letscode.postosaude.testesIntegracaoController;

import br.com.letscode.postosaude.model.CargosEnum;
import br.com.letscode.postosaude.model.Profissional;
import br.com.letscode.postosaude.controller.ProfissionalController;
import br.com.letscode.postosaude.services.ProfissionalService;
import br.com.letscode.postosaude.repository.ProfissionalRepositorio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfissionalControllerIntegTest {
    public Profissional profissionalTeste;

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
    @DisplayName("Teste consultar todos os Profissionais controller")
    void selecionarTodosControllerIntegracaoTest(){}

    @Test
    @DisplayName("Teste remover Profissional controller")
    void deleteProfissionalControllerIntegracaoTest(){}
}
