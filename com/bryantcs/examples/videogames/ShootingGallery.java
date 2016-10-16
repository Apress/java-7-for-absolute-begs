package com.bryantcs.examples.videogames;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ShootingGallery implements ActionListener {

	// Define the components
	private ShootingGalleryPanel shootingGalleryPanel;
	private JPanel scorePanel = new JPanel();
	private JLabel scoreLabel = new JLabel("Score: ");
	static JLabel scoreDisplayLabel = new JLabel("0");
	private JFrame frame = new JFrame("Shooting Gallery");
	// Set up a place to keep score (default is 0)
	static int score;
	// Set the game size
	static Dimension gameDimension = new Dimension(500, 500);

	// Add a menu (just one option, Exit)
	private void addMenu(JFrame frame) {
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('x');
		exitItem.addActionListener(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(file);
		frame.setJMenuBar(menuBar);
	}

	// Setup and display the user interface
	private void createAndShowGUI() {
		shootingGalleryPanel = new ShootingGalleryPanel();
		addMenu(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		shootingGalleryPanel.setPreferredSize(gameDimension);
		scorePanel.setPreferredSize(new Dimension(400, 50));
		scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.X_AXIS));
		scorePanel.add(scoreLabel);
		scorePanel.add(scoreDisplayLabel);
		frame.getContentPane().add(scorePanel);
		frame.getContentPane().add(shootingGalleryPanel);
		frame.getContentPane().setLayout(new
				BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}

	// The main method
	public static void main(String[] args) {
		ShootingGallery shootingGallery = new ShootingGallery();
		shootingGallery.createAndShowGUI();
	}

	// Listen for the user choosing Exit from the menu
	// 
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() != null) {
			if (e.getActionCommand().equals("Exit")) {
				System.exit(0);
			}
		}
	}
}