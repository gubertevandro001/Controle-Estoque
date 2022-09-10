package br.edu.unidep.project.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.project.dtos.LoteDTO;
import br.edu.unidep.project.entities.Lote;
import br.edu.unidep.project.entities.Produto;
import br.edu.unidep.project.repositorys.LoteRepository;
import br.edu.unidep.project.services.exceptions.DataIntegratyViolationException;

@Service
public class LoteService {
	
	@Autowired
	private LoteRepository loteRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	
	public Lote buscarLote(Integer id) {
		Optional<Lote> lote = loteRepository.findById(id);
		return lote.get();
	}
	
	public List<Lote> mostrarLotes() {
		return loteRepository.findAll();
	}
	
	public Lote cadastrarLote(@Valid LoteDTO loteDTO) {
		return aPartirDTO(loteDTO);
	}
	
	public Lote editarLote(@Valid Integer id, LoteDTO loteDTO) {		
		return updateLoteFromDTO(id, loteDTO);
	}
	
	private Lote aPartirDTO(LoteDTO loteDTO) {
		
		Lote lote = new Lote();
		
		lote.setDescricao(loteDTO.getDescricao());
		lote.setQuantidade(loteDTO.getQuantidade());
		lote.setDataValidade(loteDTO.getDataValidade());
		
		Produto produto = produtoService.buscarProduto(loteDTO.getCodigoProduto());
		
		lote.setProduto(produto);
		
		return loteRepository.save(lote);
		
	}
	
	private Lote updateLoteFromDTO(@Valid Integer id, LoteDTO loteDTO) {
		
		Lote lote = buscarLote(id);
		
		if (lote != null && loteDTO.getCodigoLote() == lote.getCodigoLote()) {
			
			lote.setCodigoLote(loteDTO.getCodigoLote());
			lote.setDescricao(loteDTO.getDescricao());
			lote.setQuantidade(loteDTO.getQuantidade());
			lote.setDataValidade(loteDTO.getDataValidade());
			
			Produto produto = produtoService.buscarProduto(loteDTO.getCodigoProduto());
			
			lote.setProduto(produto);
			
			return loteRepository.save(lote);
			
		}
		else {
			return null;
		}
	}
	
	public void deletarLote(Integer id) {	
		Lote lote = buscarLote(id);
		
		if (lote != null && lote.getQuantidade() == 0) {
			loteRepository.deleteById(id);
		}
		else {
			throw new DataIntegratyViolationException("Ainda existem saldos no lote " + lote.getDescricao() + " Para o Produto " + lote.getProduto().getDescricao());
		}
	}
}
