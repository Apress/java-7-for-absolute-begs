package com.bryantcs.examples.comparing;

public class CompareSamSpade {

	public static void main(String[] args) {
		ComparablePerson samSpade = new ComparablePerson("Sam", "Spade");
		ComparablePerson greatNoirDetective = new ComparablePerson("Sam", "Spade");
		System.out.println(samSpade == greatNoirDetective);
		System.out.println(samSpade.equals(greatNoirDetective));
	}
}