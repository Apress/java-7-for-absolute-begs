package com.bryantcs.examples.shiftDemo;

public class ShiftDemo {

	public static void main(String[] args) throws Exception {
		int b = 127;
		System.out.println("b: " + b);
		System.out.println("b as binary: " + Integer.toBinaryString(b));
		String leftShiftString = Integer.toBinaryString(b<<3);
		System.out.println("binary after signed left shifting 3 places: " +
				leftShiftString);
		System.out.println("value of b after signed shifting left 3 places: " +
				Integer.parseInt(leftShiftString, 2));
		String rightShiftString = Integer.toBinaryString(b>>3);
		System.out.println("binary after signed shifting right 3 places: " +
				rightShiftString);
		System.out.println("value of b after signed shifting right 3 places: " +
				Integer.parseInt(rightShiftString, 2));
		String unsignedRightShiftString = Integer.toBinaryString(b>>>3);
		System.out.println("binary after unsigned shifting right 3 places: " +
				unsignedRightShiftString);
		System.out.println("value of b after unsigned shifting right 3 places: " +
				Integer.parseInt(unsignedRightShiftString, 2));
		b = -128;
		System.out.println("Resetting b to " + b);
		System.out.println("b as binary: " + Integer.toBinaryString(b));
		unsignedRightShiftString = Integer.toBinaryString(b>>>3);
		System.out.println("binary after unsigned shifting right 3 places: " + unsignedRightShiftString);
		System.out.println("value of b after unsigned shifting right 3 places: " +
				Integer.parseInt(unsignedRightShiftString, 2));
	}
}