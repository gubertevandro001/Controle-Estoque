package br.edu.unidep.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.unidep.project.dtos.ProdutoLoteDTO;
import br.edu.unidep.project.entities.Lote;
import br.edu.unidep.project.entities.Produto;
import br.edu.unidep.project.entities.ProdutoLote;
import br.edu.unidep.project.repositorys.ProdutoLoteRepository;

@Service
public class ProdutoLoteService {
	
	@Autowired
	private ProdutoLoteRepository produtoLoteRepository;
	
	@Autowired
	private LoteService loteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	
	public ProdutoLote salvarProdutoLote(@RequestBody ProdutoLoteDTO produtoLoteDTO) {
		return aPartirProdutoLoteDTO(produtoLoteDTO);
	}
	
	private ProdutoLote aPartirProdutoLoteDTO(ProdutoLoteDTO produtoLoteDTO) {
		
		ProdutoLote produtoLote = new ProdutoLote();
		
		Lote lote = loteService.buscarLote(produtoLoteDTO.getCodigoLote());
		Produto produto = produtoService.buscarProduto(produtoLoteDTO.getCodigoProduto());
		
		produtoLote.setLote(lote);
		produtoLote.setProduto(produto);
		
		return produtoLoteRepository.save(produtoLote);
	}

}
