package br.com.alura.bradesco;

import br.com.bradesco.banco.modelo.ContaCorrente;
import br.com.bradesco.banco.modelo.Conta;

public class TesteBiblioteca {
	
	public static void main(String[] args) {
		
		Conta c = new ContaCorrente(123, 321);
		
		c.deposita(200.3);
		
		System.out.println(c.getSaldo());
	}

}
