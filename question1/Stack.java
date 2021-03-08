package question1;

public interface Stack<T> {
	/**
	 * this function is used get top of stack data
	 * 
	 * @return T top of stack data
	 */
	public T peek();

	/**
	 * this function is used pop stack
	 * 
	 * @return T top of stack data
	 */
	public T pop();

	/**
	 * this function is used get size of stack
	 * 
	 * @return T size of stack
	 */
	public int size();

	/**
	 * @param operand
	 *            T to be pushed in Stack
	 * @return boolean true if operand pushed in to stack else false
	 */
	boolean push(T operand);
}
