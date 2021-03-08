package problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class make collection of Employee
 * 
 * @author anuj.khandelwal_meta
 *
 */
public class EmployeeCollection {
	// ArrayList of Employee class
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();

	/**
	 * This function add employee to employee list
	 * 
	 * @param employee
	 *            object of Employee to be added in list.
	 * @return boolean true if insertion success else return false.
	 */
	public boolean add(Employee employee) {
		boolean isAdded = false;
		// if employee already in list
		if (employeeList.contains(employee)) {
			isAdded = false;
		} else {
			employeeList.add(employee);
			isAdded = true;

		}

		return isAdded;
	}

	/**
	 * sort employee list by empId
	 */
	public void sortByEmpId() {
		// comparator for sorting by empId
		Comparator<Employee> empIdComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return emp1.getEmpId() - emp2.getEmpId();
			}
		};
		// sorting
		Collections.sort(employeeList, empIdComparator);
	}

	/**
	 * sort employee list by empName
	 */
	public void sortByEmpName() {
		// comparator for sorting by empName
		Comparator<Employee> empNameComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee emp1, Employee emp2) {
				return emp1.getName().compareTo(emp2.getName());
			}
		};
		// sorting
		Collections.sort(employeeList, empNameComparator);
	}

	/**
	 * print employee details from list
	 */
	public void print() {
		for (int employeeIndex = 0; employeeIndex < employeeList.size(); employeeIndex++) {
			System.out.println(employeeList.get(employeeIndex));
		}
	}

}
