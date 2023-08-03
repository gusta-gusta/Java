package br.com.bradesco.banco.test;

import br.com.bradesco.banco.modelo.SaldoInsuficienteException;
import br.com.bradesco.banco.modelo.Conta;
import br.com.bradesco.banco.modelo.ContaCorrente;

public class TesteSaca {

	public static void main(String[] args) {
		
		
		Conta conta = new ContaCorrente(123, 321);
		
		conta.deposita(200.0);
		try {
		conta.saca(199.81);
		} catch(SaldoInsuficienteException  ex) {
			System.out.println("Erro Saldo Insuficiente: " + ex.getMessage()); 	 
		}
		System.out.println(conta.getSaldo());
		
	}
	
}
