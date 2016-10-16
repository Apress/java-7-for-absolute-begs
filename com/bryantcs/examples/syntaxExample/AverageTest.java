package com.bryantcs.examples.syntaxExample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AverageTest {

	public static void main(String[] args) {

		// set up a test for AverageImpl
		int[] ints = {1, 2, 3, 4};
		AverageImpl averageImpl = new AverageImpl(ints);

		// do one test
		String testString = buildTestString(averageImpl.getInts(),
				averageImpl.getAverage(), averageImpl.getRunTime());
		System.out.println(testString);

		// set up a second test (using setInts)
		ints[0] = 2;
		ints[1] = 3;
		ints[2] = 4;
		ints[3] = 5;
		averageImpl.setInts(ints);

		// do the second test
		testString = buildTestString(averageImpl.getInts(),
				averageImpl.getAverage(), averageImpl.getRunTime());
		System.out.println(testString);

		// Test the exception
		int[] ints2 = {};
		try {
			averageImpl.setInts(ints2);
		} catch(IllegalArgumentException iae) {
			System.out.println("Oops! can't use an empty array");
		}

		// add a test for the convenience method
		System.out.println("AverageImpl.averageTwoNumbers(1, 2) = "
				+ AverageImpl.averageTwoNumbers(1, 2));
	}

	private static String buildTestString(int[] values, float average, long time) {
		// set up a timestamp for our tests
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String timeStamp = formatter.format(now);

		StringBuffer sb = new StringBuffer(timeStamp);
		sb.append(">Averaged {");
		for (int i = 0; i < values.length; i++) {
			sb.append(values[i]);
			if (i < values.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("} and got ");
		sb.append(average);
		sb.append(" in ");
		sb.append(time);
		sb.append(" nanoseconds");
		return sb.toString();
	}
}