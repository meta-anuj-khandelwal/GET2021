package problem3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		OrgenicMolecule molecule = new OrgenicMolecule();
		while (true) {
			System.out.println("Enter Compound formula : ");
			String formula = scanner.next();
			System.out.println("molecule weight : " + molecule.calculateCompoundWeight(formula));
		}
	}
}
