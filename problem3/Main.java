package problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static int readIntFromConsol() {
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
		BowlerOrder bowlerOrder;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter numbe of bowlers : ");
		int bowlerCount = readIntFromConsol();
		bowlerOrder = new BowlerOrder(bowlerCount);
		for (int bowlerNumber = 0; bowlerNumber < bowlerCount; bowlerNumber++) {
			System.out.println("Enter bowler name : ");
			String name = scanner.nextLine();
			System.out.println("Enter quota of bowler : ");
			int ballCount = readIntFromConsol();
			Bowler bowler = new Bowler(name, ballCount);
			bowlerOrder.addBowler(bowler);
		}
		System.out
				.println("Enter total number of balls Virat is going to play : ");
		int viratPlayBall = readIntFromConsol();
		System.out.println("Order\tRemainig balls");
		// System.out.println(bowlerOrder.getBowlerOrder(viratPlayBall));
		System.out.println(bowlerOrder.getOrder(viratPlayBall));
	}
}
