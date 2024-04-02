import java.util.*;
import graphics.*;
import graphics.MazeCanvas.Side;

public class Cell {
  private int row;
  private int col;
  private MazeCanvas mc;
  private ArrayList<Side> listOfWalls;
  private boolean visited = false;

  public boolean getVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public Cell(MazeCanvas mc, int row, int col) {
    this.row = row;
    this.col = col;
    this.mc = mc;
    this.listOfWalls = new ArrayList<Side>();
    this.listOfWalls.add(Side.Top);
    this.listOfWalls.add(Side.Bottom);
    this.listOfWalls.add(Side.Left);
    this.listOfWalls.add(Side.Right);
    this.mc.drawCell(row, col);
  }

  public int getRow() {
    return this.row;
  }

  public int getCol() {
    return this.col;
  }

  public ArrayList<Side> getWalls() {
    return new ArrayList<Side>(this.listOfWalls);
  }

  public void removeWall(Side side) {
    this.mc.eraseWall(this.row, this.col, side);
    listOfWalls.remove(side);
  }
  

}
