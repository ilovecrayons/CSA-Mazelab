import java.awt.Color;
import java.util.List;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Generator {
  MazeCanvas mc;
  Maze maze;
  Color generatorClassColor = Color.GREEN;

  public Generator(MazeCanvas mc, Maze m) {
    this.mc = mc;
    this.maze = m;
  }

  public List<Side> shuffle(List<Side> sides) {
    for (int i = 0; i < sides.size(); i++) {
      int j = (int) (Math.random() * sides.size());
      Side temp = sides.get(i);
      sides.set(i, sides.get(j));
      sides.set(j, temp);
    }
    return sides;
  }
  
  public Side getOpposite(Side side) {
    switch (side) {
      case Top:
        return Side.Bottom;
      case Bottom:
        return Side.Top;
      case Left:
        return Side.Right;
      case Right:
        return Side.Left;
      case Center:
        return Side.Center;
      default:
        return null;
    }
  }

  public boolean run(Cell cell, Side fromSide) {
  
    cell.setVisited(true);
    mc.drawPath(cell.getRow(), cell.getCol(), Side.Center,generatorClassColor);
    mc.drawPath(cell.getRow(), cell.getCol(), fromSide, generatorClassColor);
    cell.removeWall(fromSide);
    List<Side> sides = shuffle(cell.getWalls());
    for (Side side : sides) {
      Cell neighbor = maze.getNeighbor(cell, side);
      if (!neighbor.getVisited()) {
        mc.drawPath(cell.getRow(), cell.getCol(), side, generatorClassColor);
        cell.removeWall(side);
        this.run(neighbor, getOpposite(side));
        mc.erasePath(cell.getRow(), cell.getCol(), side);
      }
    }
    mc.erasePath(cell.getRow(), cell.getCol(), Side.Center);
    mc.erasePath(cell.getRow(), cell.getCol(), fromSide);
    return false;
  }

  public boolean run() {
    return run(maze.getEntryCell(), Side.Center);
  }
}
