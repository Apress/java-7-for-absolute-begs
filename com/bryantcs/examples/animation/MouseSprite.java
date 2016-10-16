package com.bryantcs.examples.animation;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class MouseSprite {
	private int spriteX, spriteY, step;
	private boolean done = false;
	Image[] spriteImages= new Image[4];
	JPanel spritePanel;

	MouseSprite(int x, int y, Image[] images, JPanel panel) {
		spriteX = x;
		spriteY = y;
		step = 0;
		spriteImages = images;
		spritePanel = panel;
	}

	void draw(Graphics g) {
		ImageObserver observer = spritePanel;
		if (step < 4) {
			g.drawImage(spriteImages[step], spriteX, spriteY, observer);
			step++;
		} else {
			done = true;
		}
	}

	public boolean isDone() {
		return done;
	}

}