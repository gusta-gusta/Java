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
import br.com.alura.loja.vo.RelatorioDeVendasVo;

public class CadastroDePedido{

	public static void main(String[] args) {
		popularBancoDeDados();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		Produto produto = produtoDAO.buscarPorId(1l);
		Produto produto2 = produtoDAO.buscarPorId(2l);
		Produto produto3 = produtoDAO.buscarPorId(3l);
		Cliente cliente = clienteDAO.buscarPorId(1l);
		
		em.getTransaction().begin();
		
		
		Pedido pedido = new Pedido(cliente);
		pedido.AdicionarItem(new ItemPedido(2, pedido, produto));
		pedido.AdicionarItem(new ItemPedido(40, pedido, produto2));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido.AdicionarItem(new ItemPedido(7, pedido, produto3));
		
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		pedidoDAO.cadastrar(pedido);
		pedidoDAO.cadastrar(pedido2);
		
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("Valor Total: R$" + totalVendido);
	
		
		
		List<RelatorioDeVendasVo> relatorio = pedidoDAO.relatorioDeVendas();
		relatorio.forEach(System.out::println); // ForEach roda a List<> e o .out:: roda tudo dessa lista 
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
