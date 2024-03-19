import graphics.MazeCanvas;

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
    canvas.pause();
    canvas.close();

  }
}
