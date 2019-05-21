package virtualPetShelter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {
	VirtualPetShelter underTest;
	VirtualPet virtualPet1;
	VirtualPet virtualPet2;

	@Before
	public void setup() {
		underTest = new VirtualPetShelter();
		virtualPet1 = new VirtualPet("pet1", 50, 10, 15);
		virtualPet2 = new VirtualPet("pet2", 50, 10, 15);

	}

	@Test
	public void ShouldIntakePetToShelter() {
		underTest.takeInNewPetToShelter(virtualPet1);
		VirtualPet result = underTest.findPetInShelter("pet1");
		assertEquals(virtualPet1, result);

	}

	@Test
	public void shouldRemovePetWhenAdopted() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.removeAdoptedPet(virtualPet1);
		VirtualPet result = underTest.findPetInShelter(virtualPet1.getPetName());
		assertThat(result, is(nullValue()));
	}

	@Test
	public void shouldReturnPetOneandPetTwoInCollection() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.takeInNewPetToShelter(virtualPet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertThat(allPets, containsInAnyOrder(virtualPet1, virtualPet2));
	}

	@Test
	public void shouldDecreaseHungerOfOnePetToZero() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.feedPetInShelter("pet1");
		VirtualPet testedPet = underTest.findPetInShelter("pet1");
		int result = testedPet.getHunger();
		assertEquals(result, 0);

	}

	@Test
	public void shouldDecreaseHungerOfAllPetsToZero() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.takeInNewPetToShelter(virtualPet2);
		underTest.feedAllPets();
		VirtualPet testedPet1 = underTest.findPetInShelter("pet1");
		VirtualPet testedPet2 = underTest.findPetInShelter("pet2");
		int result1 = testedPet1.getHunger();
		int result2 = testedPet2.getHunger();
		assertEquals(0, result1);
		assertEquals(0, result2);

	}

	@Test
	public void shouldDecreaseoredomOfOnePetTOZero() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.playWithPet("pet1");
		VirtualPet testedPet = underTest.findPetInShelter("pet1");
		int result = testedPet.getBoredom();
		assertEquals(result, 0);

	}

	@Test
	public void shouldDecreaseBoredomOfAllPetsToZero() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.takeInNewPetToShelter(virtualPet2);
		underTest.playWithAllPets();
		VirtualPet testedPet1 = underTest.findPetInShelter("pet1");
		VirtualPet testedPet2 = underTest.findPetInShelter("pet2");
		int result1 = testedPet1.getBoredom();
		int result2 = testedPet2.getBoredom();
		assertEquals(result1, 0);
		assertEquals(result2, 0);

	}
	@Test
	public void shouldDecreaseThirstOfOnePetToZeero() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.waterPet("pet1");
		VirtualPet testedPet = underTest.findPetInShelter("pet1");
		int result = testedPet.getThirst();
		assertEquals(0, result);
		
	}
	@Test
	public void shouldIncreaseByOneAfterTickRuns() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.tick();
		VirtualPet testedPet = underTest.findPetInShelter("pet1");
		int resultHunger = testedPet.getHunger();
		int resultBoredom = testedPet.getBoredom();
		int resultThirst = testedPet.getThirst();
		assertEquals(51, resultHunger);
		assertEquals(11, resultBoredom);
		assertEquals(16, resultThirst);
	}
	
}
