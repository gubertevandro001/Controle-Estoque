package br.edu.unidep.project.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unidep.project.dtos.LoteDTO;
import br.edu.unidep.project.services.LoteService;

@RestController
@RequestMapping(value="/lotes")
public class LoteController {
	
	@Autowired
	private LoteService loteService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<LoteDTO> buscarLote(@PathVariable Integer id) {
		LoteDTO loteDTO = new LoteDTO(loteService.buscarLote(id));
		return ResponseEntity.ok().body(loteDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<LoteDTO>> mostrarLotes() {
		List<LoteDTO> lotesDTO = loteService.mostrarLotes().stream().map(lote -> new LoteDTO(lote)).collect(Collectors.toList());
		return ResponseEntity.ok().body(lotesDTO);
	}
	
	@PostMapping
	public ResponseEntity<LoteDTO> cadastrarLote(@Valid @RequestBody LoteDTO loteDTO) {
		LoteDTO ltDTO = new LoteDTO(loteService.cadastrarLote(loteDTO));
		return ResponseEntity.ok().body(ltDTO);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<LoteDTO> editarLote(@Valid @PathVariable Integer id, @RequestBody LoteDTO loteDTO) {
		LoteDTO ltDTO = new LoteDTO(loteService.editarLote(id, loteDTO));
		return ResponseEntity.ok().body(ltDTO);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletarLote(@PathVariable Integer id) {
		loteService.deletarLote(id);
		return ResponseEntity.noContent().build();
	}
}

