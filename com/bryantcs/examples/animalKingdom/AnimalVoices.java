package com.bryantcs.examples.animalKingdom;

public class AnimalVoices {

	public static void main(String[] args) {
		// create instances of our animals
		Cat cat = new Cat();
		Dog dog = new Dog();
		Mouse mouse = new Mouse();

		// let our animals speak
		cat.speak();
		dog.speak();
		mouse.speak();
	}
}