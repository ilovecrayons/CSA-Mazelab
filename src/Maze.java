
import java.awt.Color;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

/**
 * @author s-FEIHUANG
 * Maze class implementation
 */
public class Maze {
  private MazeCanvas mazeCanvas;

  /**
   * @param mc MazeCanvas
   */
  public Maze(MazeCanvas mc) {
    this.mazeCanvas = mc;
  }

  /**
   * draws the grids
   */
  public void drawGrids() {
    for (int row = 0; row < mazeCanvas.getRows(); row++) {
      for (int col = 0; col < mazeCanvas.getCols(); col++) {
        mazeCanvas.drawCell(row, col);
      }
    }
  }

  /**
   * generates the snake
   */
  public void genSnake() {
    this.drawGrids();
    Color darkRed = new Color(224, 0, 0);
    for (int row = 0; row < mazeCanvas.getRows(); row++) {
      for (int col = 0; col < mazeCanvas.getCols(); col++) {
        if (row == 0) {
          if (col % 2 == 0) {
            mazeCanvas.eraseWall(row, col, Side.Left);
            mazeCanvas.eraseWall(row, col, Side.Bottom);

            mazeCanvas.drawPath(row, col, Side.Left, Color.RED);
            mazeCanvas.drawPath(row, col, Side.Center, Color.RED);
            mazeCanvas.drawPath(row, col, Side.Bottom, Color.RED);
          } else {
            mazeCanvas.eraseWall(row, col, Side.Right);
            mazeCanvas.eraseWall(row, col, Side.Bottom);
            mazeCanvas.drawPath(row, col, Side.Right, Color.RED);
            mazeCanvas.drawPath(row, col, Side.Center, Color.RED);
            mazeCanvas.drawPath(row, col, Side.Bottom, Color.RED);
          }
          mazeCanvas.drawCenter(row, col, darkRed);
        } else if (row == mazeCanvas.getRows() - 1) {
          if (col % 2 == 0) {
            mazeCanvas.eraseWall(row, col, Side.Right);
            mazeCanvas.eraseWall(row, col, Side.Top);

            mazeCanvas.drawPath(row, col, Side.Right, Color.RED);
            mazeCanvas.drawPath(row, col, Side.Center, Color.RED);
            mazeCanvas.drawPath(row, col, Side.Top, Color.RED);
          } else {
            mazeCanvas.eraseWall(row, col, Side.Left);
            mazeCanvas.eraseWall(row, col, Side.Top);
            mazeCanvas.drawPath(row, col, Side.Left, Color.RED);
            mazeCanvas.drawPath(row, col, Side.Center, Color.RED);
            mazeCanvas.drawPath(row, col, Side.Top, Color.RED);
          }
          mazeCanvas.drawCenter(row, col, darkRed);
        } else {
          mazeCanvas.eraseWall(row, col, Side.Top);
          mazeCanvas.eraseWall(row, col, Side.Bottom);
          mazeCanvas.drawPath(row, col, Side.Bottom, Color.RED);
          mazeCanvas.drawCenter(row, col, Color.RED);
          mazeCanvas.drawPath(row, col, Side.Top, Color.RED);
        }

      }
    }

  }
}
