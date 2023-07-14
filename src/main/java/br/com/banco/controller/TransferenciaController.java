package br.com.banco.controller;

import br.com.banco.controller.dto.FilterDto;
import br.com.banco.controller.dto.TransferenciaDto;
import br.com.banco.service.transferencia.ITransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
@CrossOrigin("*")
public class TransferenciaController {

    @Autowired
    private ITransferenciaService service;

    @GetMapping
    public ResponseEntity<List<TransferenciaDto>> findAll(FilterDto filterDto) {
        List<TransferenciaDto> transferencias = service.findAll(filterDto);
        return ResponseEntity.ok(transferencias);
    }

}
