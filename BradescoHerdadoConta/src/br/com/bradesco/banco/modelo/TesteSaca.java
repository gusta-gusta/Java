package br.com.bradesco.banco.modelo;

import PacoteHerdadoConta.SaldoInsuficienteException;

public class TesteSaca {

	public static void main(String[] args) {
		
		
		PacoteHerdadoConta.Conta conta = new PacoteHerdadoConta.ContaCorrente(123, 321);
		
		conta.deposita(200.0);
		
		try {
			conta.saca(210.0);
		} catch(SaldoInsuficienteException  ex) {
			System.out.println("Erro Saldo Insuficiente: " + ex.getMessage()); 	 
		}
		System.out.println(conta.getSaldo());
		
	}
	
}
