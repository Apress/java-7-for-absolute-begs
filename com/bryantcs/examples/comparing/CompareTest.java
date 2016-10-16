package com.bryantcs.examples.comparing;

public class CompareTest {

	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		Object c = b;
		System.out.println(a == b);
		System.out.println(b == c);
	}
}