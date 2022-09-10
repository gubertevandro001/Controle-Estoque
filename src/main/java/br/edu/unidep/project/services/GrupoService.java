package br.edu.unidep.project.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.project.dtos.GrupoDTO;
import br.edu.unidep.project.entities.Grupo;
import br.edu.unidep.project.repositorys.GrupoRepository;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	
	public Grupo buscarGrupo(Integer id) {
		Optional<Grupo> grupo = grupoRepository.findById(id);
		return grupo.get();
	}
	
	public List<Grupo> mostrarGrupos() {
		return grupoRepository.findAll();
	}
	
	public Grupo cadastrarGrupo(@Valid GrupoDTO grupoDTO) {
		Grupo grupo = new Grupo(grupoDTO.getCodigoGrupo(), grupoDTO.getDescricao());
		return grupoRepository.save(grupo);
	}
	
	public Grupo editarGrupo(@Valid Integer id, GrupoDTO grupoDTO) {
		Grupo grupo = buscarGrupo(id);
		
		if (grupo != null) {
			grupo.setDescricao(grupoDTO.getDescricao());
			return grupoRepository.save(grupo);
		}
		
		return null;

	}
	
	public void deletarGrupo(Integer id) {	
		Grupo grupo = buscarGrupo(id);
		
		if (grupo != null) {
			grupoRepository.deleteById(id);
		}
	}
}
