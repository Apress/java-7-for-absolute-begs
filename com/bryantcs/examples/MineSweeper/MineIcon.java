package com.bryantcs.examples.MineSweeper;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MineIcon {

  private static Icon mineIcon = new ImageIcon("C:\\Projects\\\\mine.png");
  private static Icon suspectIcon = new ImageIcon("C:\\Projects\\question.png");
  private static Icon oneIcon = new ImageIcon("C:\\Projects\\one.png");
  private static Icon twoIcon = new ImageIcon("C:\\Projects\\two.png");
  private static Icon threeIcon = new ImageIcon("C:\\Projects\\three.png");
  private static Icon fourIcon = new ImageIcon("C:\\Projects\\four.png");
  private static Icon fiveIcon = new ImageIcon("C:\\Projects\\five.png");
  private static Icon sixIcon = new ImageIcon("C:\\Projects\\six.png");
  private static Icon sevenIcon = new ImageIcon("C:\\Projects\\seven.png");
  private static Icon eightIcon = new ImageIcon("C:\\Projects\\eight.png");

  static Icon getMineIcon() {
    return mineIcon;
  }

  static Icon getSuspectIcon() {
    return suspectIcon;
  }

  static Icon getNumberIcon(int mineCount) {
    if (mineCount == 1) return oneIcon;
    if (mineCount == 2) return twoIcon;
    if (mineCount == 3) return threeIcon;
    if (mineCount == 4) return fourIcon;
    if (mineCount == 5) return fiveIcon;
    if (mineCount == 6) return sixIcon;
    if (mineCount == 7) return sevenIcon;
    if (mineCount == 8) return eightIcon;
    return null;
  }
}