package com.bryantcs.examples.animation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fireworks implements ActionListener {

	private static final long serialVersionUID = 1L;

	FireworksPanel fireworksPanel = new FireworksPanel();
	JFrame frame = new JFrame("Fireworks");
	JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton actionButton=new JButton("Go");
	boolean animating = false;
	// Here's the timer, which checks for user actions
	// and, if the animation is running, redraws the
	// screen. It does both 25 times per second
	// (1000 milliseconds divided by 40).
	Timer timer = new Timer(40, this);

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
		frame.getContentPane().setLayout(new BorderLayout());
		actionButton.addActionListener(this);
		buttonPanel.add(actionButton);
		fireworksPanel.setPreferredSize(new Dimension(400, 200));
		fireworksPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(fireworksPanel,BorderLayout.CENTER);
		frame.getContentPane().add(fireworksPanel);
		frame.getContentPane().add(buttonPanel,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Fireworks fireworks = new Fireworks();
		fireworks.createAndShowGUI();
	}

	// This method listens to the timer. The
	// program goes through it every 40th of a
	// second, giving us a Hertz or frame rate of 25.
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() != null) {
			// Check for the user choosing Exit
			// from the file menu and exit if so
			if (e.getActionCommand().equals("Exit")) {
				System.exit(0);
			}
			// Check for the Go button being clicked and, if so,
			// start the animation and set the button to Stop
			if (e.getActionCommand().equals("Go")) {
				animating = true;
				timer.start();
				actionButton.setText("Stop");
			}
			// Check for the Stop button being clicked and, if so,
			// stop the animation and set the button to Go
			if (e.getActionCommand().equals("Stop")) {
				animating = false;
				timer.stop();
				actionButton.setText("Go");
			}
		}
		// If the animation is running (the user has
		// clicked Go but not Stop), repaint the window
		// which is how we create the animation).
		if (animating){
			fireworksPanel.repaint();
		}
	}
}