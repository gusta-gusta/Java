package PacoteComposto;

import PacoteEncapsulado.Cliente;
import PacoteEncapsulado.Conta;

public class TesteSacaNegativo {
	
	public static void main(String[] args) {
		
		Conta contaGusta = new Conta();
		
		Cliente gusta = new Cliente();
		
		contaGusta.titular = gusta;
		contaGusta.titular.nome = "Gusta";
		contaGusta.deposita(100);

		System.out.println(contaGusta.saca(200));
		System.out.println(contaGusta.getSaldo());
		
		
	
	}

}
