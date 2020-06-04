import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Test;

public class BoardTestCase {
	private int boardSize = 6;
	
	private int[][][] boardSetup0 = new int[][][] {
		{ //input
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 1, 0 },
			{ 1, 1, 0, 0, 0, 0 },
			{ 1, 1, 0, 0, 0, 1 }
		},
		{ //expected
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 1, 1, 1 },
			{ 1, 1, 0, 0, 1, 1 }, 
			{ 0, 0, 0, 0, 0, 0 }, 
			{ 1, 1, 0, 0, 0, 0 }
		}
	};
	
	private int[][][] boardSetup1 = new int[][][] {
		{
			{ 0, 0, 0, 1, 0, 1 },
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0 },
			{ 1, 1, 0, 0, 0, 0 },
			{ 1, 1, 0, 0, 0, 0 }
		},
		{
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 0, 0, 0, 0 }
		}
	};
	
	private int[][][] boardSetup2 = new int[][][] {
		{ // input
			{ 1 ,0 ,0 ,0 ,0 ,1 },
			{ 0 ,1 ,0 ,1 ,0 ,0 },
			{ 0 ,0 ,0 ,0 ,1 ,0 },
			{ 0 ,1 ,1 ,1 ,1 ,0 },
			{ 1 ,1 ,1 ,0 ,1 ,0 },
			{ 0 ,0 ,0 ,0 ,1 ,1 }
		},
		{ // expected
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 0 },
			{ 0, 1, 0, 0, 1, 0 },
			{ 1, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 1, 1, 1 }
		},
		{ // expected in next iteration
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 1, 0 },
			{ 1, 1, 0, 0, 1, 1 },
			{ 1, 1, 0, 1, 0, 0 },
			{ 0, 0, 0, 0, 1, 0 }
		}
	};

	
	@Test
	public void boardSetup0Test() {
		Board board = new Board();
		board.setBoard(boardSetup0[0]);
		board.nextState();
		// Since there is no method for testing 2d arrays, we need to assert each row
		for (int i = 0; i < this.boardSize; i++) {
			assertArrayEquals(boardSetup0[1][i], board.getBoard()[i]);
		}
	}

	@Test
	public void boardSetup1Test() {
		Board board = new Board();
		board.setBoard(boardSetup1[0]);
		board.nextState();
		// Since there is no method for testing 2d arrays, we need to assert each row
		for (int i = 0; i < this.boardSize; i++) {
			assertArrayEquals(boardSetup1[1][i], board.getBoard()[i]);
		}
	}
	
	@Test
	public void boardSetup2Test() {
		Board board = new Board();
		board.setBoard(boardSetup2[0]);
		board.nextState();
		// Since there is no method for testing 2d arrays, we need to assert each row
		for (int i = 0; i < this.boardSize; i++) {
			assertArrayEquals(boardSetup2[1][i], board.getBoard()[i]);
		}

		// running nextIteration
		board.nextState();
		for (int i = 0; i < this.boardSize; i++) {
			assertArrayEquals(boardSetup2[2][i], board.getBoard()[i]);
		}
	}

}
