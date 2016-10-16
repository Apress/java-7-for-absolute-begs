package com.bryantcs.examples.writingAndReadingXMLFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class WriteWithDOM {

	public static void main (String args[]) {
		// Create an empty Document
		Document doc = createDocument();

		// Create the XML
		createElements(doc);

		// Create a String representation of the XML
		String xmlContent = createXMLString(doc);

		// Write the XML to a file
		writeXMLToFile(xmlContent);
	}

	// Here's where we create the (empty for now) XML document
	private static Document createDocument() {
		Document doc = null;
		try {
			DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
			doc =  docBuilder.newDocument();
			doc.setXmlStandalone(true);
		}
		catch(ParserConfigurationException pce) {
			System.out.println("Couldn't create a DocumentBuilder");
			System.exit(1);
		}
		return doc;
	}

	// Here's where we add content to the XML document
	private static void createElements(Document doc) {
		// Create the root element
		Element poem = doc.createElement("poem");
		poem.setAttribute("title", Poem.getTitle());
		poem.setAttribute("author", Poem.getAuthor());

		// Add the root element to the document
		doc.appendChild(poem);

		// Create the child elements
		for (String lineIn : Poem.getLines() ) {
			Element line = doc.createElement("line");
			Text lineText = doc.createTextNode(lineIn);
			line.appendChild(lineText);
			// Add each element to the root element
			poem.appendChild(line);
		}
	}

	// Here's where we convert the DOM object
	// into a String that contains XML
	private static String createXMLString(Document doc) {
		// Transform the DOM to a String
		Transformer transformer = null;
		StringWriter stringWriter = new StringWriter();
		try {
			TransformerFactory transformerFactory =
					TransformerFactory.newInstance();
			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
					"no");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			// Create a string to contain the XML from the Document object
			stringWriter = new StringWriter();
			StreamResult result = new StreamResult(stringWriter);
			DOMSource source = new DOMSource(doc);
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			System.out.println("Couldn't create a Transformer");
			System.exit(1);
		} catch (TransformerException e) {
			System.out.println("Couldn't transform DOM to a String");
			System.exit(1);
		}
		return stringWriter.toString();
	}

	// Here's where we turn the String holding the XML into a file
	private static void writeXMLToFile(String xmlContent) {
		String fileName = "C:" + File.separator + "test"
				+ File.separator + "domoutput.xml";
		try {
			File domOutput = new File(fileName);
			FileOutputStream domOutputStream
			= new FileOutputStream(domOutput, true);
			domOutputStream.write(xmlContent.getBytes());
			domOutputStream.close();
			System.out.println(fileName + " was successfully written");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Couldn't find a file called " + fileName);
			System.exit(1);
		} catch (IOException ioe) {
			System.out.println("Couldn't write to a file called " + fileName);
			System.exit(1);
		}
	}
}