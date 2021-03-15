package problem1;

public class DataKey {
	// key
	private String key;
	// value corresponding to key
	private String value;

	/**
	 * @param key
	 *            String
	 * @param value
	 *            String value corresponding to key
	 */
	public DataKey(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * This function return key value pair.
	 * 
	 * @return String key value pair.
	 */
	@Override
	public String toString() {
		return "key=" + key + ", value=" + value;
	}

	/**
	 * This function is used to compare Datakey object based on their key
	 * 
	 * @param anotherDataKey
	 *            object to be compare with this object
	 * @return int positive integer if this DataKey object > anotherDataKey,
	 *         negative integer if this DataKey object < anotherDataKey, if both
	 *         are equal than 0.
	 */
	public int compareTo(DataKey anotherDataKey) {
		return this.key.compareTo(anotherDataKey.key);
	}

}
