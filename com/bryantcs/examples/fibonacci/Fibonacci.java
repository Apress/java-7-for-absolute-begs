package com.bryantcs.examples.fibonacci;

public class Fibonacci {

	private int calculate(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("Input must be 0 or greater");
		}
		if (length <= 1) {
			return length;
		} else {
			return calculate(length - 1) + calculate(length - 2);
		}
	}
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		for (int i = 0; i < 10; i++){
			System.out.println(fibonacci.calculate(i));
		}
	}
}