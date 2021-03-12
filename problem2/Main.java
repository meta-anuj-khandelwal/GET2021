package problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import problem1.VCP;

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
		Node<Integer> node;
		PriorityQueue<Node> queue = new MyPriorityQueue(100);

		while (true) {
			System.out.println("1] Insert ");
			System.out.println("2] Delete ");
			System.out.println("3] Print");
			int choice = readIntFromConsol();
			switch (choice) {
			case 1:
				System.out.println("Enter value to insert : ");
				int value = readIntFromConsol();
				node = new Node<Integer>(value);
				boolean isEnqueueSuccess = queue.enQueue(node);
				if (isEnqueueSuccess) {
					System.out.println("Successfully added");
				} else {
					System.out.println("overflow");
				}

				break;
			case 2:
				node = queue.deQueue();
				if (node != null) {
					System.out.println("Deleted value :" + node.getData());
				} else {
					System.out.println("underflow");
				}
				break;
			case 3:
				queue.print();
				break;
			default:
				System.out.println("Wrong input");
			}
		}
	}
}
