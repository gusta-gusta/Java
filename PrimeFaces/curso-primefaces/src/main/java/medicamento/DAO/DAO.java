package medicamento.DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import medicamento.Modelo.Base;

public class DAO<T extends Base> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static EntityManager manager = ConnectionFactory.getEntityManager();
	
	public T buscarPorId(Class<T> clazz, Long id) {
		return manager.find(clazz, id);
		
	}
	
	public void salvar(T t) {
		try {
			manager.getTransaction().begin(); // Inicia 
			
			if (t.getId() == null) {
				manager.persist(t); 		  //Persiste
			} else {
				manager.merge(t);			  //merge
			}
			
			
			manager.getTransaction().commit();// Commita
		} catch (Exception e) {
			manager.getTransaction().rollback();// Retorna
		}
	}

	
	public void remover(Class<T>clazz, Long id) {
	
		T t = buscarPorId(clazz, id);
		
		try {
			manager.getTransaction().begin(); // Inicia 
			manager.remove(t); 				  // Remover
			manager.getTransaction().commit();// Commita
		} catch (Exception e) {
			manager.getTransaction().rollback();// Retorna
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(String jpql) {
		Query query = manager.createQuery(jpql);
		return query.getResultList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	















}
