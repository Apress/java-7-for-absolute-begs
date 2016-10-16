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

public class ScootBall implements ActionListener {

	private static final long serialVersionUID = 1L;

	ScootBallPanel scootBallPanel = new ScootBallPanel();
	JFrame frame = new JFrame("ScootBall");
	JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton scootButton=new JButton("Scoot");
	Thread animationThread = null;

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
		scootButton.addActionListener(this);
		buttonPanel.add(scootButton);
		scootBallPanel.setPreferredSize(new Dimension(400, 200));
		scootBallPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(scootBallPanel,BorderLayout.CENTER);
		frame.getContentPane().add(scootBallPanel);
		frame.getContentPane().add(buttonPanel,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		ScootBall scootBall = new ScootBall();
		scootBall.createAndShowGUI();
	}

	// The actionPerformed method listens for actions taken by the user
	public void actionPerformed(ActionEvent e) {
		// If the user chooses Exit, then exit
		if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		// Since we didn't exit, check for whether the user clicked the Scoot button
		// and ignore the click if a ball is already moving. If not, start one moving.
		if (e.getActionCommand().equals("Scoot") && scootBallPanel.isAnimating() == false) {
			scootBallPanel.reset();
			animationThread = new Thread(scootBallPanel);
			scootBallPanel.setAnimating(true);
			animationThread.start();
		}
	}
}