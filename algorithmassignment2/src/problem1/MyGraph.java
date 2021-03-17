package problem1;

import java.util.ArrayList;

public class MyGraph implements Graph {
	private MyLinkList<GrapdhNode>[] adjacencyList;
	int vertices;

	/**
	 * @param vertices
	 */
	public MyGraph(int vertices) {

		this.adjacencyList = new MyLinkList[vertices];
		this.vertices = vertices;

		for (int i = 0; i < vertices; i++) {
			adjacencyList[i] = new MyLinkList<GrapdhNode>();
		}
	}

	@Override
	public void addEdge(int source, int destination, int weight) {
		// forward edge
		adjacencyList[source].add(new GrapdhNode(destination, weight));

		// backward edge in undirected graph
		adjacencyList[destination].add(new GrapdhNode(source, weight));
	}

	@Override
	public boolean isConnected() {
		boolean connected = true;
		// created visited array
		boolean[] visited = new boolean[vertices];

		// start the DFS from vertex 0
		DFS(adjacencyList[0].get(0).getVertex(), adjacencyList, visited);

		// check if all the vertices are visited, if yes then graph is connected
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				connected = false;
			}
		}
		return connected;
	}

	private void DFS(int source, MyLinkList<GrapdhNode>[] adjacencyList,
			boolean[] visited) {

		visited[source] = true;

		// travel the neighbors
		for (int i = 0; i < adjacencyList[source].getSize(); i++) {
			GrapdhNode neighbor = adjacencyList[source].get(i);
			if (visited[neighbor.getVertex()] == false) {
				// make recursive call from neighbor
				DFS(neighbor.getVertex(), adjacencyList, visited);
			}
		}

	}

	@Override
	public MyLinkList<Integer> reachable(int source) {
		MyLinkList<Integer> reachableNode = new MyLinkList<Integer>();
		boolean[] visited = new boolean[vertices];

		// start the DFS from vertex 0
		DFS(source, adjacencyList, visited);

		// check if all the vertices are visited, if yes then graph is connected
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] && i != source) {
				reachableNode.add(i);
			}
		}

		return reachableNode;
	}

	@Override
	public void mst() {
		int parent[] = new int[vertices];
		int key[] = new int[vertices];
		boolean mstSet[] = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		key[0] = 0;
		parent[0] = -1;

		for (int i = 0; i < vertices; i++) {
			int u = minKey(key, mstSet);
			mstSet[u] = true;
			for (int v = 0; v < vertices; v++) {
				boolean ans = false;
				int w = 0;
				for (int j = 0; j < adjacencyList[u].getSize(); j++) {
					if (adjacencyList[u].get(j).getVertex() == v) {
						ans = true;
						w = adjacencyList[u].get(j).getWeight();
					}
				}

				if (ans && mstSet[v] == false && w < key[v]) {
					parent[v] = u;
					key[v] = w;
				}
			}
		}
		printMST(parent);

	}

	public int minKey(int key[], boolean mstSet[]) {
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for (int v = 0; v < vertices; v++) {
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		}
		return min_index;
	}

	public void printMST(int parent[]) {
		System.out.println("The minimum spanning tree is");
		System.out.println("Edge \t Weight");
		for (int i = 1; i < vertices; i++) {
			int w = 0;
			for (int j = 0; j < adjacencyList[i].getSize(); j++) {
				if (adjacencyList[i].get(j).getVertex() == parent[i])
					w = adjacencyList[i].get(j).getWeight();
			}
			System.out.println(parent[i] + " - " + i + "\t" + w);
		}
	}

	@Override
	public void shortestPath(int source, int destination) {
		boolean visited[] = new boolean[this.vertices];
		int distance[] = new int[this.vertices];

		for (int vertex = 0; vertex < this.vertices; vertex++) {
			distance[vertex] = Integer.MAX_VALUE;
		}
		// distance from self is zero
		distance[source] = 0;

		// starting from source node and finding next minimum distance node
		for (int index = source; index < adjacencyList.length; index++) {
			int minimumVertex = minKey(distance, visited);
			visited[minimumVertex] = true;

			for (int counter = 0; counter < adjacencyList[minimumVertex]
					.getSize(); counter++) {
				int currentNeighborVertex = adjacencyList[minimumVertex].get(
						counter).getVertex();
				int currentNeighborVertexWeight = adjacencyList[minimumVertex]
						.get(counter).getWeight();

				if (visited[currentNeighborVertex] == false) {
					int newDistance = distance[minimumVertex]
							+ currentNeighborVertexWeight;
					if (newDistance < distance[currentNeighborVertex])
						distance[currentNeighborVertex] = newDistance;
				}

			}
		}

		findAndPrintPath(distance, source, destination);
	}

	// private helper method for finding and printing path from minimum distance
	// array and source and destination nodes
	private void findAndPrintPath(int[] distance, int source, int destination) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(destination);
		// Starting from destination
		int currentNode = destination;
		// Loop until we find source node
		while (currentNode != source) {
			MyLinkList<GrapdhNode> edges = this.adjacencyList[currentNode];
			// iterating over all the neighbour nodes of the current node
			for (int index = 0; index < edges.getSize(); index++) {
				if ((distance[currentNode] - edges.get(index).getWeight()) == distance[edges
						.get(index).getVertex()]) {
					path.add(edges.get(index).getVertex());
					break;
				}
			}
			// setting the current node to the next node
			currentNode = path.get(path.size() - 1);
		}
		System.out.println("Shortest Path: ");
		for (int id = path.size() - 1; id >= 0; id--) {
			System.out.print(" -> " + path.get(id));
		}
		System.out.println();
	}

	public void print() {
		for (int i = 0; i < adjacencyList.length; i++) {
			System.out.print(i);
			for (int j = 0; j < adjacencyList[i].getSize(); j++) {
				System.out.print("-> " + adjacencyList[i].get(j) + "   ");
			}
		}
	}
}
