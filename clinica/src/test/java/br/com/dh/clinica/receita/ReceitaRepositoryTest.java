package br.com.dh.clinica.receita;

import org.assertj.core.api.Assertions;
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
public class ReceitaRepositoryTest {
	@Autowired
	ReceitaRepository receitaRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	public Paciente pacienteTest() {
		Paciente paciente = new Paciente("Ana Julia Bento", "Rua das Couves, 50", "2013-03-25", "1155555-5555",
                "2020-10-15", "ana@ana.com.br", 40.00, 1.30,"333.333.333-00");

        this.pacienteRepository.save(paciente);
        
        return paciente;
	}
	
	public Consulta consultaTest() {
		Paciente paciente = pacienteTest();
		
		Consulta consulta = new Consulta("2020-10-18", 150.99, "Consulta de teste", "Dr. Teste", paciente);
		
		this.consultaRepository.save(consulta);
		
		return consulta;
	}
	
	@Test
    public void verificaIdReceitaNull() {
		Consulta consulta = consultaTest();
        
        Receita receita = new Receita ("Amoxilina 500mg - comprimido. Uso externo", "7 dias", "Um comprimido de 8/8 horas", consulta);

        this.receitaRepository.save(receita);

        Receita receitaDb = this.receitaRepository.findOneByTempo(receita.getTempo());

        Assertions.assertThat(receitaDb.getId_receita()).isNotNull();
    }

    @Test
    public void verificaConsultaNull() {
    	Consulta consulta = consultaTest();
    	
        Receita receita = new Receita ("Amoxilina 500mg - comprimido. Uso externo", "7 dias", "Um comprimido de 8/8 horas", consulta);

        this.receitaRepository.save(receita);

        Receita receitaDb = this.receitaRepository.findOneById(receita.getId_receita());

        Assertions.assertThat(receitaDb.getConsulta()).isNotNull();
    }

    @Test
    public void verificaReceitaEstaSalva() {
    	Consulta consulta = consultaTest();
        
        Receita receita = new Receita ("Amoxilina 500mg - comprimido. Uso externo", "7 dias", "Um comprimido de 8/8 horas", consulta);

        this.receitaRepository.save(receita);

        Assertions.assertThat(this.receitaRepository.findOneById(receita.getId_receita())).isNotNull();
    }

}
