package problem3;

public interface PriorityQueue<T> {
	/**
	 * 
	 * @param value
	 *            value to be enter in queue
	 * @return boolean true if enqueue successful else false
	 */
	public boolean enQueue(T value);

	/**
	 * This function is used to delete value from queue
	 * 
	 * @return Integer deleted value from queue
	 */
	public T deQueue();

	/**
	 * This function is used to check queue is full or not
	 * 
	 * @return boolean true if queue is full else false
	 */
	public boolean isFull();

	/**
	 * This function is used to check queue is empty or not
	 * 
	 * @return boolean true if queue is empty else false
	 */
	public boolean isEmpty();

	/**
	 * @return int size of queue
	 */
	public int size();

	/**
	 * this function print content of queue
	 */
	public void print();

}
