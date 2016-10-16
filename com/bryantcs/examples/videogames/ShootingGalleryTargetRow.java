package com.bryantcs.examples.videogames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JPanel;

public class ShootingGalleryTargetRow extends JPanel {

	private static final long serialVersionUID = 1L;

	// We need a list of targets
	private LinkedList<ShootingGalleryTarget> targets =
			new LinkedList<ShootingGalleryTarget>();

	// We need to know how many points this target is worth
	private int targetValue;

	// We need to know when to remove a target
	// off the bottom and add a new one at the top
	private int newTargetTicker;

	// We need a sprite for the player to shoot
	// Using a buffered image to reduce flicker
	private BufferedImage sprite;

	// The constructor, in which we set the values of the things we need to know
	public ShootingGalleryTargetRow(Image sprite, int value) {
		targetValue = value;
		newTargetTicker = 0;
		this.sprite = (BufferedImage) sprite;
	}

	public LinkedList<ShootingGalleryTarget> getTargets() {
		return targets;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		for (int targetCounter = 0; targetCounter < targets.size(); targetCounter ++) {
			ShootingGalleryTarget currentTarget = targets.get(targetCounter);
			if (currentTarget.getY() > getHeight() + ShootingGalleryPanel.TARGET_SPACE) {
				targets.remove(currentTarget);
			} else {
				currentTarget.setY(currentTarget.getY() + ShootingGalleryPanel.TARGET_SPACE / 10);
				currentTarget.draw(g);
			}
		}
	}

	public void tick() {
		for (int targetCounter = 0; targetCounter < targets.size(); targetCounter ++) {
			ShootingGalleryTarget currentTarget = targets.get(targetCounter);
			currentTarget.setY(currentTarget.getY() + ShootingGalleryPanel.TARGET_SPACE / 10);
		}
		newTargetTicker++;
		if (newTargetTicker > 9) {
			newTargetTicker = 0;
			ShootingGalleryTarget newTarget =
					new ShootingGalleryTarget(targetValue, sprite, 0,
							-ShootingGalleryPanel.TARGET_SPACE, this);
			targets.add(newTarget);
		}
		repaint();
	}
}