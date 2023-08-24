package br.com.alura.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro extends Produto {
	
	private String autor;
	private Integer numeroDePaginas;
	
	//------------------------Construtor----------------------------------		
	public Livro() {
		
	}
	
	public Livro(String nome, String descricao, BigDecimal preco, Categoria categoria, String autor,
			Integer numeroDePaginas) {
		super(nome, descricao, preco, categoria);
		this.autor = autor;
		this.numeroDePaginas = numeroDePaginas;
	}
	
	//------------------------Getters & Setters --------------------------	

	public String getAutor() {
		return autor;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(Integer numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
}

