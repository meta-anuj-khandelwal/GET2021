package question3;

import java.util.ArrayList;

/**
 * <h1>Student</h1>
 * <p>
 * This class is used to manage student for counseling.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-04
 */
public class Student {
	String name = new String();
	ArrayList<String> courseChoiceList = new ArrayList<String>();
	String programAllocated = new String();

	/**
	 * @param name
	 *            name of student
	 * @param courseChoiceList
	 *            list of course in which to enroll
	 */
	public Student(String name, ArrayList<String> courseChoiceList) {
		this.name = name;
		this.courseChoiceList = courseChoiceList;
	}

	/**
	 * @return the courseChoiceList
	 */
	public ArrayList<String> getCourseChoiceList() {
		return courseChoiceList;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param courseChoiceList
	 *            the courseChoiceList to set
	 */
	public void setCourseChoiceList(ArrayList<String> courseChoiceList) {
		this.courseChoiceList = courseChoiceList;
	}

	/**
	 * @return the programAllocated
	 */
	public String getProgramAllocated() {
		return programAllocated;
	}

	/**
	 * @param programAllocated
	 *            the programAllocated to set
	 */
	public void setProgramAllocated(String programAllocated) {
		this.programAllocated = programAllocated;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", courseChoiceList="
				+ courseChoiceList + ", programAllocated=" + programAllocated
				+ "]";
	}

}
