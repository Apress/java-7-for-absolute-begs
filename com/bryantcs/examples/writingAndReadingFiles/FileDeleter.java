package com.bryantcs.examples.writingAndReadingFiles;

import java.io.File;
import java.io.IOException;

public class FileDeleter {
	public static void main(String[] args) throws IOException {
		String fileName = "C:" + File.separator +
				"test" + File.separator + "myFile.txt";
		File myFile = new File(fileName);
		if(!myFile.exists()) {
			throw new IOException("Cannot delete " + fileName
					+ " because" + fileName + " does not exist");
		} else {
			myFile.delete();
		}
		System.out.println(fileName + " exists? " + myFile.exists());
	}
}
