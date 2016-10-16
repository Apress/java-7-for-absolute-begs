package com.bryantcs.examples.swingDemo;

import java.awt.Dimension;

import javax.swing.JFrame;

public class SwingDemo {

	private JFrame frame = new JFrame("SwingDemo");

	private void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(200, 200));
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingDemo swingDemo = new SwingDemo();
		swingDemo.createAndShowGUI();
	}
}