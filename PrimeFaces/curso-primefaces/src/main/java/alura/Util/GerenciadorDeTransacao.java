package alura.Util;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transacional
@Interceptor
public class GerenciadorDeTransacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager em;

	@AroundInvoke //Invoca ao redor 
	public Object executaTransacao(InvocationContext contexto) throws Exception{

		// abre transacao
		em.getTransaction().begin();

		// chama os DAO's que precisam desse Gerenciamento
		Object resultado =  contexto.proceed();
		
		
		// commita a transacao
		em.getTransaction().commit();
		
		return resultado;
	}

}
