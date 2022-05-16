package br.com.letscode.postosaude.testesUnitariosService;

import br.com.letscode.postosaude.exception.PacienteNaoEncontradoException;
import br.com.letscode.postosaude.exception.PacienteVacinadoNaoEncontradoException;
import br.com.letscode.postosaude.exception.VacinaNaoEncontradaException;
import br.com.letscode.postosaude.model.*;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import br.com.letscode.postosaude.services.PacienteService;
import br.com.letscode.postosaude.services.PacienteVacinadoService;
import br.com.letscode.postosaude.repository.PacienteVacinadoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
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
    @DisplayName("Teste criar PacienteVacinado service")
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
    @DisplayName("Teste atualizar PacienteVacinado service")
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
    @DisplayName("Teste Consulta PacienteVacinado service")
    void consultaPacienteVacinadoTeste(){
        Paciente paciente = new Paciente(1,"Fulano", LocalDate.now(), SexoEnum.MASCULINO);
        Profissional profissional = new  Profissional("Profissional 1", CargosEnum.PROFISSIONAL_SAUDE, null);
        Vacina vacina = new Vacina(10984,"FUNDACAO BUTANTAN", 2249278);
        List<PacienteVacinado> entidadeList = new ArrayList<>();
        entidadeList.add(new PacienteVacinado(paciente, profissional,vacina, LocalDate.now(), 1));

        Mockito.when(pacienteVacinadoRepositorio.findAll().stream()
                .filter(pv-> pv.getDose().equals(1)).collect(Collectors.toList()))
                .thenReturn(entidadeList);

        List<PacienteVacinado> pacienteVacinados = pacienteVacinadoService.consultarPacienteVacinado(1);
        Assertions.assertNotNull(pacienteVacinados);
        Assertions.assertFalse(pacienteVacinados.isEmpty());
        Assertions.assertEquals(1,entidadeList.size());
    }

    @Test
    @DisplayName("Teste deletar PacienteVacinado service")
    @Disabled
    void deletarPacienteVacinadoTeste(){
        Paciente paciente = new Paciente(1,"Fulano", LocalDate.now(), SexoEnum.MASCULINO);
        Profissional profissional = new  Profissional("Profissional 1", CargosEnum.PROFISSIONAL_SAUDE, null);
        Vacina vacina = new Vacina(10984,"FUNDACAO BUTANTAN", 2249278);
        List<PacienteVacinado> entidadeList = new ArrayList<>();
        entidadeList.add(new PacienteVacinado(paciente, profissional,vacina, LocalDate.now(), 1));
    }
}
