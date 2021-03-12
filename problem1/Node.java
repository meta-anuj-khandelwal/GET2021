package problem1;

import java.util.ArrayList;

/**
 * This class is designed for node of a tree. this class contains key value list
 * of child node and reference of parent node
 * 
 * @author anuj.khandelwal_meta
 *
 */
public class Node {
	// key value
	private Directory key;
	// list of child node
	private ArrayList<Node> child = new ArrayList<Node>();
	// reference of parent node
	private Node parent;

	/**
	 * 
	 * @param key
	 *            key value of Node
	 */
	public Node(Directory key) {
		this.key = key;
	}

	/**
	 * 
	 * @return key of Node
	 */
	public Directory getDirectory() {
		return this.key;
	}

	/**
	 * this function add child node to this node
	 * 
	 * @param key
	 *            Directory to be added as child node.
	 * @return boolean true if child added else false.
	 */
	public boolean addChildNode(Directory key) {
		boolean isExist = false;
		// making node of key
		Node childNode = new Node(key);
		// setting reference of parent.
		childNode.parent = this;
		// searching if any sibling node contains same directory or not
		for (int i = 0; i < child.size() && !isExist; i++) {
			if (child.get(i).key.getDirectoryName().equals(
					key.getDirectoryName())) {
				isExist = true;
			}
		}
		// if sibling node contains same directory than add new directory
		if (!isExist)
			child.add(childNode);
		return !isExist;
	}

	/**
	 * @return the key
	 */
	public Directory getKey() {
		return key;
	}

	/**
	 * @return the child
	 */
	public ArrayList<Node> getChild() {
		return child;
	}

	/**
	 * @return the parent reference
	 */
	public Node getParent() {
		return parent;
	}

}
