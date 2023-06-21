package PacoteAnotacoes;



public abstract class Conta { //Classe

@DoublePositivo	
	protected double saldo;   	//Atributo
	private String titular; 	//Atributo
	private String agencia; 	//Atributo
	private String numero; 		//Atributo



	void deposita(double valor) {
		this.saldo = this.saldo + valor;
	}
}
	






