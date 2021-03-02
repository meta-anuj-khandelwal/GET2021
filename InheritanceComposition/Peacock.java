package InheritanceComposition;

/**
 * <h1>Peacock</h1>
 * <p>
 * This class designed for Lion species. extends Bird as base class
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-02-28
 */
public class Peacock extends Bird {
	//contains sound of Peacock
	private final String sound = "scream";

	/**
	 * @param name
	 *            animal name
	 * @param age
	 *            animal age
	 * @param weight
	 *            animal weight
	 */
	public Peacock(String name, int age, float weight) {
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
		// TODO Auto-generated method stub
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
		return "Peacoke [name=" + name + ", age=" + age + ", weight=" + weight
				+ ", animalId=" + animalId + "]";
	}

}
