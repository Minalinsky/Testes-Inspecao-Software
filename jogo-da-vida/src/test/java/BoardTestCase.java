import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Test;

public class BoardTestCase {
	

	private int[][] finalBoard = new int[][]{
		  { 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0 }
	};
	
	private int[][] boardSetup1 = new int[][] {
		{ 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 1 },
		{ 0, 1, 1, 0, 1, 1 },
		{ 0, 1, 1, 1, 0, 1 },
		{ 1, 0, 0, 1, 0, 1 },
		{ 0, 0, 1, 1, 0, 1 }
	};
	
	private int[][] boardSetup1Next = new int[][] {
		{ 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 1, 1 },
		{ 0, 1, 0, 0, 0, 1 },
		{ 1, 0, 0, 0, 0, 1 },
		{ 0, 0, 0, 0, 0, 1 },
		{ 0, 0, 1, 1, 0, 0 }
	};
	
	@Test
	public void boardLengthTest() {
		Board board = new Board();
		int expectedSize = 6;
		int obtained = board.getBoard().length;
		assertEquals(expectedSize, obtained);
	}
	
	@Test
	public void finalBoardStateTest() {
		Board board = new Board();
		int[][] expectedArray = finalBoard;
		board.setBoard(expectedArray);
		// board.nextState() should not alter the expectedArray
		board.nextState();
		// Since there is no method for testing 2d arrays, we need to assert each row
		for (int i = 0; i < 6; i++) {
			assertArrayEquals(expectedArray[i], board.getBoard()[i]);
		}
	}
	
	@Test
	public void generalBoardStateTest() {
		Board board = new Board();
		int[][] expectedArray = boardSetup1Next;
		board.setBoard(boardSetup1);
		board.nextState();
		// Since there is no method for testing 2d arrays, we need to assert each row
		for (int i = 0; i < 6; i++) {
			assertArrayEquals(expectedArray[i], board.getBoard()[i]);
		}
	}

}
