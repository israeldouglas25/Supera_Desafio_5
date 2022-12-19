package br.com.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@Autowired
	private ContaService contaService;
	
	public List<Transferencia> findAll(){
		return transferenciaRepository.findAll();
	}
	
	public List<Transferencia> findAllByNome(String nome){
		return transferenciaRepository.findTransferenciaByNomeOperadorTransacao(nome);
	}
	
	public List<Transferencia> findAllByConta(Long id){
		Conta conta = contaService.findById(id);
		return transferenciaRepository.findTransferenciaByConta(conta);
	}
	
}
