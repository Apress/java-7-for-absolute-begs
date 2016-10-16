package com.bryantcs.examples.animation;

import java.awt.Graphics;

import javax.swing.JPanel;

public class FireworksPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Firework[] fireworks = new Firework[4];

	FireworksPanel() {
		init();
	}

	void init() {
		for (int i = 0; i < 4; i++) {
			fireworks[i] = new Firework((int)(Math.random()
					* this.getWidth()), this.getHeight(), 30);
		}
	}

	public void reset() {
		init();
	}

	public void paint (Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < 4; i++) {
			if (fireworks[i].isDone()) {
				fireworks[i] = new Firework((int)(Math.random()
						* this.getWidth()), this.getHeight(), 30);
			}
			fireworks[i].draw(g);
		}
	}
}