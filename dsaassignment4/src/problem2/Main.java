package problem2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UniqueCharacter uniqueCharacter = new UniqueCharacter();
		while (true) {
			System.out.println("Enter String : ");
			String string = scanner.nextLine();
			System.out.println("Unique Characters : "+uniqueCharacter.countCharacter(string));
		}
	}
}
