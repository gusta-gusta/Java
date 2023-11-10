package alura.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import alura.Modelo.Usuario;
import alura.Util.JPAUtil;

public class UsuarioDAO {
	
	public boolean existe(Usuario usuario) {
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :pEmail and u.senha = :pSenha  ", Usuario.class);
		
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());
			List <Usuario> resultados = query.getResultList();
			
			

			if (resultados != null && resultados.size() ==1) {
				em.close();
				return true;
				
			}
			else {
				return false;
			}
			
	
	}
	
}