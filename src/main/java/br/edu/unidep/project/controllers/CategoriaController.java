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

import br.edu.unidep.project.dtos.CategoriaDTO;
import br.edu.unidep.project.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CategoriaDTO> buscarCategoria(@PathVariable Integer id) {
		CategoriaDTO categoriaDTO = new CategoriaDTO(categoriaService.buscarCategoria(id));
		return ResponseEntity.ok().body(categoriaDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> mostrarCategorias() {
		List<CategoriaDTO> categoriasDTO = categoriaService.mostrarCategorias().stream().map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriasDTO);
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> cadastrarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
		CategoriaDTO catDTO = new CategoriaDTO(categoriaService.cadastrarCategoria(categoriaDTO));
		return ResponseEntity.ok().body(catDTO);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<CategoriaDTO> editarCategoria(@PathVariable Integer id, @Valid @RequestBody CategoriaDTO categoriaDTO) {
		CategoriaDTO ctDTO = new CategoriaDTO(categoriaService.editarCategoria(id, categoriaDTO));
		return ResponseEntity.ok().body(ctDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarCategoria(@PathVariable Integer id) {
		categoriaService.deletarCategoria(id);
		return ResponseEntity.noContent().build();
	}
}
