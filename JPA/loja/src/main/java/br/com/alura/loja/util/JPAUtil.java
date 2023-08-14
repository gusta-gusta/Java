package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	// C�digos �teis 
	
	//Persistir os Dados =)
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja"); // nome do persistence-unit do persistence.xml
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
