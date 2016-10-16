package com.bryantcs.examples.comparing;

import java.util.Comparator;

public class BookComparator implements Comparator<ComparablePersonWithFavoriteBook> {

	public int compare(ComparablePersonWithFavoriteBook p1, ComparablePersonWithFavoriteBook p2) {
		return p1.favoriteBook.compareTo(p2.favoriteBook);
	}
}