package alura.Util;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("curso-primefaces");

	@Produces // produz o entity
	@RequestScoped // Vai produzir a cada requisição
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	//@Disposes diz como fechar a requisição
	public void close(@Disposes EntityManager em) {
		em.close();
	}
}
