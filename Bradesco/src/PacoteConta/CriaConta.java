package PacoteConta;


public class CriaConta extends Conta {

	public static void main(String[] args) {
	

			Conta primeiraConta = new Conta();
			primeiraConta.saldo = 200;
			
		System.out.println(primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = 50;                // Obj.Atributo = x;
		//O objeto � criado e sua refer�ncia � atribu�da � vari�vel segundaConta, em seguida, atributo saldo est� definido no lugar correto de forma que a atribui��o seja feita com sucesso.
			
		System.out.println(segundaConta.saldo);
	}
	
	
}
