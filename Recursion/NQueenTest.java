package Recursion;

/**
 * Test class to test nQueenProblem class
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-02
 */
public class NQueenTest {
	public static void main(String[] args) {
		int[][] board = new int[3][3];
		NQueenProblem nQueenProblem = new NQueenProblem();
		Boolean result = nQueenProblem.nQueen(board, 0, board.length);
		System.out.println(result);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}
}
