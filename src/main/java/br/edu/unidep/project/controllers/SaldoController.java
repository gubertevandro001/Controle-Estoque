package br.edu.unidep.project.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import br.edu.unidep.project.dtos.SaldoDTO;
import br.edu.unidep.project.services.SaldoService;

@RestController
@RequestMapping(value = "/saldos")
public class SaldoController {
	
	@Autowired
	private SaldoService saldoService;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaldoDTO> buscarSaldo(@PathVariable Integer id) {
		SaldoDTO saldoDTO = new SaldoDTO(saldoService.buscarSaldo(id));
		return ResponseEntity.ok().body(saldoDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<SaldoDTO>> mostrarSaldos() {
		List<SaldoDTO> saldosDTO = saldoService.mostrarSaldos().stream().map(saldo -> new SaldoDTO(saldo)).collect(Collectors.toList());
		return ResponseEntity.ok().body(saldosDTO);
	}
	
	@PostMapping
	public ResponseEntity<SaldoDTO> cadastrarSaldo(@RequestBody SaldoDTO saldoDTO) {
		SaldoDTO saldo = new SaldoDTO(saldoService.cadastrarSaldo(saldoDTO));
		return ResponseEntity.ok().body(saldo);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SaldoDTO> editarSaldo(@PathVariable Integer id, @RequestBody SaldoDTO saldoDTO) {
		SaldoDTO saldo = new SaldoDTO(saldoService.editarSaldo(id, saldoDTO));
		return ResponseEntity.ok().body(saldo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarSaldo(@PathVariable Integer id) {
		saldoService.deletarSaldo(id);
		return ResponseEntity.noContent().build();
	}
}
