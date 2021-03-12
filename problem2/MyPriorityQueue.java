package problem2;

import java.util.Arrays;

public class MyPriorityQueue implements PriorityQueue<Node> {
	// maximum size array
	final int maxSize;
	// queue array
	Node queue[];
	// size of queue
	int size = 0;

	/**
	 * @param maxSize
	 *            maximum size array
	 */
	public MyPriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		queue = new Node[this.maxSize];
	}

	/**
	 * This function is used to check queue is empty or not
	 * 
	 * @return boolean true if queue is empty else false
	 */
	@Override
	public boolean isEmpty() {
		boolean empty;
		if (size == 0) {
			empty = true;
		} else {
			empty = false;
		}
		return empty;
	}

	/**
	 * This function is used to check queue is full or not
	 * 
	 * @return boolean true if queue is full else false
	 */
	@Override
	public boolean isFull() {
		boolean full;
		if (this.size == this.maxSize) {
			full = true;
		} else {
			full = false;
		}
		return full;
	}

	/**
	 * 
	 * @param value
	 *            value to be enter in queue
	 * @return boolean true if enqueue successful else false
	 */
	@Override
	public boolean enQueue(Node value) {
		boolean addResult = false;
		if (isFull()) {
			addResult = false;
			// empty case
		} else if (isEmpty()) {
			queue[0] = value;
			size++;
			addResult = true;
		} else {
			// finding position of new node value according to it's priority and
			// shift all element by 1 position
			int index = size - 1;
			while ((index >= 0)
					&& (queue[index].getData().compareTo(value.getData()) < 0)) {
				queue[index + 1] = queue[index];
				index--;
			}
			queue[index + 1] = value;
			size++;
			addResult = true;
		}
		return addResult;
	}

	/**
	 * This function is used to delete value from queue
	 * 
	 * @return Integer deleted value from queue
	 */
	@Override
	public Node deQueue() {

		Node data = null;
		if (isEmpty()) {
			data = null;
		} else {
			// deletion of node from front of queue and shift all value 1
			// position left.
			data = queue[0];
			for (int index = 0; index < size - 1; index++) {
				queue[index] = queue[index + 1];
			}
			size--;
		}
		return data;
	}

	/**
	 * @return int size of queue
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * this function print content of queue
	 */
	public void print() {
		for (int index = 0; index < size; index++) {
			System.out.println(queue[index]);
		}
	}

}
