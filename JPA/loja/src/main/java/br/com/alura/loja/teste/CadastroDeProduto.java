package br.com.alura.loja.teste;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.DAO.CategoriaDAO;
import br.com.alura.loja.DAO.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.CategoriaId;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
	
cadastrarProduto();
	
	Long id = 1L;
	EntityManager em = JPAUtil.getEntityManager();
	ProdutoDAO produtoDAO = new ProdutoDAO(em);

	Produto p = produtoDAO.buscarPorId(1l);
	System.out.println(p.getPreco());
	
//	List<Produto> todos = produtoDAO.buscarTodos();
//	todos.forEach(p2 -> System.out.println(p.getNome()));

	List<Produto> todos = produtoDAO.buscarCategoria("CELULAR");
	todos.forEach(p2 -> System.out.println(p.getNome()));
	
	BigDecimal precoDoProduto = produtoDAO.buscarPrecoDoProdutoComNome("Xiaomi Redmi 8 PRO");
	System.out.println("Preco do Produto: R$" + precoDoProduto);
	}

	private static void cadastrarProduto() {
		//------------ Categoria		
			Categoria celulares = new Categoria("CELULAR");
		
			
		//------------ Produto	
			Produto celular = new Produto("Xiaomi Redmi 8 PRO", "128gb ram", new BigDecimal("1100"), celulares);

			EntityManager em = JPAUtil.getEntityManager();
			ProdutoDAO produtoDAO = new ProdutoDAO(em);
			CategoriaDAO categoriaDAO = new CategoriaDAO(em);
			
			em.getTransaction().begin();
			
			categoriaDAO.cadastrar(celulares);
			produtoDAO.cadastrar(celular);
			em.getTransaction().commit();
			
			em.find(Categoria.class, new CategoriaId("CELULAR", "GustaType"));
			
			em.persist(celulares);
			em.close();
	}
}