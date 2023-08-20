package br.com.alura.loja.DAO;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;

public class CategoriaDAO {

	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria); // persistir os dados.
	}
	
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria); // Tira do Detached e Coloca no estado managed. obs: /Ciclo.png
	}
	
	public void remover(Categoria categoria) {
		categoria = em.merge(categoria);//  Para garantir que está no estado managed. obs: /Ciclo.png
		this.em.remove(categoria); // Remove, porém precisa estar no estado managed. obs:  /Ciclo.png
	}	
	
	
	
}
