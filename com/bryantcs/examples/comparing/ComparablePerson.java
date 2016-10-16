package com.bryantcs.examples.comparing;

public class ComparablePerson implements Comparable<ComparablePerson> {
	String firstName;
	String lastName;

	public ComparablePerson (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public boolean equals(ComparablePerson p) {
		if (p == null) {
			return false;
		}
		if (p == this) {
			return true;
		}
		if (!(p instanceof ComparablePerson)) {
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

	public int compareTo(ComparablePerson p) {
		int thisTotal = firstName.hashCode() + lastName.hashCode();
		int pTotal = p.firstName.hashCode() + p.lastName.hashCode();
		if (thisTotal > pTotal) {
			return 1;
		}
		if (thisTotal < pTotal) {
			return -1;
		}
		// if we got here, they must be equal
		return 0;
	}
}