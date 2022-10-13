package br.edu.unidep.project.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unidep.project.dtos.LoteDTO;
import br.edu.unidep.project.dtos.ProdutoDTO;
import br.edu.unidep.project.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ProdutoDTO> buscarProduto(@PathVariable Integer id) {
		ProdutoDTO produtoDTO = new ProdutoDTO(produtoService.buscarProduto(id));
		return ResponseEntity.ok().body(produtoDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> mostrarProdutos() {
		List<ProdutoDTO> produtosDTO = produtoService.mostrarProdutos().stream().map(prod -> new ProdutoDTO(prod)).collect(Collectors.toList());
		return ResponseEntity.ok().body(produtosDTO);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> cadastrarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
		ProdutoDTO prodDTO = new ProdutoDTO(produtoService.cadastrarProduto(produtoDTO));
		return ResponseEntity.ok().body(prodDTO);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ProdutoDTO> editarProduto(@PathVariable Integer id, @Valid @RequestBody ProdutoDTO produtoDTO) {
		produtoDTO = new ProdutoDTO(produtoService.editarProduto(id, produtoDTO));
		return ResponseEntity.ok().body(produtoDTO);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
		produtoService.deletarProduto(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value="/{id}/lotes")
	public ResponseEntity<List<LoteDTO>> mostrarLotesProdutos(@PathVariable Integer id) {
		List<LoteDTO> lotesDTO = produtoService.mostrarLotesProduto(id).stream().map(lt -> new LoteDTO(lt)).collect(Collectors.toList());
		return ResponseEntity.ok().body(lotesDTO);
	}
	
	@PutMapping(value="/{idProduto}/lotes/{idLote}/deletar")
	public ResponseEntity<ProdutoDTO> deletarLotesProduto(@PathVariable("idProduto") Integer idProduto, @PathVariable("idLote") Integer idlote) {
	    ProdutoDTO produtoDTO = new ProdutoDTO(produtoService.deletarLoteProduto(idProduto, idlote));
		return ResponseEntity.ok().body(produtoDTO);
	}
}

