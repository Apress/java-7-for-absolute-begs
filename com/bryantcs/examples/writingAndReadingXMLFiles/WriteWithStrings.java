package com.bryantcs.examples.writingAndReadingXMLFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteWithStrings {

	public static void main(String[] args) {
		String xmlContent = createXMLContent();
		writeXMLToFile(xmlContent);
	}

	private static String createXMLContent() {
		// write the first line
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<poem title=\"");
		sb.append(Poem.getTitle());
		sb.append("\" author=\"");
		sb.append(Poem.getAuthor());
		sb.append("\">\n");
		// write the middle lines
		for (String lineIn : Poem.getLines()) {
			sb.append("<line>");
			sb.append(lineIn);
			sb.append("</line>\n");
		}
		// write the last line
		sb.append("</poem>");
		return sb.toString();
	}

	private static void writeXMLToFile(String xmlContent) {
		String fileName = "C:" + File.separator + "test"
				+ File.separator + "domoutput.xml";
		try {
			File domOutput = new File(fileName);
			FileOutputStream domOutputStream
			= new FileOutputStream(domOutput, true);
			domOutputStream.write(xmlContent.getBytes());
			domOutputStream.close();
			System.out.println(fileName + " was successfully created");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Couldn't find a file called " + fileName);
			System.exit(1);
		} catch (IOException ioe) {
			System.out.println("Couldn't write to a file called " + fileName);
			System.exit(1);
		}
	}
}