package Assignment3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;

import javax.print.attribute.standard.Finishings;

public class IntSetTest {
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

	public static intSet setCreater() {
		System.out.println("Enter set size");
		int size = readIntFromConsel();
		while (size <= 0) {
			System.out.println("Size must be greter than 0\nplease re enter :");
			size = readIntFromConsel();
		}
		int arr[] = new int[size];
		System.out.println("Enter Set element :");
		for (int index = 0; index < size; index++) {
			arr[index] = readIntFromConsel();
		}
		return new intSet(arr);
	}

	public static void main(String[] args) {
		intSet intset = new intSet();
		while (true) {
			System.out.println("********************************************");
			System.out.println("1] Create a Set");
			System.out.println("2] Check size");
			System.out.println("3] Display Set");
			System.out.println("4] Find Complement set");
			System.out.println("5] Is member or not");
			System.out.println("6] Check Subset");
			System.out.println("7] Find union");
			System.out.println("8] Exit");
			System.out.println("Enter Your Choice :");
			int choice = readIntFromConsel();
			switch (choice) {
			case 1:
				intset = setCreater();
				System.out.println("Set created successfully");
				break;
			case 2:
				System.out.println("Set Size : " + intset.size());
				break;
			case 3:
				System.out.print("Set : ");
				intset.print();
				break;
			case 4:
				intSet complementSet = intset.getComplement();
				System.out.println("Complement Set : ");
				complementSet.print();
				break;
			case 5:
				System.out.println("Enter number");
				int number = readIntFromConsel();
				System.out.println("\n" + number + " is element of set : "
						+ intset.iSMember(number));

				break;
			case 6:
				intSet subset = setCreater();
				System.out.println(intset.iSSubset(subset));
				break;

			case 7:
				System.out.println("Create Set 1 :");
				intSet set1 = setCreater();
				System.out.println("Create Set 2 :");
				intSet set2 = setCreater();
				intSet union = intSet.union(set1, set2);
				System.out.print("Union Set : ");
				union.print();
				break;
			case 8:

				return;
			default:
				System.out.println("Invalid input...");
			}
		}
	}
}
