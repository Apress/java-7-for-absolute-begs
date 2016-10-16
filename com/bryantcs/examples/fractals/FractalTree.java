package com.bryantcs.examples.fractals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FractalTree implements ActionListener {

	private FractalTreePanel
	fractalTreePanel = new FractalTreePanel();

	private JFrame frame = new JFrame("Fractal Tree");

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
		fractalTreePanel.setPreferredSize(new Dimension(600, 450));
		fractalTreePanel.setBackground(Color.WHITE);
		frame.getContentPane().add(fractalTreePanel);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		FractalTree fractalTree = new FractalTree();
		fractalTree.createAndShowGUI();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() != null) {
			if (e.getActionCommand().equals("Exit")) {
				System.exit(0);
			}
			if (e.getActionCommand().equals("Repaint")) {
				fractalTreePanel.repaint();
			}
		}
	}
}