package br.edu.unidep.project.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.project.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
