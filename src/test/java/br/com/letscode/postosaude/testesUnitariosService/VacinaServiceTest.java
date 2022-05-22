package br.com.letscode.postosaude.testesUnitariosService;

import br.com.letscode.postosaude.repository.PacienteVacinadoRepositorio;
import br.com.letscode.postosaude.services.VacinaService;
import br.com.letscode.postosaude.repository.VacinaRepositorio;
import br.com.letscode.postosaude.model.Vacina;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class VacinaServiceTest {

    @InjectMocks
    private VacinaService vacinaService;
    @Mock
    private VacinaRepositorio vacinaRepositorio;
    @Mock
    private PacienteVacinadoRepositorio pacienteVacinadoRepositorio;

    @Test
    @DisplayName("Teste deletar Vacina service com sucesso")
    void deleteVacinaTeste(){

        Vacina novo = new Vacina(1,10984,"FUNDACAO BUTANTAN", 2249278);
        Optional<Vacina> retorno = Optional.of(new Vacina());

        Mockito.when(vacinaRepositorio.findById(novo.getId()))
                .thenReturn(Optional.of(novo));

        Mockito.doNothing().when(pacienteVacinadoRepositorio).deleteByVacinaId(novo.getId());
        Mockito.doNothing().when(vacinaRepositorio).delete(novo);

        vacinaService.deleteVacina(novo.getId());

        Assertions.assertNotNull(retorno);
        Mockito.verify(vacinaRepositorio, Mockito.times(1)).delete(novo);
    }

    @Test
    @DisplayName("Teste atualizar Vacina service com sucesso")
    void updateVacinaTeste(){

        Vacina entidade = new Vacina(1,10984,"FUNDACAO BUTANTAN", 2249278);
        Vacina entidadeRetorno;

        Mockito.when(vacinaRepositorio.findById(entidade.getId())).thenReturn(Optional.of(entidade));
        Mockito.when(vacinaRepositorio.save(entidade)).thenReturn(entidade);

        entidadeRetorno = vacinaService.updateVacina(1, entidade);

        Assertions.assertNotNull(entidadeRetorno);
        Assertions.assertEquals(entidadeRetorno.getPosto_saude(), entidade.getPosto_saude());
        Assertions.assertEquals(entidadeRetorno.getCodigoVacina(), entidade.getCodigoVacina());
        Assertions.assertEquals(entidadeRetorno.getFabricante(), entidade.getFabricante());
    }

    @Test
    @DisplayName("Teste delete Vacina service com Id inexistente")
    void deleteVacinaComIdInexistenteTeste(){

        Vacina novo = new Vacina(1,10984,"FUNDACAO BUTANTAN", 2249278);
        novo.setId(null);
        Optional<Vacina> retorno = Optional.of(new Vacina());

        Mockito.when(vacinaRepositorio.findById(novo.getId()))
                .thenReturn(Optional.of(novo));

        Mockito.doNothing().when(pacienteVacinadoRepositorio).deleteByVacinaId(novo.getId());
        Mockito.doNothing().when(vacinaRepositorio).delete(novo);

        vacinaService.deleteVacina(novo.getId());

        Assertions.assertNotSame(retorno,novo);
        Mockito.verify(vacinaRepositorio, Mockito.times(1)).delete(novo);
    }

    @Test
    @DisplayName("Teste atualizar Vacina service com Id inválido")
    void atualizarVacinaComIdInvalidoTeste(){

        Vacina entidade = new Vacina(null,10984,"FUNDACAO BUTANTAN", 2249278);
        Vacina entidadeRetorno;

        Mockito.when(vacinaRepositorio.findById(entidade.getId())).thenReturn(Optional.of(entidade));
        Mockito.when(vacinaRepositorio.save(entidade)).thenReturn(entidade);

        entidadeRetorno = vacinaService.updateVacina(entidade.getId(), entidade);

        Assertions.assertNotNull(entidadeRetorno);
        Assertions.assertEquals(entidadeRetorno.getPosto_saude(), entidade.getPosto_saude());
        Assertions.assertEquals(entidadeRetorno.getCodigoVacina(), entidade.getCodigoVacina());
        Assertions.assertEquals(entidadeRetorno.getFabricante(), entidade.getFabricante());
    }
}
