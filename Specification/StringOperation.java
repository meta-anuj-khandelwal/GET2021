package Specification;

import java.util.ArrayList;

/**
 * <h1>StringOperation</h1>
 * <p>
 * This class is designed to perform following operations on String <br>
 * Compare two strings<br>
 * Replace lower case characters with upper case and vice-versa<br>
 * Return the largest word of a string<br>
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-02-28
 */

public class StringOperation {
	/**
	 * This function is used to compare to String.
	 * 
	 * @param args0
	 *            String This parameter contains first String .
	 * @param args1
	 *            String This parameter contains Second String .
	 * @return 1 if args0==args1 else 0.
	 * 
	 */
	public static int compare(String args0, String args1) {
		int compareResult = 0;
		if (args0 == null && args1 == null) {
			compareResult = 1;
		} else if (args0 == null || args1 == null) {
			compareResult = 0;
		} else {
			if (args0.length() != args1.length()) {
				compareResult = 0;
			} else {
				for (int index = 0; index < args0.length(); index++) {
					if (args0.charAt(index) == args1.charAt(index)) {
						compareResult = 1;

					} else {
						compareResult = 0;
						break;
					}
				}
				if (args0.length() == 0) {
					compareResult = 1;
				}
			}
		}
		return compareResult;
	}

	/**
	 * This function is used to reverse String.
	 * 
	 * @param string
	 *            String This parameter contains String to be reversed .
	 * 
	 * @return String reverse of string.
	 * 
	 */
	public static String getReverse(String string) {
		String reverse = new String();
		if (string == null) {
			reverse = null;
		} else {
			for (int index = string.length() - 1; index >= 0; index--) {
				reverse += string.charAt(index);
			}
		}
		return reverse;

	}

	/**
	 * This function is used to replace lower case characters of String with
	 * upper case and vice-versa.
	 * 
	 * @param string
	 *            String This parameter contains String.
	 * @return String case changed string.
	 * 
	 */
	public static String changeCase(String string) {
		String updatedCaseString = new String();
		if (string == null) {
			updatedCaseString = null;
		} else {
			for (int index = 0; index < string.length(); index++) {
				if (string.charAt(index) >= 'A' && string.charAt(index) <= 'Z') {
					updatedCaseString = updatedCaseString
							+ (char) (string.charAt(index) + 32);
				} else if (string.charAt(index) >= 'a'
						&& string.charAt(index) <= 'z') {
					updatedCaseString = updatedCaseString
							+ (char) (string.charAt(index) - 32);

				} else {
					updatedCaseString += string.charAt(index);
				}
			}

		}
		return updatedCaseString;
	}

	/**
	 * This function is used to find largest word of a string
	 * 
	 * @param string
	 *            String This parameter contains String.
	 * @return String largest word from string If two words are of same length
	 *         then return last word.
	 * 
	 */
	public static String findLongest(String string) {
		ArrayList<String> stringToken = new ArrayList<String>();
		int largestIndex = 0;

		if (string == null) {
			stringToken.add(null);

		} else {
			String token = new String();
			for (int index = 0; index < string.length(); index++) {
				if (string.charAt(index) == ' ') {
					stringToken.add(token);
					token = "";
				} else {
					token += string.charAt(index);
				}
			}
			stringToken.add(token);
			for (int index = 0; index < stringToken.size(); index++) {
				if (stringToken.get(index).length() >= stringToken.get(
						largestIndex).length()) {
					largestIndex = index;
				}
			}
		}
		return stringToken.get(largestIndex);
	}

}
