package PacoteEncapsulado;

public class TestaGetESet {
		public static void main(String[] args) {
			
			Conta conta = new Conta(122, 1311);

			System.out.println(conta.getNumero()) ;
		
		
		Cliente gu = new Cliente("Gustavo Sales Rodrigues","413.958.908-62","Programador");
				
	conta.setTitular(gu);
				
	
	System.out.println(conta.getTitular().getNome());
	

	Conta conta2 = new Conta(100, 2525);
	
System.out.println(Conta.getTotal());
	
		}	


}
