package dsaassignment1;
/**
 * <h1>MyLinkList</h1>
 * <p>
 * This class is used in implement of  linked list data structure.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-04
 */
public class Node<T> {
	private T data;
	private Node<T> next;
	private boolean visited;

	/**
	 * @param data
	 * @param next
	 * @param visited
	 */
	public Node(T data) {
		this.data = data;
		this.next = null;
		this.visited = false;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the next node
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @param visited
	 *            the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
