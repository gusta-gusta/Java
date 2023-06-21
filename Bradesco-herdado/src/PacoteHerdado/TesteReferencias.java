package PacoteHerdado;

public class TesteReferencias {
	public static void main(String[] args) {
		
		Gerente g1 = new Gerente(); // Pra que serve  ???
			
		g1.setNome("Gustavao");
		g1.setSalario(5000.0);
		
		Funcionario f = new EditorVideo();
		f.setSalario(2500.0);
		
		Funcionario ev = new Designer();
		ev.setSalario(2500.0);
		 
		ControleBonificacao controle = new ControleBonificacao();
		
		controle.registra(g1);
		controle.registra(f);
		controle.registra(ev);
		
		System.out.println(controle. getSoma());
		
		
		
		
		
	}
}
