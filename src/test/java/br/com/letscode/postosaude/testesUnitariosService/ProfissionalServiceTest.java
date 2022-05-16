package br.com.letscode.postosaude.testesUnitariosService;

import br.com.letscode.postosaude.exception.ProfissionalNaoEncontradoException;
import br.com.letscode.postosaude.model.CargosEnum;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import br.com.letscode.postosaude.repository.ProfissionalRepositorio;
import br.com.letscode.postosaude.services.PacienteService;
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

import java.time.LocalDate;
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
    @DisplayName("Teste atualizar Profissional service")
    void updateProfissionalTeste(){
        Profissional profissional = new Profissional(1,"123", CargosEnum.PROFISSIONAL_SAUDE, null);
        Profissional profissionalRetorno = new Profissional(2,"1234", CargosEnum.PROFISSIONAL_SAUDE, LocalDate.parse("1999-05-15"));

        Mockito.when(profissionalRepositorio.findById(profissional.getId())).thenReturn(Optional.of(profissional));
        Mockito.when(profissionalRepositorio.save(profissional)).thenReturn(profissional);

        profissionalRetorno = profissionalService.updateProfissional(1, profissional);

        Assertions.assertNotNull(profissionalRetorno);
        Assertions.assertEquals(profissionalRetorno.getDeleted_at(),profissional.getDeleted_at());
    }

    @Test
    @DisplayName("Teste consulta Profissional service")
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

}
