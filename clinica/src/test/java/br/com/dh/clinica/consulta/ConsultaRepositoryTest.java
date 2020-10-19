package br.com.dh.clinica.consulta;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.dh.clinica.model.entities.Consulta;
import br.com.dh.clinica.model.entities.Paciente;
import br.com.dh.clinica.model.repositories.ConsultaRepository;
import br.com.dh.clinica.model.repositories.PacienteRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConsultaRepositoryTest {
	private static Validator validator;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	public Paciente pacienteTest() {
		Paciente paciente = new Paciente("Ana Julia Bento", "Rua das Couves, 50", "2013-03-25", "1155555-5555",
                "2020-10-15", "ana@ana.com.br", 40.00, 1.30,"333.333.333-00");

        this.pacienteRepository.save(paciente);
        
        return paciente;
	}
	
	@BeforeClass
	public static void setupValidatorInstance() {
	    validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Test
	public void verificaIdConsultaNull() {
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);
		
		this.consultaRepository.save(consulta);
		
		Consulta clienteDb = this.consultaRepository.findById(consulta.getId_consulta());
		
		Assertions.assertThat(clienteDb.getId_consulta()).isNotNull();
	}
	
	@Test
	public void verificaDataConsultaNull() {
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);
		
		this.consultaRepository.save(consulta);
		
		Consulta clienteDb = this.consultaRepository.findById(consulta.getId_consulta());
		
		Assertions.assertThat(clienteDb.getData_consulta()).isNotNull();
	}
	
	@Test
	public void verificaValorConsultaNull() {
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);
		
		this.consultaRepository.save(consulta);
		
		Consulta clienteDb = this.consultaRepository.findById(consulta.getId_consulta());
		
		Assertions.assertThat(clienteDb.getValor()).isNotNull();
	}
	
	@Test
	public void verificaMedicoConsultaNull() {
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);
		
		this.consultaRepository.save(consulta);
		
		Consulta clienteDb = this.consultaRepository.findById(consulta.getId_consulta());
		
		Assertions.assertThat(clienteDb.getMedico()).isNotNull();
	}
	
	@Test
	public void verificaIdClienteConsultaNull() {
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);
		
		this.consultaRepository.save(consulta);
		
		Consulta clienteDb = this.consultaRepository.findById(consulta.getId_consulta());
		
		Assertions.assertThat(clienteDb.getPaciente()).isNotNull();
	}
	
	@Test
	public void notAddConsultaDataNull() {	
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);
		
	    Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
	 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void notAddConsultaDataVazio() {
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);
		
	    Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
	 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void notAddConsultaDataBranco() {
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);
		
		Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
		 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void notAddConsultaMedicoNull() {
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);
		
		Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
		 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void notAddConsultaMedicoVazio() {
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);
		
		Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
		 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void notAddConsultaMedicoBranco() {
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);
		
		Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
		 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void notAddConsultaValorNegativo() {
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);

		Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
		 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
}
