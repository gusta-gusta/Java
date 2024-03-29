package br.com.alura.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "informatica")
public class Informatica extends Produto {

	private String marca;
	private Integer modelo;

	// ------------------------Construtor----------------------------------
	public Informatica() {

	}

	public Informatica(String nome, String descricao, BigDecimal preco, Categoria categoria, String marca,
			Integer modelo) {
		super(nome, descricao, preco, categoria);
		this.marca = marca;
		this.modelo = modelo;
	}

	// ------------------------Getters & Setters --------------------------

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

}
