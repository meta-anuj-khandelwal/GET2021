package Testing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FixXYTest {
	// array of input for function
	private int input[];
	// array of input for function
	private int expectedResult[];
	// value for x
	private int x;
	// value for y
	private int y;

	/**
	 * @param input
	 *            array of input for function
	 * @param expectedResult
	 *            array of input for function
	 * @param x
	 *            value for x
	 * @param y
	 *            value for y
	 */
	public FixXYTest(int[] input, int[] expectedResult, int x, int y) {

		this.input = input;
		this.expectedResult = expectedResult;
		this.x = x;
		this.y = y;
	}

	/*
	 * Test cases for FixXYTest() test If there are equal numbers of X and Y in the
	 * input array
	 */
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 5, 4, 9, 4, 9, 5 },
						new int[] { 9, 4, 5, 4, 5, 9 }, 4, 5 },
				{ new int[] { 1, 4, 1, 5 }, new int[] { 1, 4, 5, 1 }, 4, 5 },
				{ new int[] { 1, 4, 1, 5, 5, 4, 1 },
						new int[] { 1, 4, 5, 1, 1, 4, 5 }, 4, 5 },
				{ new int[] { 1, 4, 1, 4, 1, 5, 5 },
						new int[] { 1, 4, 5, 4, 5, 1, 1 }, 4, 5 }, });
	}

	/**
	 * this function is used to perform JUnit testing on
	 * arrOperation.fixXY(array, x, y)
	 * 
	 * @return nothing
	 */
	@Test
	public void fixxyTest() {
		ArrOperation arrOperation = new ArrOperation();
		assertArrayEquals(expectedResult, arrOperation.fixXY(input, 4, 5));
	}

	/*
	 * 1. If array is empty. 2.If there are unequal numbers of X and Y in the
	 * input array. 3.If two adjacents X values are there
	 */
	@Test(expected = AssertionError.class)
	public void fixxyTest1() {
		ArrOperation arrOperation = new ArrOperation();
		assertArrayEquals(expectedResult,
				arrOperation.fixXY(new int[] {}, 4, 5));
		assertArrayEquals(expectedResult,
				arrOperation.fixXY(new int[] { 1, 4, 4, 5, 5, 4, 5 }, 4, 5));
		assertArrayEquals(expectedResult,
				arrOperation.fixXY(new int[] { 5, 4, 4, 5, 5, 4, 5 }, 4, 5));
	}

}
