package PacoteHerdado;

public class ControleBonificacao {
	
	private double soma;
	
	// Functions 
	

	
	public void registra(Funcionario f) {
		
		double boni = f.getBonificacao();
		this.soma = this.soma + boni;
		
	}
	
	// getters e setters
	
	public double getSoma() {
		return soma;
	}

	public void setSoma(double soma) {
		this.soma = soma;
	}

}
