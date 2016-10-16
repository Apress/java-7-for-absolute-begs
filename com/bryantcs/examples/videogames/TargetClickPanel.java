package com.bryantcs.examples.videogames;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class TargetClickPanel extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;

	// Keep track of the targets
	private Target targets[] = new Target[5];

	// The constructor, which populates the array with nulls
	public TargetClickPanel() {
		addMouseListener(this);
		for (int i = 0; i < targets.length; i++) {
			targets[i] = null;
		}
	}

	// Here's where we update the game field
	public void paint (Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < targets.length; i++) {
			// here's where we make the initial targets
			// on the first time through the loop
			if (targets[i] == null) {
				targets[i] = new Target(this);
			}
			// Is the target done (either fully drawn or has been clicked?)
			if (!targets[i].isDone()) {
				// if not done, draw it in the game area
				targets[i].draw(g);
			} else {
				// if it is done, make a new one and put it in the array; 
				// the old one can then be garbage collected
				// as no reference to it now exists
				targets[i] = new Target(this);
			}
		}
	}

	// We have to have this method to fulfill the MouseListener contract
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	// We have to have this method to fulfill the MouseListener contract
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	// We have to have this method to fulfill the MouseListener contract
	@Override
	public void mouseExited(MouseEvent e) {
	}

	// We have to have this method to fulfill the MouseListener contract
	@Override
	public void mousePressed(MouseEvent e) {
	}

	// Here's where we check for user input within the game field
	// and check to see if the input changes the game
	// (because the user hit a target)
	@Override
	public void mouseReleased(MouseEvent e) {
		for (int i = 0; i < targets.length; i++) {
			targets[i].pointInTarget(e.getX(), e.getY());
		}
	}
}