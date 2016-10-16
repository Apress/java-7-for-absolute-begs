package com.bryantcs.examples.animalKingdom;

class Mouse extends Mammal implements Herbivore{
	// implement the super class's abstract methods
	@Override
	void speak() {
		System.out.println("The mouse says, \"squeak.\"");
	}

	// methods for the Herbivore interface
	@Override  public void eat (Object plantMatter) {
		// eat plants
	}
}