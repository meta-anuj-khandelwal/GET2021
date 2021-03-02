package InheritanceComposition;

import java.util.ArrayList;

/**
 * <h1>Zone</h1>
 * <p>
 * This class is designed for Zone management in zoo <br>
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-02-28
 */
public class Zone<T extends Animal> {
	// limit of cages in a zone
	private final int cageLimit = 10;
	// total number of available cages in a zone
	private int totalCage = 0;
	// data of all cages in zone
	private ArrayList<Cage> cages = new ArrayList<Cage>();
	// variable denotes park available in zone or not
	private boolean hasPark;
	// variable denotes park canteen in zone or not
	private boolean hasCanteen;

	/**
	 * This function is used to check park is available in zone or not.
	 *
	 * @return boolean true if park is available else false
	 */
	public boolean isHasPark() {
		return hasPark;
	}

	/**
	 * This function is used to set park availability in zone.
	 * 
	 * @param hasPark
	 *            park is available in zone or not.
	 * 
	 * @return nothing
	 */
	public void setHasPark(boolean hasPark) {
		this.hasPark = hasPark;
	}

	/**
	 * This function is used to check canteen is available in zone or not.
	 *
	 * @return boolean true if canteen is available else false
	 */
	public boolean isHasCanteen() {
		return hasCanteen;
	}

	/**
	 * This function is used to set canteen availability in zone.
	 * 
	 * @param hasCanteen
	 *            canteen is available in zone or not.
	 * 
	 * @return nothing
	 */
	public void setHasCanteen(boolean hasCanteen) {
		this.hasCanteen = hasCanteen;
	}

	/**
	 * This function is used to get total cage in zone.
	 * 
	 * 
	 * @return int number of total cage in zone
	 */
	public int getTotalCage() {
		return totalCage;
	}

	/**
	 * This function is used to get all cage in zone.
	 * 
	 * 
	 * @return ArrayList<Cage> all cage data
	 */
	public ArrayList<Cage> getCages() {
		return cages;
	}

	/**
	 * This function is used to get cage limit in zone.
	 * 
	 * 
	 * @return int cage limit in zone
	 */
	public int getCageLimit() {
		return cageLimit;
	}

	/**
	 * This function is used to add cage in zone.
	 * 
	 * @param cls
	 *            Class of animal for which cage needed
	 * 
	 * @return boolean true if cage added successfully else false
	 */
	public boolean addCage(Class<?> cls) {
		boolean result;
		// check space available in cage or not
		if (totalCage < cageLimit) {
			this.totalCage = this.totalCage + 1;
			cages.add(new Cage(cls));
			result = true;

		} else {
			result = false;
		}
		return result;
	}

	/**
	 * This function is used to add animal data in cage in zone.
	 * 
	 * @param animal
	 *            Animal whose data is to be added
	 * 
	 * @return boolean true if animal added successfully else false
	 */
	public boolean addAnimal(Animal animal) {
		// TODO Auto-generated method stub
		boolean result = false;
		// animal belongs belongs to this cage or not
		for (int cageIndex = 0; cageIndex < totalCage; cageIndex++) {
			if (String.valueOf(cages.get(cageIndex).getCls()).equals(
					String.valueOf(animal.getClass()))) {
				// check space available in cage or not
				if (cages.get(cageIndex).hasAvailableSpace()) {
					cages.get(cageIndex).addToCage(animal);
					result = true;
				}
			} else {
				result = false;
			}
		}
		return result;

	}

	/**
	 * This function is used to remove animal from zone in case of death.
	 * 
	 * @param animalId
	 *            int animalId which is to remove
	 * 
	 * @return boolean true if animal removed successfully else false
	 */
	public boolean removeAnimal(int animalId) {
		boolean result = false;
		// check for animalId in all cages
		for (int cageIndex = 0; cageIndex < totalCage; cageIndex++) {
			if (cages.get(cageIndex).removeAnimal(animalId)) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}

	/**
	 * This function is used to get zone data.
	 * 
	 * @return String data of zone.
	 * 
	 */
	@Override
	public String toString() {
		return "Zone [cageLimit=" + cageLimit + ", totalCage=" + totalCage
				+ ", cages=" + cages + "]";
	}

}
