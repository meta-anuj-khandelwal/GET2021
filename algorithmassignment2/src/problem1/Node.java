package problem1;

public class Node<T> {
	// data of node
	private T data;
	// next refernce to node
	private Node<T> next;

	/**
	 * @param data
	 *            data of node
	 * @param next
	 *            reference of next node
	 */
	public Node(T data) {
		this.data = data;
		this.next = null;

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

}
