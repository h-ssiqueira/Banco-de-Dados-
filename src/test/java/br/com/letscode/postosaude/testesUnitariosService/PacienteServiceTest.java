package br.com.letscode.postosaude.testesUnitariosService;

import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import br.com.letscode.postosaude.repository.PacienteVacinadoRepositorio;
import br.com.letscode.postosaude.services.PacienteService;
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
public class PacienteServiceTest {

    @InjectMocks
    private PacienteService pacienteService;
    @Mock
    private PacienteRepositorio pacienteRepositorio;
    @Mock
    private PacienteVacinadoRepositorio pacienteVacinadoRepositorio;

    @Test
    @DisplayName("Teste criar paciente service com sucesso")
    void criarPacienteTeste(){

        Paciente criarPaciente = new Paciente();
        criarPaciente.setNome("Teste");
        criarPaciente.setSexo(SexoEnum.MASCULINO);
        criarPaciente.setData_nascimento(LocalDate.now());

        Paciente pacienteRetorno = new Paciente();
        pacienteRetorno.setId(323);
        pacienteRetorno.setNome("Teste");
        pacienteRetorno.setSexo(SexoEnum.MASCULINO);
        pacienteRetorno.setData_nascimento(LocalDate.now());

        Mockito.when(pacienteRepositorio.save(criarPaciente)).thenReturn(pacienteRetorno);
        pacienteRetorno = pacienteService.criarPaciente(criarPaciente);

        Assertions.assertNotNull(pacienteRetorno);
        Assertions.assertNotNull(pacienteRetorno.getId());
        Assertions.assertEquals(323, pacienteRetorno.getId());
        Assertions.assertEquals(criarPaciente.getNome(), pacienteRetorno.getNome());
    }

    @Test
    @DisplayName("Teste deletar paciente service com sucesso")
    void deletePacienteTeste(){

        Paciente novo = new Paciente(1, "Clotilde", LocalDate.parse("1920-01-01"),SexoEnum.FEMININO);
        Optional<Paciente> retorno = Optional.of(new Paciente());

        Mockito.when(pacienteRepositorio.findById(novo.getId())).thenReturn(Optional.of(novo));

        Mockito.doNothing().when(pacienteVacinadoRepositorio).deleteByPacienteId(novo.getId());
        Mockito.doNothing().when(pacienteRepositorio).delete(novo);

        pacienteService.deletePaciente(novo.getId());

        Assertions.assertNotNull(retorno);
        Mockito.verify(pacienteRepositorio, Mockito.times(1)).delete(novo);
    }

    @Test
    @DisplayName("Teste consulta paciente por nome service com sucesso")
    void consultaPacienteNTeste(){

        Paciente entidade = new Paciente(1,"Fulano", LocalDate.now(), SexoEnum.MASCULINO);
        Mockito.when(pacienteRepositorio.findByNome("Fulano")).thenReturn(entidade);

        Paciente entidadeRetorno = pacienteService.consultaPacienteN("Fulano");

        Assertions.assertEquals(entidadeRetorno.getNome(), entidade.getNome());
    }

    @Test
    @DisplayName("Teste consulta paciente por genero service com sucesso")
    void consultaPacienteGTeste(){

        List<Paciente> entidadeList = new ArrayList<>();
        entidadeList.add(new Paciente("Fulano" , LocalDate.now(), SexoEnum.MASCULINO));
        entidadeList.add(new Paciente("Ciclano", LocalDate.now(), SexoEnum.MASCULINO));
        entidadeList.add(new Paciente("Beltrano", LocalDate.now(), SexoEnum.MASCULINO));
        Mockito.when(pacienteRepositorio.findAll().stream()
                .filter(p-> p.getSexo()
                        .equals(SexoEnum.MASCULINO))
                .collect(Collectors.toList()))
                .thenReturn(entidadeList);

        List<Paciente> pacientes = pacienteService.consultaPacienteG(SexoEnum.MASCULINO);
        Assertions.assertNotNull(pacientes);
        Assertions.assertFalse(pacientes.isEmpty());
        Assertions.assertEquals(3, entidadeList.size());
    }

    @Test
    @DisplayName("Teste atualiza paciente service com sucesso")
    void updatePacienteTeste(){

        Paciente entidade = new Paciente(1,"Fulano", LocalDate.now(), SexoEnum.MASCULINO);
        Paciente entidadeRetorno = new Paciente(1,"Beltano", LocalDate.parse("1999-05-15"), SexoEnum.MASCULINO);

        Mockito.when(pacienteRepositorio.findById(entidade.getId())).thenReturn(Optional.of(entidade));
        Mockito.when(pacienteRepositorio.save(entidade)).thenReturn(entidade);

        entidadeRetorno = pacienteService.updatePaciente(1,entidade);

        Assertions.assertNotNull(entidadeRetorno);
        Assertions.assertEquals(entidadeRetorno.getNome(),entidade.getNome());
        Assertions.assertEquals(entidadeRetorno.getSexo(),entidade.getSexo());
        Assertions.assertEquals(entidadeRetorno.getData_nascimento(),entidade.getData_nascimento());
    }

