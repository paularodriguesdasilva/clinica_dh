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
import br.com.dh.clinica.model.repositories.ConsultaRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConsultaRepositoryTest {
	private static Validator validator;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@BeforeClass
	public static void setupValidatorInstance() {
	    validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Test
	public void verificaIdConsultaNull() {
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", 1);
		
		this.consultaRepository.save(consulta);
		
		Consulta clienteDb = this.consultaRepository.findById(consulta.getId_consulta());
		
		Assertions.assertThat(clienteDb.getId_consulta()).isNotNull();
	}
	
	@Test
	public void verificaDataConsultaNull() {
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", 1);
		
		this.consultaRepository.save(consulta);
		
		Consulta clienteDb = this.consultaRepository.findById(consulta.getId_consulta());
		
		Assertions.assertThat(clienteDb.getData_consulta()).isNotNull();
	}
	
	@Test
	public void verificaValorConsultaNull() {
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", 1);
		
		this.consultaRepository.save(consulta);
		
		Consulta clienteDb = this.consultaRepository.findById(consulta.getId_consulta());
		
		Assertions.assertThat(clienteDb.getValor()).isNotNull();
	}
	
	@Test
	public void verificaMedicoConsultaNull() {
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", 1);
		
		this.consultaRepository.save(consulta);
		
		Consulta clienteDb = this.consultaRepository.findById(consulta.getId_consulta());
		
		Assertions.assertThat(clienteDb.getMedico()).isNotNull();
	}
	
	@Test
	public void verificaIdClienteConsultaNull() {
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", 1);
		
		this.consultaRepository.save(consulta);
		
		Consulta clienteDb = this.consultaRepository.findById(consulta.getId_consulta());
		
		Assertions.assertThat(clienteDb.getFk_id_paciente()).isNotNull();
	}
	
	@Test
	public void notAddConsultaDataNull() {	
		Consulta consulta = new Consulta(null, 150.99, "Consulta de teste", "Dr. Teste", 1);
		
	    Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
	 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void notAddConsultaDataVazio() {
		Consulta consulta = new Consulta("", 150.99, "Consulta de teste", "Dr. Teste", 1);
		
	    Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
	 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void notAddConsultaDataBranco() {
		Consulta consulta = new Consulta(" ", 150.99, "Consulta de teste", "Dr. Teste", 1);
		
		Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
		 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void notAddConsultaMedicoNull() {
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", null, 1);
		
		Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
		 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void notAddConsultaMedicoVazio() {
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "", 1);
		
		Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
		 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void notAddConsultaMedicoBranco() {
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", " ", 1);
		
		Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
		 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void notAddConsultaValorNegativo() {
		Consulta consulta = new Consulta("2020-10-18", -150.99, "Consulta de teste", "Dr. Teste", 1);

		Set<ConstraintViolation<Consulta>> violations = validator.validate(consulta);
		 
	    Assertions.assertThat(violations.size()).isEqualTo(1);
	}
}
