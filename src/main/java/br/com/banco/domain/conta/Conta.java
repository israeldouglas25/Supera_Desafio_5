package br.com.banco.domain.conta;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idConta")
public class Conta {

	@Id
	private Long idConta;
	@Column(name = "nome_responsavel", length = 50, nullable = false)
	private String nome;

}
