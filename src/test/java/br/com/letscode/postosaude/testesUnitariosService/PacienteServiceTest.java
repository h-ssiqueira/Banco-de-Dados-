package br.com.letscode.postosaude.testesUnitariosService;

import br.com.letscode.postosaude.exception.PacienteCadastradoException;
import br.com.letscode.postosaude.model.Paciente;
import br.com.letscode.postosaude.model.SexoEnum;
import br.com.letscode.postosaude.repository.PacienteRepositorio;
import br.com.letscode.postosaude.services.PacienteService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    @InjectMocks
    private PacienteService pacienteService;
    @Mock
    private PacienteRepositorio pacienteRepositorio;

    @Test
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

        // TODO: 14/05/2022 Falta os assetions

    }

//    @Test
//    public void

}
