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

import br.edu.unidep.project.dtos.GrupoDTO;
import br.edu.unidep.project.services.GrupoService;

@RestController
@RequestMapping(value="/grupos")
public class GrupoController {
	
	@Autowired
	private GrupoService grupoService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<GrupoDTO> buscarGrupo(@PathVariable Integer id) {
		GrupoDTO grupoDTO = new GrupoDTO(grupoService.buscarGrupo(id));
		return ResponseEntity.ok().body(grupoDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<GrupoDTO>> mostrarGrupos() {
		List<GrupoDTO> gruposDTO = grupoService.mostrarGrupos().stream().map(gpo -> new GrupoDTO(gpo)).collect(Collectors.toList());
		return ResponseEntity.ok().body(gruposDTO);
	}
	
	@PostMapping
	public ResponseEntity<GrupoDTO> cadastrarGrupo(@Valid @RequestBody GrupoDTO grupoDTO) {
		GrupoDTO gpoDTO = new GrupoDTO(grupoService.cadastrarGrupo(grupoDTO));
		return ResponseEntity.ok().body(gpoDTO);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<GrupoDTO> editarGrupo(@PathVariable Integer id, @Valid @RequestBody GrupoDTO grupoDTO) {
		GrupoDTO gpoDTO = new GrupoDTO(grupoService.editarGrupo(id, grupoDTO));
		return ResponseEntity.ok().body(gpoDTO);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletarGrupo(@PathVariable Integer id) {
		grupoService.deletarGrupo(id);
		return ResponseEntity.noContent().build();
	}
}
