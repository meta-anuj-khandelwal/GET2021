package problem2;

public class Node<T extends Comparable<T>> {
	T data;

	/**
	 * @param data
	 *            data to be added in Node
	 */
	public Node(T data) {
		this.data = data;
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
	 * this method return data of node in string format.
	 * 
	 * @return String data of node in string format.
	 */
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

}
