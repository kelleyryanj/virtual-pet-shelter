package virtualPetShelter;

public class VirtualPet {

	private String petName;
	private int hunger;
	private int boredom;
	private int thirst;

	public VirtualPet(String petName, int hunger, int boredom, int thirst) {
		this.petName = petName;
		this.hunger = hunger;
		this.boredom = boredom;
		this.thirst = thirst;
	}

	public String getPetName() {

		return petName;
	}

	public int getHunger() {

		return hunger;
	}

	public int getBoredom() {
		
		return boredom;

	}

//	public int thirst() {
//		
//		return thirst;
//	}

	public void feedPet() {
		hunger -= 50;
		
	}
	
	public void play() {
		boredom -=10;
	}

	public int getThirst() {
		
		return thirst;
	}

	public void water() {
		thirst -=15;
	}

	public void tick() {
		hunger += 1;
		boredom +=1;
		thirst +=1;
		
	}


		
	
}
