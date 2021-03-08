package problem2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for UniqueCharCount
 * 
 * @author Anuj khandelwal
 *
 */
public class UniqueCharCountTest {
	UniqueCharacter uniqueCharacter = new UniqueCharacter();

	/**
	 * test cases for all unique character, all duplicate character , few
	 * duplicate character and single character.
	 */
	@Test
	public void test() {
		assertEquals(3, uniqueCharacter.countCharacter("aabbcc"));
		assertEquals(1, uniqueCharacter.countCharacter("a"));
		assertEquals(1, uniqueCharacter.countCharacter("aaaaaa"));
		assertEquals(4, uniqueCharacter.countCharacter("abcdabcd"));
		assertEquals(3, uniqueCharacter.countCharacter("abc"));

	}

}
