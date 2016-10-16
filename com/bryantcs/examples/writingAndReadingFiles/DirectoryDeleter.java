package com.bryantcs.examples.writingAndReadingFiles;

import java.io.File;

public class DirectoryDeleter {
	public static void main(String[] args) {
		String testDirectoryName = "C:" + File.separator + "test";
		File testDirectory = new File(testDirectoryName);
		if (testDirectory.exists()) {
			testDirectory.delete();
			System.out.println("Deleted a directory called " + testDirectoryName);
		} else {
			System.out.println("Couldn't delete " + testDirectory
					+ " because it does not exist");
		}
	}
}
