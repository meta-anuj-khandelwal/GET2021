package problem1;

public class TreeNode {
	// data of tree node
	private DataKey dataKey;
	// Reference to left and right child
	private TreeNode left, right;

	/**
	 * @param dataKey
	 *            data of tree node
	 */
	public TreeNode(DataKey dataKey) {
		this.dataKey = dataKey;
		left = right = null;
	}

	/**
	 * @return the dataKey
	 */
	public DataKey getDataKey() {
		return dataKey;
	}

	/**
	 * @param dataKey
	 *            the dataKey to set
	 */
	public void setDataKey(DataKey dataKey) {
		this.dataKey = dataKey;
	}

	/**
	 * @return the left Reference
	 */
	public TreeNode getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            the left Reference to set
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	/**
	 * @return the right Reference
	 */
	public TreeNode getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right Reference to set
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}

}
