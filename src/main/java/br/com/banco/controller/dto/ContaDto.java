package br.com.banco.controller.dto;

import br.com.banco.domain.conta.Conta;
import lombok.Data;

@Data
public class ContaDto {
	
	
	private Long idConta;
	private String nome;
	
	public static ContaDto of(Conta conta) {
		ContaDto contaDTO = new ContaDto();
        contaDTO.setNome(conta.getNome());
        contaDTO.setIdConta(conta.getIdConta());
        return contaDTO;
    }

}
