package br.com.banco.domain.repository;

import br.com.banco.domain.transferencia.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

}
