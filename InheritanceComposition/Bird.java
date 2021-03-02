package InheritanceComposition;
/**
 * <h1>Bird</h1>
 * <p>
 * This abstract class is base class for all bird species<br>
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-02-28
 */
public abstract class Bird extends Animal{

	/**
	 * @param name
	 *            animal name
	 * @param age
	 *            animal age
	 * @param weight
	 *            animal weight
	 */
	public Bird(String name, int age, float weight) {
		super(name, age, weight);
	}

	

}
