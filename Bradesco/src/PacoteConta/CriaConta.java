package PacoteConta;


public class CriaConta extends Conta {

	public static void main(String[] args) {
	

			Conta primeiraConta = new Conta();
			primeiraConta.saldo = 200;
			
		System.out.println(primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = 50;                // Obj.Atributo = x;
		//O objeto é criado e sua referência é atribuída à variável segundaConta, em seguida, atributo saldo está definido no lugar correto de forma que a atribuição seja feita com sucesso.
			
		System.out.println(segundaConta.saldo);
	}
	
	
}
