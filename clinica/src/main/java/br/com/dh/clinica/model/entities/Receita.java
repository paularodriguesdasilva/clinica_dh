package br.com.dh.clinica.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_receita;
	private String descricao;
	private String tempo;
	private String dosagem;
	
	@ManyToOne
	@JoinColumn(name = "fk_receita_consulta1")
	@JsonIgnoreProperties("receitas")
	private Consulta consulta;
	
	
	public Receita() {}
	
	public Receita(String descricao, String tempo, String dosagem) {
		this.descricao = descricao;
		this.tempo = tempo;
		this.dosagem = dosagem;
	}
	
	
	public int getId_receita() {
		return id_receita;
	}
	public void setId_receita(int id_receita) {
		this.id_receita = id_receita;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	public String getDosagem() {
		return dosagem;
	}
	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}
}


