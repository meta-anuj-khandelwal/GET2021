package Testing;

/**
 * <h1>ArrOperation</h1>
 * <p>
 * This class is used to perform various operations (Mirror, fixXY ,find count
 * of clumps,Split array) on array
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-04
 */
public class ArrOperation {
	/**
	 * This function use to get highest size mirror from array.Mirror section in
	 * an array is a group of contiguous elements such that somewhere in the
	 * array, the same group appears in reverse order.
	 * 
	 * @param array
	 *            int[] array of numbers to find mirror size
	 * @return int highest size of mirror
	 */
	public int mirror(int[] array) {

		int localMirrorLength = 0;
		int maxMirrorLength = 0;
		try {
			int length = array.length;

			// comparing array element from start
			for (int frontIndex = 0; frontIndex < length; frontIndex++) {
				// comparing array element from back end
				for (int backIndex = length - 1; backIndex >= 0
						&& (frontIndex + localMirrorLength) < length; backIndex--) {
					if (array[frontIndex + localMirrorLength] == array[backIndex]) {
						localMirrorLength++;
					} else {
						maxMirrorLength = Math.max(localMirrorLength,
								maxMirrorLength);
						localMirrorLength = 0;
					}
				}
			}
			maxMirrorLength = Math.max(localMirrorLength, maxMirrorLength);
		} catch (Exception e) {
			System.err.println(e);
		}
		return maxMirrorLength;
	}

	/**
	 * This function use to get count of clumps Clump in an array is a series of
	 * 2 or more adjacent elements of the same value.
	 * 
	 * @param array
	 *            int[] array of numbers to find count of clumps
	 * @return int count of clumps in array
	 */
	public int clumps(int[] array) {
		int clumpCount = 0;
		try {
			for (int index = 0; index < array.length; index++) {
				int number = array[index];
				boolean flag = true;
				index++;
				while (index < array.length && array[index] == number) {
					if (flag) {
						clumpCount++;
						flag = false;
					}
					index++;
				}
				index--;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return clumpCount;
	}

	/**
	 * This function use to get array rearranged array so that every X is
	 * immediately followed by a Y.
	 * 
	 * @param array
	 *            int[] array of numbers to be rearranged.
	 * @return int[] rearranged array such that every X is immediately followed
	 *         by a Y.
	 * @throws AssertionError
	 *             If array is empty, If there are unequal numbers of X and Y in
	 *             the input array, If two adjacents X values are there, If X
	 *             occurs at the last index of the array.
	 */
	public int[] fixXY(int[] array, int x, int y) {
		if (array.length == 0) {
			throw new AssertionError("Empty Array");
		}
		if (array[array.length - 1] == x) {
			throw new AssertionError("X occurs at the last index of the array");

		}
		if (!isEqualCount(array, x, y)) {
			throw new AssertionError("unequal numbers of X and Y in array");
		}
		int index_x = 0;
		int index_y = 0;
		int index_y_previous = 0;
		try {
			for (index_x = 0; index_x < array.length - 1; index_x++) {

				if (array[index_x] == x) {
					if (array[index_x + 1] == x) {
						throw new AssertionError(
								"two adjacents X values are there");
					}
					for (index_y = index_y_previous; index_y < array.length; index_y++) {
						if (array[index_y] == y && array[index_x + 1] != x) {
							int temp = array[index_x + 1];
							array[index_x + 1] = array[index_y];
							array[index_y] = temp;
							index_y_previous = index_x + 2;
							break;

						}
					}
				}

			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return array;
	}

	/**
	 * this function is used to check count of x and y in array are same or not.
	 * 
	 * @param array
	 *            int[] array of numbers in which count of x and y to be
	 *            compared
	 * @return boolean return true if count of x and y is equal else false.
	 */
	private boolean isEqualCount(int array[], int x, int y) {
		int countx = 0;
		int county = 0;
		for (int index = 0; index < array.length; index++) {
			if (array[index] == x) {
				countx++;
			} else if (array[index] == y) {
				county++;
			}
		}
		return countx == county;
	}

	/**
	 * this function give split index of the input array so that the sum of the
	 * numbers on one side is equal to the sum of the numbers on the other side
	 * .
	 * 
	 * @param array
	 *            int[] array of numbers to find split index.
	 * @return int split index if condition satisfied else -1.
	 */
	public int splitArray(int[] array) {
		int sum = 0;
		int splitIndex = -1;
		try {
			for (int index = 0; index < array.length; index++) {
				sum += array[index];
			}

			int reverseSum = 0;
			for (int index = array.length - 1; index >= 0; index--) {
				reverseSum += array[index];
				sum -= array[index];
				if (sum == reverseSum) {
					splitIndex = index;
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return splitIndex;
	}

}