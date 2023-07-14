package br.com.banco.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.domain.conta.Conta;
import br.com.banco.domain.transferencia.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

}
