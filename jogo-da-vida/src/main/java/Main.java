/* Nomes:
 * Alyson Matheus Maruyama Nascimento - 8532269
 * [ INSERIR NOME ]
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		Scanner scanner = new Scanner(System.in);
		System.out.println("1 - Próximo Estado\nQualquer outro valor - SAIR");
		int op = scanner.nextInt();
		
		while(op == 1) {
			board.nextState();
			op = scanner.nextInt();
		}
		
		System.out.println("Finalizado.");
	}
}