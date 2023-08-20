package br.com.alura.loja.DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDAO {

	private EntityManager em;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto); // persistir os dados.
	}
	
	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}

	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}
	
//----------------------- busca pelo id
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id); // Busque na tabela Produto o ID e Retorne.
		
	}
	
//-----------------------  busca por JPQL, indicamos onde está a quey, qual a classe da entidade que essa query vai devolver e utilizamos getResultList() para ele de fato carregar essa query, convertê-la para um SQL e disparar carregando as entidades e montando os objetos (sem a necessidade de fazer isso manualmente) com ResultSet, conforme era no JDBC. 
	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList(); // Retorna uma Lista da tabela Produto e nos mostra com o getResultList()
	}

//---------------------------------------------------------------------------------------------	
	
	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)			
				.getResultList();
	}
	
//---------------------------------------------------------------------------------------------	
	
	public List<Produto> buscarCategoria(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)			
				.getResultList();
	}

//---------------------------------------------------------------------------------------------	
//filtrar um atributo devolvido ao invés da entidade inteira
//---------------------------------------------------------------------------------------------	
	public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("nome", nome)			
				.getSingleResult();
				
	}
	
//----------------------------------------------------------------------------------------------
//Buscar produto x de até y valor 
	public Produto buscarProdutoComPrecoAte(BigDecimal preco) {
	    String jpql = "SELECT p FROM Produto p WHERE p.preco <= :preco";
	    return this.em.createQuery(jpql, Produto.class)
	            .setParameter("preco", preco)
	            .getSingleResult();
	}
//----------------------------------------------------------------------------------------------
//Buscar todos os produtos de x valor 	
	public List<Produto> buscarProdutosComPrecoAte(BigDecimal preco) {
        String jpql = "SELECT p FROM Produto p WHERE p.preco <= :preco";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter("preco", preco)
                .getResultList();
    }
	
	
}
