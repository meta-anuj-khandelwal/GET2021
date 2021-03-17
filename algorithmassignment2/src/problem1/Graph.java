package problem1;

public interface Graph {
	boolean isConnected();

	MyLinkList<Integer> reachable(int source);

	void mst();

	void shortestPath(int source, int destination);

	public void addEdge(int source, int destination,int weight);
}
