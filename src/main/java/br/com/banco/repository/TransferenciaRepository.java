package br.com.banco.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

	List<Transferencia> findTransferenciaByConta(Conta conta);

	List<Transferencia> findTransferenciaByNomeOperadorTransacao(String name);

	List<Transferencia> findTransferenciaByDataTransferenciaBetween(
			LocalDateTime dataInicial, LocalDateTime dataFinal);

}
