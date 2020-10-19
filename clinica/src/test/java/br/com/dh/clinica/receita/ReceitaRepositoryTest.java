package br.com.dh.clinica.receita;

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
public class ReceitaRepositoryTest {
	@Autowired
	ReceitaRepository receitaRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Test
    public void verificaIdReceitaNull() {
		Paciente paciente = new Paciente("Ana Julia Bento", "Rua das Couves, 50", "2013-03-25", "1155555-5555",
                "2020-10-15", "ana@ana.com.br", 40.00, 1.30,"333.333.333-00");

        this.pacienteRepository.save(paciente);
        
        
        Consulta consulta = new Consulta ("2020-10-14", 70.00, "", "Dr. Aurelio", paciente);
        
        this.consultaRepository.save(consulta);
        
        
        Receita receita = new Receita ("Amoxilina 500mg - comprimido. Uso externo", "7 dias", "Um comprimido de 8/8 horas", consulta);

        this.receitaRepository.save(receita);

        Receita receitaDb = this.receitaRepository.findOneByTempo(receita.getTempo());

        Assertions.assertThat(receitaDb.getId_receita()).isNotNull();
    }

    @Test
    public void verificaConsultaNull() {
    	Paciente paciente = new Paciente("Ana Julia Bento", "Rua das Couves, 50", "2013-03-25", "1155555-5555",
                "2020-10-15", "ana@ana.com.br", 40.00, 1.30,"333.333.333-00");

        this.pacienteRepository.save(paciente);
        
        
        Consulta consulta = new Consulta ("2020-10-14", 70.00, "", "Dr. Aurelio", paciente);
        
        this.consultaRepository.save(consulta);
        
        
        Receita receita = new Receita ("Amoxilina 500mg - comprimido. Uso externo", "7 dias", "Um comprimido de 8/8 horas", consulta);

        this.receitaRepository.save(receita);

        Receita receitaDb = this.receitaRepository.findOneById(receita.getId_receita());

        Assertions.assertThat(receitaDb.getConsulta()).isNotNull();
    }

    @Test
    public void verificaReceitaEstaSalva() {
    	Paciente paciente = new Paciente("Ana Julia Bento", "Rua das Couves, 50", "2013-03-25", "1155555-5555",
                "2020-10-15", "ana@ana.com.br", 40.00, 1.30,"333.333.333-00");

        this.pacienteRepository.save(paciente);
        
        
        Consulta consulta = new Consulta ("2020-10-14", 70.00, "", "Dr. Aurelio", paciente);
        
        this.consultaRepository.save(consulta);
        
        
        Receita receita = new Receita ("Amoxilina 500mg - comprimido. Uso externo", "7 dias", "Um comprimido de 8/8 horas", consulta);

        this.receitaRepository.save(receita);

        Assertions.assertThat(this.receitaRepository.findOneById(receita.getId_receita())).isNotNull();
    }

}
