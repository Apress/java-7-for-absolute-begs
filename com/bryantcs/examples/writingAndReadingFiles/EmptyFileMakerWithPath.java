package com.bryantcs.examples.writingAndReadingFiles;

import java.io.File;

public class EmptyFileMakerWithPath {

	public static void main(String[] args) {
		String fileName = "C:" + File.separator +
				"test" + File.separator + "myFile.txt";
		File myFile = new File(fileName);
		try {
			myFile.createNewFile();
		} catch (Exception e) {
			System.out.println("Couldn't create " + myFile.getPath());
		}
		System.out.println("Created " + myFile.getPath());
	}
}
