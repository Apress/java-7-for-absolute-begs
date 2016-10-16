package com.bryantcs.examples.writingAndReadingFiles;

import java.io.File;

public class DirectoryMaker {
	public static void main(String[] args) {
		String testDirectoryName = "C:" + File.separator + "test";
		File testDirectory = new File(testDirectoryName);
		try {
			testDirectory.mkdir();
		} catch (Exception e) {
			System.out.println("Couldn't create a directory called "
					+ testDirectoryName);
			System.exit(1);
		}
		System.out.println("Created a directory called " + testDirectoryName);
	}
}
