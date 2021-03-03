package Recursion;

/**
 * <h1>Search</h1>
 * <p>
 * This class designed to perform searching operation using recursive and binary
 * search algorithm<br>
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-02
 */
public class Search {
	/**
	 * This is helper function used for recursive linear search.
	 * 
	 * @param numbers
	 *            Array of numbers from which searching will perform.
	 * @param searchNumber
	 *            This parameter contains number to be find numbers array.
	 * @param index
	 *            int index for which recursive function is searching
	 *            searchNumber
	 * @return int index of searchNumber in numbers if number not found than
	 *         return -1.
	 * 
	 * 
	 */
	private static int linearSearchRecursive(int numbers[], int searchNumber,
			int index) {
		if (index == numbers.length) {
			return -1;
		}
		if (numbers[index] == searchNumber) {
			return index;
		}
		return linearSearchRecursive(numbers, searchNumber, ++index);
	}

	/**
	 * This is helper function used for recursive binary search.
	 * 
	 * @param numbers
	 *            Array of numbers from which searching will perform.
	 * @param searchNumber
	 *            This parameter contains number to be find numbers array.
	 * @param lowIndex
	 *            int low index consider for searching.
	 * @param highIndex
	 *            int high index consider for searching.
	 * @return int index of searchNumber in numbers if number not found than
	 *         return -1.
	 * 
	 * 
	 */
	private static int binarySearchRecursive(int[] numbers, int searchNumber,
			int lowIndex, int highIndex) {

		if (highIndex >= lowIndex) {

			int middleIndex = (highIndex + lowIndex) / 2;
			if (numbers[middleIndex] == searchNumber) {

				return middleIndex;

			} else if (numbers[middleIndex] > searchNumber) {

				return binarySearchRecursive(numbers, searchNumber, lowIndex,
						middleIndex - 1);

			} else if (numbers[middleIndex] < searchNumber) {

				return binarySearchRecursive(numbers, searchNumber,
						middleIndex + 1, highIndex);

			}
		}
		return -1;
	}

	/**
	 * This function is used for recursive linear search.
	 * 
	 * @param numbers
	 *            Array of numbers from which searching will perform.
	 * @param searchNumber
	 *            This parameter contains number to be find numbers array.
	 * @return int index of searchNumber in numbers if number not found than
	 *         return -1.
	 * 
	 * 
	 */
	public static int linearSearch(int numbers[], int searchNumber) {
		return linearSearchRecursive(numbers, searchNumber, 0);
	}

	/**
	 * This function is used for recursive binary search.
	 * 
	 * @param numbers
	 *            Array of numbers from which searching will perform.
	 * @param searchNumber
	 *            This parameter contains number to be find numbers array.
	 * @return int index of searchNumber in numbers if number not found than
	 *         return -1.
	 * 
	 */
	public static int binarySearch(int numbers[], int searchNumber) {
		return binarySearchRecursive(numbers, searchNumber, 0,
				numbers.length - 1);
	}

}
