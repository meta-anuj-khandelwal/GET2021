package InheritanceComposition;

/**
 * <h1>Lion</h1>
 * <p>
 * This class designed for Lion species. extends Mammal as base class
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-02-28
 */
public class Lion extends Mammal {
	// contains sound of Lion

	private final String sound = "Roars";

	/**
	 * @param name
	 *            animal name
	 * @param age
	 *            animal age
	 * @param weight
	 *            animal weight
	 */
	public Lion(String name, int age, float weight) {
		super(name, age, weight);
		// TODO Auto-generated constructor stub
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
		return "Lion [name=" + name + ", age=" + age + ", weight=" + weight
				+ ", animalId=" + animalId + "]";
	}

}
