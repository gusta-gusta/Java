
public class TestaLacos2 {

	public static void main(String[] args) {
		for(int linha=0;linha < 10;linha++) {
			for(int coluna=0;coluna < 10;coluna++) {
				if(coluna > linha) {
					break;
					}	//break vai pular a primeira linha ap�s a "}" quando der false  ------- |o break ir� interromper apenas o la�o de repeti��o mais interno que o cont�m.|
					System.out.print("*" + coluna);
				}
					System.out.println();
			}
		}
	}
