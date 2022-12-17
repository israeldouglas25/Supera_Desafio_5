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

//	/**
//	 * Metodo para depositar
//	 * 
//	 * @param deposito
//	 * 
//	 */
//	public void deposita(double deposito) {
//		valor += deposito;
//	}
//
//	/**
//	 * Metodo para sacar com tratamento de erro
//	 * 
//	 * @param valor
//	 * @throws SacaException
//	 */
//	public void saca(double valor) throws SacaException {
//
//		if (this.valor < valor) {
//			throw new SacaException("Valor invalido! Saldo: " + this.valor + ", valor: " + valor);
//		}
//		this.valor -= valor;
//	}
//
//	/**
//	 * Metodo para transferencia de uma conta para outra
//	 * 
//	 * @param valor
//	 * @param destino
//	 * @throws SacaException
//	 */
//	public void transfere(double valor, Transferencia destino) throws SacaException {
//		this.saca(valor);
//		destino.deposita(valor);
//	}

	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", valor=" + valor + ", dataTransferencia=" + dataTransferencia + ", tipo="
				+ tipo + ", nomeOperadorTransacao=" + nomeOperadorTransacao + ", conta=" + conta + "]";
	}

}
