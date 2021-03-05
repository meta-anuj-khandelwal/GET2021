package Testing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ClumpTest {

	private int input[];
	private int expectedResult;

	public ClumpTest(int input[], int expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 1, 2, 2, 3, 4, 4 }, 2 },
				{ new int[] { 1, 1, 2, 1, 1 }, 2 },
				{ new int[] { 1, 1, 1, 1, 1 }, 1 },
				{ new int[] { -2,-2,34,12 }, 1 }, });
	}

	@Test
	public void clumpTest() {
		ArrOperation arrOperation = new ArrOperation();
		assertEquals(expectedResult, arrOperation.clumps(input));
	}
}
