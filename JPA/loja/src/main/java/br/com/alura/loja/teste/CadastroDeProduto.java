package br.com.alura.loja.teste;
import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.DAO.CategoriaDAO;
import br.com.alura.loja.DAO.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
	
		Categoria celulares = new Categoria("CELULARES");
		
	Produto celular = new Produto("Xiaomi Redmi", "128gb ram", new BigDecimal("1100"), celulares);
	
	EntityManager em = JPAUtil.getEntityManager();
	ProdutoDAO produtoDAO = new ProdutoDAO(em);
	CategoriaDAO categoriaDAO = new CategoriaDAO(em);


	em.getTransaction().begin();
	categoriaDAO.cadastrar(celulares);
	produtoDAO.cadastrar(celular); // persistir os dados.
	em.getTransaction().commit();
	em.close();
	
		}
}