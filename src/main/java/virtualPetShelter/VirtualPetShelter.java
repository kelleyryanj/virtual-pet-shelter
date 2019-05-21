package virtualPetShelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> virtualPetsInShelter = new HashMap<>();

	public void takeInNewPetToShelter(VirtualPet petInShelter) {
		virtualPetsInShelter.put(petInShelter.getPetName(), petInShelter);

	}

	public VirtualPet findPetInShelter(String name) {
		return virtualPetsInShelter.get(name);
	}

	public void removeAdoptedPet(VirtualPet petInShelter) {
		virtualPetsInShelter.remove(petInShelter.getPetName(), petInShelter);

	}

	public Collection<VirtualPet> getAllPets() {

		return virtualPetsInShelter.values();
	}

	public void feedPetInShelter(String petInShelter) {
		VirtualPet feedPet = findPetInShelter(petInShelter);
		feedPet.feedPet();
	}

	public void feedAllPets() {
		for (String key : virtualPetsInShelter.keySet()) {
			VirtualPet value = virtualPetsInShelter.get(key);
			value.feedPet();
		}
	}

	public void playWithPet(String petInShelter) {
		VirtualPet playWithPet = findPetInShelter(petInShelter);
		playWithPet.play();

	}

	public void playWithAllPets() {
		for (String key : virtualPetsInShelter.keySet()) {
			VirtualPet value = virtualPetsInShelter.get(key);
			value.play();
		}

	}

	public void waterPet(String petInShelter) {
		VirtualPet waterPet = findPetInShelter(petInShelter);
		waterPet.water();

	}

	public void waterAllPets() {
		for (String key : virtualPetsInShelter.keySet()) {
			VirtualPet value = virtualPetsInShelter.get(key);
			value.water();
		}
	}

	public void tick() {
		for (String key : virtualPetsInShelter.keySet()) {
			VirtualPet value = virtualPetsInShelter.get(key);
			value.tick();

		}

	}

}
