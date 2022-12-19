package br.com.banco.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	private Long id;
	@Column(name = "valor", nullable = false)
	private double valor;
	@Column(name = "data_transferencia", nullable = false)
	private LocalDateTime dataTransferencia;
	@Column(name = "tipo", nullable = false, length = 15)
	private String tipo;
	@Column(name = "nome_operador_transacao", nullable = false, length = 50)
	private String nomeOperadorTransacao;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "conta_id", nullable = false)
	private Conta conta;

	public Transferencia() {
	}

	public Transferencia(Long id, double valor, LocalDateTime dataTransferencia, String tipo,
			String nomeOperadorTransacao, Conta conta) {
		this.id = id;
		this.valor = valor;
		this.dataTransferencia = dataTransferencia;
		this.tipo = tipo;
		this.nomeOperadorTransacao = nomeOperadorTransacao;
		this.conta = conta;
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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dataTransferencia == null) ? 0 : dataTransferencia.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((nomeOperadorTransacao == null) ? 0 : nomeOperadorTransacao.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transferencia other = (Transferencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		if (dataTransferencia == null) {
			if (other.dataTransferencia != null)
				return false;
		} else if (!dataTransferencia.equals(other.dataTransferencia))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (nomeOperadorTransacao == null) {
			if (other.nomeOperadorTransacao != null)
				return false;
		} else if (!nomeOperadorTransacao.equals(other.nomeOperadorTransacao))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", valor=" + valor + ", dataTransferencia=" + dataTransferencia + ", tipo="
				+ tipo + ", nomeOperadorTransacao=" + nomeOperadorTransacao + ", conta=" + conta + "]";
	}

}
