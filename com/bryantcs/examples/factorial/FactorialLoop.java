package com.bryantcs.examples.factorial;

public class FactorialLoop {

	int calculate(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("integer must be 0+");
		}
		if( number == 0 || number == 1)
			return 1;
		else {
			int total = 1;
			for (int i = 1; i < number + 1; i++) {
				total *= i;
			}
			return total;
		}
	}
	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		System.out.println(factorial.calculate(4));
	}
}