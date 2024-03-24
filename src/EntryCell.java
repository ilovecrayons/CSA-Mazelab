import java.awt.Color;

import graphics.MazeCanvas;

public class EntryCell extends EdgeCell{
  public static final Color entryColor = Color.GREEN;
  
  public EntryCell(MazeCanvas mc, int row, int col) {
    super(mc, row, col);
    mc.drawShade(row, col, entryColor);

  }
}
