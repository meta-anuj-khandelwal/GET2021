package InheritanceComposition;

/**
 * <h1>Animal</h1>
 * <p>
 * This abstract class is base class <br>
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-02-28
 */
public abstract class Animal {
	// animal name
	String name;
	// animal age
	int age;
	// animal weight
	float weight;
	// auto generated animal id
	int animalId;
	static int id = 1;

	/**
	 * @param name
	 *            animal name
	 * @param age
	 *            animal age
	 * @param weight
	 *            animal weight
	 */
	public Animal(String name, int age, float weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		animalId = id;
		id++;
	}

	/**
	 * This function is used to get animal name.
	 * 
	 * @return String name of animal.
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * This function is used to set animal name.
	 * 
	 * @param name
	 *            String name of animal
	 * @return nothing.
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This function is used to get animal age.
	 * 
	 * @return int animal of age.
	 * 
	 */
	public int getAge() {
		return age;
	}

	/**
	 * This function is used to set animal age.
	 * 
	 * @param age
	 *            int age of animal
	 * @return nothing.
	 * 
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * This function is used to get animal weight
	 * 
	 * @return float animal weight.
	 * 
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * This function is used to set animal weight.
	 * 
	 * @param weight
	 *            float weight of animal
	 * @return nothing.
	 * 
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * This function is used to get animal id.
	 * 
	 * @return int animal Id.
	 * 
	 */
	public int getAnimalId() {
		return animalId;
	}

	/**
	 * This function is used to get animal sound.
	 * 
	 * @return String sound of animal.
	 * 
	 */
	public abstract String getSound();
}
