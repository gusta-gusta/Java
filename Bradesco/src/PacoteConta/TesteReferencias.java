package PacoteConta;

public class TesteReferencias {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 300;
		
		
		Conta segundaConta = primeiraConta;
		
		System.out.println(segundaConta.saldo + " " + primeiraConta.saldo);
	}

}
