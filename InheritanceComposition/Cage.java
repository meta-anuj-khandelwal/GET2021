package InheritanceComposition;

import java.util.ArrayList;

/**
 * <h1>Cage</h1>
 * <p>
 * This class is designed for cage operations in zoo <br>
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-02-28
 */
public class Cage {
	// denotes total capacity of cage
	private final int cageLimit = 10;
	// denotes total animal in cage
	private int totalAnimal = 0;
	// data of all animal in cage
	private ArrayList<Animal> animalData = new ArrayList<Animal>();
	// to make cage for a unique animal
	Class<?> cls;

	/**
	 * @param cls
	 *            class of animal for which cage needed
	 */

	public Cage(Class<?> cls) {
		this.cls = cls;
	}

	/**
	 * This function is used to get for which class cage is designed.
	 * 
	 * @return Class class of animal for which cage is designed.
	 */
	public Class<?> getCls() {
		return cls;
	}

	/**
	 * This function is used to get Animal data who are in cage.
	 * 
	 * @return ArrayList<Animal> Animal data who are in cage
	 */
	public ArrayList<Animal> getAnimalData() {
		return animalData;
	}

	/**
	 * This function is used to add animal data in cage.
	 * 
	 * @param animal
	 *            Animal whose data is to be added
	 * 
	 * @return boolean true if animal added successfully else false
	 */
	public boolean addToCage(Animal animal) {
		boolean result;
		// check space available in cage or not and animal belongs belongs to
		// this cage or not
		if (totalAnimal < cageLimit
				&& String.valueOf(this.cls).equals(
						String.valueOf(animal.getClass()))) {
			totalAnimal++;
			animalData.add(animal);
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * This function is used to check more animal space available or not.
	 * 
	 * @return boolean true if space available else false
	 */
	public boolean hasAvailableSpace() {
		boolean spaceAvailable;
		if (totalAnimal < cageLimit) {
			spaceAvailable = true;
		} else {
			spaceAvailable = false;
		}
		return spaceAvailable;
	}

	/**
	 * This function is used to remove animal from cage in case of death.
	 * 
	 * @param animalId
	 *            int animalId which is to remove
	 * 
	 * @return boolean true if animal removed successfully else false
	 */
	public boolean removeAnimal(int animalId) {
		boolean result = false;
		// check for animalId in all available animal data
		for (int index = 0; index < animalData.size(); index++) {
			if (animalData.get(index).getAnimalId() == animalId) {
				animalData.remove(index);
				totalAnimal--;
				result = true;
				break;

			} else {
				result = false;
			}
		}
		return result;
	}

	/**
	 * This function is used to print cage data.
	 * 
	 * @return String data of cage.
	 * 
	 */
	@Override
	public String toString() {
		return "[cageLimit=" + cageLimit + ", totalAnimal=" + totalAnimal + "]";
	}

}
