package Assignment3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PolyTest {
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

	public static Poly polyCreater() {
		System.out.println("Enter Degree of polynomial");
		int degree = readIntFromConsel();
		while (degree < 0) {
			System.out
					.println("degree must be greter than or equal 0\nplease re enter :");
			degree = readIntFromConsel();
		}
		int arr[] = new int[degree+1];
		System.out.println("Enter Polynomial coeficients  :");
		for (int index = 0; index <= degree; index++) {
			System.out.println("Enter cofficient of x^" + index);
			arr[index] = readIntFromConsel();
		}
		return new Poly(arr);
	}

	public static void main(String[] args) {
		Poly poly = new Poly();
		while (true) {
			System.out.println("********************************************");
			System.out.println("1] Create a Polynomial");
			System.out.println("2] Check degree");
			System.out.println("3] Display Polynomial");
			System.out.println("4] Add Polynomial");
			System.out.println("5] Multiply Pultiply ");
			System.out.println("6] Exit");
			System.out.println("Enter Your Choice :");
			int choice = readIntFromConsel();
			switch (choice) {
			case 1:
				poly = polyCreater();
				System.out.println("polynomial created successfully");
				break;
			case 2:
				System.out.println("Degree : " + poly.degree());
				break;
			case 3:
				System.out.print("Polynomial : ");
				poly.print();
				break;
			case 4:
				System.out.println("Create polynomial 1 :");
				Poly p1 = polyCreater();
				System.out.println("Create polynomial 2 :");
				Poly p2 = polyCreater();
				Poly addition = Poly.addPoly(p1, p2);
				System.out.print("Addition : ");
				addition.print();
				break;
			case 5:
				System.out.println("Create polynomial 1 :");
				Poly poly1 = polyCreater();
				System.out.println("Create polynomial 2 :");
				Poly poly2 = polyCreater();
				Poly multiplication = Poly.multiplyPoly(poly1, poly2);
				System.out.print("Addition : ");
				multiplication.print();
				break;
			case 6:

				return;
			default:
				System.out.println("Invalid input...");
			}
		}
	}
}
