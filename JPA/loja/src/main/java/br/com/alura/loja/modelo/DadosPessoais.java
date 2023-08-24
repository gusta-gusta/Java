package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

@Embeddable // essa classe é embutível, eu consigo embuti-la dentro de uma entidade. 
public class DadosPessoais {
	
	private String nome;
	private String cpf;
	
	
//-------------------- Construtor	
	public DadosPessoais(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		
	}
	
	public DadosPessoais() {
	
	}
	
//-------------------- Getters 
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	
	
}