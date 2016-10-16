package com.bryantcs.examples.writingAndReadingFiles;

import java.io.File;

public class TrueTempFileMaker {
	public static void main(String[] args) {
		String tempDirectoryName = "C:" + File.separator + "test";
		File tempDirectory = new File(tempDirectoryName);
		for (int i = 0; i < 10; i++) {
			try {
				File thisFile = 
						File.createTempFile("tmp", null, tempDirectory);
				thisFile.deleteOnExit();
			} catch (Exception e) {
				System.out.println("Couldn't create temp file " + i);
			}
		}
		System.out.println("Done creating temp files");
	}
}
