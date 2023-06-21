package PacoteHerdado;

public class Designer extends Funcionario {

	@Override
	public double getBonificacao() {
		System.out.println("Chamando o M�todo de Bonificacao do Designer");

	return 200;
	}

}
