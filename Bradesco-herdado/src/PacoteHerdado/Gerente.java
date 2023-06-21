package PacoteHerdado;

public class Gerente extends Funcionario implements Autenticavel {


	private AutenticacaoModelo autenticacaoModelo;
	
	public Gerente() { 
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