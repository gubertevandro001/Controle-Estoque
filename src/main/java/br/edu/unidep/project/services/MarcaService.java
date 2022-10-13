package br.edu.unidep.project.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.project.dtos.MarcaDTO;
import br.edu.unidep.project.entities.Marca;
import br.edu.unidep.project.repositorys.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	public Marca buscarMarca(Integer id) {
		Optional<Marca> marca = marcaRepository.findById(id);
		return marca.get();
	}
	
	public List<Marca> mostrarMarcas() {
		return marcaRepository.findAll();
	}
	
	public Marca cadastrarMarca(@Valid MarcaDTO marcaDTO) {
		return marcaRepository.save(new Marca(marcaDTO.getCodigoMarca(), marcaDTO.getDescricao()));
	}
	
	public Marca editarMarca(@Valid Integer id, MarcaDTO marcaDTO) {
		Marca marca = buscarMarca(id);
		
		if (marca != null) {
			marca.setDescricao(marcaDTO.getDescricao());
			return marcaRepository.save(marca);
		}
		
		return null;
	}
	
	public void deletarMarca(Integer id) {
		Marca marca = buscarMarca(id);
		
		if (marca != null) {
			marcaRepository.deleteById(id);
		}
	}
}

