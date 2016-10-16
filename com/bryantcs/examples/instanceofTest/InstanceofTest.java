package com.bryantcs.examples.instanceofTest;

public class InstanceofTest {

  public static void main(String[] args) {
    Student student = new Student("Sam", "Spade", "Noir U");
    System.out.println(student instanceof Student);
    System.out.println(student instanceof Person);
  }

}