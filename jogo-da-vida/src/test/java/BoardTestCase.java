import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Test;

public class BoardTestCase {
	
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

	
	@Test
	public void boardSetup0Test() {
		Board board = new Board();
		board.setBoard(boardSetup0[0]);
		board.nextState();
		// Since there is no method for testing 2d arrays, we need to assert each row
		for (int i = 0; i < 6; i++) {
			assertArrayEquals(boardSetup0[1][i], board.getBoard()[i]);
		}
	}
	@Test
	public void boardSetup1Test() {
		Board board = new Board();
		board.setBoard(boardSetup1[0]);
		board.nextState();
		// Since there is no method for testing 2d arrays, we need to assert each row
		for (int i = 0; i < 6; i++) {
			assertArrayEquals(boardSetup1[1][i], board.getBoard()[i]);
		}
	}

}
