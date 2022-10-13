package br.edu.unidep.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unidep.project.dtos.ProdutoLoteDTO;
import br.edu.unidep.project.services.ProdutoLoteService;

@RestController
public class ProdutoLoteController {
	
	@Autowired
	private ProdutoLoteService produtoLoteService;
	
	
	@PostMapping
	public ResponseEntity<Void> salvarProdutoLote(@RequestBody ProdutoLoteDTO produtoLoteDTO) {
		ProdutoLoteDTO pdLoteDTO = new ProdutoLoteDTO(produtoLoteService.salvarProdutoLote(produtoLoteDTO));
		return ResponseEntity.noContent().build();
	}

}
