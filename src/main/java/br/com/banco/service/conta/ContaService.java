package br.com.banco.service.conta;

import br.com.banco.domain.conta.Conta;
import br.com.banco.domain.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService implements IContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public Conta findById(Long id) {
        return contaRepository.getById(id);
    }

}
