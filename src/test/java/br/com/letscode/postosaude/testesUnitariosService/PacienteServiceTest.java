package br.com.letscode.postosaude.testesUnitariosService;

import br.com.letscode.postosaude.exception.PacienteNaoEncontradoException;
import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import br.com.letscode.postosaude.services.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    @InjectMocks
    private PacienteService pacienteService;
    @Mock
    private PacienteRepositorio pacienteRepositorio;

    @Test
    @DisplayName("Teste criar paciente service")
    public void criarPacienteTeste(){
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
    @DisplayName("Teste deletar paciente service")
    public void deletePacienteTeste(){

    }

    @Test
    @DisplayName("Teste consulta paciente por nome service")
    public void consultaPacienteNTeste(){
        Paciente entidade = new Paciente(1,"Fulano", LocalDate.now(), SexoEnum.MASCULINO);
        Mockito.when(pacienteRepositorio.findByNome("Fulano")).thenReturn(entidade);

        Paciente entidadeRetorno = pacienteService.consultaPacienteN("Fulano");

        Assertions.assertEquals(entidadeRetorno.getNome(), entidade.getNome());
    }

    @Test
    @DisplayName("Teste consulta paciente por genero service")
    public void consultaPacienteGTeste(){
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
    @DisplayName("Teste atualiza paciente service")
    public void updatePacienteTeste(){
        Paciente entidade = new Paciente(1,"Fulano", LocalDate.now(), SexoEnum.MASCULINO);

        entidade.setNome("Beltrano");

        Mockito.when(pacienteRepositorio.save(entidade)).thenReturn(entidade);
        pacienteService.updatePaciente(1, entidade);

        Paciente entidadeRetorno = pacienteService.consultaPacienteN("Beltrano");

        Assertions.assertNotNull(entidade);
        Assertions.assertEquals(entidade.getNome(),entidadeRetorno.getNome());
    }


}
