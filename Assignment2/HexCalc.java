package Assignment2;

public class HexCalc {
	private static int base = 16;

	/**
	 * This function is used to add two hexadecimal number.
	 * 
	 * @param firstNumber
	 *            String This parameter contains the first number .
	 * @param secondNumber
	 *            String This parameter contains the second number .
	 * @return String sum of two hexadecimal number in String.
	 * 
	 */
	public static String add(String firstNumber, String secondNumber) {
		int firstDecimalNumber = Integer.parseInt(hexToDecimal(firstNumber));
		int secondDecimalNumber = Integer.parseInt(hexToDecimal(secondNumber));
		int sum = firstDecimalNumber + secondDecimalNumber;
		return DecimalToHex(sum);
	}

	/**
	 * This function is used to subtract two hexadecimal number.
	 * 
	 * @param firstNumber
	 *            String This parameter contains the first number .
	 * @param secondNumber
	 *            String This parameter contains the second number .
	 * @return String subtraction of two hexadecimal number in String.
	 * 
	 */
	public static String subtract(String firstNumber, String secondNumber) {
		int firstDecimalNumber = Integer.parseInt(hexToDecimal(firstNumber));
		int secondDecimalNumber = Integer.parseInt(hexToDecimal(secondNumber));
		int difference = firstDecimalNumber - secondDecimalNumber;
		return DecimalToHex(difference);
	}

	/**
	 * This function is used to multiply two hexadecimal number.
	 * 
	 * @param firstNumber
	 *            String This parameter contains the first number .
	 * @param secondNumber
	 *            String This parameter contains the second number .
	 * @return String multiplication of two hexadecimal number in String.
	 * 
	 */
	public static String multiply(String firstNumber, String secondNumber) {
		int firstDecimalNumber = Integer.parseInt(hexToDecimal(firstNumber));
		int secondDecimalNumber = Integer.parseInt(hexToDecimal(secondNumber));
		int multiplication = firstDecimalNumber * secondDecimalNumber;
		return DecimalToHex(multiplication);
	}

	/**
	 * This function is used to divide two hexadecimal number.
	 * 
	 * @param firstNumber
	 *            String This parameter contains the first number .
	 * @param secondNumber
	 *            String This parameter contains the second number .
	 * @return String division of two hexadecimal number in String.
	 * 
	 */

	public static String divide(String firstNumber, String secondNumber) {
		int firstDecimalNumber = Integer.parseInt(hexToDecimal(firstNumber));
		int secondDecimalNumber = Integer.parseInt(hexToDecimal(secondNumber));
		int division = firstDecimalNumber / secondDecimalNumber;
		return DecimalToHex(division);
	}

	/**
	 * This function is used to check two hexadecimal number are equal or not.
	 * 
	 * @param firstNumber
	 *            String This parameter contains the first number .
	 * @param secondNumber
	 *            String This parameter contains the second number .
	 * @return boolean true if numbers are equal.
	 * 
	 */
	public static boolean equal(String firstNumber, String secondNumber) {
		return firstNumber.equals(secondNumber);
	}

	/**
	 * This function is used to check firstNumber < secondNumber.
	 * 
	 * @param firstNumber
	 *            String This parameter contains the first number .
	 * @param secondNumber
	 *            String This parameter contains the second number .
	 * @return boolean true if nfirstNumber < secondNumber.
	 * 
	 */
	public static boolean lessThan(String firstNumber, String secondNumber) {
		int result = firstNumber.compareTo(secondNumber);
		if (result < 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This function is used to check firstNumber > secondNumber.
	 * 
	 * @param firstNumber
	 *            String This parameter contains the first number .
	 * @param secondNumber
	 *            String This parameter contains the second number .
	 * @return boolean true if nfirstNumber > secondNumber.
	 * 
	 */
	public static boolean greterThan(String firstNumber, String secondNumber) {
		int result = firstNumber.compareTo(secondNumber);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This function is used to convert hexadecimal number to decimal number.
	 * 
	 * @param Number
	 *            String This parameter contains the hexadecimal number in
	 *            String .
	 * @return String decimal number equivalent to hexadecimal number in String.
	 * 
	 */

	public static String hexToDecimal(String Number) {
		int decimalNumber = 0;
		int currentDigit;
		for (int i = Number.length() - 1; i >= 0; i--) {
			if (Character.isDigit(Number.charAt(i))) {
				currentDigit = Integer
						.parseInt(String.valueOf(Number.charAt(i)));
			} else {
				currentDigit = Number.charAt(i) - 55;
			}

			decimalNumber = decimalNumber
					+ (currentDigit * (int) (Math.pow(base, Number.length() - i
							- 1)));
		}
		return String.valueOf(decimalNumber);

	}

	/**
	 * This function is used to convert decimal number to hexadecimal number .
	 * 
	 * @param Number
	 *            int This parameter contains the decimal number in int .
	 * @return String hexadecimal number equivalent to decimal number in String.
	 * 
	 */

	public static String DecimalToHex(int Number) {
		int decimalNumber = Math.abs(Number);
		if (decimalNumber == 0) {
			return "0";
		}
		int reminder;
		char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		String hexNumber = new String();
		while (decimalNumber != 0) {
			reminder = decimalNumber % base;
			hexNumber = hex[reminder] + hexNumber;
			decimalNumber /= base;
		}
		if (Number < 0) {
			String numberComplement = add(subtract("FFFFFFF", hexNumber), "1");
			return numberComplement;
		} else {
			return hexNumber;
		}
	}

}
