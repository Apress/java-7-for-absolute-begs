package com.bryantcs.examples.MineSweeper;

public class Mine {

	enum flagState {UNKNOWN, MINE, SUSPECT};
	private boolean isCleared = false;
	private boolean hasMine = false;
	private flagState flag = flagState.UNKNOWN;
	boolean hasMine() {
		return hasMine;
	}

	void setMine() {
		hasMine = true;
	}

	boolean isCleared() {
		return isCleared;
	}

	void clear() {
		isCleared = true;
	}

	flagState getFlagState() {
		return flag;
	}

	flagState setFlagState() {
		if (flag == flagState.UNKNOWN) {
			flag = flagState.MINE;
			return flagState.MINE;
		}
		if (flag == flagState.MINE) {
			flag = flagState.SUSPECT;
			return flagState.SUSPECT;
		}
		if (flag == flagState.SUSPECT) {
			flag = flagState.UNKNOWN;
			return flagState.UNKNOWN;
		}
		return flagState.UNKNOWN;
	}
}