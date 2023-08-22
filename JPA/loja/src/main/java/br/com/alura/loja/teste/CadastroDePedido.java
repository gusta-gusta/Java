package br.com.alura.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.DAO.CategoriaDAO;
import br.com.alura.loja.DAO.ClienteDAO;
import br.com.alura.loja.DAO.PedidoDAO;
import br.com.alura.loja.DAO.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDePedido{

	public static void main(String[] args) {
		popularBancoDeDados();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		Produto produto = produtoDAO.buscarPorId(1l);
		Cliente cliente = clienteDAO.buscarPorId(1l);
		
		em.getTransaction().begin();
		
		
		Pedido pedido = new Pedido(cliente);
		pedido.AdicionarItem(new ItemPedido(2, pedido, produto));
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		pedidoDAO.cadastrar(pedido);
		
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("Valor Total: R$" + totalVendido);
	
		
		
		List<Object[]> relatorio = pedidoDAO.relatorioDeVendas();
		
		
		for (Object[] obj : relatorio) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
	
		}
	}
	
	private static void popularBancoDeDados() {
		
		//------------ Categoria		
			Categoria celulares = new Categoria("CELULAR");				
		//------------ Produto	
			Produto celular = new Produto("Xiaomi Redmi 8 PRO", "128gb ram", new BigDecimal("2500"), celulares);
		//------------ Cliente
			Cliente cliente = new Cliente("Gustavo", "010.201.312-82");

			EntityManager em = JPAUtil.getEntityManager();
			ProdutoDAO produtoDAO = new ProdutoDAO(em);
			CategoriaDAO categoriaDAO = new CategoriaDAO(em);
			ClienteDAO clienteDAO = new ClienteDAO(em);
			
			em.getTransaction().begin();
			
			categoriaDAO.cadastrar(celulares);
			produtoDAO.cadastrar(celular);
			clienteDAO.cadastrar(cliente);
			em.getTransaction().commit();
			
			em.persist(celulares);
			em.close();
	}
	
}
