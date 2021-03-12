package problem1;

import java.util.ArrayList;

/**
 * This class is used to maintain tree structure of file directory and perform
 * actions like creation of new directory, changing current directory, searching
 * for a directory, showing sub directory of current directory.
 * 
 * @author anuj.khandelwal_meta
 *
 */
public class DirectoryTree {
	// head root of directory system
	private Node root;
	// node contain reference of current working directory
	private static Node currentNode;

	/**
	 * @param key
	 *            Head Directory of virtual file system
	 */
	public DirectoryTree(Directory key) {
		this.root = new Node(key);
		currentNode = this.root;
	}

	/**
	 * This function return head(root) node of directory system.
	 * 
	 * @return Node head(root) node of directory system.
	 */

	public Node getHead() {
		return root;
	}

	/**
	 * This function return current working node of directory system.
	 * 
	 * @return Node current working node of directory system.
	 */
	public Node getCurrentNode() {
		return currentNode;
	}

	/**
	 * This function add new Directory in current working directory
	 * 
	 * @param directory
	 *            directory to be added.
	 * @return boolean true if added successfully else false.
	 */
	public boolean addChild(Directory directory) {
		return currentNode.addChildNode(directory);
	}

	/**
	 * this function change current working directory.
	 * 
	 * @param directory
	 *            String directory name to which switch
	 * @return boolean true if cwd changed else false.
	 */
	public boolean changeDirectory(String directory) {
		boolean isChanged = false;
		ArrayList<Node> child = currentNode.getChild();
		// going to parent directory
		if (directory.equals("bk") && currentNode.getParent() != null) {
			currentNode = currentNode.getParent();
			isChanged = true;
		}
		// searching directory in all child nodes of current directory
		else {
			for (int i = 0; i < child.size(); i++) {
				// if directory found switch cwd to that directory.
				if (child.get(i).getKey().getDirectoryName().equals(directory)) {
					currentNode = child.get(i);
					isChanged = true;
					break;
				}
			}
		}
		return isChanged;
	}

	/**
	 * this is a helper function used to get path of directory
	 * 
	 * @param node
	 *            Node whose path to be fetch.
	 * @return String path of node.
	 */
	private static String getCurrentPath(Node node) {
		String cwd = new String();
		Node currentDirectoryNode = node;

		while (currentDirectoryNode != null) {
			cwd = currentDirectoryNode.getKey().getDirectoryName() + "\\" + cwd;
			currentDirectoryNode = currentDirectoryNode.getParent();
		}

		return cwd;
	}

	/**
	 * this function print all sub directory details
	 */
	public void displaySubDirectory() {
		Node currentDirectoryNode = currentNode;
		// traversing to all children node and printing their details
		for (int index = 0; index < currentDirectoryNode.getChild().size(); index++) {
			System.out.println(currentDirectoryNode.getChild().get(index)
					.getDirectory());
		}

	}

	public void findDirectory(String string) {
		findDirectoryRecursive(string, currentNode);
	}

	/**
	 * this function find all sub directory of currentNode
	 * 
	 * @param string
	 *            name of sub directory to be search
	 * @param currentNode
	 *            node whose sub directory to be find
	 */
	private void findDirectoryRecursive(String string, Node currentNode) {
		Node currentDirectoryNode = currentNode;
		for (int index = 0; index < currentDirectoryNode.getChild().size(); index++) {

			Node child = currentDirectoryNode.getChild().get(index);

			if (child.getDirectory().getDirectoryName().contains(string)) {
				System.out.println(getCurrentPath(child));
			}

			findDirectoryRecursive(string, child);
		}
	}

	/**
	 * This function print all the branch of currentNode recursively
	 * 
	 * @param currentNode
	 *            node whose all sub directory to be print
	 */
	public void displayTree(Node currentNode) {
		Node currentDirectoryNode = currentNode;
		for (int index = 0; index < currentDirectoryNode.getChild().size(); index++) {
			Node child = currentDirectoryNode.getChild().get(index);
			System.out.println(getCurrentPath(child));
			displayTree(child);
		}
	}

}
