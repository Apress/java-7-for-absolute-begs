package com.bryantcs.examples.videogames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TargetClick implements ActionListener {

	// Create the user interface components
	private TargetClickPanel targetClickPanel = new TargetClickPanel();
	private JPanel scorePanel = new JPanel();
	private JLabel timeLabel = new JLabel("Time: ");
	private JLabel scoreLabel = new JLabel("          Targets Hit: ");
	private JLabel timeDisplayLabel = new JLabel("0");
	private JLabel scoreDisplayLabel = new JLabel("0");
	private JFrame frame = new JFrame("TargetClick");

	// Create the timer, which will manage the game loop
	private Timer timer = new Timer(400, this);

	// Create some other bits needed by the game logic
	static Random random = new Random();
	static int score;
	private long startTime;
	long elapsedTime = 0;
	private int gameLength = 50;










	// Add a menu, as we've seen before
	private void addMenu(JFrame frame) {
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		JMenuItem exitItem = new JMenuItem("Exit");
		JMenuItem newGameItem = new JMenuItem("New Game");
		JMenuItem gameLengthItem = new JMenuItem("Set Game Length");
		exitItem.setMnemonic('x');
		exitItem.addActionListener(this);
		newGameItem.setMnemonic('n');
		newGameItem.addActionListener(this);
		gameLengthItem.setMnemonic('s');
		gameLengthItem.addActionListener(this);
		file.add(exitItem);
		file.add(newGameItem);
		file.add(gameLengthItem);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(file);
		frame.setJMenuBar(menuBar);
	}

	// Display the user interface, as we've seen before
	private void createAndShowGUI() {
		addMenu(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		targetClickPanel.setPreferredSize(new Dimension(400, 200));
		targetClickPanel.setBackground(Color.WHITE);
		scorePanel.setPreferredSize(new Dimension(400, 50));
		scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.X_AXIS));
		scorePanel.add(timeLabel);
		scorePanel.add(timeDisplayLabel);
		scorePanel.add(scoreLabel);
		scorePanel.add(scoreDisplayLabel);
		frame.getContentPane().add(scorePanel);
		frame.getContentPane().add(targetClickPanel);
		frame.getContentPane().setLayout(new
				BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.pack();
		frame.setVisible(true);
	}

	// start or restart the game
	private void init() {
		timer.start();
		startTime = System.currentTimeMillis();
	}

	// The main method  
	public static void main(String[] args) {
		TargetClick targetClick = new TargetClick();
		targetClick.createAndShowGUI();
		targetClick.init();
	}

	// The game loop (which isn't a loop)
	// Also contains the game logic
	public void actionPerformed(ActionEvent e) {
		// check for user input (step 1 in a game loop)
		if (e.getActionCommand() != null) {
			if (e.getActionCommand().equals("Exit")) {
				timer.stop();
				System.exit(0);
			}
			if (e.getActionCommand().equals("New Game")){
				newGame();
			}
			if (e.getActionCommand().equals("Set Game Length")) {
				String option = JOptionPane.showInputDialog(frame,
						"Number of Targets:");
				if (option != null) {
					gameLength = Integer.parseInt(option);
				}
				newGame();
			}
		}
		// update the score
		updateScorePanel();
		// game over? (part of step 2 in a game loop)
		// the rest of step 2 (processing the game logic)
		// is in the TargetClickPanel and Target classes
		if (score == gameLength) {
			endGame();
		}
		// redraw the playing field (step 3 in a game loop)
		targetClickPanel.repaint();
	}

	// A convenience method for showing the time and score
	private void updateScorePanel() {
		elapsedTime = System.currentTimeMillis() - startTime;
		timeDisplayLabel.setText(Long.toString(elapsedTime / 1000));
		scoreDisplayLabel.setText(Integer.toString(score));




	}

	// What to do when the game ends – part of the game logic
	private void endGame() {
		timer.stop();
		String scoreString = "You clicked " + gameLength +
				" targets in " + (elapsedTime / 1000) + " seconds";
		int option;
		option = JOptionPane.showConfirmDialog(frame, scoreString 
				+ " Play again?", "Game Over",
				JOptionPane.YES_NO_OPTION); 
		if (option == 1) {
			System.exit(0);
		} else {
			newGame();
		}
	}

	// What to do when the user starts a new game
	private void newGame() {
		score = 0;
		scoreDisplayLabel.setText("0");
		startTime = System.currentTimeMillis();
		timeDisplayLabel.setText("0");
		if (!timer.isRunning()) {
			timer.start();
		}
	}
}