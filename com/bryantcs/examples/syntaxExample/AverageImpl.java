package com.bryantcs.examples.syntaxExample;

public class AverageImpl extends Object implements Average {

	private long begin;
	private long end;
	private int[] ints;
	private static final String EXCEPTION_MESSAGE =
			"ints must contain at least one int";

	public AverageImpl(int[] ints) throws IllegalArgumentException {
		if (ints.length == 0){
			throw new IllegalArgumentException(EXCEPTION_MESSAGE);
		}
		this.ints = ints;
	}

	@Override
	public float getAverage() {
		begin = System.nanoTime();
		int result = 0;
		for (int i = 0; i < ints.length; i++) {
			result += ints[i];
		}
		end = System.nanoTime();
		return (float) result / ints.length;
	}

	public static float averageTwoNumbers(int a, int b) {
		return (float) (a + b) / 2;
	}

	// a classic getter method
	@Override
	public int[] getInts() {
		return ints;
	}

	// a classic setter method
	@Override
	public void setInts(int[] ints) throws IllegalArgumentException {
		if (ints.length == 0){
			throw new IllegalArgumentException(EXCEPTION_MESSAGE);
		}
		this.ints = ints;
	}

	public long getRunTime() {
		return end - begin;
	}
}