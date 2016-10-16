package com.bryantcs.examples.enumExample;

public class EnumExample {

	public static void main(String[] args) {
		int[] compassPoints = {22, 77, 144, 288};
		for (int i = 0; i < compassPoints.length; i++) {
			System.out.println(compassPoints[i] + " degrees is (very roughly) "
					+ Direction.findCardinalDirection(compassPoints[i]));
		}
		for (Direction d : Direction.values()) {
			System.out.println(d + " is " + d.getDegrees() + " degrees.");
		}
	}
}