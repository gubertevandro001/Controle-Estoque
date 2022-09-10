package br.edu.unidep.project.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.project.dtos.CategoriaDTO;
import br.edu.unidep.project.entities.Categoria;
import br.edu.unidep.project.repositorys.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarCategoria(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.get();
	}
	
	public List<Categoria> mostrarCategorias() {
		return categoriaRepository.findAll();
	}
	
	public Categoria cadastrarCategoria(@Valid CategoriaDTO categoriaDTO) {
		return categoriaRepository.save(new Categoria(categoriaDTO.getCodigoCategoria(), categoriaDTO.getDescricao()));
	}
	
	public Categoria editarCategoria(@Valid Integer id, CategoriaDTO categoriaDTO) {
		Categoria categoria = buscarCategoria(id);
		
		if (categoria != null) {
			categoria.setDescricao(categoriaDTO.getDescricao());
			return categoriaRepository.save(categoria);
		}
		
		return null;
	}
	
	public void deletarCategoria(Integer id) {
		Categoria categoria = buscarCategoria(id);
		
		if (categoria != null) {
			categoriaRepository.deleteById(id);
		}
	}
}

