package problem1;

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

		BSTDictionary bstDictionary = new BSTDictionary();
		Scanner scanner = new Scanner(System.in);
		String key, value;
		while (true) {
			System.out.println("1]Insert");
			System.out.println("2]Delete");
			System.out.println("3]Fetch");
			System.out.println("4]Sorted List");
			System.out.println("5]Sorted List between k1 and k2");
			System.out.println("6]Exit");
			int choice = readfromuser();
			switch (choice) {
			case 1:
				System.out.println("Enter key : ");
				key = scanner.next();
				System.out.println("Enter Value : ");
				value = scanner.next();
				if (bstDictionary.insert(key, value)) {
					System.out.println("Success");
				} else {
					System.out.println("Key already exist");
				}
				break;
			case 2:
				System.out.println("Enter key : ");
				key = scanner.next();

				if (bstDictionary.delete(key)) {
					System.out.println("Success");
				} else {
					System.out.println("Key Not Find");
				}
				break;
			case 3:
				System.out.println("Enter key : ");
				key = scanner.next();
				value = bstDictionary.get(key);
				if (value != null) {
					System.out.println("Value : " + value);
				} else {
					System.out.println("Key Not Find");
				}
				break;
			case 4:
				MyLinkList<DataKey> linkList = bstDictionary.getSortedList();
				linkList.print();
				System.out.println();
				break;
			case 5:
				System.out.println("Enter key1 : ");
				String key1 = scanner.next();
				System.out.println("Enter key2 : ");
				String key2 = scanner.next();
				MyLinkList<DataKey> linkListrange = bstDictionary
						.getSortedInRange(key1, key2);
				linkListrange.print();
				System.out.println();
				break;
			case 6:

				return;
			default:
				break;
			}

		}
	}
}
