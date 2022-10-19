package br.edu.unidep.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.unidep.project.dtos.ProdutoEstoqueDTO;
import br.edu.unidep.project.entities.Estoque;
import br.edu.unidep.project.entities.Produto;
import br.edu.unidep.project.entities.ProdutoEstoque;
import br.edu.unidep.project.repositorys.ProdutoEstoqueRepository;
import br.edu.unidep.project.services.exceptions.DataIntegratyViolationException;

@Service
public class ProdutoEstoqueService {
	
	@Autowired
	private ProdutoEstoqueRepository produtoEstoqueRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private EstoqueService estoqueService;
	
	private ProdutoEstoque aPartirDTO(ProdutoEstoqueDTO produtoEstoqueDTO) {
		
		ProdutoEstoque produtoEstoque = new ProdutoEstoque();
		
		Estoque estoque = estoqueService.buscarEstoque(produtoEstoqueDTO.getCodigoEstoque());
		
		Produto produto = produtoService.buscarProduto(produtoEstoqueDTO.getCodigoProduto());
				
		produtoEstoque.setEstoque(estoque);
		produtoEstoque.setProduto(produto);

		return produtoEstoqueRepository.save(produtoEstoque);
	}
	
	public ProdutoEstoque salvarProdutoEstoque(ProdutoEstoqueDTO produtoEstoqueDTO) {
		return aPartirDTO(produtoEstoqueDTO);
	}
}
