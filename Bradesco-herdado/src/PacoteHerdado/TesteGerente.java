package PacoteHerdado;

public class TesteGerente {
	public static void main(String[] args) {
		Gerente gustavo = new Gerente();
				gustavo.setNome("Gustavo");
				gustavo.setCpf("413.951.923-01");
				gustavo.setSalario(5000.0);
				gustavo.setSenha(1234);
				System.out.println(gustavo.getSalario());
				System.out.println(gustavo.getCpf());
				System.out.println(gustavo.getNome());
				
				boolean autenticou = gustavo.autentica(1234);
				
				System.out.println(autenticou);

				System.out.println(gustavo.getBonificacao());
				
		
	}
	
}
