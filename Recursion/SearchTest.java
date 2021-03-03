package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SearchTest {
	/**
	 * This function is used to add read positive integer value form console.
	 * 
	 * 
	 * @return int console input integer
	 */
	public static int readpositivefromuser() {
		int number;
		while (true) {
			number = readefromuser();
			if (number > 0)
				break;
			else
				System.out.println("Wrong input type \n please re enter :");
		}
		return number;
	}

	/**
	 * This function is used to add read integer value form console.
	 * 
	 * 
	 * @return int console input integer
	 */
	public static int readefromuser() {
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
		System.out.println("Enter array size");
		int size = readpositivefromuser();
		int arr[] = new int[size];
		for (int index = 0; index < size; index++) {
			arr[index] = readefromuser();
		}
		while (true) {
			System.out.println("1] search using linear search : ");
			System.out.println("2] search using binary search : ");
			int ch = readefromuser();

			if (ch == 1) {
				System.out.println("Enter key");
				int value = readefromuser();
				int index = Search.linearSearch(arr, value);
				if (index >= 0)
					System.out.println("Element find at : " + index);
				else
					System.out.println("Element not found");

			} else if (ch == 2) {
				System.out.println("Enter key");
				int value = readefromuser();
				int index = Search.binarySearch(arr, value);
				if (index >= 0)
					System.out.println("Element find at : " + index);
				else
					System.out.println("Element not found");
			} else {
				System.out.println("Wrong input...");
			}
		}
	}
}
