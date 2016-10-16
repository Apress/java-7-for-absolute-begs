package com.bryantcs.examples.videogames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class ShootingGalleryShooter extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;

	// We need to know where the cursor is
	private int xPosition, yPosition;

	// We need to know whether the player can shoot
	private boolean readyToShoot;

	// We need to know the current step
	// when drawing the cursor after a shot
	private int currentStep;

	// We need to know the maximum steps
	// (Changing this value would change
	// the timeout between shots, by the way.)
	private int maxSteps = 50;

	// The constructor
	public ShootingGalleryShooter(int width) {

		// Add the listeners for mouse clicks and motion
		addMouseListener(this);
		addMouseMotionListener(this);

		// Let the player shoot right away
		readyToShoot = true;
		currentStep = maxSteps;

		// Draw the cursor 20 pixels from the right edge
		xPosition = width - 20;
	}

	public void paintComponent(Graphics g) {
		// Let the parent draw itself
		// (sets the panel's background color)
		super.paintComponent(g);

		// Set the cursor's background color
		this.setBackground(Color.WHITE);

		// Figure out whether the player can shoot
		if (currentStep < maxSteps) {
			// If not, increment the current step
			currentStep++;
			readyToShoot = false;
		} else {
			readyToShoot = true;
		}

		// Fill two rectangles to show how long
		// the player has to wait to shoot again
		g.setColor(Color.RED);
		g.fillRect(xPosition, yPosition - (maxSteps / 2), 3, currentStep);
		g.setColor(Color.YELLOW);
		g.fillRect(xPosition, yPosition - (maxSteps / 2) + currentStep, 3, maxSteps - currentStep);

		// Draw the actual position from which a shot comes
		g.setColor(Color.BLACK);
		g.fillRect(xPosition - 5, yPosition, 5, 2);
	}

	// Provide a way to set the Y location
	public void setY(int newY) {
		yPosition = newY;
	}

	// Convenience method for indicating that the player can shoot
	private void setReadyToShoot(boolean ready) {
		readyToShoot = ready;
		if (ready == false) {
			currentStep = 0;
		}
	}

	// Work through the rows from right to left to see if a shot hit a target
	private void analyzeShot(int shotY) {
		if (!analyzeShotForRow(ShootingGalleryPanel.row3, shotY)) {
			if(!analyzeShotForRow(ShootingGalleryPanel.row2, shotY)) {
				analyzeShotForRow(ShootingGalleryPanel.row1, shotY);
			}
		}
	}

	// Work through the targets in a row to see if we hit one
	private boolean analyzeShotForRow(ShootingGalleryTargetRow row, int shotY) {
		boolean hit = false;
		int count = row.getTargets().size();

		while(!hit && count > 0) {
			ShootingGalleryTarget currentTarget = row.getTargets().get(count - 1);

			// Here's where we check the target's polygon for a hit
			if (currentTarget.polygon.contains(ShootingGalleryPanel.TARGET_SPACE / 2, shotY)) {
				// If we get a hit, stop checking
				hit = true;

				// Update the score
				ShootingGallery.score += currentTarget.getValue();
				ShootingGallery.scoreDisplayLabel.setText(new Integer(ShootingGallery.score).toString());

				// Remove the target that got hit
				row.getTargets().remove(currentTarget);
			} else {
				// We're working backwards because doing so makes
				// it easy to detect when we've run out of targets to check
				count--;
			}
		}
		return hit;
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

	// Here's where we check for mouse clicks
	@Override
	public void mouseReleased(MouseEvent e) {
		if(readyToShoot){
			// If ready to shoot, process the shot
			setReadyToShoot(false);
			analyzeShot(e.getY());
		}
		// If not ready to shoot, do nothing
	}

	// We have to have this method to fulfill the MouseMotionListener contract
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	// Here's where we listen for mouse movement and use
	// the setY method to update the cursor's position
	@Override
	public void mouseMoved(MouseEvent e) {
		setY(e.getY());
	}

	// process a tick from the timer (in ShootingGalleryPanel)
	public void tick() {
		if (currentStep < maxSteps) {
			// If we're still drawing the cursor after a shot, then increment
			// the step counter and ensure that the player can't shoot yet
			currentStep++;
			readyToShoot = false;
		} else {
			// Otherwise, let the player shoot
			readyToShoot = true;
		}

		// repaint the cursor (otherwise, the cursor won't move)
		repaint();
	}
}