package br.com.bradesco.banco.test;

import br.com.bradesco.banco.modelo.Conta;
import br.com.bradesco.banco.modelo.ContaCorrente;
import br.com.bradesco.banco.modelo.ContaPoupanca;

public class Teste {

    public static void main(String[] args) {

    	
    	Object cc = new ContaCorrente(100, 102);
    	Object cp = new ContaPoupanca(95, 82);
    	
    	System.out.println(cc);
    	System.out.println(cp);
    	
    }
   	
    	static void println(Object conta) {
   	}
}

