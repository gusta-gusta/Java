package PacoteHerdado;

public class SistemaInterno {
	
	private int senha = 1234;
	
		public void autentica(Autenticavel Gustavo) {
			boolean autenticou = Gustavo.autentica(senha);
			if(autenticou) {
				System.out.println("Bem vindo.");
			}
			else
			{
				System.out.println("Senha Invalida");
			}
		}

}
