package com.bryantcs.examples.writingAndReadingXMLFiles;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadWithDOM {

	public static void main(String[] args) {
		String fileName = "C:" + File.separator + "test"
				+ File.separator + "poemsource.xml";
		writeFileContentsToConsole(fileName);
	}

	// Write the contents of the file to the console
	private static void writeFileContentsToConsole(String fileName) {
		// Create a DOM Document object
		Document doc = createDocument(fileName);
		// Get the root element
		Element root = doc.getDocumentElement();
		// Create a StringBuilder object that describes the root element
		StringBuilder sb = new StringBuilder();
		sb.append("The root element is named: \"" + root.getNodeName() + "\"");
		sb.append(" and has the following attributes: ");
		NamedNodeMap attributes = root.getAttributes();
		for (int i = 0; i < attributes.getLength(); i ++) {
			Node thisAttribute = attributes.item(i);
			sb.append(thisAttribute.getNodeName());
			sb.append (" (\"" + thisAttribute.getNodeValue() + "\")");
			if (i < attributes.getLength() - 1) {
				sb.append(", ");
			}
		}
		// Write the description of the root element to the console
		System.out.println(sb);

		// Work through the children of the root
		// First, get a list of the child nodes
		NodeList nodes = doc.getElementsByTagName("line");
		for (int i = 0; i < nodes.getLength(); i++) {
			// Process each element in turn
			Element element = (Element) nodes.item(i);
			System.out.println("Found an element named \"" +
					// By writing its name and content to the console (System.out)
					element.getTagName() + "\"" +
					" with the following content: \"" +
					element.getTextContent() + "\"");
		}
	}

	// Create a DOM Document object from a file
	private static Document createDocument(String fileName) {
		Document doc = null;
		try {
			// Get the file
			File xmlFile = new File(fileName);
			// Create document builder factory
			DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
			// Create a document builder object
			DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
			// Load the document by parsing the file with the document builder
			doc = docBuilder.parse(xmlFile);
			// Indicate that this document is self-contained
			doc.setXmlStandalone(true);
		}
		// Deal with the possible exceptions
		catch (IOException ioe) {
			System.out.println("Couldn't open file: " + fileName);
			System.exit(1);
		}
		catch (SAXException se) {
			System.out.println("Couldn't parse the XML file");
			System.exit(1);
		}
		catch(ParserConfigurationException pce) {
			System.out.println("Couldn't create a DocumentBuilder");
			System.exit(1);
		}
		// Finally return the Document object
		// that we built from the file
		return doc;
	}
}