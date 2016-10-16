package com.bryantcs.examples.writingAndReadingFiles;

import java.io.File;

public class MultipleDirectoryMaker {
	public static void main(String[] args) {
		String testDirectoryName = "C:" + File.separator + "test" +
				File.separator + "test2" + File.separator + "test3";
		File testDirectory = new File(testDirectoryName);
		try {
			testDirectory.mkdirs();
		} catch (Exception e) {
			System.out.println("Couldn't create a directory called "
					+ testDirectoryName);
			System.exit(1);
		}
		System.out.println("Created a directory called " + testDirectoryName);
	}
}
