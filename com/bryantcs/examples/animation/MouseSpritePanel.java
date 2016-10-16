package com.bryantcs.examples.animation;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MouseSpritePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image[] spriteImages = new Image[4];
	private ArrayList<MouseSprite> currentSprites = new ArrayList<MouseSprite>();

	MouseSpritePanel() {
		try {
			spriteImages[0] = ImageIO.read(new
					File("C:\\test\\sprites\\sprite1.png"));
			spriteImages[1] = ImageIO.read(new
					File("C:\\test\\sprites\\sprite2.png"));
			spriteImages[2] = ImageIO.read(new
					File("C:\\test\\sprites\\sprite3.png"));
			spriteImages[3] = ImageIO.read(new
					File("C:\\test\\sprites\\sprite4.png"));
		} catch (IOException e) {
			System.out.println("Couldn't open a sprite file");
			System.exit(1);
		}
	}

	void add (int x, int y) {
		MouseSprite newSprite = new MouseSprite(x, y, spriteImages, this);
		currentSprites.add(newSprite);
	}

	public void paint (Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < currentSprites.size(); i++) {
			MouseSprite currentSprite = currentSprites.get(i);
			if (!currentSprite.isDone()) {
				currentSprite.draw(g);
			} else {
				currentSprite = null;
				currentSprites.remove(i);
			}
		}
	}
}