package br.com.alura.loja.DAO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
		return em.createQuery(jpql, Produto.class).getResultList(); // Retorna uma Lista da tabela Produto e nos mostra
																	// com o getResultList()
	}

//---------------------------------------------------------------------------------------------	

	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
	}

//---------------------------------------------------------------------------------------------	

	public List<Produto> buscarCategoria(String nome) {
		return em.createNamedQuery("Produto.produtosPorCategoria", Produto.class).setParameter("nome", nome)
				.getResultList();
	}

//---------------------------------------------------------------------------------------------	
//filtrar um atributo devolvido ao invés da entidade inteira
//---------------------------------------------------------------------------------------------	
	public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class).setParameter("nome", nome).getSingleResult();

	}

//----------------------------------------------------------------------------------------------
//Buscar produto x de até y valor 
	public Produto buscarProdutoComPrecoAte(BigDecimal preco) {
		String jpql = "SELECT p FROM Produto p WHERE p.preco <= :preco";
		return this.em.createQuery(jpql, Produto.class).setParameter("preco", preco).getSingleResult();
	}

//----------------------------------------------------------------------------------------------
//Buscar todos os produtos de x valor 	
	public List<Produto> buscarProdutosComPrecoAte(BigDecimal preco) {
		String jpql = "SELECT p FROM Produto p WHERE p.preco <= :preco";
		return this.em.createQuery(jpql, Produto.class).setParameter("preco", preco).getResultList();
	}

	// --------------------------------- Filtro com JPQL
	public List<Produto> buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro) {
		String jpql = "SELECT p FROM Produto p WHERE 1=1 ";
		if (nome != null && !nome.trim().isEmpty()) {
			jpql = " AND p.nome = :nome ";
		}
		if (preco != null) {
			jpql = " AND p.preco = :preco ";
		}
		if (dataCadastro != null) {
			jpql = " AND p.dataCadastro = :dataCadastro ";
		}
		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
		if (nome != null && !nome.trim().isEmpty()) {
			query.setParameter("nome", nome);
		}
		if (preco != null) {
			query.setParameter("preco", preco);
		}
		if (dataCadastro != null) {
			query.setParameter("dataCadastro", dataCadastro);
		}

		return query.getResultList();

	}

	// --------------------------------- Filtro com Criteria Builder
	public List<Produto> buscarPorParametrosComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class);
		Predicate filtros = builder.and();
		if (nome != null && !nome.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
		}
		if (preco != null) {
			filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
		}
		if (dataCadastro != null) {
			filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
		}
		query.where(filtros);
		return em.createQuery(query).getResultList();
	}

}