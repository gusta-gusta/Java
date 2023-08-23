package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private BigDecimal valorTotal = BigDecimal.ZERO;
										//fetch podemos alterar EAGER/LAZY 
	@ManyToOne(fetch = FetchType.LAZY) //@ManyToOne carregamento padr�o: EAGER, que carrega junto com a entidade, por mais que voc� n�o utilize aquele relacionamento
	private Cliente cliente;
	// Cacade = Tudo que acontecer com pedido acontece com ItemPedido, efeito cascata.
		@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) // olha, JPA, esse relacionamento, ele j� est� mapeado l�
																// do outro lado. Que outro lado? Na classe ItemPedido,
																// pelo atributo chamado pedido. (Para indicar que se
																// trata de um relacionamento bidirecional)	
	private List<ItemPedido> itens = new ArrayList<>(); // para inicializar essa lista como uma lista vazia, porque
														// sen�o teremos que sempre ficar fazendo aquele if, if lista
														// foi instanciada? Se a lista � nula, d� new na lista; if a
														// lista � nula, d� new na lista. Ent�o ter�amos que fazer isso
														// o tempo inteiro. Para evitar essa checagem, j� inicializamos
														// aqui a cole��o.
		
		//OneToMany carregamento padrao: LAZY, que s� carrega se for feito o acesso.

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
		this.valorTotal = this.valorTotal.add(item.getValor());
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

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}



}
