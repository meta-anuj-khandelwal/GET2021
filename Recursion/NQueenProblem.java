package Recursion;

public class NQueenProblem {
	/**
	 * This function helping function for nQueen(int[][] board, int row_num, int
	 * dimensionOfMatrix) function. find is placing queen at this column and row
	 * or not
	 * 
	 * @param board
	 *            2D arrays denotes board value 0 for empty space and 1 for
	 *            filled place
	 * @param row_num
	 *            int queen row number.
	 * @param col_num
	 *            int queen column number.
	 * @return boolean true if placing queen at this column and row is safe else
	 *         false
	 */
	private boolean isSafe(int[][] board, int row_num, int col_num) {
		for (int currentRow = 0; currentRow < row_num; currentRow++) {
			if (board[currentRow][col_num] == 1) {
				return false;
			}
		}

		int diagonal_row_num = row_num;
		int diagonal_col_num = col_num;

		while (diagonal_row_num >= 0 && diagonal_col_num >= 0) {
			if (board[diagonal_row_num][diagonal_col_num] == 1) {
				return false;
			}
			diagonal_row_num--;
			diagonal_col_num--;
		}

		diagonal_row_num = row_num;
		diagonal_col_num = col_num;

		while (diagonal_row_num >= 0 && diagonal_col_num < board.length) {
			if (board[diagonal_row_num][diagonal_col_num] == 1) {
				return false;
			}
			diagonal_row_num--;
			diagonal_col_num++;
		}
		return true;
	}

	/**
	 * This function is used for find nqueen problem solution
	 * 
	 * @param board
	 *            2D arrays denotes board value 0 for empty space and 1 for
	 *            filled place
	 * @param row_num
	 *            int start position of queen row number.
	 * @param dimensionOfMatrix
	 *            int dimension of board
	 * @return boolean true if nqueen problem solution exist else false
	 */
	public boolean nQueen(int[][] board, int row_num, int dimensionOfMatrix) {
		if (row_num >= dimensionOfMatrix) {
			return true;
		}

		for (int col_num = 0; col_num < dimensionOfMatrix; col_num++) {
			if (isSafe(board, row_num, col_num)) {
				board[row_num][col_num] = 1;

				if (nQueen(board, row_num + 1, dimensionOfMatrix)) {
					return true;
				}
				// back tracking
				board[row_num][col_num] = 0;
			}
		}
		return false;
	}
}
