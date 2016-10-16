package com.bryantcs.examples.videogames;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Image;

public class ShootingGalleryTarget {

	// The integer things we need to know: value, size, position,
	// and offset from the edge of the row (for centering)
	private int value, size, xPosition, yPosition, offset;

	// A reference to the row that holds the target (which
	// we need to use as the ImageObserver for the sprite)
	private ShootingGalleryTargetRow row;

	// The sprite
	private Image sprite;

	// A polygon object that we use for collision detection
	Polygon polygon;

	// The constructor, wherein we set the values of all the things we need
	public ShootingGalleryTarget(int value, Image sprite, int x, int y, ShootingGalleryTargetRow row) {
		size = sprite.getWidth(row);
		this.value = value;
		this.sprite = sprite;
		xPosition = x;
		yPosition = y;
		this.row = row;
		offset = (ShootingGalleryPanel.TARGET_SPACE - size) / 2;
	}

	// The draw method
	public void draw(Graphics g) {

		// Set the target's position
		int x = xPosition + offset;
		int y = yPosition + offset;

		// Draw the sprite
		g.drawImage(sprite, x, y, size, size, row);

		// Create a polygon that matches the sprite
		// We'll use the polygon to see if the sprite gets hit
		polygon = new Polygon();
		polygon.addPoint(x, y);
		polygon.addPoint(x, y + size);
		polygon.addPoint(x + size, y + size);
		polygon.addPoint(x + size, y);
	}

	// Provide a way to update the vertical position
	public void setY(int y) {
		yPosition = y;
	}

	// Provide a way to get the vertical position
	public int getY() {
		return yPosition;
	}

	// Provide a way to get the value
	// (used when the target is hit)
	public int getValue() {
		return value;
	}
}