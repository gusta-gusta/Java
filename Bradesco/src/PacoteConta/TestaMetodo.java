package PacoteConta;

public class TestaMetodo {

	public static void main(String[] args) {
		
		Conta contaGusta = new Conta();
			contaGusta.titular = "Gustavo Sales Rodrigues";
			contaGusta.deposita(50);
			

			
			contaGusta.saca(20);
			
			Conta contaLorenna = new Conta();
			
			contaGusta.transfere(10, contaLorenna);
		

			
			
			contaGusta.deposita(1000);
			contaLorenna.deposita(700);
			

	}
		
}
