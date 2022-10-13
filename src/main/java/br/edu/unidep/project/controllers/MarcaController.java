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

import br.edu.unidep.project.dtos.MarcaDTO;
import br.edu.unidep.project.services.MarcaService;

@RestController
@RequestMapping(value="/marcas")
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<MarcaDTO> buscarMarca(@PathVariable Integer id) {
		MarcaDTO marcaDTO = new MarcaDTO(marcaService.buscarMarca(id));
		return ResponseEntity.ok().body(marcaDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<MarcaDTO>> mostrarMarcas() {
		List<MarcaDTO> marcasDTO = marcaService.mostrarMarcas().stream().map(gpo -> new MarcaDTO(gpo)).collect(Collectors.toList());
		return ResponseEntity.ok().body(marcasDTO);
	}
	
	@PostMapping
	public ResponseEntity<MarcaDTO> cadastrarMarca(@Valid @RequestBody MarcaDTO marcaDTO) {
		MarcaDTO mrcDTO = new MarcaDTO(marcaService.cadastrarMarca(marcaDTO));
		return ResponseEntity.ok().body(mrcDTO);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<MarcaDTO> editarMarca(@PathVariable Integer id, @Valid @RequestBody MarcaDTO marcaDTO) {
		MarcaDTO mrcDTO = new MarcaDTO(marcaService.editarMarca(id, marcaDTO));
		return ResponseEntity.ok().body(mrcDTO);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletarMarca(@PathVariable Integer id) {
		marcaService.deletarMarca(id);
		return ResponseEntity.noContent().build();
	}
}
