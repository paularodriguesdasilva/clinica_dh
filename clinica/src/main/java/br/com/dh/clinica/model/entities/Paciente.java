package br.com.dh.clinica.model.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id_paciente;
	@Column
	@Getter @Setter private String nome;
	@Column
	@Getter @Setter private String endereco;
	@Column
	@Getter @Setter private String data_nasc;
	@Column
	@Getter @Setter private String telefone;
	@Column
	@Getter @Setter private String data_primeira_consulta;
	@Column
	@Getter @Setter private String email;
	@Column
	@Getter @Setter private Double peso;
	@Column
	@Getter @Setter private Double altura;
	@Column
	@Getter @Setter private String cpf;
	
	@OneToMany(mappedBy = "paciente")
	@JsonIgnoreProperties("paciente")
	@Getter @Setter private Set<Consulta> consultas;
	
	public Paciente(String nome, String endereco, String data_nasc, String telefone, String data_primeira_consulta,
			String email, Double peso, Double altura, String cpf) {
		this.nome = nome;
		this.endereco = endereco;
		this.data_nasc = data_nasc;
		this.telefone = telefone;
		this.data_primeira_consulta = data_primeira_consulta;
		this.email = email;
		this.peso = peso;
		this.altura = altura;
		this.cpf = cpf;
	}	
}
