package Recursion;

/**
 * <h1>MathOperations</h1>
 * <p>
 * This class designed to calculate HCF and LCM <br>
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-02
 */
public class MathOperations {
	/**
	 * This function helping function for lcm() function.
	 * 
	 * @param firstNumber
	 *            int This parameter contains first value for LCM calculation.
	 * @param secondNumber
	 *            int This parameter contains second value for LCM calculation.
	 * @param mutliplier
	 *            int This parameter contains multiplier of firstNumber.
	 * @return int LCM of two numbers.
	 * @throws ArithmeticException
	 *             if any of number is 0.
	 * 
	 */
	private static int findLCM(int firstNumber, int secondNumber, int mutliplier) {
		if (firstNumber == 0 || secondNumber == 0) {
			throw new ArithmeticException();
		}
		mutliplier += secondNumber;
		if (mutliplier % firstNumber == 0 && mutliplier % secondNumber == 0) {
			return mutliplier;
		}
		return findLCM(firstNumber, secondNumber, mutliplier);
	}

	/**
	 * This function is used to calculate LCM of two numbers.
	 * 
	 * @param firstNumber
	 *            int This parameter contains first value for LCM calculation.
	 * @param secondNumber
	 *            int This parameter contains second value for LCM calculation.
	 *
	 * @return int LCM of two numbers.
	 * @throws ArithmeticException
	 *             if any of number is 0.
	 * 
	 */
	public static int lcm(int firstNumber, int secondNumber) {
		return findLCM(firstNumber, secondNumber, 0);
	}

	/**
	 * This function is used to calculate HCF of two numbers.
	 * 
	 * @param firstNumber
	 *            int This parameter contains first value for HCF calculation.
	 * @param secondNumber
	 *            int This parameter contains second value for HCF calculation.
	 *
	 * @return int HCF of two numbers.
	 * 
	 */
	public static int hcf(int firstNumber, int secondNumber) {
		if (firstNumber == 0) {
			return secondNumber;
		} else {
			return hcf(secondNumber % firstNumber, firstNumber);
		}

	}

}
