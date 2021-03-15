package problem2;

/**
 * <h1>MyLinkList</h1>
 * <p>
 * This class is used to implement linked list data structure.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-04
 */
public class MyLinkList<T> {
	// starting of link list
	Node<T> start;

	/**
	 * @return the start
	 */
	public Node<T> getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(Node<T> start) {
		this.start = start;
	}

	/**
	 * this function used add value to link list.
	 * 
	 * @param value
	 *            T value to be added in list of type T(generic).
	 * @return nothing.
	 */
	void add(T value) {
		Node<T> node = new Node<T>(value);
		// if list is empty
		if (start == null) {
			start = node;
		}// if list is a=created previously
		else {
			Node<T> currentNode = start;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
		}

	}

	/**
	 * this function used get value at index position.
	 * 
	 * @param index
	 *            position of element
	 * @return T data at index position if invalid index than null
	 */
	public T get(int index) {
		int currentIndex = 0;
		T data = null;
		int listSize = getSize();

		if (start == null || index >= listSize) {
			data = null;

		} else {
			Node<T> currentNode = start;
			while (currentNode != null) {
				if (currentIndex == index) {
					data = currentNode.getData();
					break;
				}
				currentNode = currentNode.getNext();
				currentIndex++;
			}
		}
		return data;

	}

	/**
	 * this function used print whole link list.
	 * 
	 * 
	 * @return nothing
	 */
	void print() {
		if (start == null) {
			System.out.println("No list found");

		} else {
			Node<T> currentNode = start;
			while (currentNode != null) {
				System.out.print(currentNode.getData() + "\n");
				currentNode = currentNode.getNext();
			}

		}
	}

	/**
	 * this function used calculate size of link list.
	 * 
	 * 
	 * @return int size of link list.
	 */
	int getSize() {
		int size = 0;
		if (start == null) {
			size = 0;
		} else {
			Node<T> currentNode = start;
			while (currentNode != null) {
				size++;
				currentNode = currentNode.getNext();
			}
		}
		return size;
	}

}