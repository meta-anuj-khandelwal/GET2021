package Assignment3;

import java.util.ArrayList;

final public class intSet {
	private final int set[] = new int[1000];
	int size = 0;

	intSet() {
		for (int i = 0; i < 1000; i++) {
			set[i] = -1;
		}
	}

	intSet(int... arr) {
		for (int i = 0; i < 1000; i++) {
			set[i] = -1;
		}
		for (int i = 0; i < arr.length; i++) {
			set[arr[i] - 1] = 1;
			size++;
		}
	}

	/**
	 * This function is used to check x is member of intSet or not.
	 * 
	 * @param x
	 *            int This parameter contains the integer .
	 * @return boolean if x is member of intSet return true else return false.
	 * 
	 */
	public boolean iSMember(int x) {
		if (this.set[x - 1] == 1)
			return true;
		else
			return false;
	}

	/**
	 * This function is used to check size of intSet object.
	 * 
	 * @return boolean if x is member of intSet return true else return false.
	 * 
	 */
	public int size() {
		return size;
	}

	/**
	 * This function is used to check s is subset of this intSet or not.
	 * 
	 * @param s
	 *            intSet This parameter contains other intSet .
	 * @return boolean if s is subset of this intSet return true else return
	 *         false.
	 * 
	 */
	public boolean iSSubset(intSet s) {
		for (int i = 1; i <= 1000; i++) {
			if (s.set[i - 1] != -1) {
				if (this.iSMember(i)) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This function is used to get Complement of intSet.
	 * 
	 * @return intSet Complement of intSet.
	 * 
	 */
	public intSet getComplement() {
		int arr[] = new int[1000 - this.size()];
		int index = 0;
		intSet complementSet;
		for (int i = 1; i <= 1000; i++) {
			if (!this.iSMember(i)) {
				arr[index] = i;
				index++;
			}
		}
		complementSet = new intSet(arr);
		return complementSet;
	}

	/**
	 * This function is used to get union of two intSet.
	 * 
	 * @param s1
	 *            intSet This parameter contains first intSet .
	 * @param s2
	 *            intSet This parameter contains second intSet .
	 * @return intSet union of two intSet.
	 * 
	 */
	public static intSet union(intSet s1, intSet s2) {
		intSet unionSet;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 1; i <= 1000; i++) {
			if (s1.iSMember(i) || s2.iSMember(i)) {
				arrayList.add(i);
			}
		}
		int arr[] = new int[arrayList.size()];
		int i = 0;
		for (int a : arrayList) {
			arr[i] = a;
			i++;
		}
		unionSet = new intSet(arr);
		return unionSet;
	}

	public void print() {
		for (int i = 1; i <= 1000; i++) {
			if (this.set[i - 1] != -1) {
				System.out.println(i + " ");
			}
		}
	}

}
