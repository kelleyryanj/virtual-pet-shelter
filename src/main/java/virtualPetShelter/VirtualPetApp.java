package virtualPetShelter;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter shelter = new VirtualPetShelter();
		VirtualPet pet1 = new VirtualPet("Lucky", 10, 10, 10);
		shelter.takeInNewPetToShelter(pet1);

		System.out.println("Welcome to the Scarlet and Grey Pet Shelter");

		boolean gameLoop = true;
		while (gameLoop == true)

		{
			System.out.println("Here is the status of the Pets:");
			System.out.println("Name\t|\tHunger\t|\tThirst\t|\tBoredom");
			System.out.println("**************************************************************");
			for (VirtualPet pets : shelter.getAllPets()) {
				System.out.println(pets.getPetName() + "\t|\t" + pets.getHunger() + "\t|\t" + pets.getThirst() + "\t|\t" + pets.getBoredom());
			}
			System.out.println("What do you want to do?");
			System.out.println("1: admit a pet");
			System.out.println("2: adopt a pet");
			System.out.println("0: quit");
			System.out.println();
			int userInput = input.nextInt();
			if (userInput == 1) {

				for (String keyValue : shelter.virtualPetsInShelter.keySet()) {
					VirtualPet key = shelter.virtualPetsInShelter.get(keyValue);
					System.out.println(keyValue);
				}

				System.out.println("Please type name of new pet to take in");
				String petName = input.next();
				System.out.println("Please enter how hungry they are");
				int petHunger = input.nextInt();
				System.out.println("Please enter how thirsty they are");
				int petThirst = input.nextInt();
				System.out.println("Please enter how bored they are");
				int petBoredom = input.nextInt();

				VirtualPet newPet = new VirtualPet(petName, petHunger, petThirst, petBoredom);
				shelter.takeInNewPetToShelter(newPet);

//				for (String keyValue : shelter.virtualPetsInShelter.keySet()) {
//					VirtualPet key = shelter.virtualPetsInShelter.get(keyValue);
//					System.out.println(keyValue);
//				}
			} else if (userInput == 2) {

				System.out.println("Please enter name of pet you want to adopt");

				String newPet1 = input.next();

				shelter.removeAdoptedPet(shelter.findPetInShelter(newPet1));

				for (String keyValue : shelter.virtualPetsInShelter.keySet()) {
					VirtualPet key = shelter.virtualPetsInShelter.get(keyValue);
					System.out.println(keyValue);
				}
			} else if (userInput == 0) {
				System.out.println("Thanks for volunteering!");
				input.close();
				System.exit(0);
			}

		}
	}
}

// }
