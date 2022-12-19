package br.com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.repository.ContaRepository;

@RestController
@RequestMapping("/contas")
public class ContaController {
    
    @Autowired
    private ContaRepository contaRepository;

    
}
