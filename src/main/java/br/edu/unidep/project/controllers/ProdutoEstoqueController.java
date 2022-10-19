package br.edu.unidep.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unidep.project.dtos.ProdutoEstoqueDTO;
import br.edu.unidep.project.services.ProdutoEstoqueService;

@RestController
@RequestMapping(value = "/pe")
public class ProdutoEstoqueController {

	
	@Autowired
	private ProdutoEstoqueService produtoEstoqueService;
	
	@PostMapping
	public ResponseEntity<Void> salvarProdutoEstoque(ProdutoEstoqueDTO produtoEstoqueDTO) {
		ProdutoEstoqueDTO prod = new ProdutoEstoqueDTO(produtoEstoqueService.salvarProdutoEstoque(produtoEstoqueDTO));
		return ResponseEntity.noContent().build();
	}
	
}
