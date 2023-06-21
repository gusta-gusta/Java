package PacoteEnum;

public class ExemploEnum {
	
		public static void main(String[] args) {
			
				Prioridade pMin = Prioridade.MIN;
				Prioridade pNormal = Prioridade.NORMAL;
				Prioridade pMax = Prioridade.MAX;
				
				
				System.out.println(pMin.name());
				System.out.println(pNormal.name());
				System.out.println(pMax.name());
				
				System.out.println(pMin.ordinal());
				System.out.println(pNormal.ordinal());
				System.out.println(pMax.ordinal());
				
				System.out.println(pMin.getValor());
				System.out.println(pNormal.getValor());
				System.out.println(pMax.getValor());
		
				
				
		}

}
