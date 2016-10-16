package com.bryantcs.examples.comparing;

public class ComparablePersonWithFavoriteBook implements Comparable<ComparablePersonWithFavoriteBook> {
  String firstName;
  String lastName;
  String favoriteBook;
    public ComparablePersonWithFavoriteBook (String firstName, String lastName, String favoriteBook) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.favoriteBook = favoriteBook;
  }

  public boolean equals(ComparablePersonWithFavoriteBook p) {
    if (p == null) {
      return false;
    }
    if (p == this) {
      return true;
    }
    if (!(p instanceof ComparablePersonWithFavoriteBook)) {
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

  public int compareTo(ComparablePersonWithFavoriteBook p) {
    // sort by last name first
    if (lastName.compareTo(p.lastName) > 0) {
      return 1;
    }
    if (lastName.compareTo(p.lastName) < 0) {
      return -1;
    }
    // last names must be equal
    // so compare first names
    if (firstName.compareTo(p.firstName) > 0) {
      return 1;
    }
    if (firstName.compareTo(p.firstName) < 0) {
      return -1;
    }
    // both names must be equal
    return 0;
  }
}