package com.bryantcs.examples.factorial;

public class Factorial {

	int calculate(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("integer must be 0+");
		}
		if( number == 0) {      return 1;
		} else {
			return number * calculate (number - 1);
		}
	}
	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		System.out.println(factorial.calculate(4));
	}
}