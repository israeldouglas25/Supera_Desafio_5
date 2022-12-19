package br.com.banco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping
	public ResponseEntity<List<Transferencia>> findAll(){
		List<Transferencia> transferencias = transferenciaRepository.findAll();
		return ResponseEntity.ok(transferencias);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transferencia> findAllByName(@PathVariable Long id){
		Optional<Transferencia> transferencia = transferenciaRepository.findById(id);
		return ResponseEntity.ok(transferencia.get());
	}

}
