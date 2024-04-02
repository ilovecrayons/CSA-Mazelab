import java.awt.Color;

import graphics.MazeCanvas;

public class BlockCell extends ShadedCell{
  private static final Color blockShadeColor = Color.LIGHT_GRAY;
  
  public BlockCell(MazeCanvas mazeCanvas, int row, int col) {
    super(mazeCanvas, row, col, blockShadeColor);
  }
  
  @Override
  public boolean getVisited() {
    return true;
  }
}
