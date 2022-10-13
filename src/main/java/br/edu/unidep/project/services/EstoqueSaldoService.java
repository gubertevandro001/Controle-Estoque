package br.edu.unidep.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.unidep.project.dtos.EstoqueSaldoDTO;
import br.edu.unidep.project.entities.Estoque;
import br.edu.unidep.project.entities.EstoqueSaldo;
import br.edu.unidep.project.entities.Produto;
import br.edu.unidep.project.entities.Saldo;
import br.edu.unidep.project.repositorys.EstoqueSaldoRepository;

@Service
public class EstoqueSaldoService {
	
	@Autowired
	private EstoqueSaldoRepository estoqueSaldoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private SaldoService saldoService;
	
	@Autowired
	private EstoqueService estoqueService;
	
	public EstoqueSaldo buscarEstoqueSaldo(Integer id) {
		Optional<EstoqueSaldo> estoqueSaldo = estoqueSaldoRepository.findById(id);
		return estoqueSaldo.get();
	}
	
	
	private EstoqueSaldo aPartirDTO(EstoqueSaldoDTO estoqueSaldoDTO) {
		
		EstoqueSaldo estoqueSaldo = new EstoqueSaldo();
		
		Produto produto = produtoService.buscarProduto(estoqueSaldoDTO.getCodigoProduto());
		Saldo saldo = saldoService.buscarSaldo(estoqueSaldoDTO.getCodigoSaldo());
		Estoque estoque = estoqueService.buscarEstoque(estoqueSaldoDTO.getCodigoEstoque());
		estoqueSaldo.setQuantidade(estoqueSaldoDTO.getQuantidade());
		
		estoqueSaldo.setEstoque(estoque);
		estoqueSaldo.setProduto(produto);
		estoqueSaldo.setSaldo(saldo);
		
		estoqueSaldoRepository.save(estoqueSaldo);
		
		return estoqueSaldo;
	}
	
	public EstoqueSaldo cadastrarEstoqueSaldo(EstoqueSaldoDTO estoqueSaldoDTO) {
		return aPartirDTO(estoqueSaldoDTO);
	}
	
}
