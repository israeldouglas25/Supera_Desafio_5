package br.com.banco.controller.dto;

import br.com.banco.domain.conta.Conta;
import br.com.banco.domain.transferencia.Transferencia;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransferenciaDto {

    private Long id;
    private Double valor;
    private LocalDateTime dataTransferencia;
    private String tipo;
    private String nomeOperadorTransacao;
    private Conta conta;

    public static TransferenciaDto of(Transferencia transferencia) {
        TransferenciaDto transferenciaDto = new TransferenciaDto();
        transferenciaDto.setDataTransferencia(transferencia.getDataTransferencia());
        transferenciaDto.setTipo(transferencia.getTipo());
        transferenciaDto.setValor(transferencia.getValor());
        transferenciaDto.setId(transferencia.getId());
        transferenciaDto.setNomeOperadorTransacao(transferencia.getNomeOperadorTransacao() == null ? "" : transferencia.getNomeOperadorTransacao());
        transferenciaDto.setConta(transferencia.getConta());
        return transferenciaDto;
    }

}
