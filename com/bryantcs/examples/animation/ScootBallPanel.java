package com.bryantcs.examples.animation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class ScootBallPanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private boolean animating = false;
	private int xPosition = 5;


	public boolean isAnimating() {
		return animating;
	}

	public void setAnimating(boolean animating) {
		this.animating = animating;
	}

	public void reset() {
		xPosition = 5;
	}

	public void paint (Graphics g) {
		int width = this.getSize().width;
		int height = this.getSize().height;
		super.paintComponent(g);
		if (animating) {
			g.setColor(Color.RED);
			g.fillOval(xPosition, height / 2, 10 ,10);
			xPosition += 20;
			if (xPosition > width) {
				animating = false;
			}
		}
	}

	// The run method controls how often the screen
	// gets redrawn and so controls the frame rate
	public void run() {
		while(animating) {
			try {
				Thread.sleep(40);
				this.repaint();
			} catch (InterruptedException ie) {
				return;
			}
		}
	}
}