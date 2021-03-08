package problem2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provide facility to count unique character in string
 * 
 * @author anuj.khandelwal_meta
 *
 */
public class UniqueCharacter {
	// store previously processed data of string
	private HashMap<String, Integer> characterCountMap = new HashMap<String, Integer>();

	/**
	 * This function count unique character in string
	 * 
	 * @param string
	 *            String in which unique characters to be count.
	 * @return number of unique character.
	 */
	public int countCharacter(String string) {
		int uniqueCharacterCount = 0;
		// if string processed previously
		if (characterCountMap.containsKey(string)) {
			uniqueCharacterCount = characterCountMap.get(string);
			System.out.println("Result from cache");
		} else {
			// making set of character to store unique character of string
			Set<Character> characterSet = new HashSet<Character>();
			for (int index = 0; index < string.length(); index++) {
				characterSet.add(string.charAt(index));
			}
			// getting unique characters
			uniqueCharacterCount = characterSet.size();
			characterCountMap.put(string, uniqueCharacterCount);
		}
		return uniqueCharacterCount;
	}
}
