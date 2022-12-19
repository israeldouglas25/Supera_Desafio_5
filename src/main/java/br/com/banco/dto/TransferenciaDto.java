package br.com.banco.dto;

import java.time.LocalDateTime;

import br.com.banco.model.Transferencia;

public class TransferenciaDto {

	private Long id;
	private double valor;
	private LocalDateTime dataTransferencia;
	private String tipo;
	private String nomeOperadorTransacao;

	public static TransferenciaDto of(Transferencia transferencia) {
		TransferenciaDto transferenciaDto = new TransferenciaDto();
		transferenciaDto.setDataTransferencia(transferencia.getDataTransferencia());
		transferenciaDto.setTipo(transferencia.getTipo());
		transferenciaDto.setValor(transferencia.getValor());
		transferenciaDto.setId(transferencia.getId());
		transferenciaDto.setNomeOperadorTransacao(transferencia.getNomeOperadorTransacao() == null ? "" : transferencia.getNomeOperadorTransacao());
		return transferenciaDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDateTime dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNomeOperadorTransacao() {
		return nomeOperadorTransacao;
	}

	public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
		this.nomeOperadorTransacao = nomeOperadorTransacao;
	}

}
