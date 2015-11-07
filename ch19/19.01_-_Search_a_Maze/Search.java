import java.util.*;
import java.io.*;

class Point {
  public int row, col;
  public Point(int row, int col) {
    this.row = row;
    this.col = col;
  }
  @Override
  public boolean equals(Object obj) {
    if (obj == this)
      return true;
    if (!(obj instanceof Point))
      return false;
    Point b = (Point)obj;
    return this.row == b.row && this.col == b.col;
  }
}

public class Search {
  public static int[] rcoords = new int[]{0, 1, 0, -1};
  public static int[] ccoords = new int[]{1, 0, -1, 0};
  public static boolean inBounds(boolean[][] maze, Point point, int m, int n) {
    int row = point.row;
    int col = point.col;
    if (row < 0 || col < 0 || row >= m || col >= n)
      return false;
    if (maze[row][col] == true) return false;
    return true;
  }

  public static boolean dfs(boolean[][] maze, Point current, Point exit, int m, int n, Stack<Point> path) {
    if (current.row == exit.row && current.col == exit.col) 
      return true;
    int row = current.row;
    int col = current.col;

    for (int i = 0; i < 4; i++) {
      Point newPoint = new Point(row + rcoords[i], col + ccoords[i]);
      if (inBounds(maze, newPoint, m, n)) {
        maze[newPoint.row][newPoint.col] = true;
        path.push(newPoint);
        if (dfs(maze, newPoint, exit, m, n, path))
          return true;
        path.pop();
      }
    }
    return false;
  } 
  public static Stack<Point> computePath(boolean[][] maze, Point entrance, Point exit, int m, int n) {
    Stack<Point> path = new Stack<Point>();
    maze[entrance.row][entrance.col] = true;
    path.push(entrance);
    if (!dfs(maze, entrance, exit, m, n, path))
      path.pop();
    return path;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int m = Integer.parseInt(line[0]);
    int n = Integer.parseInt(line[1]);
    Point entrance = null;
    Point exit = null;
    boolean[][] maze = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      char[] row = br.readLine().toCharArray(); 
      for (int j = 0; j < n; j++) {
        if (row[j] == '1')
          maze[i][j] = true;
        else {
          maze[i][j] = false;
          if (row[j] == 'S')
            entrance = new Point(i, j);
          else if (row[j] == 'E')
            exit = new Point(i, j);
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        boolean cell = maze[i][j];
        System.out.print(cell == true ? '1' : '0');
      }
      System.out.println();
    }
    Stack<Point> path = computePath(maze, entrance, exit, m, n);
    for (Point p : path) {
      System.out.println(p.row + " " + p.col);
    }
  }
}
