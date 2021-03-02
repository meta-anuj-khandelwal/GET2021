package InheritanceComposition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>ZooManagementSystem</h1>
 * <p>
 * This class is designed for Zoo management<br>
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-02-28
 */
public class ZooManagementSystem {
	// all zone of Bird
	private ArrayList<Zone<Bird>> birdZones = new ArrayList<Zone<Bird>>();
	// all zone of Mammal
	private ArrayList<Zone<Mammal>> mammalZones = new ArrayList<Zone<Mammal>>();
	// all zone of Reptile
	private ArrayList<Zone<Reptile>> reptileZones = new ArrayList<Zone<Reptile>>();

	/**
	 * @param birdZones
	 * @param mammalZones
	 * @param reptileZones
	 */
	public ZooManagementSystem(int birdZonesCount, int mammalZonesCount,
			int reptileZonesCount) {
		// Initializing all zones
		for (int count = 0; count < birdZonesCount; count++) {
			birdZones.add(new Zone<Bird>());
		}
		for (int count = 0; count < mammalZonesCount; count++) {
			mammalZones.add(new Zone<Mammal>());
		}
		for (int count = 0; count < reptileZonesCount; count++) {
			reptileZones.add(new Zone<Reptile>());
		}
	}

	/**
	 * This function is used to remove animal from cage in case of death.
	 * 
	 * @param animalId
	 *            int animalId which is to remove
	 * 
	 * @return boolean true if animal removed successfully else false
	 */
	private boolean removeAnimal(int animalId) {
		boolean result = false;
		// checking for animalId in birdZones
		for (int zoneNumber = 0; zoneNumber < birdZones.size(); zoneNumber++) {
			if (birdZones.get(zoneNumber).removeAnimal(animalId)) {
				result = true;
				break;
			}
		}
		// checking for animalId in mammalZones
		for (int zoneNumber = 0; zoneNumber < mammalZones.size(); zoneNumber++) {
			if (mammalZones.get(zoneNumber).removeAnimal(animalId)) {
				result = true;
				break;
			}
		}
		// checking for animalId in reptileZones
		for (int zoneNumber = 0; zoneNumber < reptileZones.size(); zoneNumber++) {
			if (reptileZones.get(zoneNumber).removeAnimal(animalId)) {
				result = true;
				break;
			}
		}
		return result;

	}

	/**
	 * This function is used to add cage in zo0.
	 * 
	 * @param Species
	 *            String name of species for which cage is needed
	 * @param animalName
	 *            String name of animal for which cage is needed
	 * @return boolean true if cage added successfully else false
	 */
	public boolean addcage(String Species, String animalName) {
		boolean result = false;
		// checking required zone for bird or not
		if (Species.equals("Bird".toLowerCase())) {
			if (animalName.equals("Peacock".toLowerCase())) {
				for (int zoneNumber = 0; zoneNumber < birdZones.size(); zoneNumber++) {
					if (birdZones.get(zoneNumber).addCage(Peacock.class)) {
						result = true;
						break;
					}
				}
			}
		}
		// checking required zone for Mammal or not
		else if (Species.equals("Mammal".toLowerCase())) {
			if (animalName.equals("Lion".toLowerCase())) {
				for (int zoneNumber = 0; zoneNumber < mammalZones.size(); zoneNumber++) {
					if (mammalZones.get(zoneNumber).addCage(Lion.class)) {
						result = true;
						break;
					}
				}
			}
		}
		// checking required zone for Reptile or not
		else if (Species.equals("Reptile".toLowerCase())) {
			if (animalName.equals("Crocodile".toLowerCase())) {
				for (int zoneNumber = 0; zoneNumber < reptileZones.size(); zoneNumber++) {
					if (reptileZones.get(zoneNumber).addCage(Crocodile.class)) {
						result = true;
						break;
					}
				}
			}
		}
		return result;
	}

