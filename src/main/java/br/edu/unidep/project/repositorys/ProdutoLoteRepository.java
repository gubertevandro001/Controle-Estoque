package br.edu.unidep.project.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.project.entities.ProdutoLote;

public interface ProdutoLoteRepository extends JpaRepository<ProdutoLote, Integer> {
	
}
