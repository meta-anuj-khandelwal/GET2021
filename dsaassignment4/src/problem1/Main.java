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

		EmployeeCollection employeeCollection = new EmployeeCollection();
		Scanner scanner = new Scanner(System.in);

		while (true) {
	
			System.out.println("1] Add Employee");
			System.out.println("2] Sort Employee by Employee Id");
			System.out.println("3] Sort Employee by Employee name");
			System.out.println("4] Display");
			int choice = readfromuser();
			switch (choice) {
			case 1:
				System.out.println("Enter Employee ID :");
				int empId = readfromuser();
				System.out.println("Enter Employee Name :");
				String empName = scanner.next();
				System.out.println("Enter Employee Adress :");
				String empAddress = scanner.next();
				Employee emp = new Employee(empId, empName, empAddress);
				
				if (employeeCollection.add(emp)) {
					System.out.println("Employeee Added successful");
				} else {
					System.out.println("Employeee Addition failed");
				}
				break;
			case 2:
				employeeCollection.sortByEmpId();
				break;
			case 3:
				employeeCollection.sortByEmpName();
				break;
			case 4:
				employeeCollection.print();
				break;
			}
		}
	}
}
