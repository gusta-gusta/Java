package br.com.bradesco.banco.test;

public class TesteString {

	public static void main(String[] args) {

		String nome = "Alura";
		
		
		//Uma String não pode ser alterada! Nasceu maiusculo toLowerCase não afeta
		nome.toLowerCase();
		
		// Porém, podemos criar uma outra variável para armazenar esta alteração mas nunca em uma já criada de certa forma.
		String outra = nome.toLowerCase();
		
		//Nesse caso criamos a 'outra' que recebe o conteudo de 'nome' com .toLowerCase() como parametro 
		System.out.println(outra);		
		System.out.println(nome);
		
		
		/* String usamos aspas duplas " "
		 * 
		 * Char usamos aspas simples ' '
		 */
		
		String vazio = "  Alura    ";
		String outroVazio = vazio.trim();
		
		System.out.println(vazio);
		System.out.println(outroVazio);
		
		
		for(int i = 0; i < nome.length(); i++) {
			System.out.println(nome.charAt(i));
		}
		
		
		String texto = "Socorram";
		texto = texto.concat("-");
		texto = texto.concat("me");
		texto = texto.concat(", ");
		texto = texto.concat("subi ");
		texto = texto.concat("no ");
		texto = texto.concat("ônibus ");
		texto = texto.concat("em ");
		texto = texto.concat("Marrocos");
		System.out.println(texto); 
		
	}

}
