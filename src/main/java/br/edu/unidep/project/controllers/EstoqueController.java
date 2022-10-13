package br.edu.unidep.project.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import br.edu.unidep.project.dtos.EstoqueDTO;
import br.edu.unidep.project.services.EstoqueService;

@RestController
@RequestMapping(value = "/estoques")
public class EstoqueController {
	
	@Autowired
	private EstoqueService estoqueService;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EstoqueDTO> buscarEstoque(@PathVariable Integer id) {
		
		EstoqueDTO estoqueDTO = new EstoqueDTO(estoqueService.buscarEstoque(id));
		return ResponseEntity.ok().body(estoqueDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<EstoqueDTO>> mostrarEstoques() {
		
		List<EstoqueDTO> estoquesDTO = estoqueService.mostrarEstoques().stream().map(est -> new EstoqueDTO(est)).collect(Collectors.toList());
		return ResponseEntity.ok().body(estoquesDTO);
		
	}
	
	@PostMapping
	public ResponseEntity<EstoqueDTO> cadastrarEstoque(@RequestBody EstoqueDTO estoqueDTO) {
		
		EstoqueDTO estoque = new EstoqueDTO(estoqueService.cadastrarEstoque(estoqueDTO));
		return ResponseEntity.ok().body(estoque);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EstoqueDTO> editarEstoque(@PathVariable Integer id, @RequestBody EstoqueDTO estoqueDTO) {
		
		EstoqueDTO estoque = new EstoqueDTO(estoqueService.editarEstoque(id, estoqueDTO));
		return ResponseEntity.ok().body(estoque);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarEstoque(@PathVariable Integer id) {
		
		estoqueService.deletarEstoque(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	

}
