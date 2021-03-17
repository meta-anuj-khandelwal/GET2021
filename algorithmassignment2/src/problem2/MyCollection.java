package problem2;

/**
 * This class is designed to perform insertion sort on MyLinkedList
 * 
 * @author anuj.khandelwal_meta
 *
 */
public class MyCollection {

	/**
	 * Quick Sort for the Employees Type Linked List
	 * 
	 * @param empList
	 *            Linked List of the employee type
	 */
	public static void quickSort(Node<Employees> head, Node<Employees> tail) {

		Node<Employees> start = head;
		Node<Employees> end = tail;

		if (start == null || start == end.getNext() || start == end) {
			return;
		}

		Node<Employees> prevPivot = partition(start, end);
		quickSort(start, prevPivot);

		if (prevPivot != null && prevPivot == start) {
			quickSort(prevPivot.getNext(), end);
		} else if (prevPivot != null && prevPivot.getNext() != null) {
			quickSort(prevPivot.getNext().getNext(), end);
		}
	}

	// Private helper method for making quick sort
	private static Node<Employees> partition(Node<Employees> start,
			Node<Employees> end) {

		if (start == end || start == null || end == null) {
			return start;
		}

		Node<Employees> prevPivot = start;
		Node<Employees> current = start;

		Node<Employees> pivot = end;

		int pivotage = end.getData().getAge();
		int pivotSlary = end.getData().getSalary();
		int pivotId = end.getData().getEmployeeId();
		String pivotName = end.getData().getName();

		while (start != end) {

			if (start.getData().compareTo(pivot.getData()) > 0) {
				System.out.println("m chala ");
				prevPivot = current;

				int tempSalary = current.getData().getSalary();
				String tempName = current.getData().getName();
				int tempId = current.getData().getEmployeeId();
				int tempAge = current.getData().getAge();

				current.getData().setSalary(start.getData().getSalary());
				current.getData().setName(start.getData().getName());
				current.getData()
						.setEmployeeId(start.getData().getEmployeeId());
				current.getData().setAge(start.getData().getAge());

				start.getData().setSalary(tempSalary);
				start.getData().setName(tempName);
				start.getData().setEmployeeId(tempId);
				start.getData().setAge(tempAge);

				current = current.getNext();
			}
			start = start.getNext();
		}

		int temp = current.getData().getSalary();
		int tempAge = current.getData().getAge();
		String tempName = current.getData().getName();
		int tempId = current.getData().getEmployeeId();

		current.getData().setSalary(pivotSlary);
		current.getData().setName(pivotName);
		current.getData().setEmployeeId(pivotId);
		current.getData().setAge(pivotage);

		end.getData().setSalary(temp);
		end.getData().setAge(tempAge);
		end.getData().setEmployeeId(tempId);
		end.getData().setName(tempName);

		return prevPivot;
	}
}