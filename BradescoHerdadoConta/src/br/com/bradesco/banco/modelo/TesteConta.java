 // Failed to get sources. Instead, stub sources have been generated by the disassembler.
 // Implementation of methods is unavailable.
package br.com.bradesco.banco.modelo;
public class TesteConta {
  
  public TesteConta() {
  }
  
  public static void main(java.lang.String[] args) {
	  
	  //Full Qualified Name -> FQN = Nome Pacote . Nome Simples da Classe
	  PacoteHerdadoConta.ContaCorrente outra = null;
	  outra.deposita(200.0);
	  
	  
	  System.out.println(outra.getSaldo());
	  
  }
} 