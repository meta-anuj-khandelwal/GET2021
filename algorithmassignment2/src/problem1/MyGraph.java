package problem1;

public class MyGraph implements Graph {
	// adjacency list for graph.
	private MyLinkList<GrapdhNode>[] adjacencyList;
	// count of vertices.
	int vertices;

	/**
	 * @param vertices
	 *            number of vertices.
	 */
	public MyGraph(int vertices) {

		this.adjacencyList = new MyLinkList[vertices];
		this.vertices = vertices;

		for (int vertex = 0; vertex < vertices; vertex++) {
			adjacencyList[vertex] = new MyLinkList<GrapdhNode>();
		}
	}

	/**
	 * This function add edge to graph.
	 * 
	 * @param source
	 *            source vertex of graph.
	 * @param destination
	 *            destination vertex of graph.
	 * @param int weight of edge.
	 */
	@Override
	public void addEdge(int source, int destination, int weight) {
		if ((source >= 0 && source < vertices)
				&& (destination >= 0 && destination < vertices)) {
			// forward edge
			adjacencyList[source].add(new GrapdhNode(destination, weight));

			// backward edge in undirected graph
			adjacencyList[destination].add(new GrapdhNode(source, weight));
		}
	}

	/**
	 * This function check if graph is connected or not.
	 * 
	 * @return boolean true if graph is connected else false.
	 */
	@Override
	public boolean isConnected() {
		boolean connected = true;
		// created visited array
		boolean[] visited = new boolean[vertices];

		// start the DFS from vertex 0
		DFS(adjacencyList[0].get(0).getVertex(), adjacencyList, visited);

		// check if all the vertices are visited, if yes then graph is connected
		for (int vertex = 0; vertex < visited.length; vertex++) {
			if (!visited[vertex]) {
				connected = false;
			}
		}
		return connected;
	}

	/**
	 * This function perform Depth first search
	 * 
	 * @param source
	 *            source of graph
	 * @param adjacencyList
	 *            adjacency list of graph
	 * @param visited
	 *            array of boolean where index value denotes vertex.
	 */
	private void DFS(int source, MyLinkList<GrapdhNode>[] adjacencyList,
			boolean[] visited) {

		visited[source] = true;

		// travel the neighbors
		for (int vertex = 0; vertex < adjacencyList[source].getSize(); vertex++) {
			GrapdhNode neighbor = adjacencyList[source].get(vertex);
			if (visited[neighbor.getVertex()] == false) {
				// make recursive call from neighbor
				DFS(neighbor.getVertex(), adjacencyList, visited);
			}
		}

	}

	/**
	 * This function return MyLinkedList of reachable vertex from source node.
	 * 
	 * @param source
	 *            source vertex from where reachable nodes to be find.
	 * @return MyLinkedList of reachable vertex.
	 */
	@Override
	public MyLinkList<Integer> reachable(int source) {

		MyLinkList<Integer> reachableNode = new MyLinkList<Integer>();
		if (source >= 0 && source < vertices) {
			boolean[] visited = new boolean[vertices];

			// start the DFS from vertex 0
			DFS(source, adjacencyList, visited);

			// check if all the vertices are visited, if yes then graph is
			// connected
			for (int vertex = 0; vertex < visited.length; vertex++) {
				if (visited[vertex] && vertex != source) {
					reachableNode.add(vertex);
				}
			}
		}
		return reachableNode;
	}

	/**
	 * This function find minimum spanning tree.
	 */
	@Override
	public void mst() {

		int parentVertices[] = new int[vertices];
		int weight[] = new int[vertices];
		boolean visited[] = new boolean[vertices];
		// setting all weight to infinite
		for (int vertex = 0; vertex < vertices; vertex++) {
			weight[vertex] = Integer.MAX_VALUE;
			visited[vertex] = false;
		}

		weight[0] = 0;
		parentVertices[0] = -1;
		// visiting all nodes
		for (int vertex = 0; vertex < vertices; vertex++) {

			int currentVertex = minimumWeightVertex(weight, visited);

			visited[currentVertex] = true;

			for (int v = 0; v < vertices; v++) {
				boolean isVertexFound = false;
				int loacalWeight = 0;

				for (int neighbourVertex = 0; neighbourVertex < adjacencyList[currentVertex]
						.getSize(); neighbourVertex++) {
					if (adjacencyList[currentVertex].get(neighbourVertex)
							.getVertex() == v) {
						isVertexFound = true;
						loacalWeight = adjacencyList[currentVertex].get(
								neighbourVertex).getWeight();
					}
				}

				if (isVertexFound && visited[v] == false
						&& loacalWeight < weight[v]) {
					parentVertices[v] = currentVertex;
					weight[v] = loacalWeight;
				}
			}
		}
		printMST(parentVertices);

	}

