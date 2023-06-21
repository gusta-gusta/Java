package PilhaExecoes;

public class FluxoComTratamento {

    public static void main(String[] args) {
    	
        System.out.println("Ini do main");
        metodo1();
        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Ini do metodo1");
        try {
        metodo2();
        } catch(ArithmeticException | NullPointerException ex) {
        	
        	String mensagem = ex.getMessage();
        //	ex.printStackTrace();
        	System.out.println("Exception " + mensagem);
        }
    
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
        System.out.println("Ini do metodo2");
        for(int i = 1; i <= 5; i++) {
            System.out.println(i);

            	int a = i/ 0;
            //Conta c = null;
            //c.deposita(); 

            	System.out.println("Fim do metodo2");
    }
}

//Explicação 

// Ini do main
//metodo1() --> Ini do metodo1
//metodo1() --> metodo2() --> Ini do metodo2
//metodo1() --> metodo2() --> 1 até 5
//metodo1() --> metodo2() --> Fim do metodo2
//metodo1() --> Fim do metodo1
// Fim do main"
    

// TRY E CATCH EXPLICAÇÃO
    
//Para tratarmos uma exceção, que pode ocorrer enquanto nosso programa esta
//sendo executado, precisamos tratá-la antecipadamente com um bloco de
//código específico.






}