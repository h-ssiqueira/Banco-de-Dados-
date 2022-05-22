package br.com.letscode.postosaude.testesUnitariosService;

import br.com.letscode.postosaude.model.*;
import br.com.letscode.postosaude.services.PacienteVacinadoService;
import br.com.letscode.postosaude.repository.PacienteVacinadoRepositorio;
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
public class PacienteVacinadoServiceTest {

    @InjectMocks
    private PacienteVacinadoService pacienteVacinadoService;
    @Mock
    private PacienteVacinadoRepositorio pacienteVacinadoRepositorio;

    @Test
    @DisplayName("Teste criar PacienteVacinado service com sucesso")
    void criarPacienteVacinadoTeste(){

        PacienteVacinado criarPacienteVacinado = new PacienteVacinado();
        criarPacienteVacinado.setPaciente(new Paciente("Rodrigo",LocalDate.now(), SexoEnum.MASCULINO));
        criarPacienteVacinado.setVacina(new Vacina(1,"postinho",15));
        criarPacienteVacinado.setProfissional(new Profissional("Profissa 1", CargosEnum.PROFISSIONAL_SAUDE));
        criarPacienteVacinado.setData_aplicacao(LocalDate.now());
        criarPacienteVacinado.setDose(1);

        PacienteVacinado pacienteVacinadoRetorno = new PacienteVacinado();
        pacienteVacinadoRetorno.setPaciente(new Paciente("Rodrigo",LocalDate.now(), SexoEnum.MASCULINO));
        pacienteVacinadoRetorno.setVacina(new Vacina(1,"postinho",15));
        pacienteVacinadoRetorno.setProfissional(new Profissional("Profissa 1", CargosEnum.PROFISSIONAL_SAUDE));
        pacienteVacinadoRetorno.setData_aplicacao(LocalDate.now());
        pacienteVacinadoRetorno.setDose(1);
        pacienteVacinadoRetorno.setId(323);

        Mockito.when(pacienteVacinadoRepositorio.save(criarPacienteVacinado)).thenReturn(pacienteVacinadoRetorno);
        pacienteVacinadoRetorno = pacienteVacinadoService.criarPacienteVacinado(criarPacienteVacinado);

        Assertions.assertNotNull(pacienteVacinadoRetorno);
        Assertions.assertNotNull(pacienteVacinadoRetorno.getId());
        Assertions.assertEquals(323, pacienteVacinadoRetorno.getId());
        Assertions.assertEquals(criarPacienteVacinado.getDose(), pacienteVacinadoRetorno.getDose());
        Assertions.assertEquals(criarPacienteVacinado.getData_aplicacao(), pacienteVacinadoRetorno.getData_aplicacao());
    }

    @Test
    @DisplayName("Teste atualizar PacienteVacinado service com sucesso")
    void updatePacienteVacinadoTeste(){

        PacienteVacinado entidade = new PacienteVacinado(1,
                                                        new Paciente(1,"Gloria",LocalDate.parse("1980-01-01"),SexoEnum.FEMININO),
                                                        new Profissional("1",CargosEnum.PROFISSIONAL_SAUDE, null),
                                                        new Vacina(1,123,"Hospital",333),
                                                        LocalDate.parse("2022-05-16"),
                                                        3);
        entidade.setDeleted_by("Rhuan");
        entidade.setDeleted_at(LocalDate.now());
        Mockito.when(pacienteVacinadoRepositorio.findById(1)).thenReturn(Optional.of(entidade));
        Mockito.when(pacienteVacinadoRepositorio.save(entidade)).thenReturn(entidade);

        PacienteVacinado retorno = pacienteVacinadoService.updatePacienteVacinado(1,entidade);
        
        Assertions.assertNotNull(retorno);
        Assertions.assertEquals(entidade.getVacina(), retorno.getVacina());
        Assertions.assertEquals(entidade.getDose(), retorno.getDose());
        Assertions.assertEquals(entidade.getData_aplicacao(), retorno.getData_aplicacao());
        Assertions.assertEquals(entidade.getPaciente(), retorno.getPaciente());
        Assertions.assertEquals(entidade.getProfissional(), retorno.getProfissional());
    }

