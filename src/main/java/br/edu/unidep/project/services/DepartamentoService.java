package br.edu.unidep.project.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.project.dtos.DepartamentoDTO;
import br.edu.unidep.project.entities.Departamento;
import br.edu.unidep.project.repositorys.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public Departamento buscarDepartamento(Integer id) {
		Optional<Departamento> departamento = departamentoRepository.findById(id);
		return departamento.get();
	}
	
	public List<Departamento> mostrarDepartamentos() {
		return departamentoRepository.findAll();
	}
	
	public Departamento cadastrarDepartamento(@Valid DepartamentoDTO departamentoDTO) {
		return departamentoRepository.save(new Departamento(departamentoDTO.getCodigoDepartamento(), departamentoDTO.getDescricao()));
		
	}
	
	public Departamento editarDepartamento(@Valid Integer id, DepartamentoDTO departamentoDTO) {
		Departamento departamento = buscarDepartamento(id);
		
		if (departamento != null) {
			departamento.setDescricao(departamentoDTO.getDescricao());
			return departamentoRepository.save(departamento);
		}
		
		return null;
	}
	
	public void deletarDepartamento(Integer id) {
		Departamento departamento = buscarDepartamento(id);
		
		if (departamento != null) {
			departamentoRepository.deleteById(id);
		}
	}
}
