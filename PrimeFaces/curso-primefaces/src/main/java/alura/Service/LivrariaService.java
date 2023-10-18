package alura.Service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import alura.DAO.DAO;
import alura.Modelo.Livraria;
import alura.Util.NegocioException;

public class LivrariaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	@Inject
	private DAO<Livraria> dao;
	
	public void salvar(Livraria l) throws NegocioException {
		
		if (l.getTitulo().length() < 3) {
			throw new NegocioException("O titulo não pode ter menos que 3 caracteres");
		}
				
		
		dao.salvar(l);
	}

	public void remove(Livraria l) throws NegocioException {
		dao.remover(Livraria.class, l.getId());
	}
	
	public List<Livraria> todosOsLivros ()  	{
		return dao.buscarTodos("select l from Livraria l order by l.titulo");
	}
}
