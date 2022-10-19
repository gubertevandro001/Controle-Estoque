package br.edu.unidep.project.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.project.entities.ProdutoEstoque;

public interface ProdutoEstoqueRepository extends JpaRepository<ProdutoEstoque, Integer>{
}
