package br.com.banco.service.transferencia;

import br.com.banco.controller.dto.FilterDto;
import br.com.banco.controller.dto.TransferenciaDto;
import br.com.banco.domain.repository.TransferenciaRepository;
import br.com.banco.domain.transferencia.Transferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TransferenciaService implements ITransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<TransferenciaDto> findAll(FilterDto filterDto) {
        var pageable = PageRequest.of(filterDto.getPage(), filterDto.getSize());
        return transferenciaRepository.findAll(pageable)
                .stream()
                .filter(transferencia -> filterByConta(transferencia, filterDto.getIdConta()))
                .filter(transferencia -> filterByName(transferencia, filterDto.getNomeOperador()))
                .filter(transferencia -> filterDataInicial(transferencia, filterDto.getDataInicial()))
                .filter(transferencia -> filterDataFinal(transferencia, filterDto.getDataFinal()))
                .map(TransferenciaDto::of)
                .collect(Collectors.toList());
    }

    public boolean filterByName(Transferencia transferencia, String filterName) {
        if (!StringUtils.hasText(filterName)) {
            return true;
        }
        if (!StringUtils.hasText(transferencia.getNomeOperadorTransacao())) {
            return false;
        }
        return transferencia.getNomeOperadorTransacao().equals(filterName);
    }

    public boolean filterByConta(Transferencia transferencia, Long filterConta) {
        if (Objects.isNull(filterConta)) {
            return true;
        }
        if (Objects.isNull(transferencia.getConta())) {
            return false;
        }
        return transferencia.getConta().getIdConta().equals(filterConta);
    }

    public boolean filterDataFinal(Transferencia transferencia, LocalDateTime dataFinal) {
        if (Objects.isNull(dataFinal)) {
            return true;
        }
        if (Objects.isNull(transferencia.getDataTransferencia())) {
            return false;
        }
        return transferencia.getDataTransferencia().isBefore(dataFinal) || transferencia.getDataTransferencia().isEqual(dataFinal);
    }

    public boolean filterDataInicial(Transferencia transferencia, LocalDateTime dataInicial) {
        if (Objects.isNull(dataInicial)) {
            return true;
        }
        if (Objects.isNull(transferencia.getDataTransferencia())) {
            return false;
        }
        return transferencia.getDataTransferencia().isEqual(dataInicial) || transferencia.getDataTransferencia().isAfter(dataInicial);
    }

}
