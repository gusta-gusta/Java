package PacoteComposto;

import PacoteEncapsulado.Cliente;
import PacoteEncapsulado.Conta;

public class TestaBanco {
		
	public static void main(String[] args) {
		Cliente gustavo = new Cliente();
		gustavo.nome = "Gustavo Sales Rodrigues";
		gustavo.cpf = "413958908-62";
		gustavo.Profissao = "Programador Full Stack";

		
		
		Conta contaDoGustavo = new Conta();
		
		//Associando Cliente gustavo para Conta contadoDoGustavo
			contaDoGustavo.titular = gustavo;
			
			
		contaDoGustavo.deposita(100);
		
		System.out.println(contaDoGustavo.titular.nome);
		
		
		Conta contaDaLorenna = new Conta();
		
		
		
		contaDaLorenna.titular = new Cliente();
			System.out.println(contaDaLorenna.titular.nome);
			
		contaDaLorenna.titular.nome = "Lorenna dos Santos Rodrigues Alves";
		System.out.println(contaDaLorenna.titular.nome);
	}

}
