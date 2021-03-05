package Testing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
		ArrOperation arrOperation = new ArrOperation();
		int array[];
		while (true) {
			System.out.println("1] largest mirror");
			System.out.println("2] number of clumps");
			System.out.println("3] fixXY problem");
			System.out.println("4] split array");
			System.out.println("5] exit");
			int choice = readfromuser();
			switch (choice) {
			case 1:
				array = makeArray();
				print(array);
				System.out.println("Mirror Size : "
						+ arrOperation.mirror(array));
				break;
			case 2:
				array = makeArray();
				print(array);
				System.out.println("Total clumps : "
						+ arrOperation.clumps(array));
				break;
			case 3:
				array = makeArray();
				System.out.println("Enter value of x : ");
				int x = readfromuser();
				System.out.println("Enter value of y : ");
				int y = readfromuser();
				print(array);
				try {
					print(arrOperation.fixXY(array, x, y));
				} catch (Exception e) {
					System.err.print(e);
				}
				break;
			case 4:
				array = makeArray();
				print(array);
				System.out.println("Split index : "
						+ arrOperation.splitArray(array));
				break;
			case 5:
				return;

			}
		}

	}

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	}

	private static int[] makeArray() {
		int array[] = null;
		int size;
		System.out.println("Enter Array Size : ");
		size = readfromuser();
		if (size > 0) {
			array = new int[size];
			System.out.println("Enter Array elements");
			for (int index = 0; index < size; index++) {
				array[index] = readfromuser();
			}
		}
		return array;
	}
}
