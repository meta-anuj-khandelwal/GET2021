package problem2;

public class Employees {
	// name of salary
	private String name;
	// age of salary
	private int age;
	// employee id
	private int employeeId;
	// salary of employee
	private int salary;

	/**
	 * @param name
	 *            name of salary
	 * @param age
	 *            age of salary
	 * @param employeeId
	 *            employee id
	 * @param salary
	 *            salary of employee
	 */
	public Employees(String name, int age, int employeeId, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.employeeId = employeeId;
		this.salary = salary;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * This function compare this Employees object with anotherEmployee object
	 * based on salary and age
	 * 
	 * @param anotherEmployees
	 *            object which need to compare with this object
	 * @return int if this employee > anotherEmployees return positive integer ,
	 *         if employee < anotherEmployees return negative integer if both
	 *         are equal return 0.
	 */
	public int compareTo(Employees anotherEmployees) {
		if (this.salary != anotherEmployees.salary) {
			return this.salary - anotherEmployees.salary;
		} else {
			return (anotherEmployees.age - this.age);
		}
	}

	/**
	 * This function is used to fetch Employee data
	 * 
	 * @return Employee data in String.
	 */
	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + ", employeeId=" + employeeId
				+ ", salary=" + salary;
	}

}
