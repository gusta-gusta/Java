package br.com.alura.loja.teste;

import java.math.BigDecimal;

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

public class PerformanceConsultas {

    public static void main(String[] args) {
    	popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();
        Pedido pedido = em.find(Pedido.class, 1l);
        System.out.println(pedido.getItens().size());
        PedidoDAO pedidoDAO = new PedidoDAO(em);
        Pedido pedido4 = pedidoDAO.buscarPedidoComCliente(1l);
        em.close();
        System.out.println(pedido4.getCliente().getNome());

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
			
		//------------ Pedido
			Pedido pedido = new Pedido(cliente);
			pedido.AdicionarItem(new ItemPedido(2, pedido, celular));
			pedido.AdicionarItem(new ItemPedido(40, pedido, videogame));
			
			Pedido pedido2 = new Pedido(cliente);
			pedido.AdicionarItem(new ItemPedido(7, pedido, notebook));

			EntityManager em = JPAUtil.getEntityManager();
			ProdutoDAO produtoDAO = new ProdutoDAO(em);
			CategoriaDAO categoriaDAO = new CategoriaDAO(em);
			ClienteDAO clienteDAO = new ClienteDAO(em);
			PedidoDAO pedidoDAO = new PedidoDAO(em);
			
			em.getTransaction().begin();
			
			categoriaDAO.cadastrar(celulares);
			categoriaDAO.cadastrar(videogames);
			categoriaDAO.cadastrar(informatica);
			
			produtoDAO.cadastrar(celular);
			produtoDAO.cadastrar(videogame);
			produtoDAO.cadastrar(notebook);
			
			clienteDAO.cadastrar(cliente);
			
			pedidoDAO.cadastrar(pedido);
			pedidoDAO.cadastrar(pedido2);
			
			
			
			em.getTransaction().commit();
			
			em.persist(celulares);
			em.close();
	}
	
}
