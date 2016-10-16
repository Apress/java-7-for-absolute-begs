package com.bryantcs.examples.comparing;

public class Person {
	String firstName;
	String lastName;

	public Person (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public boolean equals(Person p) {
		if (p == null) {
			return false;
		}
		if (p == this) {
			return true;
		}
		if (!(p instanceof Person)) {
			return false;
		}
		if (p.lastName.equals(this.lastName)
				&& p.firstName.equals(this.firstName)) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {
		int result = 17;
		result *= firstName.hashCode() * 37;
		result *= lastName.hashCode() * 37;
		return result;
	}
}