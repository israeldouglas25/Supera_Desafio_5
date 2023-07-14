package br.com.banco.domain.transferencia;

import br.com.banco.domain.conta.Conta;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transferencia {

	@Id
	private Long id;
	@Column(name = "valor", nullable = false)
	private Double valor;
	@Column(name = "data_transferencia", nullable = false)
	private LocalDateTime dataTransferencia;
	@Column(name = "tipo", nullable = false, length = 15)
	private String tipo;
	@Column(name = "nome_operador_transacao", nullable = false, length = 50)
	private String nomeOperadorTransacao;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "conta_id", nullable = false)
	private Conta conta;

	public Double saldo(Double saldo) {
		return saldo += this.valor;
	}
}
