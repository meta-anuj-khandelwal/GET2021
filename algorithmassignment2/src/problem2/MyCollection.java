package problem2;

/**
 * This class is designed to perform Quick sort on MyLinkedList
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
	public static void quickSort(Node<Employees> headNode,
			Node<Employees> EndNode) {

		Node<Employees> start = headNode;
		Node<Employees> end = EndNode;

		// if list is null or single node or start is next to end
		if (start == null || start == end.getNext() || start == end) {
			return;
		}
		// partition of list
		Node<Employees> previousPivot = partition(start, end);
		// recursive quick sort
		quickSort(start, previousPivot);
		/*
		 * if pivot is picked and moved to the start, that means start and pivot
		 * is same so pick from next of pivot
		 */
		if (previousPivot != null && previousPivot == start) {
			quickSort(previousPivot.getNext(), end);
		}
		/*
		 * if pivot is in between of the list, start from next of pivot, since
		 * we have previousPivot, so we move two nodes
		 */
		else if (previousPivot != null && previousPivot.getNext() != null) {
			quickSort(previousPivot.getNext().getNext(), end);
		}
	}

	/**
	 * This takes first and last node, but do not break any links in the whole
	 * linked list
	 * 
	 * @param start
	 *            start of sublist
	 * @param end
	 *            end of sublist
	 * @return previousPivot
	 */
	private static Node<Employees> partition(Node<Employees> start,
			Node<Employees> end) {

		if (start == end || start == null || end == null) {
			return start;
		}

		Node<Employees> previousPivot = start;
		Node<Employees> current = start;
		Node<Employees> pivot = end;

		int pivotage = end.getData().getAge();
		int pivotSlary = end.getData().getSalary();
		int pivotId = end.getData().getEmployeeId();
		String pivotName = end.getData().getName();

		// iterate till end

		while (start != end) {

			if (start.getData().compareTo(pivot.getData()) > 0) {

				previousPivot = current;
				// swapping current node and start node
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

		// swapping current node and end node
		int tempSalary = current.getData().getSalary();
		int tempAge = current.getData().getAge();
		String tempName = current.getData().getName();
		int tempId = current.getData().getEmployeeId();

		current.getData().setSalary(pivotSlary);
		current.getData().setName(pivotName);
		current.getData().setEmployeeId(pivotId);
		current.getData().setAge(pivotage);

		end.getData().setSalary(tempSalary);
		end.getData().setAge(tempAge);
		end.getData().setEmployeeId(tempId);
		end.getData().setName(tempName);

		return previousPivot;
	}
}