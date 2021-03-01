package br.com.tree.prova.vo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParadaViagem {
	private String nome;	
	private BigDecimal mglt;
	private BigDecimal qtdParada;
	
	@Override
	public String toString() {
		return String.format("%s: %.0f paradas", this.nome, this.qtdParada);
	}
	
}
