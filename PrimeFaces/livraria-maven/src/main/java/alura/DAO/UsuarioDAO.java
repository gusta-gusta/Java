package alura.DAO;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import alura.Modelo.Usuario;

public class UsuarioDAO implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager em;
	
	public boolean existe(Usuario usuario) {
		
		
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :pEmail and u.senha = :pSenha  ", Usuario.class);
		
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());
			List <Usuario> resultados = query.getResultList();
			
			

			if (resultados != null && resultados.size() ==1) {
				return true;
				
			}
			else {
				return false;
			}
			
	
	}
	
}