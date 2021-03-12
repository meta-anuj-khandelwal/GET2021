package problem1;

import java.util.Date;

/**
 * This is java bean class which used to store Directory Name and it's creation
 * time.
 * 
 * @author anuj.khandelwal_meta
 *
 */

public class Directory {
	// Name of directory
	private String directoryName;
	// creation time of directory
	private Date creationTime;

	/**
	 * @param directoryName
	 *            name of directory
	 */
	public Directory(String directoryName) {
		this.directoryName = directoryName;
		creationTime = new Date();
	}

	/**
	 * @return the directoryName
	 */
	public String getDirectoryName() {
		return directoryName;
	}

	/**
	 * @return the directory creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * this function return String of creationTime and directoryName.
	 */
	@Override
	public String toString() {
		return creationTime + "\t" + directoryName;
	}

}
