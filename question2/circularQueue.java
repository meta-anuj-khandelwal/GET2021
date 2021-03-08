package question2;

/**
 * <h1>circularQueue</h1>
 * <p>
 * This class is used to implement circular queue data structure.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-04
 */
public class circularQueue implements Queue<Integer> {

	private Integer[] queue = new Integer[maxSize];
	private int frontIndex = -1;
	private int rearIndex = -1;

	/**
	 * This function is used to check queue is empty or not
	 * 
	 * @return boolean true if queue is empty else false
	 */
	@Override
	public boolean isEmpty() {
		boolean empty;
		if (frontIndex == -1) {
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
		if (frontIndex == (rearIndex + 1) % maxSize) {
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
	public boolean enqueue(Integer value) {
		boolean addResult = false;
		if (isFull()) {
			addResult = false;
		} else if (isEmpty()) {
			frontIndex++;
			rearIndex++;
			queue[rearIndex] = value;
			addResult = true;
		} else {
			rearIndex = (rearIndex + 1) % maxSize;
			queue[rearIndex] = value;
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
	public Integer dequeue() {
		Integer data;
		if (isEmpty()) {
			data = null;
		}
		// if only one element in queue
		else if (frontIndex == rearIndex) {
			data = queue[frontIndex];
			frontIndex = -1;
			rearIndex = -1;
		} else {
			data = queue[frontIndex];
			frontIndex = (frontIndex + 1) % maxSize;
		}
		return data;
	}

}
