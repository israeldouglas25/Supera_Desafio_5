package br.com.banco.domain.repository;

import br.com.banco.domain.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
