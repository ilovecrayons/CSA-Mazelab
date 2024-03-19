import java.awt.Color;
import java.util.ArrayList;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class EdgeCell extends ShadedCell {
  
  private static Color edgeColor = Color.CYAN;
  private ArrayList<Side> listOfEdges;

  public EdgeCell(MazeCanvas mc, int row, int col) {
    super(mc, row, col, edgeColor);
    listOfEdges = new ArrayList<Side>();
    if (row == 0) {
      listOfEdges.add(Side.Top);
    }
    if (row == mc.getRows() - 1) {
      listOfEdges.add(Side.Bottom);
    }
    if (col == 0) {
      listOfEdges.add(Side.Left);
    }
    if (col == mc.getCols() - 1) {
      listOfEdges.add(Side.Right);
    }
  }

  @Override public ArrayList<Side> getWalls() {
    ArrayList<Side> ans = new ArrayList<Side>(super.getWalls());
    for (Side s : listOfEdges) {
      if (ans.contains(s)) {
        ans.remove(s);
      }
    }
    return ans;
  }
}
