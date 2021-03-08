package question1;

/**
 * <h1>OperandStack</h1>
 * <p>
 * This class is used to implement Operand stack.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-04
 */
public class OperandStack implements Stack<Integer> {
	final int maxSize = 100;
	Integer stack[] = new Integer[maxSize];
	int topIndex = -1;
	int stackSize = 0;

	/**
	 * @param operand
	 *            Integer to be pushed in operandStack
	 * @return boolean true if operand pushed in to stack else false
	 */
	@Override
	public boolean push(Integer operand) {
		boolean result = false;
		if (stackSize > maxSize) {
			result = false;
		} else {
			topIndex++;
			stack[topIndex] = operand;
			stackSize++;
			result = true;
		}
		return result;
	}

	/**
	 * this function is used get top of stack data
	 * 
	 * @return Integer top of stack data
	 */
	@Override
	public Integer peek() {
		Integer peekElement;
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
	 * @return Integer top of stack data
	 */
	@Override
	public Integer pop() {
		Integer peekElement;
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
