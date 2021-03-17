package problem1;

public class Main {
	public static void main(String[] args) {
		MyGraph graph = new MyGraph(5);
		graph.addEdge(0, 1, 10);
		graph.addEdge(1, 4, 1);
		graph.addEdge(4, 3, 17);
		//graph.addEdge(2, 0, 1);
		//System.out.println(graph.isConnected());
		// graph.print();

		graph.addEdge(3, 2, 21);
		graph.print();
		System.out.println("\n" + graph.isConnected());
		graph.reachable(3).print();
		graph.mst();
		
	}
}
