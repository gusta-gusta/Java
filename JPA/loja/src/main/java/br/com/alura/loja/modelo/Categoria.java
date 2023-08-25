package br.com.alura.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
		
	@EmbeddedId //Aqui dentro estão os atributos que formam a chave primaria
	private CategoriaId id;

	
//----------------------- Constructor -------------------------
	
	public Categoria(String nome) {
		this.id = new CategoriaId(nome, "GustaType");
	}

	public Categoria() {
}
//----------------------- Getters & Setters -------------------

	public String getNome() {
		return this.id.getNome();
		
	}
	
}
