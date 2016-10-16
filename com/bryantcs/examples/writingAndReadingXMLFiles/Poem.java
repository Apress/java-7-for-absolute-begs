package com.bryantcs.examples.writingAndReadingXMLFiles;

import java.util.ArrayList;

public class Poem {

	private static String title = "The Great Figure";
	private static String author ="William Carlos Williams";
	private static ArrayList<String> lines = new ArrayList<String>();

	static {
		lines.add("Among the rain");
		lines.add("and lights");
		lines.add("I saw the figure 5");
		lines.add("in gold");
		lines.add("on a red");
		lines.add("fire truck");
		lines.add("moving");
		lines.add("tense");
		lines.add("unheeded");
		lines.add("to gong clangs");
		lines.add("siren howls");
		lines.add("and wheels rumbling");
		lines.add("through the dark city");
	}

	public static String getTitle() {
		return title;
	}

	public static String getAuthor() {
		return author;
	}

	public static ArrayList<String> getLines() {
		return lines;
	}
}