package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//###
//podemos fazer tudo via anotações. Então, em cima da classe, podemos colocar uma anotação da JPA que é o @Entity.
//Assim, é como se disséssemos: JPA, está vendo essa classe Produto?
//Ela é uma entidade, ou seja, existe uma tabela no banco de dados que está mapeando, e que é o espelho dessa classe.
//Então, é para isso que serve essa anotação @Entity. 

@Entity
@Table(name = "produtos") // Informa que apesar da classe ser Produto, no banco é produtos então faz essa mesclagem
@NamedQuery(name = "Produto.produtosPorCategoria", 
query = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome")
public class Produto {
		
	  @Id // Diz quem é a chave primaria
	  @GeneratedValue(strategy = GenerationType.IDENTITY) // Diz como o valor da chave primaria é gerado.
	  private Long id;
	  private String nome;
	  //@Column(name = "desc") // Mesma situação do @Table, porém para a coluna  
	  private String descricao;
	  private BigDecimal preco;
	  private LocalDate dataCadastro = LocalDate.now();
	  
	  @ManyToOne
	  private Categoria categoria; //Foreign key : MANY Produtos TO ONE Categoria
	  
//----------------------- Constructor -------------------
	  
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
			super();
			this.nome = nome;
			this.descricao = descricao;
			this.preco = preco;
			this.categoria = categoria;
		}
	  
		public Produto() {
		}

//----------------------- Getters & Setters -------------------

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
		
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
		
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
