package br.com.tree.prova.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nave {	
	private String nome;
	private String modelo;
	private Integer qtdPassageiros;
}
