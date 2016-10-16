package com.bryantcs.examples.writingAndReadingFiles;

import java.io.File;

public class FileFinder {

	public static void main(String[] args) {
		String fileName = "C:" + File.separator +
				"test" + File.separator + "myFile.txt";
		File myFile = new File(fileName);
		System.out.println(fileName + " exists? " + myFile.exists());
	}
}
