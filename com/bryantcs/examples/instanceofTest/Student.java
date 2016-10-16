package com.bryantcs.examples.instanceofTest;

public class Student extends Person {
	String schoolName;

	public Student (String firstName, String lastName, String schoolName) {
		super(firstName, lastName);
		this.schoolName = schoolName;
	}
}