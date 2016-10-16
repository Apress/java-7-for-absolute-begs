package com.bryantcs.examples.MineSweeper;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MineSweeperHelper {

	private MineSweeper mineSweeper;

	public MineSweeperHelper(MineSweeper mineSweeper) {
		this.mineSweeper = mineSweeper;
	}

	void updateLabels() {
		mineSweeper.minesFoundLabel.setText("Found: " + mineSweeper.mineField.getMinesFound());
		mineSweeper.minesRemainingLabel.setText("Remaining: " +
				mineSweeper.mineField.getMinesRemaining());
	}

	void updateButtons() {
		for (int i = 0; i < mineSweeper.rows; i++) {
			for (int j = 0; j < mineSweeper.columns; j++) {
				if (mineSweeper.mineField.getMineCleared(i, j) == true) {
					mineSweeper.mineButtons[i][j].removeMouseListener(mineSweeper.mouseListener);
					mineSweeper.mineButtons[i][j].setBackground(Color.WHITE);
					int count = mineSweeper.mineField.countAdjacentMines(i, j); 
					if (count > 0) {
						mineSweeper.mineButtons[i][j].setIcon(MineIcon.getNumberIcon(count));
					}
				} else {
					if (mineSweeper.mineField.getMineFlag(i, j) == Mine.flagState.MINE) {
						mineSweeper.mineButtons[i][j].setIcon(MineIcon.getMineIcon());
					} else if (mineSweeper.mineField.getMineFlag(i, j) == Mine.flagState.SUSPECT) {
						mineSweeper.mineButtons[i][j].setIcon(MineIcon.getSuspectIcon());
					} else {
						mineSweeper.mineButtons[i][j].setIcon(null);
					}
				}
			}
		}
	}

	void showAll() {
		for (int i = 0; i < mineSweeper.rows; i++) {
			for (int j = 0; j < mineSweeper.columns; j++) {
				boolean mine = mineSweeper.mineField.isMine(i, j);
				if (mine) {
					mineSweeper.mineButtons[i][j].setIcon(MineIcon.getMineIcon());
				} else {
					JButton thisButton = mineSweeper.mineButtons[i][j];
					thisButton.removeMouseListener(mineSweeper.mouseListener);
					thisButton.setBackground(Color.WHITE);
					thisButton.setIcon(null);
					int count = mineSweeper.mineField.countAdjacentMines(i, j);
					if (count > 0) {
						thisButton.setIcon(MineIcon.getNumberIcon(count));
					}
				}
			}
		}
	}

	void endGame(boolean won) {
		showAll();
		String wonOrLost;
		int option;
		if (won) {
			wonOrLost = "You won!";
		} else {
			wonOrLost = "You lost.";
		}
		option = JOptionPane.showConfirmDialog(mineSweeper.frame, wonOrLost
				+ " Play again?", wonOrLost,
				JOptionPane.YES_NO_OPTION); 
		if (option == 1) {
			System.exit(0);
		} else {
			newGame(mineSweeper.rows, mineSweeper.columns);
		}
	}

	void newGame(int previousRows, int previousColumns) {
		for (int i = 0; i < previousRows; i++) {
			for (int j = 0; j < previousColumns; j++) {
				mineSweeper.minePanel.remove(mineSweeper.mineButtons[i][j]);
			}
		}
		mineSweeper.init();
		mineSweeper.minePanel.validate();
		mineSweeper.frame.validate();
		mineSweeper.frame.pack();
		updateLabels();
	}
}