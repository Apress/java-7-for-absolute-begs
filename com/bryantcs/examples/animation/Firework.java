package com.bryantcs.examples.animation;

import java.awt.Color;
import java.awt.Graphics;

public class Firework {

	private int startX, startY, burstX, burstY, burstStep, currentStep, panelHeight, steps;
	Color color;

	// It takes a fair bit of setup work to figure out
	// * the starting location
	// * the bursting location
	// * which step we're on
	// * the total number of steps
	Firework(int x, int height, int ticks) {
		panelHeight = height;
		steps = ticks;
		startX = x;
		startY = height;
		burstX = x;
		burstY = height >> 1;
		burstStep = ticks >> 1;
		currentStep = 0;
		color = new Color((int)(Math.random() * 0xFFFFFF));
	}

	void draw(Graphics g) {
		Color drawColor = color;
		g.setColor(drawColor);
		int height = panelHeight - panelHeight / steps * currentStep;
		// the origin is at the top of the screen, so we check for being in
		// the bottom half by checking to see if the current height is larger
		// than the burst height. It seems backwards, but that's how it works.
		if (height > burstY) {
			// if we are in the bottom half of the panel, just draw
			// the line that represents the firework shell going up.
			g.drawLine(startX, startY, burstX, height);
		}

		if(currentStep >= burstStep) {
			// When we reach the bursting point, draw 12 lines in a circle.
			// For that, we need a tiny bit of trigonometry.
			for (int i = 0; i < 12; i++) {
				double xPrime, yPrime;
				double currentRadians = Math.toRadians(30 * i);

				int length = burstY / 2 / steps * currentStep;
				xPrime = (Math.cos(currentRadians)
						- Math.sin(currentRadians)) * length;
				yPrime = (Math.sin(currentRadians)
						+ Math.cos(currentRadians)) * length;
				int endX = new Double(xPrime).intValue() + burstX;
				int endY = new Double(yPrime).intValue() + burstY;

				g.drawLine(burstX, burstY, endX, endY);
			}
		}
		currentStep++;
	}

	// This firework is done, so the panel
	// class can let it be garbage collected.
	public boolean isDone() {
		return currentStep >= steps;
	}
}