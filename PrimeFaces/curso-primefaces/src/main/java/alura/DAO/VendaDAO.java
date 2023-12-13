package alura.DAO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import alura.Modelo.Venda;

public class VendaDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager em;
	
	private DAO<Venda> vendaDAO;
	
	@PostConstruct
	void init() {
		this.vendaDAO = new DAO<Venda>(this.em, Venda.class);
	}

	public void adiciona(Venda t) {
		vendaDAO.adiciona(t);
	}

	public void remove(Venda t) {
		vendaDAO.remove(t);
	}

	public void atualiza(Venda t) {
		vendaDAO.atualiza(t);
	}

	public List<Venda> listaTodos() {
		return vendaDAO.listaTodos();
	}

	public Venda buscaPorId(Integer id) {
		return vendaDAO.buscaPorId(id);
	}
	


}
