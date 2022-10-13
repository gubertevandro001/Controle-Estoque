package br.edu.unidep.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unidep.project.dtos.EstoqueSaldoDTO;
import br.edu.unidep.project.services.EstoqueSaldoService;

@RestController
@RequestMapping(value = "/estoques-saldos")
public class EstoqueSaldoController {
	
	@Autowired
	private EstoqueSaldoService estoqueSaldoService;
	
	
	@PostMapping
	public ResponseEntity<Void> cadastrarEstoqueSaldo(@RequestBody EstoqueSaldoDTO estoqueSaldoDTO) {
		EstoqueSaldoDTO estoqueDTO = new EstoqueSaldoDTO(estoqueSaldoService.cadastrarEstoqueSaldo(estoqueSaldoDTO));
		return ResponseEntity.noContent().build();
	}

}