	/**
	 * 
	 * @param weight
	 *            array of weight
	 * @param visited
	 *            array of boolean contains which vertex is visited and which
	 *            not
	 * @return not visited minimum weight vertex
	 */
	private int minimumWeightVertex(int weight[], boolean visited[]) {
		int minimumWeight = Integer.MAX_VALUE;
		int vertex = -1;
		for (int v = 0; v < vertices; v++) {
			if (!visited[v] && weight[v] < minimumWeight) {
				minimumWeight = weight[v];
				vertex = v;
			}
		}
		return vertex;
	}

	/**
	 * This function print the minimum spanning tree.
	 * 
	 * @param parentVertices
	 *            array of parent vertices.
	 */
	public void printMST(int parentVertices[]) {
		System.out.println("edge\t\tWeight");
		for (int vertex = 1; vertex < vertices; vertex++) {
			int weight = 0;
			for (int neighbourVertex = 0; neighbourVertex < adjacencyList[vertex]
					.getSize(); neighbourVertex++) {
				if (adjacencyList[vertex].get(neighbourVertex).getVertex() == parentVertices[vertex])
					weight = adjacencyList[vertex].get(neighbourVertex)
							.getWeight();
			}
			System.out.println(parentVertices[vertex] + "--" + vertex + "\t\t"
					+ weight);
		}
	}

	/**
	 * This function print shortest path from source to destination.
	 * 
	 * @param source
	 *            source of path.
	 * @param destination
	 *            destination of path.
	 */
	@Override
	public void shortestPath(int source, int destination) {
		if ((source >= 0 && source < vertices)
				&& (destination >= 0 && destination < vertices)) {
			boolean visited[] = new boolean[this.vertices];
			int distance[] = new int[this.vertices];
			// setting distance to infinite
			for (int vertex = 0; vertex < this.vertices; vertex++) {
				distance[vertex] = Integer.MAX_VALUE;
			}
			// distance from self is zero
			distance[source] = 0;

			// traversing all vertex
			for (int index = 0; index < adjacencyList.length; index++) {

				int minimumVertex = minimumWeightVertex(distance, visited);
				visited[minimumVertex] = true;

				for (int neighbourVertex = 0; neighbourVertex < adjacencyList[minimumVertex]
						.getSize(); neighbourVertex++) {

					int currentNeighborVertex = adjacencyList[minimumVertex]
							.get(neighbourVertex).getVertex();
					int currentNeighborVertexWeight = adjacencyList[minimumVertex]
							.get(neighbourVertex).getWeight();
					// if vertex is not visited previously
					if (!visited[currentNeighborVertex]) {
						int newDistance = distance[minimumVertex]
								+ currentNeighborVertexWeight;
						// if new distance is less than previous distance.
						if (newDistance < distance[currentNeighborVertex])
							distance[currentNeighborVertex] = newDistance;
					}

				}
			}

			findAndPrintPath(distance, source, destination);
		}
	}

	// private helper method for finding and printing path from minimum distance
	// array and source and destination nodes
	private void findAndPrintPath(int[] distance, int source, int destination) {

		MyLinkList<Integer> path = new MyLinkList<Integer>();
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
			currentNode = path.get(path.getSize() - 1);
		}
		System.out.println("Shortest Path: ");

		for (int id = path.getSize() - 1; id >= 0; id--) {
			System.out.print(" -> " + path.get(id));

		}

		System.out.println("\nDistance " + distance[destination]);

	}

	/**
	 * This function print graph adjacencyList.
	 */
	public void print() {
		for (int vertex = 0; vertex < adjacencyList.length; vertex++) {
			System.out.print(vertex);
			for (int neighbourVertex = 0; neighbourVertex < adjacencyList[vertex]
					.getSize(); neighbourVertex++) {
				System.out.print("-> "
						+ adjacencyList[vertex].get(neighbourVertex) + "   ");
			}
			System.out.println();
		}
	}
}
