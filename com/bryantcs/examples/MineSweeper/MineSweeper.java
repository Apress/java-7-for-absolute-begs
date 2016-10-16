package com.bryantcs.examples.MineSweeper;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.Border;

public class MineSweeper {

	int columns = 8;
	int rows = 8;
	int numberOfMines = 10;

	JFrame frame = new JFrame("MineSweeper");
	JPanel minePanel = new JPanel();
	JLabel minesRemainingLabel = new JLabel("Remaining:");
	JLabel minesFoundLabel = new JLabel("Found: 0");
	JButton[][] mineButtons;
	Dimension buttonSize = new Dimension(20, 20);

	MineField mineField;
	MineSweeperMouseListener mouseListener;
	MineSweeperActionListener actionListener;
	MineSweeperHelper helper;

	public MineSweeper() {
		helper = new MineSweeperHelper(this);
		actionListener = new MineSweeperActionListener(this, helper);
		mouseListener = new MineSweeperMouseListener(this, helper);
		init();
	}

	void init() {
		mineButtons = new JButton[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				JButton currentButton = new JButton();
				mineButtons[i][j] = currentButton;
				currentButton.setPreferredSize(buttonSize);
				currentButton.setMaximumSize(buttonSize);
				currentButton.setMinimumSize(buttonSize);
				currentButton.addMouseListener(mouseListener);
				currentButton.setEnabled(true);
				currentButton.setText("");
				currentButton.setIcon(null);
			}
		}
		minePanel.setLayout(new GridLayout(rows, columns));
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				minePanel.add(mineButtons[i][j]);
			}
		}
		mineField = new MineField(rows, columns, numberOfMines);
	}

	private void addAndArrangePanels(JFrame frame) {
		Border paddingBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		JPanel controlPanel = new JPanel();
		minesFoundLabel.setBorder(paddingBorder);
		minesFoundLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		minesRemainingLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		minesRemainingLabel.setBorder(paddingBorder);
		minesRemainingLabel.setText("Remaining: " + mineField.getMinesRemaining());
		controlPanel.add(minesFoundLabel);
		controlPanel.add(minesRemainingLabel);
		GridLayout gridLayout = new GridLayout(1,2);
		controlPanel.setLayout(gridLayout);
		frame.getContentPane().add(controlPanel);
		frame.getContentPane().add(minePanel);
	}

	private void addMenu(JFrame frame) {
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		JMenuItem newItem = new JMenuItem("New Game");
		newItem.setMnemonic('n');
		newItem.addActionListener(actionListener);
		file.add(newItem);
		ButtonGroup sizeOptions = new ButtonGroup();
		JRadioButtonMenuItem smallOption = new JRadioButtonMenuItem("Small (8 x 8, 10 mines)");
		smallOption.setMnemonic('s');
		smallOption.addActionListener(actionListener);
		sizeOptions.add(smallOption);
		file.add(smallOption);
		JRadioButtonMenuItem mediumOption =
				new JRadioButtonMenuItem("Medium (16 x 16, 40 mines)");
		mediumOption.setMnemonic('m');
		mediumOption.addActionListener(actionListener);
		sizeOptions.add(mediumOption);
		file.add(mediumOption);
		JRadioButtonMenuItem largeOption =
				new JRadioButtonMenuItem("Large (16 x 32, 100 mines)");
		largeOption.setMnemonic('l');
		largeOption.addActionListener(actionListener);
		sizeOptions.add(largeOption);
		file.add(largeOption);
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('x');
		exitItem.addActionListener(actionListener);
		file.add(exitItem);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(file);
		frame.setJMenuBar(menuBar);
	}

	private void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane()
		.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		addAndArrangePanels(frame);
		addMenu(frame);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		MineSweeper mineSweeper = new MineSweeper();
		mineSweeper.createAndShowGUI();
	}
}