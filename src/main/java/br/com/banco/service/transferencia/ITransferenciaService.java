package br.com.banco.service.transferencia;

import br.com.banco.controller.dto.FilterDto;
import br.com.banco.controller.dto.TransferenciaDto;

import java.util.List;

public interface ITransferenciaService {

    List<TransferenciaDto> findAll(FilterDto filterDto);
}
