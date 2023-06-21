package PacoteConta; //Importa todos arquivos do PacoteConta


public class Conta { //Classe
	double saldo;   //Atributo
	int agencia; 	//Atributo
	int numero; 	//Atributo
	String titular; //Atributo


	void deposita(double valor) {
		this.saldo = this.saldo + valor;     // O this é uma referência, ou seja, "aponta" para um objeto.
		System.out.println("Sr(a) " + this.titular +  " R$:" + valor + " Depositado com sucesso! ");
		System.out.println("Saldo atual R$:" + this.saldo);
	}

	
	public boolean saca(double valor) {
		
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			System.out.println("R$:" + valor + " Sacado com sucesso!");
			System.out.println("Saldo atual R$:" + this.saldo);

			return true;
		}else {
				
			System.out.println("Saldo Insuficiente");
			System.out.println("Saldo atual R$:" + this.saldo);
			return false;
		}
	}
	
	public boolean transfere(double valor, Conta destino ) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			System.out.println("R$:" + valor + " Transferido com sucesso!");
			System.out.println("Saldo atual R$:" + this.saldo);
			destino.deposita(valor);
			return true;
		}
			System.out.println("Saldo Insuficiente");
			System.out.println("Saldo atual R$:" + this.saldo);
			return false;
		}
	}
	



