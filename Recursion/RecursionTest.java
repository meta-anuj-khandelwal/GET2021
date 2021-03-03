package Recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionTest {

	@Test
	public void testHCF() {
		assertEquals(1, MathOperations.hcf(12, 13));
		assertEquals(12, MathOperations.hcf(12, 12));
		assertEquals(12, MathOperations.hcf(12, 24));
		assertEquals(4, MathOperations.hcf(12, 32));
		assertEquals(2, MathOperations.hcf(18, 28));

	}

	@Test
	public void testlcm() {
		assertEquals(156, MathOperations.lcm(12, 13));
		assertEquals(36, MathOperations.lcm(18, 36));
		assertEquals(780, MathOperations.lcm(12, 130));
		assertEquals(3696, MathOperations.lcm(112, 132));
		assertEquals(385, MathOperations.lcm(11, 35));
	}

	@Test
	public void testLinearSearch() {
		int arr[] = { 12, 32, 23, 12, 3, 121, 3, -32, 13, -12, 2, 123, 199 };
		assertEquals(0, Search.linearSearch(arr, 12));
		assertEquals(1, Search.linearSearch(arr, 32));
		assertEquals(4, Search.linearSearch(arr, 3));
		assertEquals(7, Search.linearSearch(arr, -32));
		assertEquals(12, Search.linearSearch(arr, 199));
		assertEquals(-1, Search.linearSearch(arr, 1122));
		assertEquals(-1, Search.linearSearch(arr, -112));

	}

	@Test
	public void testBinarySearch() {
		int arr[] = { -12, -2, 0, 12, 45, 90, 120, 340, 340, 1009 };
		assertEquals(0, Search.linearSearch(arr, -12));
		assertEquals(2, Search.linearSearch(arr, 0));
		assertEquals(7, Search.linearSearch(arr, 340));
		assertEquals(9, Search.linearSearch(arr, 1009));
		assertEquals(-1, Search.linearSearch(arr, 1122));
		assertEquals(-1, Search.linearSearch(arr, -112));

	}

	@Test
	public void testNQueen() {
		int board[][] = new int[4][4];
		NQueenProblem nQueenProblem = new NQueenProblem();
		assertEquals(true, nQueenProblem.nQueen(board, 0, board.length));
		board = new int[3][3];
		assertEquals(false, nQueenProblem.nQueen(board, 0, board.length));

	}
}
