package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Testing MathOperration class
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-02
 */
public class MathOperationTest {
	/**
	 * This function is used to add read integer value form console.
	 * 
	 * 
	 * @return int console input integer
	 */
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
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("****************************************");
			System.out.println("Enter 2 numbers :");
			int num1 = readfromuser();
			int num2 = readfromuser();
			System.out.println("1] HCF");
			System.out.println("2] LCM");
			int choice = readfromuser();
			switch (choice) {
			case 1:
				System.out.println(MathOperations.hcf(num1, num2));
				break;
			case 2:
				System.out.println(MathOperations.lcm(num1, num2));
				break;
			default:
				System.out.println("Wrong input");
			}
		}
	}
}
