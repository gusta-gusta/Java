package PacoteHerdado;

public abstract class Funcionario {  // Abstrato pois não existe um funcionario com cargo de funcionario é um conceito apenas 
	
	private  String nome;
	private  String cpf;
	private double salario; 
	// PROTECT - � basicamente public para classes filhas e privado para o resto
	
		// Os filhos vao implementar esse methodo
		public abstract double getBonificacao();	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

}
