package br.com.dh.clinica.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.clinica.model.entities.Paciente;
import br.com.dh.clinica.model.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("paciente")
@RequiredArgsConstructor
public class PacienteController {

	@Autowired 
	private PacienteRepository pacienteRepository;

	@GetMapping()
	public Iterable<Paciente> getPacientes(){ 
		return pacienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional <Paciente> getById(@PathVariable int id) {
		return pacienteRepository.findById(id); 
	}
	
	@PostMapping()
	public Paciente addPaciente(@RequestBody Paciente paciente) {
		pacienteRepository.save(paciente);
		return paciente;
	} 
	
	@DeleteMapping("/{id}")
	public void deletePaciente(@PathVariable int id) {
		pacienteRepository.deleteById(id);
	}
	
	@PutMapping("/{idPaciente}")
	public Paciente updatePaciente(@PathVariable int idPaciente, @RequestBody Paciente dadosPaciente) throws Exception{
		Paciente pacienteDB = pacienteRepository.findById(idPaciente)
				.orElseThrow(() -> new IllegalAccessException());
		
		if(dadosPaciente.getPeso() > 0)pacienteDB.setPeso(dadosPaciente.getPeso()); 
		if(dadosPaciente.getAltura() > 0)pacienteDB.setAltura(dadosPaciente.getAltura());
		
		return pacienteDB;
	}	
	
	@PutMapping("/{idPaciente}/atualizar")
	public Paciente updateInfosPaciente(@PathVariable int idPaciente, @RequestBody Paciente dadosPaciente) throws Exception{
		Paciente pacienteDB = pacienteRepository.findById(idPaciente)
				.orElseThrow(() -> new IllegalAccessException());
		
		if(!dadosPaciente.getEndereco().isEmpty())pacienteDB.setEndereco(dadosPaciente.getEndereco());
		if(!dadosPaciente.getEmail().isEmpty())pacienteDB.setEmail(dadosPaciente.getEmail());
		if(!dadosPaciente.getTelefone().isEmpty())pacienteDB.setTelefone(dadosPaciente.getTelefone());
		
		return pacienteDB;
	}	
}
