package br.com.banco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta {

	@Id
	private Long id_conta;
	@Column(name = "nome_responsavel", length = 50, nullable = false)
	private String nome;

	public Conta() {
	}

	public Conta(Long id_conta, String nome) {
		this.id_conta = id_conta;
		this.nome = nome;
	}

	public Long getId_conta() {
		return id_conta;
	}

	public void setId_conta(Long id_conta) {
		this.id_conta = id_conta;
	}

	public String getNome_responsavel() {
		return nome;
	}

	public void setNome_responsavel(String nome) {
		this.nome = nome;
	}

}
