package problem2;


public class Node<T> {
	private T data;
	private Node<T> next;

	/**
	 * @param data
	 * @param next
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
