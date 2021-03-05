package Testing;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FixXYTest {

	private int input[];
	private int expectedResult;

	public FixXYTest(int input[], int expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 5, 4, 9, 4, 9, 5 },
						new int[] {9, 4, 5, 4, 5, 9 } },
				{ new int[] { 1, 4, 1, 5 }, new int[] { 5, 4, 9, 4, 9, 5 } },
				{ new int[] { 1, 4, 1, 5 }, new int[] { 5, 4, 9, 4, 9, 5 } },
				{ new int[] { -1, -1, 2, -99, -99 },
						new int[] { 5, 4, 9, 4, 9, 5 } }, });
	}

	@Test
	public void fixxyTest() {
		ArrOperation arrOperation = new ArrOperation();
		assertEquals(expectedResult, arrOperation.clumps(input));
	}
}
