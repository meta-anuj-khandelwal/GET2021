package Specification;

/**
 * <h1>Marksheet</h1>
 * <p>
 * 
 * This class is designed to perform operations on grades i.e average marks,
 * maximum ,minimum marks and student pass percentage.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-02-28
 */
public class Marksheet {
	// total number of students.
	private int studentCount;
	// array contain grades of students.
	private int grades[];

	/**
	 * @param studentCount
	 *            total number of students.
	 * @param grades
	 *            array contain grades of students.
	 */
	public Marksheet(int studentCount, int grades[]) {
		this.studentCount = studentCount;
		this.grades = new int[this.studentCount];
		for (int index = 0; index < studentCount; index++) {
			this.grades[index] = grades[index];
		}
	}

	/**
	 * This function is used to calculate average marks.
	 * 
	 * @return float average marks of student
	 * @throws ArithmeticException
	 *             if studentCount = 0
	 * 
	 */
	public float average() {
		float average = 0.0f;
		for (int index = 0; index < studentCount; index++) {
			average += grades[index];
		}

		if (studentCount == 0)
			throw new ArithmeticException();
		else
			average = average / studentCount;
		return toTwoDecimalPlaces(average);
	}

	/**
	 * This function is used to get maximum marks.
	 * 
	 * @return int maximum marks from all grades.
	 */
	public int maximum() {
		int maximumGrades = 0;
		for (int index = 0; index < studentCount; index++) {
			if (maximumGrades < grades[index]) {
				maximumGrades = grades[index];
			}
		}
		return maximumGrades;
	}

	/**
	 * This function is used to get minimum marks.
	 * 
	 * @return int minimum marks from all grades.
	 */
	public int mainimum() {
		int mainimumGrades = Integer.MAX_VALUE;
		for (int index = 0; index < studentCount; index++) {
			if (mainimumGrades > grades[index]) {
				mainimumGrades = grades[index];
			}
		}
		return mainimumGrades;
	}

	/**
	 * This function is used to calculate student pass percentage.
	 * 
	 * @return float student pass percentage
	 * @throws ArithmeticException
	 *             if studentCount = 0
	 * 
	 */
	public float studentPassPercentage() {
		float passPercentage = 0.0f;
		int studentPassCount = 0;
		for (int index = 0; index < studentCount; index++) {
			if (grades[index] >= 40) {
				studentPassCount++;
			}
		}

		if (studentCount == 0)
			throw new ArithmeticException();
		else
			passPercentage = ((float) studentPassCount / studentCount) * 100;
		return toTwoDecimalPlaces(passPercentage);
	}

	/**
	 * This function is used to get floating-point values upto 2 decimal places.
	 * 
	 * @param number
	 *            float number to be round of
	 * @return float floating-point values upto 2 decimal places
	 */
	private static float toTwoDecimalPlaces(float number) {
		return Float.valueOf(String.format("%.2f", number));
	}

	
}
