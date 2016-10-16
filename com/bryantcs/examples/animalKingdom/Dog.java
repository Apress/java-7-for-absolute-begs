package com.bryantcs.examples.animalKingdom;

class Dog extends Mammal implements Predator, Carnivore, Scavenger {
  // implement the super class's abstract methods
  @Override
  void speak() {
    System.out.println("The dog says, \"bark.\"");
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

  // methods for the Scavenger interface
  @Override  public void eat (Object carrion, boolean tooOld) {
    if (tooOld) {
      // don't eat that!
    } else {
      // munch away
    }
  }
}