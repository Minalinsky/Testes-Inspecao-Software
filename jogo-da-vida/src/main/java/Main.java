/* Nomes:
 * Alyson Matheus Maruyama Nascimento - 8532269
 * Felipe Tiago De Carli - 10525686
 * [ INSERIR NOME ]
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Board board = new Board();
		System.out.println(board.getBoard().length);
		Scanner scanner = new Scanner(System.in);

		System.out.println("1 - Proximo Estado\nQualquer outro valor - SAIR");
		int op = scanner.nextInt();
		
		while(op == 1) {
			board.nextState();
			op = scanner.nextInt();
		}
		
		System.out.println("Finalizado.");
	}
}