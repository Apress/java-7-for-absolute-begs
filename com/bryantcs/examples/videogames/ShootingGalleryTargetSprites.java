package com.bryantcs.examples.videogames;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShootingGalleryTargetSprites {

	// Variables for the images
	// Static so that each one exists in memory only once
	private static Image smallTarget = null;
	private static Image mediumTarget = null;
	private static Image largeTarget = null;

	// Load the images into the variables
	public void init() {
		try {
			smallTarget = ImageIO.read(new File("C:\\test\\sprites\\target_small.png"));
			mediumTarget = ImageIO.read(new File("C:\\test\\sprites\\target_medium.png"));
			largeTarget = ImageIO.read(new File("C:\\test\\sprites\\target_large.png"));
		} catch (IOException e) {
			System.err.println("Couldn't load one or more sprite images");
			System.exit(1);
		}
	}

	// Get the sprite that corresponds to the size of the target
	public Image getSpriteBySize(int size) {
		// Set up an object to return
		Image imageToReturn = null;

		if (size == 25) { // Get the little black target
			imageToReturn = smallTarget;
		} else if (size == 40) { // Get the medium-sized blue target
			imageToReturn = mediumTarget;
		} else if (size == 50) { // Get the large green target
			imageToReturn = largeTarget;
		} else { // oops - no such target, so tell the player and stop
			throw new IllegalArgumentException("Unknown Sprite Size: " + size);
		}

		return imageToReturn;
	}
}