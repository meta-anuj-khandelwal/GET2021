package Testing;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LargestMirrorTest {
	// array of input for function
	private int input[];
	// expected output for function
	private int expectedResult;

	/**
	 * @param input
	 *            array of input for function
	 * @param expectedResult
	 *            expected output for function
	 */
	public LargestMirrorTest(int input[], int expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	}

	/*
	 * Test cases for largest mirror If there is mirror from start and last
	 * index. 2.If there is mirror between start and last index
	 */
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 3 },
				{ new int[] { 7, 1, 4, 9, 7, 4, 1 }, 2 },
				{ new int[] { 1, 2, 1, 4 }, 3 },
				{ new int[] { 1, 4, 5, 3, 5, 4, 1 }, 7 }, });
	}

	/**
	 * this function is used to perform JUnit testing on
	 * arrOperation.mirror(array)
	 * 
	 * @return nothing
	 */
	@Test
	public void largestMirrorTest() {
		ArrOperation arrOperation = new ArrOperation();
		assertEquals(expectedResult, arrOperation.mirror(input));
	}
}
