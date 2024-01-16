package alura.DAO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import alura.Modelo.Livro;

public class LivroDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager em;
	
	private DAO<Livro> livroDAO;
	
	@PostConstruct
	void init() {
		this.livroDAO = new DAO<Livro>(this.em, Livro.class);
	}

	public void adiciona(Livro t) {
		livroDAO.adiciona(t);
	}

	public void remove(Livro t) {
		livroDAO.remove(t);
	}

	public void atualiza(Livro t) {
		livroDAO.atualiza(t);
	}

	public List<Livro> listaTodos() {
		return livroDAO.listaTodos();
	}

	public Livro buscaPorId(Integer id) {
		return livroDAO.buscaPorId(id);
	}
	


}
