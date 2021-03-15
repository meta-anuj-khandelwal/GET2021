package problem2;

/**
 * This class is designed to perform insertion sort on MyLinkedList
 * 
 * @author anuj.khandelwal_meta
 *
 */
public class MyCollection {

	/**
	 * Insertion Sort for the Employees Type Linked List
	 * 
	 * @param employeeList
	 *            Linked List of the employee type
	 */

	public static void insertionSort(MyLinkList<Employees> employeeList) {
		// empty list case
		if (employeeList.getSize() == 0) {
			return;
		}

		// initializing sorted list head
		Node<Employees> sortedEmployeeNode = null;

		// initializing current node with head of employeeList
		Node<Employees> currentEmployeeNode = employeeList.getStart();

		// iterating on all the nodes of the linked list
		while (currentEmployeeNode.getNext() != null) {
			Node<Employees> nextEmployeeNode = currentEmployeeNode.getNext();
			// insert function will find position for current employee and
			// insert in sorted list
			sortedEmployeeNode = insert(currentEmployeeNode, sortedEmployeeNode);
			// moving to next node
			currentEmployeeNode = nextEmployeeNode;
		}
		// handling last node
		sortedEmployeeNode = insert(currentEmployeeNode, sortedEmployeeNode);
		employeeList.setStart(sortedEmployeeNode);
	}

	/**
	 * 
	 * @param newEmployeeNode
	 *            new employee node to be inserted in sorted list.
	 * @param sortedEmployeeNode
	 *            head of sorted list.
	 * @return sorted head node.
	 */
	private static Node<Employees> insert(Node<Employees> newEmployeeNode,
			Node<Employees> sortedEmployeeNode) {
		// insertion at first position
		if (sortedEmployeeNode == null
				|| sortedEmployeeNode.getData().compareTo(
						newEmployeeNode.getData()) < 0) {
			newEmployeeNode.setNext(sortedEmployeeNode);
			sortedEmployeeNode = newEmployeeNode;
		} else {
			Node<Employees> current = sortedEmployeeNode;
			// finding position for newEmployeeNode
			while (current.getNext() != null
					&& current.getNext().getData()
							.compareTo(newEmployeeNode.getData()) > 0) {
				current = current.getNext();
			}
			// adding node to its sorted position
			newEmployeeNode.setNext(current.getNext());
			current.setNext(newEmployeeNode);
		}
		return sortedEmployeeNode;
	}
}