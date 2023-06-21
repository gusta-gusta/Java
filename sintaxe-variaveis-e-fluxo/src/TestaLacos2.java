
public class TestaLacos2 {

	public static void main(String[] args) {
		for(int linha=0;linha < 10;linha++) {
			for(int coluna=0;coluna < 10;coluna++) {
				if(coluna > linha) {
					break;
					}	//break vai pular a primeira linha após a "}" quando der false  ------- |o break irá interromper apenas o laço de repetição mais interno que o contém.|
					System.out.print("*" + coluna);
				}
					System.out.println();
			}
		}
	}
