package alura.Service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import alura.DAO.DAO;
import alura.Modelo.Autor;
import alura.Util.NegocioException;

public class AutorServices implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	@Inject
	private DAO<Autor> dao;
	
	public void salvar(Autor a) throws NegocioException {
		
		if (a.getNome().length() < 3) {
			throw new NegocioException("O nome não pode ter menos que 3 caracteres");
		}
				
		
		dao.salvar(a);
	}

	public void remove(Autor a) throws NegocioException {
		dao.remover(Autor.class, a.getId());
	}
	
	public List<Autor> todosOsAutores()  	{
		return dao.buscarTodos("select a from Autor a order by a.nome");
	}
	

}
