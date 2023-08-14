package br.com.alura.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//###
//podemos fazer tudo via anota��es. Ent�o, em cima da classe, podemos colocar uma anota��o da JPA que � o @Entity.
//Assim, � como se diss�ssemos: JPA, est� vendo essa classe Produto?
//Ela � uma entidade, ou seja, existe uma tabela no banco de dados que est� mapeando, e que � o espelho dessa classe.
//Ent�o, � para isso que serve essa anota��o @Entity. 

@Entity
@Table(name = "produtos") // Informa que apesar da classe ser Produto, no banco � produtos ent�o faz essa mesclagem 
public class Produto {
		
	  @Id // Diz quem � a chave primaria
	  @GeneratedValue(strategy = GenerationType.IDENTITY) // Diz como o valor da chave primaria � gerado.
	  private Long id;
	  private String nome;
	  //@Column(name = "desc") // Mesma situa��o do @Table, por�m para a coluna  
	  private String descricao;
	  private BigDecimal preco;
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
	
	
}
