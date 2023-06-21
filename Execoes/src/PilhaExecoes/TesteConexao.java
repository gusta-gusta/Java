package PilhaExecoes;

public class TesteConexao {

	public static void main(String[] args) throws Exception {
		
		//Metodo Recente
		// try-with-resources
		//O recurso precisa implementar o m�todo close().
		
		try (Conexao conexao = new Conexao() ) {
			conexao.leDados();
		} catch (IllegalStateException ex) {
			System.out.println("Deu Erro na conexao!!!");
		}
	}
}
		
		
		
		// ---------------------------
		//Metodo Antigo
//		
//	    Conexao con = null;
//	    try {
//	        con = new Conexao();
//	        con.leDados();
//	    } catch(IllegalStateException ex) {
//	        System.out.println("Deu erro na conexao");
////Nossa inten��o � que a conex�o feche a qualquer custo, dando erro ou n�o. Mas, o try-catch tem um lugar pr�prio para isso. Estamos falando do bloco finally, um bloco opcional que podemos colocar no final e que sempre ser� executado, com ou sem erro. Dessa forma, n�o ser� mais necess�rio repetir o c�digo para fechar a conex�o.
//	    } finally {
//	    	if (con != null) {
//	    		con.close();	
//			}
//		   
//	    }
//	  }
//	}