    @Test
    @DisplayName("Teste Consulta PacienteVacinado service com sucesso")
    void consultaPacienteVacinadoTeste(){

        Paciente paciente = new Paciente(1,"Fulano", LocalDate.now(), SexoEnum.MASCULINO);
        Profissional profissional = new  Profissional("Profissional 1", CargosEnum.PROFISSIONAL_SAUDE, null);
        Vacina vacina = new Vacina(10984,"FUNDACAO BUTANTAN", 2249278);
        List<PacienteVacinado> entidadeList = new ArrayList<>();
        entidadeList.add(new PacienteVacinado(paciente, profissional,vacina, LocalDate.now(), 1));

        Mockito.when(pacienteVacinadoRepositorio.findAll()
                        .stream()
                        .filter(pv-> pv.getDose().equals(1)).collect(Collectors.toList()))
                        .thenReturn(entidadeList);

        List<PacienteVacinado> pacienteVacinados = pacienteVacinadoService.consultarPacienteVacinado(1);
        Assertions.assertNotNull(pacienteVacinados);
        Assertions.assertFalse(pacienteVacinados.isEmpty());
        Assertions.assertEquals(1,entidadeList.size());
    }

    @Test
    @DisplayName("Teste deletar PacienteVacinado service com sucesso")
    void deletarPacienteVacinadoTeste(){

        PacienteVacinado novo = new PacienteVacinado(1,
                new Paciente(1,"Gloria",LocalDate.parse("1980-01-01"),SexoEnum.FEMININO),
                new Profissional("1",CargosEnum.PROFISSIONAL_SAUDE, null),
                new Vacina(1,123,"Hospital",333),
                LocalDate.parse("2022-05-16"),
                3);
        Optional<PacienteVacinado> retorno = Optional.of(new PacienteVacinado());

        Mockito.when(pacienteVacinadoRepositorio.findById(novo.getId()))
                .thenReturn(Optional.of(novo));

        Mockito.doNothing()
                .when(pacienteVacinadoRepositorio)
                .delete(novo);

        pacienteVacinadoService.deletarPacienteVacinado(novo.getId());

        Assertions.assertNotNull(retorno);
        Mockito.verify(pacienteVacinadoRepositorio, Mockito.times(1))
                .delete(novo);
    }

    @Test
    @DisplayName("Teste criar PacienteVacinado service com id inexistente")
    void criarPacienteVacinadoComIdInexistenteTeste(){

        PacienteVacinado criarPacienteVacinado = new PacienteVacinado();
        criarPacienteVacinado.setId(null);
        criarPacienteVacinado.setPaciente(new Paciente("Rodrigo",LocalDate.now(), SexoEnum.MASCULINO));
        criarPacienteVacinado.setVacina(new Vacina(1,"postinho",15));
        criarPacienteVacinado.setProfissional(new Profissional("Profissa 1", CargosEnum.PROFISSIONAL_SAUDE));
        criarPacienteVacinado.setData_aplicacao(LocalDate.now());
        criarPacienteVacinado.setDose(1);

        PacienteVacinado pacienteVacinadoRetorno = new PacienteVacinado();
        pacienteVacinadoRetorno.setId(null);
        pacienteVacinadoRetorno.setPaciente(new Paciente("Rodrigo",LocalDate.now(), SexoEnum.MASCULINO));
        pacienteVacinadoRetorno.setVacina(new Vacina(1,"postinho",15));
        pacienteVacinadoRetorno.setProfissional(new Profissional("Profissa 1", CargosEnum.PROFISSIONAL_SAUDE));
        pacienteVacinadoRetorno.setData_aplicacao(LocalDate.now());
        pacienteVacinadoRetorno.setDose(1);

        Mockito.when(pacienteVacinadoRepositorio.save(criarPacienteVacinado)).thenReturn(pacienteVacinadoRetorno);
        pacienteVacinadoRetorno = pacienteVacinadoService.criarPacienteVacinado(criarPacienteVacinado);

        Assertions.assertNotNull(pacienteVacinadoRetorno);
        Assertions.assertNull(pacienteVacinadoRetorno.getId());
        Assertions.assertEquals(criarPacienteVacinado.getDose(), pacienteVacinadoRetorno.getDose());
        Assertions.assertEquals(criarPacienteVacinado.getData_aplicacao(), pacienteVacinadoRetorno.getData_aplicacao());
    }

