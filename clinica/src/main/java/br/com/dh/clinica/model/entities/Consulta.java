package br.com.dh.clinica.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_consulta;
	
	@NotBlank(message = "Data deve ter um valor")
	private String data_consulta;
	
	@Min(value=0, message="Valor não pode ser negativo.")
	private double valor;
	
	private String descricao;
	
	@NotBlank(message = "Médico deve ter um valor")
	private String medico;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_paciente")
	@JsonIgnoreProperties({"pedidos", "fk_id_paciente"})
	private Paciente paciente;
	
	public Consulta() {}
	
	public Consulta(String data_consulta, double valor, String descricao, String medico, Paciente paciente) {		
		this.data_consulta = data_consulta;
		this.valor = valor;
		this.descricao = descricao;
		this.medico = medico;
		this.paciente = paciente;
	}

	public int getId_consulta() {
		return id_consulta;
	}

	public String getData_consulta() {
		return data_consulta;
	}

	public void setData_consulta(String data_consulta) {
		this.data_consulta = data_consulta;
	}

	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {	
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
}
