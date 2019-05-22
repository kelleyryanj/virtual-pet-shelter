package virtualPetShelter;

public class VirtualPet {

	private String petName;
	private String description;
	private int hunger;
	private int boredom;
	private int thirst;

	public VirtualPet(String petName, String description, int hunger, int boredom, int thirst) {
		this.petName = petName;
		this.description = description;
		this.hunger = hunger;
		this.boredom = boredom;
		this.thirst = thirst;
	}

	public String getPetName() {

		return petName;
	}
	
	public String getDescription() {
		return description;
	}

	public int getHunger() {

		return hunger;
	}

	public int getBoredom() {

		return boredom;

	}

	public int getThirst() {

		return thirst;
	}

	public void feedPet() {
		hunger -= 50;
		if (hunger < 0) {
			hunger = 0;
		}

	}

	public void play() {
		boredom -= 10;
		if (boredom < 0) {
			boredom = 0;

		}
	}


	public void water() {
		thirst -= 15;
		if (thirst < 0) {
			thirst = 0;
		}
	}

	public void tick() {
		hunger += 1;
		boredom += 1;
		thirst += 1;

	}

}
