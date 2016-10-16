package com.bryantcs.examples.MineSweeper;


public class MineField {

	private Mine[][] mineField;
	private int rows;
	private int columns;
	private int mines;
	private int minesFound = 0;
	private int minesRemaining;
	private int emptiesRemaining;
	enum gameState {WIN, LOSE, CONTINUE};

	MineField(int rows, int columns, int mines) {
		this.rows = rows;
		this.columns = columns;
		this.mines = mines;
		minesRemaining = mines;
		emptiesRemaining = rows * columns - mines;
		mineField = new Mine[rows][columns];
		init();
		populate();
	}

	private void init() {
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++) {
				mineField[i][j] = new Mine();
			}
		}
	}
	gameState resolveClick(int x, int y, boolean left) {
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++) {
				if (i == x && j == y) {
					Mine thisMine = mineField[i][j];
					if (left) {
						if (thisMine.getFlagState() ==
								Mine.flagState.MINE) {
							return gameState.CONTINUE;
						}
						if (thisMine.isCleared()) 
							return gameState.CONTINUE;
						if (thisMine.hasMine()) {
							return gameState.LOSE;
						} else {
							return cascade(i, j);
						}
					} else {
						Mine.flagState state =
								thisMine.setFlagState();
						if(state == Mine.flagState.MINE) {
							minesFound++;
							minesRemaining--;
						} else if(state == Mine.flagState.SUSPECT) {
							minesFound--;
							minesRemaining++;
						}
					}
				}
			}
		}
		return gameState.CONTINUE;
	}

	private void populate() {
		populate(0);
	}


	private void populate(int mineCount) {
		int currentCount = mineCount;
		double mineChance = (double) mines / (double) (rows * columns);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Mine thisMine = mineField[i][j];
				if (!thisMine.hasMine()) {
					if (Math.random() < mineChance) {
						thisMine.setMine();
						currentCount++;
						if (currentCount == mines) {
							return;
						}
					}
				}
			}
		}
		if (currentCount < mines) {
			populate(currentCount);
		}
	}

	int getMinesFound() {
		return minesFound;
	}

	int getMinesRemaining() {
		return minesRemaining;
	}

	private gameState cascade(int x, int y) {
		if (x < 0 || y < 0 || x >= rows || y >= columns) {
			return gameState.CONTINUE;
		}
		Mine thisMine = mineField[x][y];
		if (thisMine.hasMine()) {
			return gameState.CONTINUE;
		}
		if (!thisMine.isCleared()) {
			thisMine.clear();
			emptiesRemaining--;
			if (emptiesRemaining == 0) {
				return gameState.WIN;
			}
		}
		if (countAdjacentMines(x, y) > 0) {
			return gameState.CONTINUE;
		} else{
			for (int i = x - 1; i <= x + 1; i++) {
				for (int j = y - 1; j <= y + 1; j++) {
					if (i < 0 || j < 0 || i >= rows || j >= columns) {
						continue;
					} else if (!mineField[i][j].isCleared()) {
						cascade(i, j);
					}
				}
			}
		}
		return gameState.CONTINUE;
	}

	int countAdjacentMines(int x, int y) {
		int count = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i == x && j == y) {
					continue;
				} else if (i < 0 || j < 0 || i >= rows || j >= columns) {
					continue;
				} else if (mineField[i][j].hasMine()) {
					count++;
				}
			}
		}
		return count;
	}

	boolean getMineCleared(int x, int y) {
		return mineField[x][y].isCleared();
	}
	Mine.flagState getMineFlag(int x, int y) {
		return mineField[x][y].getFlagState();
	}

	boolean isMine(int x, int y) {
		return mineField[x][y].hasMine();
	}
}