package question1;

/**
 * <h1>OperatorStack</h1>
 * <p>
 * This class is used to implement Operator Stack.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-04
 */
public class OperatorStack implements Stack<String> {
	final int maxSize = 100;
	String stack[] = new String[maxSize];
	int topIndex = -1;
	int stackSize = 0;

	/**
	 * @param operator
	 *            operator to be pushed in Stack
	 * @return boolean true if operator pushed in to stack else false
	 */
	@Override
	public boolean push(String operator) {
		boolean result = false;
		if (stackSize > maxSize) {
			result = false;
		} else {
			topIndex++;
			stack[topIndex] = operator;
			stackSize++;
			result = true;
		}
		return result;
	}

	/**
	 * this function is used get top of stack data
	 * 
	 * @return String top of stack data
	 */
	@Override
	public String peek() {
		String peekElement;
		if (stackSize == 0) {
			peekElement = null;
		} else {
			peekElement = stack[topIndex];
		}
		return peekElement;
	}

	/**
	 * this function is used pop stack
	 * 
	 * @return T top of stack data
	 */
	@Override
	public String pop() {
		String peekElement;
		if (stackSize == 0) {
			peekElement = null;
		} else {
			peekElement = stack[topIndex];
			topIndex--;
			stackSize--;
		}
		return peekElement;
	}

	/**
	 * this function is used get size of stack
	 * 
	 * @return int size of stack
	 */
	@Override
	public int size() {

		return stackSize;
	}

}
