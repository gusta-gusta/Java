package br.com.alura.loja.teste;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.alura.loja.DAO.CategoriaDAO;
import br.com.alura.loja.DAO.ClienteDAO;
import br.com.alura.loja.DAO.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class TesteCriteria{

	public static void main(String[] args) {
		popularBancoDeDados();
		

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		
		produtoDAO.buscarPorParametrosComCriteria("XBOX 360", new BigDecimal("400"), LocalDate.now());
		}
		
		private static void popularBancoDeDados() {
			//------------ Categoria		
			Categoria celulares = new Categoria("CELULAR");	
			Categoria videogames = new Categoria("VIDEOGAMES");
			Categoria informatica = new Categoria("INFORMATICA");	
		//------------ Produto	
			Produto celular = new Produto("Xiaomi Redmi 8 PRO", "128gb ram", new BigDecimal("2500"), celulares);
			Produto videogame = new Produto("XBOX 360", "500GB", new BigDecimal("400"), videogames); 
			Produto notebook = new Produto("Nitro 5", "8GB", new BigDecimal("4500"), informatica);
			
		//------------ Cliente
			Cliente cliente = new Cliente("Gustavo", "010.201.312-82");

			EntityManager em = JPAUtil.getEntityManager();
			ProdutoDAO produtoDAO = new ProdutoDAO(em);
			CategoriaDAO categoriaDAO = new CategoriaDAO(em);
			ClienteDAO clienteDAO = new ClienteDAO(em);
			
			em.getTransaction().begin();
			
			categoriaDAO.cadastrar(celulares);
			categoriaDAO.cadastrar(videogames);
			categoriaDAO.cadastrar(informatica);
			
			produtoDAO.cadastrar(celular);
			produtoDAO.cadastrar(videogame);
			produtoDAO.cadastrar(notebook);
			
			clienteDAO.cadastrar(cliente);
			
			
			em.getTransaction().commit();
			
			em.persist(celulares);
			em.close();
	}
	
}
