package br.com.banco.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.TransferenciaDto;
import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

	@Autowired
	private TransferenciaService transferenciaService;

	@GetMapping
	public ResponseEntity<List<Transferencia>> findAll() {
		List<Transferencia> transferencias = transferenciaService.findAll();
		return ResponseEntity.ok(transferencias);
	}

	@GetMapping("/nome")
	public ResponseEntity<List<Transferencia>> findAllByName(@RequestParam String nome) {
		List<Transferencia> transferencia = transferenciaService.findAllByNome(nome);
		return ResponseEntity.ok(transferencia);
	}

	@GetMapping("/conta/{id}")
	public ResponseEntity<List<TransferenciaDto>> findAllByConta(@PathVariable Long id) {
		List<Transferencia> transferencia = transferenciaService.findAllByConta(id);
		List<TransferenciaDto> transferenciaDto = transferencia
				.stream()
				.map(TransferenciaDto::of)
				.toList();
		return ResponseEntity.ok(transferenciaDto);
	}

	@GetMapping("/periodo")
	public ResponseEntity<List<Transferencia>> findAllByPeriodo(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {
		List<Transferencia> periodo = transferenciaService.findAllByPeriodo(dataInicial, dataFinal);
		return ResponseEntity.ok(periodo);
	}

}
