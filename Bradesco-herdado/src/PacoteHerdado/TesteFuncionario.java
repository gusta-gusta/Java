package PacoteHerdado;

public class TesteFuncionario {
	public static void main(String[] args) {
		
		Funcionario Gustavo = new Gerente();
		
		Gustavo.setSalario(5100);
		
		System.out.println(Gustavo.getNome());
		System.out.println(Gustavo.getBonificacao());
	}
}
