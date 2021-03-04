package dsaassignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int readIntFromConsel() {
		int number;
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		while (true) {
			try {
				number = Integer.parseInt(bufferedReader.readLine());
				break;
			} catch (Exception e) {
				System.out.println("Something went wrong\n please re enter :");
			}
		}
		return number;

	}

	public static void main(String[] args) {
		MyLinkList<Integer> list = new MyLinkList<Integer>();

		while (true) {
			System.out.println("1] Insert item in list");
			System.out.println("2] sublist rotarion");
			System.out.println("3] multivarient polynomail degree calculation");
			System.out.println("4] exit");
			int choice = readIntFromConsel();
			switch (choice) {
			case 1:
				System.out.println("Enter Number");
				int number = readIntFromConsel();
				list.add(number);
				break;
			case 2:
				System.out.println("Enter left postion");
				int leftPosition = readIntFromConsel();
				System.out.println("Enter right postion");
				int rightPosition = readIntFromConsel();
				System.out.println("Enter number of steps to rotate");
				int nsteps = readIntFromConsel();
				list.rotateSublist(leftPosition, rightPosition, nsteps);
				list.print();
				System.out.println();
				break;
			case 3:
				Polynomial polynomial = new Polynomial();
				System.out.println("Degree : " + polynomial.polyDegree());
				break;
			case 4:
				return;
			}
		}

	}
}
