package com.bryantcs.examples.MineSweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineSweeperActionListener implements ActionListener {

	private MineSweeper mineSweeper;
	private MineSweeperHelper mineSweeperHelper;

	public MineSweeperActionListener(MineSweeper mineSweeper, MineSweeperHelper helper) {
		this.mineSweeper = mineSweeper;
		mineSweeperHelper = helper;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		if (e.getActionCommand().equals("New Game")) {
			mineSweeperHelper.newGame(mineSweeper.rows, mineSweeper.columns);
			return;
		}
		if (e.getActionCommand().equals("Small (8 x 8, 10 mines)")) {
			int previousRows = mineSweeper.rows;
			int previousColumns = mineSweeper.columns;
			mineSweeper.rows = 8;
			mineSweeper.columns = 8;
			mineSweeper.numberOfMines = 10;
			mineSweeperHelper.newGame(previousRows, previousColumns);
			return;
		}
		if (e.getActionCommand().equals("Medium (16 x 16, 40 mines)")) {
			int previousRows = mineSweeper.rows;
			int previousColumns = mineSweeper.columns;
			mineSweeper.rows = 16;
			mineSweeper.columns = 16;
			mineSweeper.numberOfMines = 40;
			mineSweeperHelper.newGame(previousRows, previousColumns);
			return;
		}
		if (e.getActionCommand().equals("Large (16 x 32, 100 mines)")) {
			int previousRows = mineSweeper.rows;
			int previousColumns = mineSweeper.columns;
			mineSweeper.rows = 16;
			mineSweeper.columns = 32;
			mineSweeper.numberOfMines = 100;
			mineSweeperHelper.newGame(previousRows, previousColumns);
			return;
		}
	}
}