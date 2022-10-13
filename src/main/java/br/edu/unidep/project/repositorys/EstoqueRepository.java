package br.edu.unidep.project.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.project.entities.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{

}
