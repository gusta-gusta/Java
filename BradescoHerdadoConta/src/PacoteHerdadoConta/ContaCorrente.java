 // Failed to get sources. Instead, stub sources have been generated by the disassembler.
 // Implementation of methods is unavailable.
package PacoteHerdadoConta;


//new ContaCorrente()
public class ContaCorrente extends Conta implements Tributavel {

	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}
	
	@Override
	public void saca(double valor) throws SaldoInsuficienteException {
		double valorASacar = valor + 0.2;
		super.saca(valorASacar);
	}

	@Override
	public void deposita(double valor) {
      super.saldo += valor;
  }

	@Override
	public double getValorImposto() {	
		return super.saldo * 0.01;
	}
	
}
