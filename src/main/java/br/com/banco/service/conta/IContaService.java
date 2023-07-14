package br.com.banco.service.conta;

import br.com.banco.domain.conta.Conta;

public interface IContaService {

    Conta findById(Long id);
}
