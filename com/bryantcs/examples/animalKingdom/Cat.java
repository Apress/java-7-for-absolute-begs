package com.bryantcs.examples.animalKingdom;

class Cat extends Mammal implements Predator, Carnivore {
  
	private static int numberOfCats;
  
	Cat() {
		numberOfCats++;
	}

	public static final int getNumberOfCats() {
		return numberOfCats;
	}

	@Override
	protected void sayWhatIAm() {
		System.out.println("I am a cat");
		super.sayWhatIAm();
	}
  
	// implement the super class's abstract methods
	@Override
	void speak() {
		System.out.println("The cat says, \"meow.\"");
	}
  
	// here's our example of overloading
	void chase(Mouse mouse) {
		// chase a mouse
	}

	public void chase (Object tail) {
		// chase one's tail
	}

	// methods for the Predator interface
	@Override
	public void hunt() {
		// go hunting
	}

 	// methods for the Carnivore interface
	@Override
	public void eat (Object freshMeat) {
		// eat fresh meat
	}
}