package com.bryantcs.examples.writingAndReadingFiles;

import java.io.File;

public class DirectoryMakerWithRollback {
	public static void main(String[] args) {
		String currentPath = "C:";
		// a double colon is illegal on my Windows machine, so this fails
		String[] pathParts = {"test", "test2", "test3::fail"};
		for (String pathPart: pathParts) {
			currentPath += File.separator + pathPart;
			File testDirectory = new File(currentPath);
			if (!testDirectory.mkdir()) {
				System.out.println("Failed to create " + testDirectory
						+ "; removing all created directories");
				removePathByParts("C:", pathParts);
			} else {
				System.out.println("Created " + testDirectory);
			}
		}
	}

	private static void removePathByParts(String pathStart, String[] pathParts) {
		String currentPath = pathStart;
		String[] paths = new String[pathParts.length];
		// First, build an array of possible paths
		for (int pathCounter = 0; pathCounter < pathParts.length; pathCounter++) {
			currentPath += File.separator + pathParts[pathCounter];
			paths[pathCounter] = currentPath;
		}
		// Then work backwards, checking for the existence of each
		// path part and deleting each one if we find it
		for (int pathCounter = pathParts.length - 1; pathCounter >= 0;
				pathCounter--) {
			File currentFile = new File(paths[pathCounter]);
			if (currentFile.delete()) {
				System.out.println("Removed " + currentFile);
			}
		}
	}

}
