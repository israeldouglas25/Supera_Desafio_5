package br.com.banco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@RestController
@RequestMapping("/conta")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Transferencia>> findAll(){
		List<Transferencia> contas = repository.findAll();
		return ResponseEntity.ok(contas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Transferencia> findById(@PathVariable Long id){
		 Optional<Transferencia> transacoes = repository.findById(id);
		return ResponseEntity.ok(transacoes.get());
	}
	
	@PostMapping
	public ResponseEntity<Transferencia> insert(@RequestBody Transferencia conta){
		repository.save(conta);
		return ResponseEntity.ok(conta);
	}

}
