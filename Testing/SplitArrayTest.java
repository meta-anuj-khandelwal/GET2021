package Testing;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SplitArrayTest {
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
	public SplitArrayTest(int input[], int expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	}

	/*
	 * Test cases for split index if their is valid split index ,if not valid
	 * split index.
	 */
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 1, 1, 1, 2, 1 }, 3 },
				{ new int[] { 2, 1, 1, 2, 1 }, -1 },
				{ new int[] { 10, 10 }, 1 }, });
	}

	/**
	 * this function is used to perform JUnit testing on
	 * arrOperation.splitArray(array)
	 * 
	 * @return nothing
	 */
	@Test
	public void splitArrayTest() {
		ArrOperation arrOperation = new ArrOperation();
		assertEquals(expectedResult, arrOperation.splitArray(input));
	}
}
