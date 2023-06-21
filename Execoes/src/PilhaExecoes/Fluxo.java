package PilhaExecoes;

public class Fluxo {

    public static void main(String[] args) {
    	
        System.out.println("Ini do main");
        
        try {
            metodo1();
            } catch(Exception ex) {
            	
            	String mensagem = ex.getMessage();
            	ex.printStackTrace();
            	System.out.println("Exception " + mensagem);
            }
        System.out.println("Fim do main");
    }

    private static void metodo1() throws MinhaExcecao {
        System.out.println("Ini do metodo1");
        
       metodo2();
    
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() throws MinhaExcecao {
        System.out.println("Ini do metodo2");

        throw new MinhaExcecao("Deu Merda!");
        
       // System.out.println("Fim do metodo2");
    }
}

// TRY E CATCH EXPLICAÇÃO
    
//Para tratarmos uma exceção, que pode ocorrer enquanto nosso programa esta
//sendo executado, precisamos tratá-la antecipadamente com um bloco de
//código específico.
