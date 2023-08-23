package br.com.alura.loja.DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

public class PedidoDAO {

	private EntityManager em;

	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido); // persistir os dados.
	}
	
	public void atualizar(Pedido pedido) {
		this.em.merge(pedido);
	}

	public void remover(Pedido pedido) {
		pedido = em.merge(pedido);
		this.em.remove(pedido);
	}
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class)
				.getSingleResult();
	}
	
	public List<RelatorioDeVendasVo> relatorioDeVendas() {
		String jpql = "SELECT new br.com.alura.loja.vo.RelatorioDeVendasVo("
					+ "produto.nome, "
					+ "SUM(item.quantidade) as quantidadeTotal, "
					+ "MAX(pedido.data)) "
					+ "FROM Pedido pedido "
					+ "JOIN pedido.itens item "
					+ "JOIN item.produto produto "
					+ "GROUP BY produto.nome "
					+ "ORDER BY quantidadeTotal ASC";
		return em.createQuery(jpql, RelatorioDeVendasVo.class)
				.getResultList();
	}
																							//O join fetch permite escolher quais relacionamentos serão carregados em determinada consulta, ao invés de sempre os carregar
	public Pedido buscarPedidoComCliente(Long id) { 			 //:id ---> é um parametro //JOIN FETCH o  cliente que setei como LAZY virá como EAGER pois será necessário nesse momento, e caso faça em.close() ele já foi carrega junto com a entidade 
		return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
		
	}
	
	
	
	
	
	
	
	
	
}