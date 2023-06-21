package PacoteAnotacoes;

public class ContaCorrente extends Conta{

	
		@Override                         // Anota  o para o compilador
		void deposita(double valor) {
			this.saldo += valor -1;
		}
}
