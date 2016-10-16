package com.bryantcs.examples.animalKingdom;

abstract class Mammal {
	// And here's a method for making the sound.
	// Each child class must implement it.
	abstract void speak();

	// All descendant classes can call this and do
	// not need to implement their own versions of it
	protected void sayWhatIAm() {
		System.out.println("I am a mammal");
	}
}