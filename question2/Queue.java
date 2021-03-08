package question2;

/**
 * <h1>Queue</h1>
 * <p>
 * This interface is used for queue data structure.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-04
 */
public interface Queue<T> {
	final int maxSize = 5;

	/**
	 * 
	 * @param value
	 *            value to be enter in queue
	 * @return boolean true if enqueue successful else false
	 */
	public boolean enqueue(T value);

	/**
	 * This function is used to delete value from queue
	 * 
	 * @return T deleted value from queue
	 */
	public T dequeue();

	/**
	 * This function is used to check queue is empty or not
	 * 
	 * @return boolean true if queue is empty else false
	 */
	public boolean isEmpty();

	/**
	 * This function is used to check queue is full or not
	 * 
	 * @return boolean true if queue is full else false
	 */
	public boolean isFull();
}
