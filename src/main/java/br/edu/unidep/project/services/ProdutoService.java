package br.edu.unidep.project.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.unidep.project.dtos.ProdutoDTO;
import br.edu.unidep.project.dtos.ProdutoEstoqueDTO;
import br.edu.unidep.project.entities.Categoria;
import br.edu.unidep.project.entities.Departamento;
import br.edu.unidep.project.entities.Estoque;
import br.edu.unidep.project.entities.EstoqueSaldo;
import br.edu.unidep.project.entities.Grupo;
import br.edu.unidep.project.entities.Lote;
import br.edu.unidep.project.entities.Marca;
import br.edu.unidep.project.entities.Produto;
import br.edu.unidep.project.entities.Saldo;
import br.edu.unidep.project.repositorys.EstoqueSaldoRepository;
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
	private EstoqueService estoqueService;

	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private SaldoService saldoService;

	@Autowired
	private EstoqueSaldoRepository estoqueSaldoRepository;

	@Autowired
	private ProdutoEstoqueService produtoEstoqueService;

	public Produto buscarProduto(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}
	
	public Produto buscarProdutoEstoques(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		produto.get().getOutrosEstoques().remove(0);
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

	private Produto aPartirDTO(@RequestBody ProdutoDTO produtoDTO) {

		double quant = 0;
		
		Produto prod = new Produto();
		prod.setCodigoProduto(produtoDTO.getCodigoProduto());
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
		} else {
			prod.setQuantidade(0.0);
		}

		List<Saldo> saldos = saldoService.mostrarSaldos();
		Estoque estoque = estoqueService.buscarEstoque(produtoDTO.getCodigoEstoquePadrao());
		Categoria categoria = categoriaService.buscarCategoria(produtoDTO.getCodigoCategoria());
		Grupo grupo = grupoService.buscarGrupo(produtoDTO.getCodigoGrupo());
		Marca marca = marcaService.buscarMarca(produtoDTO.getCodigoMarca());
		Departamento departamento = departamentoService.buscarDepartamento(produtoDTO.getCodigoDepartamento());

		prod.setCategoria(categoria);
		prod.setGrupo(grupo);
		prod.setDepartamento(departamento);
		prod.setMarca(marca);
		prod.setEstoquePadrao(estoque);

		// Transforma o objeto Estoque em uma lista de Estoques para adicionar a a
		// tabela ProdutoEstoque
		prod.adicionarEstoquePadrao(estoque);
		
		prod.setOutrosEstoques(produtoDTO.getOutrosEstoques());
		
		produtoRepository.save(prod);

		// Salva o Estoque referente a variavel "estoquePadrao"
		produtoEstoqueService.salvarProdutoEstoque(new ProdutoEstoqueDTO(estoque.getCodigoEstoque(), prod.getCodigoProduto()));
		
		for (Estoque ep : prod.getOutrosEstoques()) {
			produtoEstoqueService.salvarProdutoEstoque(new ProdutoEstoqueDTO(ep.getCodigoEstoque(), prod.getCodigoProduto()));
			
		}

		for (Saldo saldo : saldoService.mostrarSaldos()) {
			estoqueSaldoRepository.save(new EstoqueSaldo(prod, saldo, estoque, null));
		}
		
		

		return prod;
	}

	private Produto updateFromDTO(Integer id, ProdutoDTO produtoDTO) {

		Produto produto = buscarProduto(id);

		if (produto != null && produto.getCodigoProduto() == produtoDTO.getCodigoProduto()) {
			produto.setDescricao(produtoDTO.getDescricao());
			produto.setCodigoReferencia(produtoDTO.getCodigoReferencia());
			produto.setCodigoBarras(produtoDTO.getCodigoBarras());
			produto.setCustoAquisicao(produtoDTO.getCustoAquisicao());
			produto.setPrecoVenda(produtoDTO.getPrecoVenda());

			Estoque estoque = estoqueService.buscarEstoque(produtoDTO.getCodigoEstoquePadrao());
			Categoria categoria = categoriaService.buscarCategoria(produtoDTO.getCodigoCategoria());
			Grupo grupo = grupoService.buscarGrupo(produtoDTO.getCodigoGrupo());
			Marca marca = marcaService.buscarMarca(produtoDTO.getCodigoMarca());
			Departamento departamento = departamentoService.buscarDepartamento(produtoDTO.getCodigoDepartamento());

			produto.setCategoria(categoria);
			produto.setGrupo(grupo);
			produto.setDepartamento(departamento);
			produto.setMarca(marca);
			produto.setEstoquePadrao(estoque);

			return produtoRepository.save(produto);
		} else {
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