	/**
	 * This function is used to add animal data in cage.
	 * 
	 * @param animal
	 *            Animal whose data is to be added
	 * 
	 * @return boolean true if animal added successfully else false
	 */
	public boolean addAnimal(Animal animal) {
		boolean result = false;
		try {

			Class birdClass = Class.forName("InheritanceComposition.Bird");
			Class mammalClass = Class.forName("InheritanceComposition.Mammal");
			Class reptileClass = Class
					.forName("InheritanceComposition.Reptile");
			// checking for animal is bird
			if (birdClass.isInstance(animal)) {
				for (int zoneNumber = 0; zoneNumber < birdZones.size(); zoneNumber++) {
					if (birdZones.get(zoneNumber).addAnimal(animal)) {
						result = true;
						break;
					}
				}

				// checking for animal is mammal
			} else if (mammalClass.isInstance(animal)) {
				for (int zoneNumber = 0; zoneNumber < mammalZones.size(); zoneNumber++) {
					if (mammalZones.get(zoneNumber).addAnimal(animal)) {
						result = true;
						break;
					}
				}
			}
			// checking for animal is reptile
			else if (reptileClass.isInstance(animal)) {
				for (int zoneNumber = 0; zoneNumber < reptileZones.size(); zoneNumber++) {
					if (reptileZones.get(zoneNumber).addAnimal(animal)) {
						result = true;
						break;
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This function is used to print all zone data.
	 *
	 * @return nothing
	 */
	public void printZoneWiseData() {
		System.out.println("*******Bird Zones*********");

		for (int zoneNumber = 0; zoneNumber < birdZones.size(); zoneNumber++) {
			System.out.println("Zone-" + (zoneNumber + 1));
			ArrayList<Cage> cages = birdZones.get(zoneNumber).getCages();
			for (int cageNumber = 0; cageNumber < cages.size(); cageNumber++) {
				System.out.println("Cage-" + (cageNumber + 1)
						+ cages.get(cageNumber));
				ArrayList<Animal> animalData = cages.get(cageNumber)
						.getAnimalData();
				for (int animalNumber = 0; animalNumber < animalData.size(); animalNumber++) {
					System.out.println(animalData.get(animalNumber));
				}
			}

		}
		System.out.println("*******Mammal Zones*********");

		for (int zoneNumber = 0; zoneNumber < mammalZones.size(); zoneNumber++) {
			System.out.println("Zone-" + (zoneNumber + 1));
			ArrayList<Cage> cages = mammalZones.get(zoneNumber).getCages();
			for (int cageNumber = 0; cageNumber < cages.size(); cageNumber++) {
				System.out.println("Cage-" + (cageNumber + 1)
						+ cages.get(cageNumber));
				ArrayList<Animal> animalData = cages.get(cageNumber)
						.getAnimalData();
				for (int animalNumber = 0; animalNumber < animalData.size(); animalNumber++) {
					System.out.println(animalData.get(animalNumber));
				}
			}

		}
		System.out.println("*******Reptile Zones*********");

		for (int zoneNumber = 0; zoneNumber < reptileZones.size(); zoneNumber++) {
			System.out.println("Zone-" + (zoneNumber + 1));
			ArrayList<Cage> cages = reptileZones.get(zoneNumber).getCages();
			for (int cageNumber = 0; cageNumber < cages.size(); cageNumber++) {
				System.out.println("Cage-" + (cageNumber + 1)
						+ cages.get(cageNumber));
				ArrayList<Animal> animalData = cages.get(cageNumber)
						.getAnimalData();
				for (int animalNumber = 0; animalNumber < animalData.size(); animalNumber++) {
					System.out.println(animalData.get(animalNumber));
				}
			}

		}
	}

	/**
	 * This function is used to Create animal object.
	 * 
	 * 
	 * @return Animal animal object as per user input
	 */
	public Animal createAnimal() {
		Animal animal;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1] Add Lion");
			System.out.println("2] Add Crocodile");
			System.out.println("3] Add Peacoke");
			System.out.println("Enter your choice : ");
			int ch = readfromuser();
			System.out.println("Enter Name :");
			String name = scanner.nextLine();
			System.out.println("Enter Age :");
			int age = readfromuser();
			System.out.println("Enter Weight :");
			float weight = scanner.nextFloat();
			if (ch == 1) {
				animal = new Lion(name, age, weight);
				break;
			} else if (ch == 2) {
				animal = new Crocodile(name, age, weight);
				break;
			} else if (ch == 3) {
				animal = new Peacock(name, age, weight);
				break;
			} else {
				System.out.println("Wrong Input ");
			}
		}
		return animal;
	}

	/**
	 * This function is used to print all zoo data.
	 * 
	 * @return String data of zoo.
	 * 
	 */
	@Override
	public String toString() {
		return "ZooManagementSystem [birdZones=" + birdZones + ", mammalZones="
				+ mammalZones + ", reptileZones=" + reptileZones + "]";
	}

	// main function
	public static void main(String[] args) {
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(2, 2,
				2);
		Scanner scanner = new Scanner(System.in);
		while (true) {

			System.out.println("1] Add Animal Data");
			System.out.println("2] Add Cage to Zone");
			System.out.println("3] Remove dead animal");
			System.out.println("4] Show all cage and their animals");
			System.out.println("5] Exit");

			System.out.println("Enter your choice : ");
			int ch = readfromuser();
			switch (ch) {
			case 1:
				Animal m1 = zooManagementSystem.createAnimal();// new Lion("L1",
																// 20, 90);
				System.out.println(zooManagementSystem.addAnimal(m1));
				break;
			case 2:
				String species;
				String animalType;
				System.out.println("Enter Species :");
				species = scanner.nextLine();
				System.out.println("Enter Animal type :");
				animalType = scanner.nextLine();
				System.out.println(zooManagementSystem.addcage(
						species.toLowerCase(), animalType.toLowerCase()));
				break;
			case 3:
				System.out.println("Enter Animal Id : ");
				int animalId = readfromuser();
				System.out.println(zooManagementSystem.removeAnimal(animalId));
				break;
			case 4:
				zooManagementSystem.printZoneWiseData();
				break;
			case 5:
				return;
			}
		}

	}

	/**
	 * This function is used to add read integer value form console.
	 * 
	 * 
	 * @return int console input integer
	 */
	public static int readfromuser() {
		int number;
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		while (true) {
			try {
				number = Integer.parseInt(bufferedReader.readLine());
				break;
			} catch (Exception e) {
				System.out.println("Wrong input type \n please re enter :");
			}
		}
		return number;
	}

}
