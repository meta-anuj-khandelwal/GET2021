package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for Employee collection
 * 
 * @author Anuj khandelwal
 *
 */
public class EmpCollectionTest {
	EmployeeCollection employeeCollection = new EmployeeCollection();
	Employee emp1 = new Employee(1, "John", "Alwar");
	Employee emp2 = new Employee(2, "Ram", "Jaipur");
	Employee emp3 = new Employee(3, "Shayam", "Delhi");
	Employee emp4 = new Employee(1, "Mohan", "Mumbai");
	Employee emp5 = new Employee(4, "Pankaj", "Bhopal");
	Employee emp6 = new Employee(5, "Mohan", "Alwar");

	/**
	 * test cases for adding original and duplicate employee data
	 */
	@Test
	public void test() {
		assertEquals(true, employeeCollection.add(emp1));
		assertEquals(true, employeeCollection.add(emp2));
		assertEquals(true, employeeCollection.add(emp3));
		assertEquals(false, employeeCollection.add(emp4));
		assertEquals(true, employeeCollection.add(emp5));
		assertEquals(true, employeeCollection.add(emp6));
	}

}
