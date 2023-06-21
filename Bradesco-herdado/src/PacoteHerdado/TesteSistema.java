package PacoteHerdado;

public class TesteSistema {

	public static void main(String[] args) {
		
		Gerente gustavo = new Gerente();
		gustavo.setSenha(1234);
		
		Administrador administrador = new Administrador();
		administrador.setSenha(1919);
		
		Cliente cliente = new Cliente();
		cliente.setSenha(0000);
		
		SistemaInterno sistemaInterno = new SistemaInterno();
		sistemaInterno.autentica(gustavo);
		sistemaInterno.autentica(administrador);
		sistemaInterno.autentica(cliente);
	}
 
}
