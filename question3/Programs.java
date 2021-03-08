package question3;

/**
 * <h1>Programs</h1>
 * <p>
 * This class is used to manage college counseling programs.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-04
 */
public class Programs {
	String courseName;
	int capacity;

	/**
	 * @param courseName
	 *            name of course
	 * @param capacity
	 *            capacity of course
	 */
	public Programs(String courseName, int capacity) {
		this.courseName = courseName;
		this.capacity = capacity;
	}

	/**
	 * @return the course name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @return the course capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * decrease course capacity if allocated to student
	 */

	public void decreaseCapacity() {
		capacity--;
	}

	/**
	 * check this program has more capacity to add student
	 * 
	 * @return boolean true program if has more capacity to add student else
	 *         false
	 */
	public boolean hasCapacity() {
		boolean isAvailable = false;
		if (capacity != 0) {
			isAvailable = true;
		} else {
			isAvailable = false;
		}
		return isAvailable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Programs [courseName=" + courseName + ", capacity=" + capacity
				+ "]";
	}

}
