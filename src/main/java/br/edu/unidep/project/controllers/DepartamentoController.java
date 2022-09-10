package br.edu.unidep.project.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unidep.project.dtos.DepartamentoDTO;
import br.edu.unidep.project.services.DepartamentoService;

@RestController
@RequestMapping(value="/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<DepartamentoDTO> buscarDepartamento(@PathVariable Integer id) {
		DepartamentoDTO depDTO = new DepartamentoDTO(departamentoService.buscarDepartamento(id));
		return ResponseEntity.ok().body(depDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<DepartamentoDTO>> mostrarDepartamentos() {
		List<DepartamentoDTO> depsDTO = departamentoService.mostrarDepartamentos().stream().map(dp -> new DepartamentoDTO(dp)).collect(Collectors.toList());
		return ResponseEntity.ok().body(depsDTO);
	}
	
	@PostMapping
	public ResponseEntity<DepartamentoDTO> cadastrarDepartamento(@Valid @RequestBody DepartamentoDTO departamentoDTO) {
		DepartamentoDTO depDTO = new DepartamentoDTO(departamentoService.cadastrarDepartamento(departamentoDTO));
		return ResponseEntity.ok().body(depDTO);		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<DepartamentoDTO> editarDepartamento(@PathVariable Integer id, @Valid @RequestBody DepartamentoDTO departamentoDTO) {
		DepartamentoDTO depDTO = new DepartamentoDTO(departamentoService.editarDepartamento(id, departamentoDTO));
		return ResponseEntity.ok().body(depDTO);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletarDepartamento(@PathVariable Integer id) {
		departamentoService.deletarDepartamento(id);
		return ResponseEntity.noContent().build();
	}
}
