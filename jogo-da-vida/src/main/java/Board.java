
public class Board {
	private int size = 6;
	private int[][] board = new int[size][size];

	// The constructor generates a new board with random cell values
	public Board() {
		 for(int i = 0; i < this.size; i ++) {
			 for(int j = 0; j < this.size; j ++) {
				 this.board[i][j] = Math.random() < 0.5 ? 0 : 1;
			 }
		 }
	}
	
	public void nextState() {
		int[][] aux = new int[this.size][this.size];
		
		System.out.println("Antigo Tabuleiro:");
		this.printBoard();
		for(int i = 0; i < this.size; i ++) {
			 for(int j = 0; j < this.size; j ++) {
				 aux[i][j] = this.processCell(i, j);
			 }
		 }
		
		this.board = aux;
		System.out.println("Novo Tabuleiro:");
		this.printBoard();
	}
	
	public void setBoard(int board[][]) {
		this.board = board;
	}
	
	public int[][] getBoard() {
		return this.board;
	}
	
	// Prints the current state of the board
	private void printBoard() {
		for(int i = 0; i < this.size; i ++) {
			 for(int j = 0; j < this.size; j ++) {
				 System.out.print(this.board[i][j] + " ");
			 }
			 System.out.println();
		 }
		System.out.println();
	}
	
	private int countNeighbours(int x, int y) {
		int count = 0;

		for(int i = Math.max(0, x - 1); i <= Math.min(this.size - 1, x + 1); i++) {
			for(int j = Math.max(0, y - 1); j <= Math.min(this.size - 1, y + 1); j++) {
				// Skip if it is the own cell
				if(i != x || j != y) {
					if(this.board[i][j] == 1) count++;
				}
				
			}
		}
		return count;
	}
	
	// Receives the cell coordinates and returns the new cell value
	private int processCell(int x, int y) {
		int currentValue = this.board[x][y];
		int numberOfNeighbours = this.countNeighbours(x, y);
		if(numberOfNeighbours == 2) return currentValue;
		
		if(currentValue == 1) { // Alive Cells
			if(numberOfNeighbours < 2 || numberOfNeighbours > 3) {
				return 0;
			}
		} else { // Dead Cells
			if(numberOfNeighbours == 3) return 1;
		}

		return currentValue;
	}
}
