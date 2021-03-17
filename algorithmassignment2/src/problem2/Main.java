package problem2;

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
		MyLinkList<Employees> employeeList = new MyLinkList<Employees>();
		Employees employee;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1] Enter employee details");
			System.out.println("2] Sort Employee");
			System.out.println("3] Show list");
			System.out.println("3] Exit");
			int choice = readfromuser();
			switch (choice) {
			case 1:
				System.out.println("Enter Name : ");
				String name = scanner.nextLine();
				System.out.println("Enter ID : ");
				int id = readfromuser();
				System.out.println("Enter Age : ");
				int age = readfromuser();
				System.out.println("Enter Salary : ");
				int salary = readfromuser();
				employee = new Employees(name, age, id, salary);
				employeeList.add(employee);
				break;
			case 2:
				Node<Employees> endNode = employeeList.getStart();

				while (endNode.getNext() != null) {
					endNode = endNode.getNext();
				}
				MyCollection.quickSort(employeeList.getStart(), endNode);
				break;
			case 3:
				employeeList.print();
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid choice");
			}

		}

	}
}
