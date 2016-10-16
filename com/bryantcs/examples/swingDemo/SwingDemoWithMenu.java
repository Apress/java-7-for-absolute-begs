package com.bryantcs.examples.swingDemo;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SwingDemoWithMenu implements ActionListener {

	private JFrame frame = new JFrame("SwingDemo");

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(200, 200));
		addMenu(frame);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingDemoWithMenu swingDemo = new SwingDemoWithMenu();
		swingDemo.createAndShowGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
	}
}
