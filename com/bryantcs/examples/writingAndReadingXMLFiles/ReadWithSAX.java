package com.bryantcs.examples.writingAndReadingXMLFiles;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ReadWithSAX {

	public static void main(String[] args) {
		String fileName = "C:" + File.separator + "test"
				+ File.separator + "poemsource.xml";
		getFileContents(fileName);
	}

	private static void getFileContents (String fileName) {
		try {
			// Make an instance of our handler
			XMLToConsoleHandler handler = new XMLToConsoleHandler();
			// Get a parser factory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// Get a parser
			SAXParser saxParser = factory.newSAXParser();
			// And now parse the file with our handler
			saxParser.parse(fileName, handler );
			// Deal with the possible exceptions
		} catch(IOException ioe) {
			System.out.println("Couldn't open " + fileName + " for parsing");
		} catch(ParserConfigurationException pce) {
			System.out.println("Failed to create a SAX parser ");
		} catch(SAXException saxe) {
			System.out.println("Failed to parse an XML file");
		}
	}
}