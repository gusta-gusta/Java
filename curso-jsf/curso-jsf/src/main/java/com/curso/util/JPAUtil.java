package com.curso.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	// Códigos úteis 
	
	//Persistir os Dados =)
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("curso-jsf"); // nome do persistence-unit do persistence.xml
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}