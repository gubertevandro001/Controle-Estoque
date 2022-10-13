package br.edu.unidep.project.repositorys;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unidep.project.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	@Transactional
	@Modifying
	@Query(value="UPDATE Produto set quantidade =:quantidade where codigo_produto=:codigo_produto and usa_controle_de_lote = true")
	void ajustarQuantidadeLotesProduto(@Param("quantidade") Double quantidade, @Param("codigo_produto") Integer codigoProduto);

}
