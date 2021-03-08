package question2;

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
		Queue<Integer> queue = new circularQueue();
		while (true) {
			System.out.println("1] enqueue");
			System.out.println("1] dequeue");
			int choice = readIntFromConsel();
			switch (choice) {
			case 1:
				System.out.println("Enter number : ");
				int value = readIntFromConsel();
				boolean result = queue.enqueue(value);
				if (result) {
					System.out.println("Success....");
				} else {
					System.out.println("Overflow Conditon");
				}
				break;
			case 2:
				Integer queuevalue = queue.dequeue();
				if (queuevalue != null) {
					System.out.println("Dequeued value is : " + queuevalue);
				} else {
					System.out.println("underflow Conditon");
				}
				break;
			}
		}
	}
}
