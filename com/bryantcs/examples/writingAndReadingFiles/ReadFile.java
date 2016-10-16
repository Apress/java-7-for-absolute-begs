package com.bryantcs.examples.writingAndReadingFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		// Specify the file
		String fileName = "C:" + File.separator + "test"
				+ File.separator + "Hamlet.txt";
		File hamletFile = new File(fileName);
		// Set up a byte array to hold the file's content
		byte[] content = new byte[0];
		try {
			// Create an input stream for the file
			FileInputStream hamletInputStream = new FileInputStream(hamletFile);
			// Figure out how much content the file has
			int bytesAvailable = hamletInputStream.available();
			// Set the content array to the length of the content
			content = new byte[bytesAvailable];
			// Load the file's content into our byte array
			hamletInputStream.read(content);
			// Close the stream
			hamletInputStream.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Couldn't find a file called " + fileName);
		} catch (IOException ioe) {
			System.out.println("Couldn't read from a file called " + fileName);
		}
		// Convert our content to a String
		// and write it out to the console
		System.out.print(new String(content));
	}
}