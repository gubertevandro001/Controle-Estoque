package br.edu.unidep.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.project.dtos.EstoqueDTO;
import br.edu.unidep.project.entities.Estoque;
import br.edu.unidep.project.repositorys.EstoqueRepository;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	
	public Estoque buscarEstoque(Integer id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);
		return estoque.get();
	}
	
	public List<Estoque> mostrarEstoques() {
		return estoqueRepository.findAll();
	}
	
	private Estoque aPartirDTO(EstoqueDTO estoqueDTO) {
		
		Estoque estoque = new Estoque();
		
		estoque.setCodigoEstoque(estoqueDTO.getCodigoEstoque());
		estoque.setDescricao(estoqueDTO.getDescricao());
		
		estoqueRepository.save(estoque);
		
		return estoque;
	}
	
	public Estoque cadastrarEstoque(EstoqueDTO estoqueDTO) {
		return aPartirDTO(estoqueDTO);
	}
	
	public Estoque editarEstoque(Integer id, EstoqueDTO estoqueDTO) {
		
		Estoque estoque = buscarEstoque(id);
		
		if (estoque != null) {
			estoque.setDescricao(estoqueDTO.getDescricao());
			estoqueRepository.save(estoque);
		}
		
		return estoque;
	}
	
	public void deletarEstoque(Integer id) {
		
		Estoque estoque = buscarEstoque(id);
		
		if (estoque != null) {
			estoqueRepository.delete(estoque);
		}
	}
}
