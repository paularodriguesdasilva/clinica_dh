package br.com.dh.clinica.paciente;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dh.clinica.model.entities.Paciente;
import br.com.dh.clinica.model.repositories.PacienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PacienteRepositoryTest {
	
	/*Testes desenvolvidos pela Paula Rodrigues*/
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Test
    public void verificaIdPacienteNull() {
        Paciente paciente = new Paciente("Ana Julia Bento", "Rua das Couves, 50", "2013-03-25", "1155555-5555",
                "2020-10-15", "ana@ana.com.br", 40.00, 1.30,"333.333.333-00");

        this.pacienteRepository.save(paciente);

        Paciente pacienteDb = this.pacienteRepository.findOneByNome(paciente.getNome());

        Assertions.assertThat(pacienteDb.getId_paciente()).isNotNull();
    }

    @Test
    public void verificaNomePacienteNull() {
    	Paciente paciente = new Paciente("Jose da Silva", "Rua das Abelhas, 20", "1999-05-29", "1133333-3333",
                "2020-10-17", "jose@jose.com.br", 90.0, 1.90,"999.888.777-10");

        this.pacienteRepository.save(paciente);

        Paciente pacienteDb = this.pacienteRepository.findOneByCpf(paciente.getCpf());

        Assertions.assertThat(pacienteDb.getNome()).isNotNull();
    }
    
    @Test
    public void verificaCpfPacienteNull() {
    	 Paciente paciente = new Paciente("Ana Julia Bento", "Rua das Couves, 50", "2013-03-25", "1155555-5555",
                 "2020-10-15", "ana@ana.com.br", 40.00, 1.30,"333.333.333-00");

        this.pacienteRepository.save(paciente);

        Paciente pacienteDb = this.pacienteRepository.findOneByNome(paciente.getNome());

        Assertions.assertThat(pacienteDb.getCpf()).isNotNull();
    }

    @Test
    public void verificaPacienteDeletado() {
        Paciente paciente = new Paciente("Jose da Silva", "Rua das Abelhas, 20", "1999-05-29", "1133333-3333",
                "2020-10-17", "jose@jose.com.br", 90.0, 1.90,"999.888.777-10");

        this.pacienteRepository.save(paciente);

        this.pacienteRepository.delete(paciente);

        Assertions.assertThat(this.pacienteRepository.findOneByCpf(paciente.getCpf())).isNull();
    }

    @Test
    public void verificaPacienteEstaSalvo() {
        Paciente paciente = new Paciente("Paula Rodrigues", "Rua da Amizade, 100", "1984-03-11", "1199999-5555",
                "2020-10-18", "paula@paula.com.br", 90.0, 1.60,"222.222.222-11");

        this.pacienteRepository.save(paciente);

        Assertions.assertThat(this.pacienteRepository.findOneByCpf(paciente.getCpf())).isNotNull();
    }
    
    @Test
    public void verificaEnderecoAtualizado() {
    	Paciente paciente = new Paciente("Paula Rodrigues", "Rua da Amizade, 100", "1984-03-11", "1199999-5555",
                "2020-10-18", "paula@paula.com.br", 90.0, 1.60,"222.222.222-11");
    	
    	this.pacienteRepository.save(paciente);
    	
    	paciente.setEndereco("Rua dos Pinheiros 23");
    	
    	this.pacienteRepository.save(paciente);
    	
    	Paciente pacienteAtualizado = this.pacienteRepository.findOneByCpf("222.222.222-11");
    	
    	Assertions.assertThat(pacienteAtualizado.getEndereco()).isEqualTo(paciente.getEndereco());
    }
    
}
