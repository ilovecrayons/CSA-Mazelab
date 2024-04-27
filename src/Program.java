import graphics.MazeCanvas;
import java.awt.Color;
import java.util.List;

/**
 * Program class implementation
 * 
 * @author s-FEIHUANG
 */

public class Program {
  public static final int WIDTH = 10, HEIGHT = 20, SIZE = 10;

  public static void main(String[] args) {
    MazeCanvas canvas = new MazeCanvas(WIDTH, HEIGHT, SIZE);
    Maze maze = new Maze(canvas);
    canvas.open();
    maze.initialize();
    Generator generator = new Generator(canvas, maze);
    generator.run();
    List<Cell> path = maze.astar();
    for (int i = 1; i < path.size() - 1; i++) {
      Cell cur = path.get(i);
      Cell next = path.get(i + 1);
      Cell prev = path.get(i - 1);
      canvas.drawCenter(cur.getRow(), cur.getCol(), Color.RED);
      
      if (cur.getRow() < next.getRow()) {
        canvas.drawPath(cur.getRow(), cur.getCol(), MazeCanvas.Side.Bottom, Color.RED);
      } else if (cur.getRow() > next.getRow()) {
        canvas.drawPath(cur.getRow(), cur.getCol(), MazeCanvas.Side.Top, Color.RED);
      } else if (cur.getCol() < next.getCol()) {
        canvas.drawPath(cur.getRow(), cur.getCol(), MazeCanvas.Side.Right, Color.RED);
      } else if (cur.getCol() > next.getCol()) {
        canvas.drawPath(cur.getRow(), cur.getCol(), MazeCanvas.Side.Left, Color.RED);
      }

      if (cur.getRow() < prev.getRow()) {
        canvas.drawPath(cur.getRow(), cur.getCol(), MazeCanvas.Side.Bottom, Color.RED);
      } else if (cur.getRow() > prev.getRow()) {
        canvas.drawPath(cur.getRow(), cur.getCol(), MazeCanvas.Side.Top, Color.RED);
      } else if (cur.getCol() < prev.getCol()) {
        canvas.drawPath(cur.getRow(), cur.getCol(), MazeCanvas.Side.Right, Color.RED);
      } else if (cur.getCol() > prev.getCol()) {
        canvas.drawPath(cur.getRow(), cur.getCol(), MazeCanvas.Side.Left, Color.RED);
      }

    }
    canvas.pause();
    canvas.close();

  }
}
