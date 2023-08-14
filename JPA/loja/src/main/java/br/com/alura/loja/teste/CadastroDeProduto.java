package br.com.alura.loja.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroDeProduto {
	public static void main(String[] args) {
	
	Produto celular = new Produto();
	celular.setNome("Xiaomi Redmi");
	celular.setDescricao("128gb ram");
	celular.setPreco(new BigDecimal("1100"));
	
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja"); // nome do persistence-unit do persistence.xml
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	em.persist(celular); // persistir os dados.
	em.getTransaction().commit();
	em.close();
	
}
}