package com.bryantcs.examples.MineSweeper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MineSweeperMouseListener implements MouseListener {

	private MineSweeper mineSweeper;
	private MineSweeperHelper mineSweeperHelper;

	public MineSweeperMouseListener(MineSweeper mineSweeper, MineSweeperHelper helper) {
		this.mineSweeper = mineSweeper;
		mineSweeperHelper = helper;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		for (int i = 0; i < mineSweeper.rows; i++) {
			for (int j = 0; j < mineSweeper.columns; j++) {
				if (clickedButton == mineSweeper.mineButtons[i][j]) {
					MineField.gameState state;
					if (e.getButton() == MouseEvent.BUTTON1) {
						state = mineSweeper.mineField.resolveClick(i,j, true);
						if (state == MineField.gameState.CONTINUE) {
							if (mineSweeper.mineField.getMineFlag(i, j) == Mine.flagState.UNKNOWN) {
								clickedButton.removeMouseListener(this);
							}
						}
					} else {
						state = mineSweeper.mineField.resolveClick(i,j, false);
					}
					if (state == MineField.gameState.WIN) {
						mineSweeperHelper.endGame(true);
					} else if (state == MineField.gameState.LOSE){
						mineSweeperHelper.endGame(false);
					} else {
						mineSweeperHelper.updateButtons();
					}
				}
			}
		}
		mineSweeperHelper.updateLabels();
	}
}