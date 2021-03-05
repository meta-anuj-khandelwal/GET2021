package Testing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ClumpTest {
	// array of input for function
	private int input[];
	// expected result
	private int expectedResult;

	public ClumpTest(int input[], int expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	}

	/*
	 * Test cases for clump test 1. when every element has same adjacent
	 * element. 2. when all are same element. 3. when elements are negative and
	 * positive.
	 */
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 1, 1, 2, 2, 3, 3, 4, 4 }, 4 },
				{ new int[] { 1, 1, 2, 1, 1 }, 2 },
				{ new int[] { 1, 1, 1, 1, 1 }, 1 },
				{ new int[] { -2, -2, 34, 12 }, 1 }, });
	}

	/**
	 * this function is used to perform JUnit testing on
	 * arrOperation.clumps(array)
	 *
	 * @return nothing
	 */
	@Test
	public void clumpTest() {
		ArrOperation arrOperation = new ArrOperation();
		assertEquals(expectedResult, arrOperation.clumps(input));
	}
}
