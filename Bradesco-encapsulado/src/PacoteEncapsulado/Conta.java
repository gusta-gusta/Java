package PacoteEncapsulado; //Importa todos arquivos do PacoteConta


public class Conta { //Classe
	private double saldo;   //Atributo
	private int agencia; 	//Atributo
	private int numero; 	//Atributo
	private Cliente titular; //Atributo
	private static int total; // É da Classe e não de cada conta criada. Estático -> Estruturado.

	

	



	public Conta(int agencia, int numero) {
				Conta.total++; // Não é this. Porque é static nesse caso da classe Conta.
				System.out.println("o total de contas é " + total);
			  this.agencia = agencia;
			  this.numero = numero;
	}
	
	


	void deposita(double valor) {
		this.saldo = this.saldo + valor;     // O this é uma referência, ou seja, "aponta" para um objeto.
		System.out.println("R$:" + valor + " Depositado com sucesso! ");
	}

	
	public boolean saca(double valor) {
		
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			System.out.println("R$:" + valor + " Sacado com sucesso!");

			return true;
		}else {
				
			System.out.println("Saldo Insuficiente");
			return false;
		}
	}
	
	public boolean transfere(double valor, Conta destino ) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			System.out.println("R$:" + valor + " Transferido com sucesso!");
			destino.deposita(valor);
			return true;
		}
			System.out.println("Saldo Insuficiente");
			return false;
		}

	
	//----------------- GETTERS & SETTERS ---------------------
	
	
	public double getSaldo() {
		return this.saldo;
	}
	
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("não pode valor menor igual a 0");
			return;
		}
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
				System.out.println("não pode valor menor igual a 0");
				return;
		}
		this.agencia = agencia;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public static int getTotal() {
		return total;
		}


	public static void setTotal(int total) { // Metodo da Classe
		Conta.total = total; 
		}
}
	



