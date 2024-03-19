import java.util.*;
import graphics.*;
import graphics.MazeCanvas.Side;
import java.awt.Color;

public class ShadedCell extends Cell {
  
  private Color shadeColor;

  public ShadedCell(MazeCanvas mazeCanvas, int row, int col, Color shadeColor) {
    super(mazeCanvas, row, col);
    mazeCanvas.drawCell(row, col);
    this.shadeColor = shadeColor;
    mazeCanvas.drawShade(row, col, shadeColor);
  }

  
}