package com.bryantcs.examples.fractals;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class FractalTreePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final static double RADIANS = Math.PI / 180.0;
	Random rand;

	public FractalTreePanel() {
		rand = new Random();
	}
	private void drawSegment(Graphics g, int x1, int y1, double angle, int depth) {
		if (depth == 0) return; // the stop condition
		int xAngleOffset =       new Double(Math.cos(angle * RADIANS) * depth * 10.0).intValue();
		int yAngleOffset = 
				new Double(Math.sin(angle * RADIANS) * depth * 10.0).intValue();
		int x2 = x1 + xAngleOffset;
		int y2 = y1 + yAngleOffset;
		int colorValue = 256 - ((depth - 1) * 32) - 1;
		if (colorValue < 0) {
			colorValue = 0;
		}
		g.setColor(new Color(0, colorValue, 0));
		g.drawLine(x1, y1, x2, y2);
		int randFactor = rand.nextInt(20) + 10; // a value between 10 and 30
		drawSegment(g, x2, y2, angle - randFactor, depth - 1);
		randFactor = rand.nextInt(20) + 10; // a value between 10 and 30
		drawSegment(g, x2, y2, angle + randFactor, depth - 1);
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		drawSegment(g, getWidth() / 2, getHeight(), -90, 9);
	}
}