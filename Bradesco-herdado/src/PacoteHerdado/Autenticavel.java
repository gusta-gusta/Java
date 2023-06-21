package PacoteHerdado;

public abstract interface Autenticavel { // interface -> Um Contrato chamado autenticavel
										 // Quem Assina esse contrato precisa implementar : metodo setSenha e metodo Autentica

	public abstract void setSenha(int senha);

	public abstract  boolean autentica(int senha);
	
}