    @Test
    @DisplayName("Teste consultar PacienteVacinado service com dose inexistente")
    void consultaPacienteVacinadoComDoseInexistenteTeste(){

        Paciente paciente = new Paciente(1,"Fulano", LocalDate.now(), SexoEnum.MASCULINO);
        Profissional profissional = new  Profissional("Profissional 1", CargosEnum.PROFISSIONAL_SAUDE, null);
        Vacina vacina = new Vacina(10984,"FUNDACAO BUTANTAN", 2249278);
        List<PacienteVacinado> entidadeList = new ArrayList<>();
        entidadeList.add(new PacienteVacinado(paciente, profissional,vacina, LocalDate.now(), 1));

        Mockito.when(pacienteVacinadoRepositorio.findAll()
                        .stream()
                        .filter(pv-> pv.getDose().equals(null)).collect(Collectors.toList()))
                .thenReturn(entidadeList);

        List<PacienteVacinado> pacienteVacinados = pacienteVacinadoService.consultarPacienteVacinado(null);
        Assertions.assertNotNull(pacienteVacinados);
        Assertions.assertTrue(pacienteVacinados.isEmpty());
        Assertions.assertEquals(0,pacienteVacinados.size());
    }

    @Test
    @DisplayName("Teste remover PacienteVacinado service com id inexistente")
    void deletePacienteVacinadoComIdInexistenteTeste(){

        PacienteVacinado novo = new PacienteVacinado(null,
                new Paciente(1,"Gloria",LocalDate.parse("1980-01-01"),SexoEnum.FEMININO),
                new Profissional("1",CargosEnum.PROFISSIONAL_SAUDE, null),
                new Vacina(1,123,"Hospital",333),
                LocalDate.parse("2022-05-16"),
                3);
        Optional<PacienteVacinado> retorno = Optional.of(new PacienteVacinado());

        Mockito.when(pacienteVacinadoRepositorio.findById(novo.getId()))
                .thenReturn(Optional.of(novo));

        Mockito.doNothing()
                .when(pacienteVacinadoRepositorio)
                .delete(novo);

        pacienteVacinadoService.deletarPacienteVacinado(novo.getId());

        Assertions.assertNull(retorno.get().getId());
        Mockito.verify(pacienteVacinadoRepositorio, Mockito.times(1))
                .delete(novo);
    }

    @Test
    @DisplayName("Teste atualiza PacienteVacinado service com data invalida")
    void atualizarPacienteVacinadoComDataInvalidaTeste(){

        PacienteVacinado entidade = new PacienteVacinado(1,
                new Paciente(1,"Gloria",LocalDate.parse("1980-01-01"),SexoEnum.FEMININO),
                new Profissional("1",CargosEnum.PROFISSIONAL_SAUDE, null),
                new Vacina(1,123,"Hospital",333),
                LocalDate.parse("2032-02-01"),
                3);
        entidade.setDeleted_by("Rhuan");
        entidade.setDeleted_at(LocalDate.now());
        Mockito.when(pacienteVacinadoRepositorio.findById(1)).thenReturn(Optional.of(entidade));
        Mockito.when(pacienteVacinadoRepositorio.save(entidade)).thenReturn(entidade);

        PacienteVacinado retorno = pacienteVacinadoService.updatePacienteVacinado(1,entidade);

        Assertions.assertNotNull(retorno);
        Assertions.assertEquals(entidade.getVacina(), retorno.getVacina());
        Assertions.assertEquals(entidade.getDose(), retorno.getDose());
        Assertions.assertEquals(entidade.getData_aplicacao(), retorno.getData_aplicacao());
        Assertions.assertEquals(entidade.getPaciente(), retorno.getPaciente());
        Assertions.assertEquals(entidade.getProfissional(), retorno.getProfissional());
    }
}
