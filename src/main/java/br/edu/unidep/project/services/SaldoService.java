package br.edu.unidep.project.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.project.dtos.SaldoDTO;
import br.edu.unidep.project.entities.Saldo;
import br.edu.unidep.project.repositorys.SaldoRepository;

@Service
public class SaldoService {
	
	@Autowired
	private SaldoRepository saldoRepository;
	
	public Saldo buscarSaldo(Integer id) {
		Optional<Saldo> saldo = saldoRepository.findById(id);
		return saldo.get();
	}
	
	public List<Saldo> mostrarSaldos() {
		return saldoRepository.findAll();
	}
	
	public Saldo cadastrarSaldo(SaldoDTO saldoDTO) {
		return aPartirDTO(saldoDTO);
	}
	
	public Saldo editarSaldo(@Valid Integer id, SaldoDTO saldoDTO) {
		
		Saldo saldo = buscarSaldo(id);
		
		if (saldo != null) {
			saldo.setDescricao(saldoDTO.getDescricao());
			saldo.setMovimentaLote(saldoDTO.getMovimentaLote());
			saldoRepository.save(saldo);
		}
		
		return saldo;
	}
	
	private Saldo aPartirDTO(SaldoDTO saldoDTO) {
		
		Saldo saldo = new Saldo();
		
		saldo.setCodigoSaldo(saldoDTO.getCodigoSaldo());
		saldo.setDescricao(saldoDTO.getDescricao());
		saldo.setMovimentaLote(saldoDTO.getMovimentaLote());
		
		saldoRepository.save(saldo);
		
		return saldo;
	}
	
	public void deletarSaldo(Integer id) {
		
		Saldo saldo = buscarSaldo(id);
		
		if (saldo != null) {
			saldoRepository.delete(saldo);
		}
	}
}
