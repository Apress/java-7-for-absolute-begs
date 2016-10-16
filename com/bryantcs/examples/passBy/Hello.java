package com.bryantcs.examples.passBy;

public class Hello {

	static int primitiveInt = 0;
	static IntegerWrapper intWrapper = new IntegerWrapper();

	public static void main(String[] args) throws Exception {
		passBy(primitiveInt, intWrapper);
		System.out.println("primitiveInt = " + primitiveInt +
				"; intWrapper.objectInt = " + intWrapper.objectInt);
	}
	public static void passBy(int primitiveInt, IntegerWrapper intWrapper) {
		primitiveInt++;
		intWrapper.objectInt++;
	}
}