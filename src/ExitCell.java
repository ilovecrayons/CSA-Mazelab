import java.awt.Color;

import graphics.MazeCanvas;

public class ExitCell extends EdgeCell{
  public static final Color exitColor = Color.MAGENTA;
  public ExitCell(MazeCanvas mc, int row, int col) {
    super(mc, row, col);
    mc.drawShade(row, col, exitColor);
  }
}
