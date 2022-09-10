package br.edu.unidep.project.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.unidep.project.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	@Query(value="DELETE from tb_produto_lote where codigo_lote=:idLote and codigo_produto=:idProduto", nativeQuery = true)
	public void deletarLotesProduto(@Param("idLote") Integer idLote, @Param("idProduto") Integer idProduto);

}
