package com.bryantcs.examples.fractals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SierpinskiTriangle implements ActionListener {

	private SierpinskiTrianglePanel
	sierpinskiTrianglePanel = new SierpinskiTrianglePanel();
	private JFrame frame = new JFrame("Sierpinski Triangle");

	private void addMenu(JFrame frame) {
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('x');
		exitItem.addActionListener(this);
		file.add(exitItem);
		JMenuItem redrawItem = new JMenuItem("Repaint");
		redrawItem.setMnemonic('r');
		redrawItem.addActionListener(this);
		file.add(redrawItem);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(file);
		frame.setJMenuBar(menuBar);
	}

	private void createAndShowGUI() {
		addMenu(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sierpinskiTrianglePanel.setPreferredSize(new Dimension(400, 400));
		sierpinskiTrianglePanel.setBackground(Color.WHITE);
		frame.getContentPane().add(sierpinskiTrianglePanel);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		SierpinskiTriangle sierpinskiTriangle = new SierpinskiTriangle();
		sierpinskiTriangle.createAndShowGUI();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() != null) {
			if (e.getActionCommand().equals("Exit")) {
				System.exit(0);
			}
			if (e.getActionCommand().equals("Repaint")) {
				sierpinskiTrianglePanel.repaint();
			}
		}
	}
}