package PacoteHerdado;


public class Cliente implements Autenticavel { // implemens é quem assina o contrato do interface 


	private AutenticacaoModelo autenticacaoModelo;
	
	public Cliente() { 
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
	}
 