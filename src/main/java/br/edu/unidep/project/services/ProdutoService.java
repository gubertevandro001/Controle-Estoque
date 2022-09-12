package br.edu.unidep.project.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.unidep.project.dtos.ProdutoDTO;
import br.edu.unidep.project.entities.Categoria;
import br.edu.unidep.project.entities.Departamento;
import br.edu.unidep.project.entities.Grupo;
import br.edu.unidep.project.entities.Lote;
import br.edu.unidep.project.entities.Marca;
import br.edu.unidep.project.entities.Produto;
import br.edu.unidep.project.repositorys.ProdutoRepository;
import br.edu.unidep.project.services.exceptions.DataIntegratyViolationException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private DepartamentoService departamentoService;

	
	public Produto buscarProduto(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}
	
	public List<Produto> mostrarProdutos() {
		return produtoRepository.findAll();	
	}
	
	public List<Lote> mostrarLotesProduto(Integer id) {
		
		Produto produto = buscarProduto(id);
		
		if (produto != null) {
			return produto.getLotes();
		}
		
		return null;
	}

	public Produto cadastrarProduto(@Valid ProdutoDTO prodDTO) {
		return aPartirDTO(prodDTO);
	}
		
	public Produto editarProduto(@Valid Integer id, ProdutoDTO prodDTO) {
		return updateFromDTO(id, prodDTO);
	}
	
	private Produto aPartirDTO(ProdutoDTO produtoDTO) {
		
		double quant = 0;
		
		Produto prod = new Produto();
		prod.setDescricao(produtoDTO.getDescricao());
		prod.setCodigoReferencia(produtoDTO.getCodigoReferencia());
		prod.setCodigoBarras(produtoDTO.getCodigoBarras());
		prod.setCustoAquisicao(produtoDTO.getCustoAquisicao());
		prod.setPrecoVenda(produtoDTO.getPrecoVenda());
		prod.setUsaControleDeLote(produtoDTO.isUsaControleDeLote());
		
		if (produtoDTO.isUsaControleDeLote() == true) {
			if (prod.getLotes() == null || prod.getLotes().isEmpty()) {
				prod.setQuantidade(0.0);
			}
		}
		else {
			prod.setQuantidade(produtoDTO.getQuantidade());
		}
		
		
		Categoria categoria = categoriaService.buscarCategoria(produtoDTO.getCodigoCategoria());
		Grupo grupo = grupoService.buscarGrupo(produtoDTO.getCodigoGrupo());
		Marca marca = marcaService.buscarMarca(produtoDTO.getCodigoMarca());
		Departamento departamento = departamentoService.buscarDepartamento(produtoDTO.getCodigoDepartamento());
		
		prod.setCategoria(categoria);
		prod.setGrupo(grupo);
		prod.setDepartamento(departamento);
		prod.setMarca(marca);
		
		
		
		return produtoRepository.save(prod);
	}
	
	private Produto updateFromDTO(Integer id, ProdutoDTO produtoDTO) {
		
		Produto produto = buscarProduto(id);
		
		if (produto != null && produto.getCodigoProduto() == produtoDTO.getCodigoProduto()) {
			produto.setDescricao(produtoDTO.getDescricao());
			produto.setCodigoReferencia(produtoDTO.getCodigoReferencia());
			produto.setCodigoBarras(produtoDTO.getCodigoBarras());
			produto.setCustoAquisicao(produtoDTO.getCustoAquisicao());
			produto.setPrecoVenda(produtoDTO.getPrecoVenda());
			
			Categoria categoria = categoriaService.buscarCategoria(produtoDTO.getCodigoCategoria());
			Grupo grupo = grupoService.buscarGrupo(produtoDTO.getCodigoGrupo());
			Marca marca = marcaService.buscarMarca(produtoDTO.getCodigoMarca());
			Departamento departamento = departamentoService.buscarDepartamento(produtoDTO.getCodigoDepartamento());
			
			produto.setCategoria(categoria);
			produto.setGrupo(grupo);
			produto.setDepartamento(departamento);
			produto.setMarca(marca);
			
			return produtoRepository.save(produto);		
		}
		else {
			return null;
		}
	}
	
	public void deletarProduto(Integer id) {
		
		Produto produto = buscarProduto(id);
		
		if (produto != null) {
			produtoRepository.deleteById(id);
		}
	}
	
	public Produto deletarLoteProduto(Integer idProduto, Integer idLote) {
		
		Produto produto = buscarProduto(idProduto);
		
		if (produto != null) {
			
			for (Produto p : mostrarProdutos()) {
				if (p == produto) {
					List<Lote> lotes = mostrarLotesProduto(p.getCodigoProduto());
					for (Lote l : lotes) {
						if (l.getCodigoLote() == idLote) {
							produto.getLotes().remove(l);
							produtoRepository.save(produto);
							return produto;
						}
					}
				}
			}
		}
		throw new DataIntegratyViolationException("Lote Não Encontrado Para o Produto");
	}
}
