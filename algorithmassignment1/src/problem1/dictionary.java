package problem1;

public interface dictionary {
	/**
	 * This function insert the key value pair in dictionary
	 * 
	 * @param key
	 *            String key to be set
	 * @param value
	 *            String value corresponds to key
	 * @return boolean if insertion success true else false.
	 */
	public boolean insert(String key, String value);

	/**
	 * This function is used to remove key value from dictionary.
	 * 
	 * @param key
	 *            String key to be delete
	 * @return boolean true if deletion success else false.
	 */
	public boolean delete(String key);

	/**
	 * This function is used to fetch value corresponds to key
	 * 
	 * @param key
	 *            key for which value need to fetch.
	 * @return String value corresponding key.
	 */
	public String get(String key);

	/**
	 * This function return the sorted key value pair MyLinkedList
	 * 
	 * @return return the sorted key value pair MyLinkedList
	 */
	public MyLinkList<DataKey> getSortedList();

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
	public MyLinkList<DataKey> getSortedInRange(String key1, String key2);
}
