package com.bryantcs.examples.animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

public class MouseSprites implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private MouseSpritePanel mouseSpritePanel = new MouseSpritePanel();
	private JFrame frame = new JFrame("MouseSprites");
	// Here's our very slow timer. 4 times a second – vroom!
	private Timer timer = new Timer(250, this);

	private void addMenu(JFrame frame) {
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('x');
		exitItem.addActionListener(this);
		file.add(exitItem);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(file);
		frame.setJMenuBar(menuBar);
	}

	private void createAndShowGUI() {
		addMenu(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouseSpritePanel.setPreferredSize(new Dimension(400, 200));
		mouseSpritePanel.addMouseListener(this);
		mouseSpritePanel.setBackground(Color.WHITE);
		frame.getContentPane().add(mouseSpritePanel);
		frame.pack();
		frame.setVisible(true);
		timer.start();
	}

	public static void main(String[] args) {
		MouseSprites mouseSprite = new MouseSprites();
		mouseSprite.createAndShowGUI();
	}

	// This method listens to the timer
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() != null) {
			// If the user chooses Exit, we exit
			if (e.getActionCommand().equals("Exit")) {
				timer.stop();
				System.exit(0);
			}
		}
		// otherwise, we redraw the panel
		// (which is how we achieve animation)
		mouseSpritePanel.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	// This method adds a new expanding bullseye.
	@Override
	public void mouseReleased(MouseEvent e) {
		mouseSpritePanel.add(e.getX(), e.getY());
	}
}