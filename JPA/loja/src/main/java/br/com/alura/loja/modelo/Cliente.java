package br.com.alura.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded // embute para mim os atributos dessa classe aqui
	private DadosPessoais dadosPessoais;

//------------------------Construtor----------------------------------	

	public Cliente(String nome, String cpf) {
		this.dadosPessoais = new DadosPessoais(nome, cpf);
	}
	
	public Cliente() {

	}

//------------------------ Method -------------------------------------	
	
	//método delegate, ele está delegando essa chamada do getNome para o atributo dadosPessoais.
	public String getNome() {
		return this.dadosPessoais.getNome();
	}
	
	//Delegate CPF
	public String getCpf() {
		return this.dadosPessoais.getCpf();
	}
	
//------------------------Getters & Setters --------------------------		
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}
	
	public void setDadosPessoais(DadosPessoais dadosPessoais) {
	 this.dadosPessoais = dadosPessoais;
	}
}
