package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data = LocalDate.now();
	@Column(name = "valor_total")
	private BigDecimal valorTotal;

	@ManyToOne
	private Cliente cliente;
	// Cacade = Tudo que acontecer com pedido acontece com ItemPedido, efeito
	// cascata.
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) // olha, JPA, esse relacionamento, ele já está mapeado lá
																// do outro lado. Que outro lado? Na classe ItemPedido,
																// pelo atributo chamado pedido. (Para indicar que se
																// trata de um relacionamento bidirecional)
	private List<ItemPedido> itens = new ArrayList<ItemPedido>(); 
	
	// para inicializar essa lista como uma lista vazia,porque
	// senão teremos que sempre ficar fazendo aquele if, if lista
	// foi instanciada? Se a lista é nula, dá new na lista; if a
	// lista é nula, dá new na lista. Então teríamos que fazer isso
	// o tempo inteiro. Para evitar essa checagem, já inicializamos
	// aqui a coleção.

	// ----------------------- Constructor -------------------

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido() {

	}

	// -------------------------- Method ----------------------

	public void AdicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
	}

	// ----------------------Getters e Setters-----------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;

	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;

	}

}
