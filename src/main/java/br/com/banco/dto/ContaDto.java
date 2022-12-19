package br.com.banco.dto;

import br.com.banco.model.Conta;

public class ContaDto {
	
	
	private Long idConta;
	private String nome;
	
	public static ContaDto of(Conta conta) {
		ContaDto contaDTO = new ContaDto();
        contaDTO.setNome(conta.getNome());
        contaDTO.setIdConta(conta.getIdConta());
        return contaDTO;
    }

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
