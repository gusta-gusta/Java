
public class TestandoCondicionais {

	public static void main(String[] args) {
		System.out.println("Testando condicionais");
		int idade = 10;
		int quantidadePessoas = 2;
		boolean acompanhado = quantidadePessoas < 1;
		
		System.out.println(acompanhado);
		
		
		
		
		
		
		
		if (idade >= 18 || acompanhado) {
			System.out.println("você tem mais de 18 anos ou Está Acompanhado");
			System.out.println("Seja Bem vindo");
		}
		else
		{	
			System.out.println("Infelizmente você não pode entrar");
		}
	}
}
