package PilhaExecoes;

public class TesteConexao {

	public static void main(String[] args) throws Exception {
		
		//Metodo Recente
		// try-with-resources
		//O recurso precisa implementar o método close().
		
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
////Nossa intenção é que a conexão feche a qualquer custo, dando erro ou não. Mas, o try-catch tem um lugar próprio para isso. Estamos falando do bloco finally, um bloco opcional que podemos colocar no final e que sempre será executado, com ou sem erro. Dessa forma, não será mais necessário repetir o código para fechar a conexão.
//	    } finally {
//	    	if (con != null) {
//	    		con.close();	
//			}
//		   
//	    }
//	  }
//	}

