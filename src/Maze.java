
import java.awt.Color;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

/**
 * @author s-FEIHUANG
 *         Maze class implementation
 */
public class Maze {
  private MazeCanvas mazeCanvas;
  private Cell[][] gridOfCells;

  /**
   * @param mc MazeCanvas
   */
  public Maze(MazeCanvas mc) {
    this.mazeCanvas = mc;
    gridOfCells = new Cell[mazeCanvas.getRows()][mazeCanvas.getCols()];
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

  public void initialize() {
    int count = (int) (0.05 * (mazeCanvas.getRows() - 2) * (mazeCanvas.getCols() - 2));
    int nPerim = 2 * mazeCanvas.getRows() + 2 * mazeCanvas.getCols() - 4;
    int iEntry = (int) (Math.random() * nPerim);
    int iExit = (int) (Math.random() * nPerim);
    int edgeCount = 0;
    for (int row = 0; row < mazeCanvas.getRows(); row++) {
      for (int col = 0; col < mazeCanvas.getCols(); col++) {
        if (row == 0 || row == mazeCanvas.getRows() - 1 || col == 0 || col == mazeCanvas.getCols() - 1) {
          if (edgeCount == iEntry) {
            gridOfCells[row][col] = new EntryCell(mazeCanvas, row, col);
          } else if (edgeCount == iExit) {
            gridOfCells[row][col] = new ExitCell(mazeCanvas, row, col);
          } else {
            gridOfCells[row][col] = new EdgeCell(mazeCanvas, row, col);
          }
          edgeCount++;
        } else if (count > 0 && Math.random() < 0.05) {
          gridOfCells[row][col] = new BlockCell(mazeCanvas, row, col);
          count--;
        } else {
          gridOfCells[row][col] = new Cell(mazeCanvas, row, col);
        }
      }
    }
  }

  public Cell getEntryCell() {
    for (int row = 0; row < mazeCanvas.getRows(); row++) {
      for (int col = 0; col < mazeCanvas.getCols(); col++) {
        if (gridOfCells[row][col] instanceof EntryCell) {
          return (EntryCell) gridOfCells[row][col];
        }
      }
    }
    return null;
  }

  public Cell getExitCell() {
    for (int row = 0; row < mazeCanvas.getRows(); row++) {
      for (int col = 0; col < mazeCanvas.getCols(); col++) {
        if (gridOfCells[row][col] instanceof ExitCell) {
          return (ExitCell) gridOfCells[row][col];
        }
      }
    }
    return null;
  }

  public Cell getCell(int row, int col) {
    return gridOfCells[row][col];
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

  public boolean inBounds(int row, int col) {
    return row >= 0 && row < mazeCanvas.getRows() && col >= 0 && col < mazeCanvas.getCols();
  }

  public Cell getNeighbor(Cell cell, Side side) {
    int row = cell.getRow();
    int col = cell.getCol();

    switch (side) {
      case Top:
        return (inBounds(row - 1, col) ? getCell(row - 1, col) : null);
      case Bottom:
        return (inBounds(row + 1, col) ? getCell(row + 1, col) : null);
      case Left:
        return (inBounds(row, col - 1) ? getCell(row, col - 1) : null);
      case Right:
        return (inBounds(row, col + 1) ? getCell(row, col + 1) : null);
      default:
        return null;
    }
  }
}
