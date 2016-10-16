package com.bryantcs.examples.fractals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class SierpinskiTrianglePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	int maxLevel = 7;

	private void drawTriangle(int level, Graphics g, Point2D.Double point1,
			Point2D.Double point2, Point2D.Double point3) {
		if (level < maxLevel) {
			// Work our way down through the levels
			Point2D.Double midPoint1 = getMiddlePoint(point1, point2);
			Point2D.Double midPoint2 = getMiddlePoint(point2, point3);
			Point2D.Double midPoint3 = getMiddlePoint(point1, point3);

			g.setColor(new Color((int)(Math.random() * 0xFFFFFF)));

			drawTriangle(level + 1, g, point1, midPoint1, midPoint3);
			drawTriangle(level + 1, g, midPoint1, point2, midPoint2);
			drawTriangle(level + 1, g, midPoint3, midPoint2, point3);
		} else {
			// At the bottom level, draw the actual triangles
			// (which are parts of the larger triangles)
			int[] xPoints = {
					new Double(point1.getX()).intValue(),
					new Double(point2.getX()).intValue(),
					new Double(point3.getX()).intValue()
			};
			int[] yPoints = {
					new Double(point1.getY()).intValue(),
					new Double(point2.getY()).intValue(),
					new Double(point3.getY()).intValue()
			};
			g.fillPolygon(xPoints, yPoints, 3);
		}
	}

	private Point2D.Double getMiddlePoint(Point2D.Double point1,
			Point2D.Double point2) {
		double newX = (point1.getX() + point2.getX()) / 2;
		double newY = (point1.getY() + point2.getY()) / 2;
		return new Point2D.Double(newX, newY);
	}

	public void paint (Graphics g) {
		super.paintComponent(g);
		int height = this.getHeight();
		int width = this.getWidth();
		// Here's one way to get the height of an equilateral triangle
		Double doubleHeight
		= Math.sqrt(height * height - (width / 2) * (width / 2));
		// 0 on the Y axis is at the bottom, so this seems upside-down
		Point2D.Double lowerLeft = new Point2D.Double(0, doubleHeight);
		Point2D.Double lowerRight = new Point2D.Double(width, doubleHeight);
		Point2D.Double top = new Point2D.Double(width / 2, 0);
		drawTriangle(1, g, lowerLeft, lowerRight, top);
	}
}