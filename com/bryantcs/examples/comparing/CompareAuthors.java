package com.bryantcs.examples.comparing;

import java.util.ArrayList;
import java.util.Collections;

public class CompareAuthors {

	public static void main(String[] args) {
		ComparablePersonWithFavoriteBook samSpade = new ComparablePersonWithFavoriteBook("Sam", "Spade", "The Maltese Falcon");
		ComparablePersonWithFavoriteBook sherlockHolmes =
				new ComparablePersonWithFavoriteBook("Sherlock", "Holmes", "The Sign of the Four");
		ComparablePersonWithFavoriteBook johnWatson = new ComparablePersonWithFavoriteBook("John", "Watson", "A Study in Scarlet");
		ComparablePersonWithFavoriteBook drWatson = new ComparablePersonWithFavoriteBook("John", "Watson", "A Study in Scarlet");

		// compare the two that are really equal
		System.out.println(johnWatson == drWatson);
		System.out.println(johnWatson.equals(drWatson));
		System.out.println();
		System.out.println("Sorting by name");

		// Make a collection from our characters and sort them
		ArrayList<ComparablePersonWithFavoriteBook> characters = new ArrayList<ComparablePersonWithFavoriteBook>();
		characters.add(samSpade);
		characters.add(sherlockHolmes);
		characters.add(johnWatson);
		characters.add(drWatson);

		// sort by the natural values (uses compareTo())
		Collections.sort(characters);
		for (int i = 0; i < characters.size(); i++) {
			ComparablePersonWithFavoriteBook person = characters.get(i);
			System.out.println(person.firstName + " "
					+ person.lastName + " likes " + person.favoriteBook);
		}
		System.out.println();
		System.out.println("Sorting by favorite book");

		// sort by book (uses the Comparator)
		Collections.sort(characters, new BookComparator());
		for (int i = 0; i < characters.size(); i++) {
			ComparablePersonWithFavoriteBook person = characters.get(i);
			System.out.println(person.firstName + " "
					+ person.lastName + " likes " + person.favoriteBook);
		}
	}
}