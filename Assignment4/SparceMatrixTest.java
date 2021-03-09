package Assignment4;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparceMatrixTest {

	int matrix[][] = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
	int matrix1[][] = { { 0, 1, 0 }, { 0, 0, 1 }, { 0, 0, 1 } };
	int expectedmultiplication[][] = { { 0, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 } };
	int expectedaddition[][] = { { 1, 1, 0 }, { 0, 1, 1 }, { 0, 0, 2 } };

	SparceMatrice matrice = new SparceMatrice(matrix);
	SparceMatrice matrice1 = new SparceMatrice(matrix1);
	SparceMatrice expectedadd = matrice.add(matrice1);
	SparceMatrice expectedmultilply = matrice.multiply(matrice1);

	@Test
	public void test() {
		// addition
		assertEquals(true, matrice.add(matrice1).isEqual(expectedadd));
		// multiplication
		assertEquals(true, matrice.multiply(matrice1)
				.isEqual(expectedmultilply));
		// symmetric
		assertEquals(false, matrice.isSymmetrical(matrice1));
	}

}
