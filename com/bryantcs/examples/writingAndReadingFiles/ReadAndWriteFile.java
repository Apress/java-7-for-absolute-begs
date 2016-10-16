package com.bryantcs.examples.writingAndReadingFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWriteFile {
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
		// Reverse the contents of our array, just so we'll
		// know we did something to the file's content
		reverseByteArray(content);
		try {
			// Create a stream for our output
			FileOutputStream hamletOutputStream
			= new FileOutputStream(hamletFile, true);
			// Write a newline character to separate the
			// original content from the new content.
			hamletOutputStream.write('\n');
			// Write our output to the file output stream
			// (and thus to our file)
			hamletOutputStream.write(content);
			// Close the output stream
			hamletOutputStream.close();
			System.out.println("New contents of hamlet.txt written");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Couldn't find a file called " + fileName);
		} catch (IOException ioe) {
			System.out.println("Couldn't write to a file called " + fileName);
		}
	}

	private static void reverseByteArray(byte[] inBytes) {
		int inLength = inBytes.length;
		for (int i = 0; i < inLength >> 1; i++) {
			byte temp = inBytes[i];
			inBytes[i] = inBytes[inLength - i - 1];
			inBytes[inLength - i - 1] = temp;
		}
	}
}
