package com.bryantcs.examples.videogames;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Target {
	// The essential information drawing a target:
	// where is it and how big is it right now?
	private int drawX, drawY, step;

	// Are we done yet? By default, no
	private boolean done = false;

	// a reference to the game area, which we use
	// to find a spot for this target
	JPanel panel;

	// The constructor
	Target(JPanel panel) {
		this.panel = panel;
		// -30 + 15 creates a 15-pixel border

		// Find a random spot in the game field
		drawX = TargetClick.random.nextInt(panel.getWidth() - 30) + 15;
		drawY = TargetClick.random.nextInt(panel.getHeight() - 30) + 15;

		// Start the step counter
		step = 0;
	}

	// Here's where we draw the target
	void draw(Graphics g) {
		if (!done) {
			// if not done, draw a circle that varies in size by the current step
			if (step == 0) {
				g.setColor(Color.RED);
				g.fillOval(drawX - 15, drawY - 15, 10, 10);
			}
			if (step == 1) {
				g.setColor(Color.RED);
				g.fillOval(drawX - 15, drawY - 15, 20, 20);
			}
			if (step == 2) {
				g.setColor(Color.RED);
				g.fillOval(drawX - 15, drawY - 15, 30, 30);
			}
			if (step == 3) {
				g.setColor(Color.RED);
				g.fillOval(drawX - 15, drawY - 15, 20, 20);
			}
			if (step == 4) {
				g.setColor(Color.RED);
				g.fillOval(drawX - 15, drawY - 15, 10, 10);
				done = true;
			}
		} else {
			// if we are done, erase the remaining circle
			g.setColor(Color.WHITE);
			g.fillOval(drawX + 1, drawY + 1, 30, 30);
		}
		step++;
	}

	// This is how we let the playing field
	// know whether this target is done
	public boolean isDone() {
		return done;
	}

	// Did this target get hit?
	public void pointInTarget(int x, int y) {
		if (x > drawX -15 && x < drawX + 15 && y > drawY - 15 && y < drawY + 15) {
			// A hit! So add 1 to the sore and indicate that this target is done
			TargetClick.score++;
			done = true;
		}
		// no need to do anything if not a hit
	}
}