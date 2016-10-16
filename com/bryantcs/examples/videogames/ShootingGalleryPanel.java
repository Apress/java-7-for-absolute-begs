package com.bryantcs.examples.videogames;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ShootingGalleryPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	// The cursor, controlled by the player
	private ShootingGalleryShooter shooter;

	// The sprites that march down the game area
	private ShootingGalleryTargetSprites sprites;

	// The width of the widest target
	public final static int TARGET_SPACE = 50;

	// A tick counter to control the animation
	private int ticks;

	// Three rows of targets
	static ShootingGalleryTargetRow row1, row2, row3;

	// The timer, to control the game loop
	private Timer timer = new Timer(20, this);

	// The constructor
	public ShootingGalleryPanel() {

		// Set up the sprites
		sprites = new ShootingGalleryTargetSprites();
		sprites.init();

		// Set a horizontal layout, because we'll
		// add three vertical rows to the left side
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		// Set up and add the left-most row (the smallest and most valuable targets)
		row1 = new ShootingGalleryTargetRow(sprites.getSpriteBySize(25), 50);
		row1.setPreferredSize(new Dimension(TARGET_SPACE + 10, getHeight()));
		add(row1);

		// Set up and add the middle row (slower and worth less)
		row2 = new ShootingGalleryTargetRow(sprites.getSpriteBySize(40), 25);
		row2.setPreferredSize(new Dimension(TARGET_SPACE + 10, getHeight()));
		add(row2);

		// Set up and add the right-most row (slowest and least valuable targets)
		row3 = new ShootingGalleryTargetRow(sprites.getSpriteBySize(50), 10);
		row3.setPreferredSize(new Dimension(TARGET_SPACE + 10, getHeight()));
		add(row3);

		// Figure out how far to indent the player's cursor and add it
		int shooterOffset = (3 * (TARGET_SPACE + 10));
		int gameWidth = ShootingGallery.gameDimension.width;

		// Set up and add the player's cursor
		shooter = new ShootingGalleryShooter(gameWidth - shooterOffset);
		shooter.setPreferredSize(new Dimension(gameWidth - shooterOffset, getHeight()));
		add(shooter);

		// Start the timer
		timer.start();
	}

	// Let the parent component paint itself
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	// The game loop
	@Override
	public void actionPerformed(ActionEvent e) {

		// increment the tick counter
		ticks++;

		// Once a second, reset the tick counter
		// to keep it from overflowing the value of an int
		if (ticks == 50) {
			ticks = 0;
		}

		// Move the left-most row every tick
		row1.tick();

		// Move the center row every second tick
		if (ticks == 0 || ticks % 2 == 0) {
			row2.tick();
		}

		// Move the right-most row every third tick
		if (ticks == 0 || ticks % 3 == 0) {
			row3.tick();
		}

		// Update the location of the player's cursor every tick
		shooter.tick();
	}
}