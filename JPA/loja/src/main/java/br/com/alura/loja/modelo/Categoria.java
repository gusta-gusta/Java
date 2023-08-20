package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	private String nome;
	
	
//----------------------- Constructor -------------------------
	
	public Categoria(String nome) {
		this.nome = nome;
	}

	public Categoria() {
}
//----------------------- Getters & Setters -------------------
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
		
	}
	public void setNome(String nome) {
		this.nome = nome;
		
	}
}
