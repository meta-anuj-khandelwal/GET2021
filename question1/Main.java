package question1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Infix Expression : ");
			String expression = scanner.nextLine();
			InfixCalc infixCalc = new InfixCalc(expression);
			System.out.println("Answer : "+infixCalc.evaluate());

		}
	}

}
