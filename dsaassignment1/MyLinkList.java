package dsaassignment1;

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
				System.out.print(currentNode.getData() + " ");
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

	/**
	 * this function used rotate find sub and rotate list in clockwise direction
	 * by the number of steps (n) given as input, l and r where l is the left
	 * position in list and r is the right position.
	 * 
	 * @param l
	 *            int is the left position in list
	 * @param r
	 *            int is the right position in list
	 * @param n
	 *            int number of steps
	 * @return nothing
	 */
	void rotateSublist(int l, int r, int n) {
		// if invalid value of l and r
		if (l < 1 || r > getSize() || l >= r) {
			return;
		}
		// sublist from l to r index.
		MyLinkList<T> sublist = new MyLinkList<T>();

		Node<T> currentNode = start;

		Node<T> subliststart = null;

		Node<T> sublistend = null;
		for (int index = 1; index <= this.getSize() && index <= r; index++) {

			if (index < l) {
				subliststart = currentNode;
			}

			if (index >= l) {
				sublist.add(currentNode.getData());
			}

			if (index == r) {
				sublistend = currentNode;
			}

			currentNode = currentNode.getNext();
		}

		MyLinkList<T> rotatedSublist = rotateList(sublist, n);

		if (l != 1)
			subliststart.setNext(rotatedSublist.start);
		else {
			start = rotatedSublist.start;
		}
		Node<T> currentNodeSublist = rotatedSublist.start;
		while (currentNodeSublist.getNext() != null) {
			currentNodeSublist = currentNodeSublist.getNext();
		}
		currentNodeSublist.setNext(sublistend.getNext());

	}

	/**
	 * this function used rotate list in clockwise direction by the number of
	 * steps (n) given as input
	 * 
	 * @param list
	 *            MyLinkList<T> sublist to be rotate.
	 * @param n
	 * 
	 * @return MyLinkList<T> rotated sublist
	 */
	private MyLinkList<T> rotateList(MyLinkList<T> list, int n) {
		for (int roatatationNumber = 0; roatatationNumber < n; roatatationNumber++) {
			Node<T> currentNode = list.start;
			while (currentNode.getNext().getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.getNext().setNext(list.start);
			list.start = currentNode.getNext();
			currentNode.setNext(null);
		}
		return list;
	}

	/**
	 * this function used to check loop in link list
	 * 
	 * 
	 * @return boolean true if loop exist else false;
	 */
	public boolean isLoop() {
		boolean result = false;
		// if list is empty
		if (start == null) {
			result = false;
		} else {
			Node<T> currnetNode = start;
			while (currnetNode != null) {
				// if loop exist
				if (currnetNode.isVisited()) {
					result = true;
					break;
				}
				currnetNode.setVisited(true);
				currnetNode = currnetNode.getNext();
			}

		}
		return result;
	}

	/**
	 * this function used to convert list to array
	 * 
	 * @return int[] converted array
	 */
	int[] toArray() {
		int arr[] = new int[getSize()];
		for (int index = 0; index < getSize(); index++) {
			arr[index] = (int) get(index);
		}
		return arr;
	}
}