package problem1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class is used implement dictionary
 * 
 * @author anuj.khandelwal_meta
 *
 */
public class BSTDictionary implements dictionary {
	// Root of BST
	TreeNode root;

	public BSTDictionary() {
		root = null;
	}

	/**
	 * 
	 * @param json
	 *            initialize dictionary with json data
	 */
	public BSTDictionary(String json) {
		this();
		loadFronJSON(json);
	}

	/**
	 * This finction initialize dictionary with json data
	 * 
	 * @param json
	 *            JSON data in String
	 */
	private void loadFronJSON(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			JSONArray arr = obj.getJSONArray("data");
			for (int index = 0; index < arr.length(); index++) {
				String key = arr.getJSONObject(index).getString("key");
				String value = arr.getJSONObject(index).getString("value");
				insert(key, value);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function insert the key value pair in dictionary
	 * 
	 * @param key
	 *            String key to be set
	 * @param value
	 *            String value corresponds to key
	 * @return boolean if insertion success true else false.
	 */

	@Override
	public boolean insert(String key, String value) {
		boolean isNewKey = false;
		if (get(key) == null) {
			DataKey newDataKey = new DataKey(key, value);

			root = insertTreeNode(root, newDataKey);

			isNewKey = true;
		} else {
			isNewKey = false;
		}
		return isNewKey;
	}

	/**
	 * This recursive method insert in BST
	 * 
	 * @param root
	 *            root node
	 * @param newDataKey
	 *            new node to be add
	 * @return root of tree.
	 */
	private TreeNode insertTreeNode(TreeNode root, DataKey newDataKey) {

		// If the tree is empty, return a new node

		if (root == null) {
			root = new TreeNode(newDataKey);
			return root;
		}

		// Otherwise, recur down the tree
		if (newDataKey.compareTo(root.getDataKey()) < 0)
			root.setLeft((insertTreeNode(root.getLeft(), newDataKey)));
		else if (newDataKey.compareTo(root.getDataKey()) > 0)
			root.setRight((insertTreeNode(root.getRight(), newDataKey)));

		return root;
	}

	/**
	 * This function is used to remove key value from dictionary.
	 * 
	 * @param key
	 *            String key to be delete
	 * @return boolean true if deletion success else false.
	 */
	@Override
	public boolean delete(String key) {
		boolean isKeyExist = false;
		if (get(key) != null) {
			DataKey deleteKey = new DataKey(key, "");
			root = deleteTreeNode(root, deleteKey);
			isKeyExist = true;
		} else {
			isKeyExist = false;
		}
		return isKeyExist;

	}

	/**
	 * This is recursive function delete a node from tree.
	 * 
	 * @param root
	 *            root node of tree
	 * @param deleteKey
	 *            dataKey to be delete from tree.
	 * @return TreeNode root node of tree
	 */
	private TreeNode deleteTreeNode(TreeNode root, DataKey deleteKey) {
		// if tree has no node
		if (root == null)
			return root;

		// Otherwise, recur down the tree
		// if deleteKey less than root's key
		if (deleteKey.compareTo(root.getDataKey()) < 0)
			root.setLeft(deleteTreeNode(root.getLeft(), deleteKey));

		// if deleteKey greater than root's key
		else if (deleteKey.compareTo(root.getDataKey()) > 0)
			root.setRight(deleteTreeNode(root.getRight(), deleteKey));

		// if key is same as root's key, then This node is to be deleted
		else {
			// node with only one child or no child
			if (root.getLeft() == null)
				return root.getRight();
			else if (root.getRight() == null)
				return root.getLeft();

			// node with two children: Get the in order successor
			root.setDataKey(minValue(root.getRight()));

			// Delete the in order successor
			root.setRight(deleteTreeNode(root.getRight(), root.getDataKey()));
		}

		return root;
	}

	/**
	 * Find minimum from tree
	 * 
	 * @param root
	 *            node from which minimum datakey is to find
	 * @return DataKey node with minimum value.
	 */
	private DataKey minValue(TreeNode root) {

		DataKey minimumValue = root.getDataKey();

		while (root.getLeft() != null) {
			minimumValue = root.getLeft().getDataKey();
			root = root.getLeft();
		}
		return minimumValue;
	}

	/**
	 * This function is used to fetch value corresponds to key
	 * 
	 * @param key
	 *            key for which value need to fetch.
	 * @return String value corresponding key.
	 */
	@Override
	public String get(String key) {
		DataKey searchKey = new DataKey(key, "");
		TreeNode searchedNode = search(root, searchKey);
		if (searchedNode != null) {
			return searchedNode.getDataKey().getValue();
		} else {
			return null;
		}
	}

	/**
	 * This function recursively find a key from tree
	 * 
	 * @param root
	 *            root of tree
	 * @param searchKey
	 *            DataKey to be search.
	 * @return TreeNode with specified key.
	 */
	public TreeNode search(TreeNode root, DataKey searchKey) {
		// root is null or key is present at root
		if (root == null || root.getDataKey().compareTo(searchKey) == 0)
			return root;

		// Key is greater than root's key
		if (root.getDataKey().compareTo(searchKey) < 0)
			return search(root.getRight(), searchKey);

		// Key is smaller than root's key
		return search(root.getLeft(), searchKey);
	}

	/**
	 * This function return the sorted key value pair MyLinkedList
	 * 
	 * @return return the sorted key value pair MyLinkedList
	 */
	@Override
	public MyLinkList<DataKey> getSortedList() {
		// TODO Auto-generated method stub
		MyLinkList<DataKey> sortedList = new MyLinkList<DataKey>();
		inOrdetToList(root, sortedList);
		return sortedList;
	}

	/**
	 * This function do inorder traversal of tree and add value in list.
	 * 
	 * @param root
	 *            root of tree
	 * @param sortedList
	 *            list if DataKey sorted by key
	 */
	private void inOrdetToList(TreeNode root, MyLinkList<DataKey> sortedList) {
		if (root != null) {
			inOrdetToList(root.getLeft(), sortedList);
			sortedList.add(root.getDataKey());
			inOrdetToList(root.getRight(), sortedList);
		}

	}

	/**
	 * This function return the sorted key value pair MyLinkedList between key1
	 * and key2 inclusive.
	 * 
	 * @param key1
	 *            starting value for range.
	 * 
	 * @param key2
	 *            closing value for range.
	 * @return return the sorted key value pair MyLinkedList
	 * 
	 * 
	 */
	@Override
	public MyLinkList<DataKey> getSortedInRange(String key1, String key2) {
		DataKey dataKey1 = new DataKey(key1, "");
		DataKey dataKey2 = new DataKey(key2, "");
		MyLinkList<DataKey> sortedList = new MyLinkList<DataKey>();
		inOrdetToListRange(root, sortedList, dataKey1, dataKey2);
		return sortedList;
	}

	/**
	 * This function do inorder traversal of tree and add value in between key1
	 * and key2 inclusive.
	 * 
	 * @param root
	 *            root of tree
	 * @param sortedList
	 *            list if DataKey sorted by key
	 * @param key1
	 *            starting value for range.
	 * 
	 * @param key2
	 *            closing value for range.
	 */
	private void inOrdetToListRange(TreeNode root,
			MyLinkList<DataKey> sortedList, DataKey dataKey1, DataKey dataKey2) {
		if (root != null) {
			inOrdetToListRange(root.getLeft(), sortedList, dataKey1, dataKey2);
			if (root.getDataKey().compareTo(dataKey1) >= 0
					&& root.getDataKey().compareTo(dataKey2) <= 0) {
				sortedList.add(root.getDataKey());
			}
			inOrdetToListRange(root.getRight(), sortedList, dataKey1, dataKey2);
		}

	}

	/**
	 * @return the root
	 */
	public TreeNode getRoot() {
		return root;
	}

}
