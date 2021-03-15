package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDictionary {

	@Test
	public void testJSON() {
		String json = "{data: [{ key: 1,value: a },{ key: 2,value: b },{ key: 3,value: c },{ key: 4,value: d },{ key: 5,value: e }]}";

		BSTDictionary bstDictionary = new BSTDictionary(json);

		assertEquals("a", bstDictionary.get("1"));

		assertEquals("e", bstDictionary.get("5"));

	}

	@Test
	public void testInsertion() {
		BSTDictionary bstDictionary = new BSTDictionary();
		assertEquals(true, bstDictionary.insert("1", "A"));
		assertEquals(true, bstDictionary.insert("2", "B"));
		assertEquals(false, bstDictionary.insert("1", "A"));
	}

	@Test
	public void testDeletion() {
		String json = "{data: [{ key: 1,value: a },{ key: 2,value: b },{ key: 3,value: c },{ key: 4,value: d },{ key: 5,value: e }]}";

		BSTDictionary bstDictionary = new BSTDictionary(json);

		assertEquals(true, bstDictionary.delete("1"));
		assertEquals(false, bstDictionary.delete("1"));
	}

	@Test
	public void testget() {
		String json = "{data: [{ key: 1,value: a },{ key: 2,value: b },{ key: 3,value: c },{ key: 4,value: d },{ key: 5,value: e }]}";

		BSTDictionary bstDictionary = new BSTDictionary(json);
		assertEquals("a", bstDictionary.get("1"));
		assertEquals("b", bstDictionary.get("2"));
		assertEquals(null, bstDictionary.get("10"));
	}
}
