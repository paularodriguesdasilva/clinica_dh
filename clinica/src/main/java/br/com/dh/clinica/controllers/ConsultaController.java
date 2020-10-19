package br.com.dh.clinica.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.clinica.model.entities.Consulta;
import br.com.dh.clinica.model.repositories.ConsultaRepository;

@RestController
@RequestMapping("consulta")
public class ConsultaController {
	
	@Autowired
	ConsultaRepository consultaRepository;

	@PostMapping()
	public Consulta addConsulta(@Valid @RequestBody Consulta consulta) {
		consultaRepository.save(consulta);
		
		return consulta;
	}
}
