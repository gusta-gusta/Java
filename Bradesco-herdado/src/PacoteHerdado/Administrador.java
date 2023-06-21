package PacoteHerdado;

public class Administrador extends Funcionario implements Autenticavel{ // Assinando Autenticavel com o implements e extendendo a classe funcionario

	private AutenticacaoModelo autenticacaoModelo;
	
	public Administrador() { 
		this.autenticacaoModelo = new AutenticacaoModelo();
	}
	
	@Override
	public void setSenha(int senha) {
		this.autenticacaoModelo.setSenha(senha);		
	}

	
	@Override
	public boolean autentica(int senha) {
			return this.autenticacaoModelo.autentica(senha);
			}
	
 

	@Override
	public double getBonificacao() {
		System.out.println("Bonificacao Gerente");
		return  super.getSalario();
	}
}
 