package br.com.letscode.postosaude.testesUnitariosService;

import br.com.letscode.postosaude.model.CargosEnum;
import br.com.letscode.postosaude.repository.ProfissionalRepositorio;
import br.com.letscode.postosaude.services.ProfissionalService;
import br.com.letscode.postosaude.model.Profissional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@ExtendWith(MockitoExtension.class)
public class ProfissionalServiceTest {

    @InjectMocks
    private ProfissionalService profissionalService;
    @Mock
    private ProfissionalRepositorio profissionalRepositorio;

    @Test
    @DisplayName("Teste atualizar Profissional service com sucesso")
    void updateProfissionalTeste(){

        Profissional profissional = new Profissional(1,"123", CargosEnum.PROFISSIONAL_SAUDE, null);
        Profissional profissionalRetorno;

        Mockito.when(profissionalRepositorio.findById(profissional.getId())).thenReturn(Optional.of(profissional));
        Mockito.when(profissionalRepositorio.save(profissional)).thenReturn(profissional);

        profissionalRetorno = profissionalService.updateProfissional(1, profissional);

        Assertions.assertNotNull(profissionalRetorno);
        Assertions.assertEquals(profissionalRetorno.getDeleted_at(),profissional.getDeleted_at());
    }

    @Test
    @DisplayName("Teste consulta Profissional service com sucesso")
    void consultaListaProfissionalTeste(){

        List<Profissional> profissionalList = new ArrayList<>();
        profissionalList.add(new Profissional("Profissional 1", CargosEnum.PROFISSIONAL_SAUDE, null));
        profissionalList.add(new Profissional("Profissional 2", CargosEnum.PROFISSIONAL_SAUDE, null));
        profissionalList.add(new Profissional("Profissional 3", CargosEnum.PROFISSIONAL_SAUDE, null));

        Mockito.when(profissionalRepositorio.findAll()
                .stream()
                .filter(p -> p.getCodigoRegistro().equals("Profissional 1"))
                        .collect(Collectors.toList()))
                            .thenReturn(profissionalList);

        List<Profissional> profissionais = profissionalService.selecionarTodos();

        Assertions.assertNotNull(profissionais);
        Assertions.assertFalse(profissionais.isEmpty());
        Assertions.assertEquals(3, profissionalList.size());
    }

    @Test
    @DisplayName("Teste consulta Profissional service sem cadastros")
    void consultaListaProfissionalSemCadastrosTeste(){

        List<Profissional> profissionais = new ArrayList<>();


        Mockito.when(profissionalRepositorio.findAll()).thenReturn(profissionais);
        List<Profissional> profissionaisRetorno = profissionalService.selecionarTodos();

        Assertions.assertNotNull(profissionais);
        Assertions.assertTrue(profissionais.isEmpty());
        Assertions.assertEquals(0, profissionais.size());
    }

    @Test
    @DisplayName("Teste remover (softDelete) Profissional service com Id inexistente")
    void removeListaProfissionalComIdInexistenteTeste(){
        Profissional profissional = new Profissional(null,"123", CargosEnum.PROFISSIONAL_SAUDE, null);
        Profissional profissionalRetorno;

        Mockito.when(profissionalRepositorio.findById(profissional.getId())).thenReturn(Optional.of(profissional));
        Mockito.when(profissionalRepositorio.save(profissional)).thenReturn(profissional);

        profissionalRetorno = profissionalService.updateProfissional(profissional.getId(), profissional);

        Assertions.assertNotNull(profissionalRetorno);
        Assertions.assertEquals(profissionalRetorno.getDeleted_at(),profissional.getDeleted_at());
    }
}
