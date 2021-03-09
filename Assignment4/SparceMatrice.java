package Assignment4;

import java.util.Arrays;
import java.util.Comparator;

public class SparceMatrice {
	private final int MAXLENGHT = 40;
	// dimensions of matrix
	private int rowCount, coloumnCount;

	// total number of elements in matrix
	int length;
	// 2d array contain rowIndex,Coloumn and value for non zero element
	final Integer sparceMatrix[][] = new Integer[MAXLENGHT][3];

	/**
	 * 
	 * @param rowCount
	 *            number of rows in matrix
	 * @param coloumnCount
	 *            number of column in matrix
	 */
	public SparceMatrice(int rowCount, int coloumnCount) {
		this.rowCount = rowCount;
		this.coloumnCount = coloumnCount;
		length = 0;

		for (int index = 0; index < MAXLENGHT; index++) {
			sparceMatrix[index][0] = Integer.MAX_VALUE;
			sparceMatrix[index][1] = Integer.MAX_VALUE;
			sparceMatrix[index][2] = Integer.MAX_VALUE;
		}
	}

	/**
	 * This constructor make sparce matrix from matrix
	 * 
	 * @param matrix
	 *            original sparce matrix
	 */
	public SparceMatrice(int matrix[][]) {
		for (int index = 0; index < MAXLENGHT; index++) {
			sparceMatrix[index][0] = Integer.MAX_VALUE;
			sparceMatrix[index][1] = Integer.MAX_VALUE;
			sparceMatrix[index][2] = Integer.MAX_VALUE;
		}
		// setting number of rows in original matrix
		this.rowCount = matrix.length;
		// setting number of column in original matrix
		this.coloumnCount = matrix[0].length;
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			for (int coloumnIndex = 0; coloumnIndex < coloumnCount; coloumnIndex++) {
				if (matrix[rowIndex][coloumnIndex] != 0) {
					this.insertEntry(rowIndex, coloumnIndex,
							matrix[rowIndex][coloumnIndex]);
				}
			}
		}
	}
	
	

	/**
	 * @return the sparceMatrix
	 */
	public Integer[][] getSparceMatrix() {
		return sparceMatrix;
	}

	/**
	 * 
	 * @param rowIndex
	 *            rowIndex of non zero element
	 * @param coloumnIndex
	 *            column Index of non zero element
	 * @param value
	 *            non zero value
	 * @return true if data added else false
	 */
	public boolean insertEntry(int rowIndex, int coloumnIndex, int value) {
		boolean isAdded = false;
		if (rowIndex < rowCount && coloumnIndex < coloumnCount && value != 0) {
			sparceMatrix[length][0] = rowIndex;
			sparceMatrix[length][1] = coloumnIndex;
			sparceMatrix[length][2] = value;
			length++;
			isAdded = true;
		}

		else {
			isAdded = false;
		}
		return isAdded;
	}

	/*
	 * print sparce matrix
	 */
	public void print() {
		for (int rowIndex = 0; rowIndex < length; rowIndex++) {
			System.out.println(sparceMatrix[rowIndex][0] + "\t"
					+ sparceMatrix[rowIndex][1] + "\t"
					+ sparceMatrix[rowIndex][2]);
		}
	}

	/*
	 * This function return transpose of SparceMatrice
	 * 
	 * @return SparceMatrice transpose matrix
	 */

	public SparceMatrice transpose() {
		SparceMatrice transposeMetirce = new SparceMatrice(this.coloumnCount,
				this.rowCount);

		for (int index = 0; index < this.length; index++) {
			transposeMetirce.insertEntry(this.sparceMatrix[index][1],
					this.sparceMatrix[index][0], this.sparceMatrix[index][2]);
		}
		Comparator<Integer[]> arrayComparator = new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] first, Integer[] second) {
				if (first[0] > second[0])
					return 1;
				else if (first[0] < second[0])
					return -1;
				else if (first[1] > second[1])
					return 1;
				else
					return -1;
			}
		};
		Arrays.sort(transposeMetirce.sparceMatrix, arrayComparator);
		return transposeMetirce;
	}

	/*
	 * This function return sum of SparceMatrices
	 * 
	 * @param secondmMtrice matrix to be added.
	 * 
	 * @return SparceMatrice addition of two matrix.
	 */
	public SparceMatrice add(SparceMatrice secondmMtrice) {
		SparceMatrice sumMetirce = null;
		if (secondmMtrice.rowCount == this.rowCount
				&& secondmMtrice.coloumnCount == this.coloumnCount) {

			sumMetirce = new SparceMatrice(secondmMtrice.rowCount,
					secondmMtrice.coloumnCount);
			int firstMatrixIndex = 0, secondMatrixIndex = 0;

			while (firstMatrixIndex < this.length
					&& secondMatrixIndex < secondmMtrice.length) {

				// if secondmMtrice's row and col is smaller
				if (this.sparceMatrix[firstMatrixIndex][0] > secondmMtrice.sparceMatrix[secondMatrixIndex][0]
						|| (this.sparceMatrix[firstMatrixIndex][0] == secondmMtrice.sparceMatrix[secondMatrixIndex][0] && this.sparceMatrix[firstMatrixIndex][1] > secondmMtrice.sparceMatrix[secondMatrixIndex][1]))

				{

					// insert smaller value into result
					sumMetirce.insertEntry(
							secondmMtrice.sparceMatrix[secondMatrixIndex][0],
							secondmMtrice.sparceMatrix[secondMatrixIndex][1],
							secondmMtrice.sparceMatrix[secondMatrixIndex][2]);

					secondMatrixIndex++;
				}

				// if a's row and col is smaller
				else if (sparceMatrix[firstMatrixIndex][0] < secondmMtrice.sparceMatrix[secondMatrixIndex][0]
						|| (sparceMatrix[firstMatrixIndex][0] == secondmMtrice.sparceMatrix[secondMatrixIndex][0] && sparceMatrix[firstMatrixIndex][1] < secondmMtrice.sparceMatrix[secondMatrixIndex][1]))

				{

					// insert smaller value into result
					sumMetirce.insertEntry(sparceMatrix[firstMatrixIndex][0],
							sparceMatrix[firstMatrixIndex][1],
							sparceMatrix[firstMatrixIndex][2]);

					firstMatrixIndex++;
				}

				else {

					// add the values as row and col is same
					int addion = sparceMatrix[firstMatrixIndex][2]
							+ secondmMtrice.sparceMatrix[secondMatrixIndex][2];

					if (addion != 0)
						sumMetirce.insertEntry(
								sparceMatrix[firstMatrixIndex][0],
								sparceMatrix[firstMatrixIndex][1], addion);
					// then insert
					firstMatrixIndex++;
					secondMatrixIndex++;
				}
			}

			// insert remaining elements
			while (firstMatrixIndex < length) {
				sumMetirce.insertEntry(sparceMatrix[firstMatrixIndex][0],
						sparceMatrix[firstMatrixIndex][1],
						sparceMatrix[firstMatrixIndex][2]);
				firstMatrixIndex++;
			}

			while (secondMatrixIndex < secondmMtrice.length) {
				sumMetirce.insertEntry(
						secondmMtrice.sparceMatrix[secondMatrixIndex][0],
						secondmMtrice.sparceMatrix[secondMatrixIndex][1],
						secondmMtrice.sparceMatrix[secondMatrixIndex][2]);
				secondMatrixIndex++;
			}
		} else {
			throw new ArithmeticException(
					"Matrix of different order can't be added");
		}
		return sumMetirce;

	}

	/*
	 * This function return multiplication of SparceMatrices
	 * 
	 * @param secondmMtrice matrix to be multiply.
	 * 
	 * @return SparceMatrice multiplication of two matrix.
	 */
	public SparceMatrice multiply(SparceMatrice secondmMtrice) {
		SparceMatrice multiplyposeMetirce = null;

		if (this.coloumnCount != secondmMtrice.rowCount) {
			multiplyposeMetirce = null;
		} else {
			multiplyposeMetirce = new SparceMatrice(this.rowCount,
					secondmMtrice.coloumnCount);

			// transpose secondmMtrice to compare row
			// and col values and to add them at the end
			secondmMtrice = secondmMtrice.transpose();
			int firstMatrixIndex, secondMatrixIndex;

			// iterate over all elements of firstMatrix
			for (firstMatrixIndex = 0; firstMatrixIndex < this.length;) {

				// current row of result matrix
				int currentRow = sparceMatrix[firstMatrixIndex][0];

				// iterate over all elements of B
				for (secondMatrixIndex = 0; secondMatrixIndex < secondmMtrice.length;) {

					// current column of result matrix
					// sparceMatrix[][0] used as secondmMtrice is transposed
					int currentColumn = secondmMtrice.sparceMatrix[secondMatrixIndex][0];

					// temporary pointers created to add all
					// multiplied values to obtain current
					// element of result matrix
					int tempa = firstMatrixIndex;
					int tempb = secondMatrixIndex;

					int sum = 0;

					// iterate over all elements with
					// same row and col value
					// to calculate result[currentRow]
					while (tempa < this.length
							&& sparceMatrix[tempa][0] == currentRow
							&& tempb < secondmMtrice.length
							&& secondmMtrice.sparceMatrix[tempb][0] == currentColumn) {

						if (sparceMatrix[tempa][1] < secondmMtrice.sparceMatrix[tempb][1])

							// skip a
							tempa++;

						else if (sparceMatrix[tempa][1] > secondmMtrice.sparceMatrix[tempb][1])

							// skip secondmMtrice
							tempb++;
						else

							// same col, so multiply and increment
							sum += sparceMatrix[tempa++][2]
									* secondmMtrice.sparceMatrix[tempb++][2];
					}

					// insert sum obtained in result[currentRow]
					// if its not equal to 0
					if (sum != 0)
						multiplyposeMetirce.insertEntry(currentRow,
								currentColumn, sum);

					while (secondMatrixIndex < secondmMtrice.length
							&& secondmMtrice.sparceMatrix[secondMatrixIndex][0] == currentColumn)

						// jump to next column
						secondMatrixIndex++;
				}

				while (firstMatrixIndex < this.length
						&& sparceMatrix[firstMatrixIndex][0] == currentRow)

					// jump to next row
					firstMatrixIndex++;
			}
		}
		return multiplyposeMetirce;
	}

	/*
	 * This function check matrix is symmetrical or not.
	 * 
	 * @param matrice matrix to be checked for Symmetry.
	 * 
	 * @return boolean true if matrices are symmetrical.
	 */
	public boolean isSymmetrical(SparceMatrice matrice) {
		boolean result;
		SparceMatrice transpose = matrice.transpose();
		if (this.isEqual(transpose)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/*
	 * This function check matrix is equal or not.
	 * 
	 * @param matrice matrix to be checked for equality.
	 * 
	 * @return boolean true if matrices are equal.
	 */
	public boolean isEqual(SparceMatrice matrice) {
		boolean result = false;
		if (this.length == matrice.length) {
			for (int index = 0; index < this.length; index++) {
				if ((this.sparceMatrix[index][0] == matrice.sparceMatrix[index][0])
						&& (this.sparceMatrix[index][1] == matrice.sparceMatrix[index][1])
						&& (this.sparceMatrix[index][2] == matrice.sparceMatrix[index][2])) {
					result = true;
				} else {
					result = false;

					break;
				}
			}
		} else {

			result = false;
		}
		return result;
	}

}
