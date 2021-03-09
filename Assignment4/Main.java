package Assignment4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static int readfromuser() {
		int number;
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		while (true) {
			try {
				number = Integer.parseInt(bufferedReader.readLine());
				break;
			} catch (Exception e) {
				System.out.println("Wrong input type \n please re enter :");
			}
		}
		return number;

	}

	public static void main(String[] args) {
		while (true) {
			SparceMatrice matrice1;
			SparceMatrice matrice2;
			System.out.println("1] Transpose of the matrix");
			System.out.println("2] symmetrical matrix check");
			System.out.println("3] Add two matrices");
			System.out.println("4] Multiply two matrices");
			int choice = readfromuser();
			switch (choice) {
			case 1:
				System.out.println("Enter matrix details:");
				SparceMatrice matrice = getMatrix();
				SparceMatrice transposeMatrice = matrice.transpose();
				System.out.println("Matrix 1 : ");
				matrice.print();
				System.out.println();
				System.out.println("Transpose Matrix 2 : ");
				transposeMatrice.print();
				break;
			case 2:
				System.out.println("Enter 1st matrix details:");
				matrice1 = getMatrix();
				System.out.println("Enter 2nd matrix details:");
				matrice2 = getMatrix();
				if (matrice1.isSymmetrical(matrice2)) {
					System.out.println("Matrices are symetric");
				} else {
					System.out.println("Matrices are not symetric");
				}
			case 3:
				System.out.println("Enter 1st matrix details:");
				matrice1 = getMatrix();
				System.out.println("Enter 2nd matrix details:");
				matrice2 = getMatrix();
				SparceMatrice sumMatrice = matrice1.add(matrice2);
				System.out.println("Sum is : ");
				sumMatrice.print();
				break;
			case 4:
				System.out.println("Enter 1st matrix details:");
				matrice1 = getMatrix();
				System.out.println("Enter 2nd matrix details:");
				matrice2 = getMatrix();
				SparceMatrice mulMatrice = matrice1.add(matrice2);
				System.out.println("Multiplication is : ");
				mulMatrice.print();
				break;
			default:
				break;
			}
		}

	}

	private static SparceMatrice getMatrix() {
		// TODO Auto-generated method stub
		SparceMatrice matrice = null;
		System.out.println("Enter number of rows : ");
		int rows = readfromuser();
		System.out.println("Enter number of columns : ");
		int columns = readfromuser();
		int matrix[][] = new int[rows][columns];
		System.out.println("Enter matrix");
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}

		matrice = new SparceMatrice(matrix);
		return matrice;

	}
}