    @Test
    @DisplayName("Teste criação de paciente service com nome já existente")
    void criaPacienteComNomeExistenteTeste(){

        Paciente criarPaciente = new Paciente();
        criarPaciente.setNome("Teste");
        criarPaciente.setSexo(SexoEnum.MASCULINO);
        criarPaciente.setData_nascimento(LocalDate.now());

        Paciente pacienteRetorno = new Paciente();
        pacienteRetorno.setId(323);
        pacienteRetorno.setNome("Teste");
        pacienteRetorno.setSexo(SexoEnum.MASCULINO);
        pacienteRetorno.setData_nascimento(LocalDate.now());

        Mockito.when(pacienteRepositorio.save(criarPaciente)).thenReturn(pacienteRetorno);
        Mockito.when(pacienteRepositorio.save(criarPaciente)).thenReturn(pacienteRetorno);
        pacienteRetorno = pacienteService.criarPaciente(criarPaciente);
        pacienteRetorno = pacienteService.criarPaciente(criarPaciente);

        Assertions.assertNotNull(pacienteRetorno);
        Assertions.assertNotNull(pacienteRetorno.getId());
        Assertions.assertEquals(323, pacienteRetorno.getId());
        Assertions.assertEquals(criarPaciente.getNome(), pacienteRetorno.getNome());
    }

    @Test
    @DisplayName("Teste consultar paciente service com nome inexistente")
    void consultaPacienteComNomeInexistenteTeste(){

        Paciente entidade = new Paciente();
        Paciente entidadeRetorno;
        Mockito.when(pacienteRepositorio.findByNome("")).thenReturn(entidade);

        entidadeRetorno = pacienteService.consultaPacienteN("");

        Assertions.assertNotNull(entidadeRetorno);
        Assertions.assertNull(entidadeRetorno.getNome());
    }

    @Test
    @DisplayName("Teste consulta de paciente service com gênero não cadastrado")
    void consultaPacienteComGeneroNaoCadastradoTeste(){

        List<Paciente> entidadeList = new ArrayList<>();
        entidadeList.add(new Paciente("Fulano" , LocalDate.now(), SexoEnum.MASCULINO));
        entidadeList.add(new Paciente("Ciclano", LocalDate.now(), SexoEnum.MASCULINO));
        entidadeList.add(new Paciente("Beltrano", LocalDate.now(), SexoEnum.MASCULINO));
        Mockito.when(pacienteRepositorio.findAll().stream()
                        .filter(p-> p.getSexo()
                                .equals(SexoEnum.FEMININO))
                        .collect(Collectors.toList()))
                .thenReturn(entidadeList);

        List<Paciente> pacientes = pacienteService.consultaPacienteG(SexoEnum.FEMININO);
        Assertions.assertNotNull(pacientes);
        Assertions.assertTrue(pacientes.isEmpty());
        Assertions.assertEquals(0, pacientes.size());
    }

    @Test
    @DisplayName("Teste delete de paciente service com id inexistente")
    void deletePacienteComIdInexistenteTeste(){

        Paciente novo = new Paciente(null, "Clotilde", LocalDate.parse("1920-01-01"),SexoEnum.FEMININO);
        Optional<Paciente> retorno = Optional.of(new Paciente());

        Mockito.when(pacienteRepositorio.findById(novo.getId())).thenReturn(Optional.of(novo));

        Mockito.doNothing().when(pacienteVacinadoRepositorio).deleteByPacienteId(novo.getId());
        Mockito.doNothing().when(pacienteRepositorio).delete(novo);

        pacienteService.deletePaciente(novo.getId());

        Assertions.assertNotNull(retorno);
        Mockito.verify(pacienteRepositorio, Mockito.times(1)).delete(novo);
    }

    @Test
    @DisplayName("Teste atualiza paciente service com nome já existente")
    void atualizaPacienteComNomeExistenteTeste(){

        Paciente pacienteExistente = new Paciente(1,"Maria", LocalDate.now(), SexoEnum.FEMININO);
        Mockito.when(pacienteRepositorio.save(pacienteExistente)).thenReturn(pacienteExistente);
        Paciente entidade = new Paciente(1,"Ana", LocalDate.now(), SexoEnum.FEMININO);
        Paciente entidadeRetorno;

        Mockito.when(pacienteRepositorio.findById(entidade.getId())).thenReturn(Optional.of(entidade));
        entidade.setNome("Maria");
        Mockito.when(pacienteRepositorio.save(entidade)).thenReturn(entidade);

        entidadeRetorno = pacienteService.updatePaciente(1,entidade);

        Assertions.assertNotNull(entidadeRetorno);
        Assertions.assertEquals(entidadeRetorno.getNome(),entidade.getNome());
        Assertions.assertEquals(entidadeRetorno.getSexo(),entidade.getSexo());
        Assertions.assertEquals(entidadeRetorno.getData_nascimento(),entidade.getData_nascimento());
    }

}
