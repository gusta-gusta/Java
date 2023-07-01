package br.com.bradesco.banco.especial;

import br.com.bradesco.banco.modelo.Conta;

public class ContaEspecial extends Conta {

	public ContaEspecial(int agencia, int numero) {
		super(agencia, numero);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deposita(double arg0) {
		super.saldo += 10;

	}

}
