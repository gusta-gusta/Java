package PacoteEnum;

public enum Prioridade {

	MIN(10),NORMAL(50),MAX(100);
	
	private int valor;
	
	Prioridade(int valor) {
		this.valor = valor;
		
	}
	
	public int getValor() {
		return this.valor;
	}
	
}
