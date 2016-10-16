package com.bryantcs.examples.writingAndReadingFiles;

import java.io.File;

public class EmptyFileMaker {

	public static void main(String[] args) {
		String fileName = "C:\\test\\myFile.txt";
		File myFile = new File(fileName);
		try {
			myFile.createNewFile();
		} catch (Exception e) {
			System.out.println("Couldn't create " + myFile.getPath());
		}
		System.out.println("Created " + myFile.getPath());
	}
}
