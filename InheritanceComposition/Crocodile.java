package InheritanceComposition;

/**
 * <h1>Crocodile</h1>
 * <p>
 * This class designed for Crocodile species. extends Reptile as base class
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-02-28
 */
public class Crocodile extends Reptile {
	//contains sound of Crocodile

	private final String sound = "Hiss";
	/**
	 * @param name
	 *            animal name
	 * @param age
	 *            animal age
	 * @param weight
	 *            animal weight
	 */
	public Crocodile(String name, int age, float weight) {
		super(name, age, weight);
	}

	/**
	 * This function is used to get animal sound.
	 * 
	 * @return String sound of animal.
	 * 
	 */
	@Override
	public String getSound() {
		return sound;
	}
	/**
	 * This function is used to get animal data.
	 * 
	 * @return String data of animal.
	 * 
	 */
	@Override
	public String toString() {
		return "Crocodile [name=" + name + ", age=" + age + ", weight="
				+ weight + ", animalId=" + animalId + "]";
	}

}
