package problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
		MyGraph graph = null;
		while (true) {
			System.out.println("1]Make Graph");
			System.out.println("2]Is Connected");
			System.out.println("3]MST");
			System.out.println("4]Shortest path");
			System.out.println("5]Print graph");
			int choice = readfromuser();
			switch (choice) {
			case 1:
				boolean addMoreEdge = true;
				System.out.println("Enter vertex count : ");
				int vertices = readfromuser();
				graph = new MyGraph(vertices);
				while (addMoreEdge) {
					System.out.println("Enter source : ");
					int s = readfromuser();
					System.out.println("Enter destination : ");
					int v = readfromuser();
					System.out.println("Enter weight : ");
					int weight = readfromuser();
					graph.addEdge(s, v, weight);
					System.out
							.println("Add  more edges if no press 0 else press any key");
					int addmode = readfromuser();
					if (addmode == 0) {
						addMoreEdge = false;
					}
				}
				break;
			case 2:
				if (graph.isConnected()) {
					System.out.println("Graph is connected");
				} else {
					System.out.println("Graph is not connected");
				}
				break;
			case 3:
				graph.mst();
				break;
			case 4:
				System.out.println("Enter source :");
				int source = readfromuser();
				System.out.println("Enter destination :");
				int destination = readfromuser();
				graph.shortestPath(source, destination);
				break;
			case 5:
				graph.print();

			}
			
		}
		
	}
}
