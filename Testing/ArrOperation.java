package Testing;

public class ArrOperation {
	public int mirror(int[] array) {
		int localMirrorLength = 0;
		int maxMirrorLength = 0;
		int length = array.length;
		for (int frontIndex = 0; frontIndex < length; frontIndex++) {
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
		return maxMirrorLength;
	}

	public int clumps(int[] array) {
		int clumpCount = 0;
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
		return clumpCount;
	}

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
		for (index_x = 0; index_x < array.length - 1; index_x++) {

			if (array[index_x] == x) {
				if (array[index_x + 1] == x) {
					throw new AssertionError("two adjacents X values are there");
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
		return array;
	}

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

	public int splitArray(int[] array) {
		int sum = 0;
		int splitIndex = -1;
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
		return splitIndex;
	}

}