package com.bryantcs.examples.hello;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWithDateTime {

	public static void main(String[] args) {
		// First, get the date as seconds since 1/1/1970
		// Note that a Date object also contains time information
		Date now = new Date();
		// Second, create a formatter object
		SimpleDateFormat formatter =
				new SimpleDateFormat("EEE, MMM dd, yyyy HH:mm:ss");
		// Third, apply the formatter to the date
		String formattedDate = formatter.format(now);
		// Finally, add our formatted date to our output
		System.out.println(formattedDate + "> Hello, " + args[0] + "!");
	}
}