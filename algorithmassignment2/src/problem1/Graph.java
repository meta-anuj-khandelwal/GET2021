package problem1;

public interface Graph {
	/**
	 * This function check if graph is connected or not.
	 * 
	 * @return boolean true if graph is connected else false.
	 */
	boolean isConnected();

	/**
	 * This function return MyLinkedList of reachable vertex from source node.
	 * 
	 * @param source
	 *            source vertex from where reachable nodes to be find.
	 * @return MyLinkedList of reachable vertex.
	 */
	MyLinkList<Integer> reachable(int source);

	/**
	 * This function find minimum spanning tree.
	 */
	void mst();

	/**
	 * This function print shortest path from source to destination.
	 * 
	 * @param source
	 *            source of path.
	 * @param destination
	 *            destination of path.
	 */
	void shortestPath(int source, int destination);

	/**
	 * This function add edge to graph.
	 * 
	 * @param source
	 *            source vertex of graph.
	 * @param destination
	 *            destination vertex of graph.
	 * @param int weight of edge.
	 */
	public void addEdge(int source, int destination, int weight);
}
