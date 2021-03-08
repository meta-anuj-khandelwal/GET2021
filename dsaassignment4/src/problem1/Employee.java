package problem1;

public class Employee {
	// employee id
	private int empId;
	// employee name
	private String name;
	// employee address
	private String address;

	/**
	 * @param empId
	 *            id of employee
	 * @param name
	 *            name of employee
	 * @param address
	 *            address of employee
	 */
	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId
	 *            the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * function to check objects are equal or not.
	 * 
	 * @param obj
	 *            Object Object to be compare with this object.
	 * @return boolean true if obj is equal to this employee.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEqual = false;
		// check for reference
		if (this == obj)
			isEqual = true;
		// check if null or same class object
		else if (obj == null || obj.getClass() != this.getClass())
			isEqual = false;
		else {
			Employee employee = (Employee) obj;
			isEqual = (this.empId == employee.empId);
		}
		return isEqual;
	}

	/**
	 * generate hash code for Employee object.
	 */
	@Override
	public int hashCode() {
		return this.empId;
	}

	@Override
	public String toString() {
		return "empId=" + empId + ", name=" + name + ", address=" + address;
	}

}
