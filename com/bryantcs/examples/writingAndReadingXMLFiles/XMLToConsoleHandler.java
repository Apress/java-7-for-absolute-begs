package com.bryantcs.examples.writingAndReadingXMLFiles;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLToConsoleHandler extends DefaultHandler {

	// The characters method handles the actual content of an element
	@Override
	public void characters(char[] content, int start, int length) throws SAXException {
		// Describe the content in the console
		System.out.println("Found content: " + new String(content, start, length));
	}

	// The endDocument method lets us do something
	// when the parser reaches the end of the document
	@Override
	public void endDocument() throws SAXException {
		// Announce in the console that we found the end of the document
		System.out.println("Found the end of the document");
	}

	// The endElement method lets us do something
	// when the parser reaches the end of an element
	@Override
	public void endElement(String arg0, String localName, String qName)
			throws SAXException {
		// Announce in the console that we found the end of an element
		System.out.println("Found the end of an element named \"" + qName + "\"");
	}

	// The startDocument lets us do something
	// when we find the top of the document
	@Override
	public void startDocument() throws SAXException {
		// Announce in the console that we found the beginning of the document
		System.out.println("Found the start of the document");
	}

	// The startElement method lets us do something
	// when we reach the beginning of an element
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// Create a StringBuilder object to contain our description of this element
		StringBuilder sb = new StringBuilder();
		// Add the name of the element
		sb.append("Found the start of an element named \"" + qName + "\"");
		// See if the element has any attributes
		if (attributes != null && attributes.getLength() > 0) {
			sb.append(" with attributes named ");
			// If we do find attributes, describe each one
			for (int i = 0; i < attributes.getLength(); i++) {
				String attributeName = attributes.getLocalName(i);
				String attributeValue = attributes.getValue(i);
				sb.append("\"" + attributeName + "\"");
				sb.append(" (value = ");
				sb.append("\"" + attributeValue + "\"");
				sb.append(")");
				// If we're not at the end of the attributes,
				// add a comma, for proper formatting
				if (i < attributes.getLength() - 1) {
					sb.append(", ");
				}
			}
		}
		// Describe the element in the console
		System.out.println(sb.toString());
	}
}