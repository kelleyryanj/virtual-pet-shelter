package virtualPetShelter;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter shelter = new VirtualPetShelter();
		VirtualPet pet1 = new VirtualPet("lucky", "old cat", 10, 10, 10);
		shelter.takeInNewPetToShelter(pet1);

		System.out.println("Welcome to the Scarlet and Grey Pet Shelter");

		boolean gameLoop = true;
		while (gameLoop == true)

		{
			System.out.println("What do you want to do?");
			System.out.println("1: Admit a pet");
			System.out.println("2: Adopt a pet");
			System.out.println("3: Feed a pet");
			System.out.println("4: Play with a pet");
			System.out.println("5: Water a pet");
			System.out.println("6: Feed all pets");
			System.out.println("7: Play with all pets");
			System.out.println("8: Waterall pets");
			System.out.println("9: see status of all pets in shelter");
			System.out.println("0: quit");
			System.out.println();
			String userInput = input.nextLine();
			if (userInput.equals("1")) {

				System.out.println("Please type name of new pet to take in");

				String petName = input.next().toLowerCase();

				System.out.println("Please give a description of the pet.");

				String petDescription = input.next().toLowerCase();
				input.nextLine();

				System.out.println("Please enter how hungry they are");

				int petHunger = input.nextInt();
				input.nextLine();
				System.out.println("Please enter how thirsty they are");

				int petThirst = input.nextInt();
				input.nextLine();
				System.out.println("Please enter how bored they are");

				int petBoredom = input.nextInt();
				input.nextLine();
				VirtualPet newPet = new VirtualPet(petName, petDescription, petHunger, petThirst, petBoredom);
				shelter.takeInNewPetToShelter(newPet);

				shelter.tick();

			} else if (userInput.equals("2")) {

				System.out.println("Please enter name of pet you want to adopt");
				System.out.println();
				for (VirtualPet pets : shelter.getAllPets()) {
					System.out.println(pets.getPetName() + " is a " + pets.getDescription());
				}
				String newPet = input.next().toLowerCase();
				input.nextLine();
				while (shelter.findPetInShelter(newPet) == null) {
					System.out.println("Sorry, there is no pet in the shelter by that name. Please retype the name.");
					newPet = input.next();
				}
				shelter.removeAdoptedPet(shelter.findPetInShelter(newPet));

				shelter.tick();

			} else if (userInput.equals("3")) {
				System.out.println("Please enter name of Pet you wish to feed.");
				System.out.println();
				for (VirtualPet pets : shelter.getAllPets()) {
					System.out.println(pets.getPetName() + " is a " + pets.getDescription());
				}
				String newPet = input.next().toLowerCase();
				input.nextLine();

				while (shelter.findPetInShelter(newPet) == null) {
					System.out.println("Sorry, there is no pet in the shelter by that name. Please retype the name.");
					newPet = input.next();
				}
				shelter.feedPetInShelter(newPet);
				System.out.println(newPet.toUpperCase() + " is full now.");
				System.out.println();

				shelter.tick();

			} else if (userInput.equals("4")) {
				System.out.println("Please enter name of Pet you wish to play with.");
				System.out.println();
				for (VirtualPet pets : shelter.getAllPets()) {
					System.out.println(pets.getPetName() + " the " + pets.getDescription());
				}
				String newPet = input.next().toLowerCase();
				input.nextLine();
				while (shelter.findPetInShelter(newPet) == null) {
					System.out.println("Sorry, there is no pet in the shelter by that name. Please retype the name.");
					newPet = input.next();
				}
				shelter.playWithPet(newPet);
				System.out.println(newPet.toUpperCase() + " is happy now.");
				System.out.println();

				shelter.tick();

			} else if (userInput.equals("5")) {
				System.out.println("Please enter name of Pet you wish to water.");
				System.out.println();
				String newPet = input.next().toLowerCase();
				input.nextLine();
				for (VirtualPet pets : shelter.getAllPets()) {
					System.out.println(pets.getPetName() + " the " + pets.getDescription());
				}
				while (shelter.findPetInShelter(newPet) == null) {
					System.out.println("Sorry, there is no pet in the shelter by that name. Please retype the name.");
					newPet = input.next();
				}
				
				shelter.waterPet(newPet);
				System.out.println(newPet.toUpperCase() + " is better now.");
				System.out.println();
				shelter.tick();

			} else if (userInput.equals("6")) {
				System.out.println("Thanks! They really love to eat as a group");
				System.out.println();
				shelter.feedAllPets();

				shelter.tick();

			} else if (userInput.equals("7")) {
				System.out.println("They love playing together as a group.");
				System.out.println();
				shelter.playWithAllPets();

				shelter.tick();

			} else if (userInput.equals("8")) {
				System.out.println("Thanks! It's a big help that you are making sure they all have water.");
				shelter.waterAllPets();

				shelter.tick();

			} else if (userInput.equals("9")) {
				System.out.println("Here is the status of the Pets:");
				System.out.println();
				System.out.println("Name\t|\t Description\t|\tHunger\t|\tBoredom\t|\tThirst");
				System.out.println("**********************************************************************************");
				for (VirtualPet pets : shelter.getAllPets()) {
					System.out.println(pets.getPetName() + "\t|\t" + pets.getDescription() + "\t\t|\t"
							+ pets.getHunger() + "\t|\t" + pets.getBoredom() + "\t|\t" + pets.getThirst());
				}

				shelter.tick();
			} else if (userInput.equals("0")) {
				gameLoop = false;

			} else {
				System.out.println("Please enter a valid option.");
				System.out.println();

			}
		}
		System.out.println("Thanks for volunteering!");
		input.close();
		System.exit(0);

	}
}
// }
