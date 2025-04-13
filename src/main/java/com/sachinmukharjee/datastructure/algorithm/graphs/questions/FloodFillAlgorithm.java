package com.sachinmukharjee.datastructure.algorithm.graphs.questions;

public class FloodFillAlgorithm {

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int originalColor = image[sr][sc];
    if (originalColor != newColor) {
      dfs(image, sr, sc, originalColor, newColor);
    }
    return image;
  }

  private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
    int row = image.length;
    int col = image[0].length;

    // Boundary check and condition
    if (sr < 0 || sr >= row || sc < 0 || sc >= col || image[sr][sc] != oldColor) {
      return;
    }

    image[sr][sc] = newColor;

    int[][] directions = {
            {-1, 0}, // Up
            {1, 0},  // Down
            {0, -1}, // Left
            {0, 1}   // Right
    };
    for (int[] dir : directions) {
      dfs(image, sr + dir[0], sc + dir[1], oldColor, newColor);
    }
  }

  public static void main(String[] args) {
      int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
      int sr = 1;
      int sc = 1;
      int newColor = 0;
      FloodFillAlgorithm algorithm = new FloodFillAlgorithm();
      int[][] result = algorithm.floodFill(image, sr, sc, newColor);

      for (int[] row : result) {
          for (int pixel : row) {
              System.out.print(pixel + " ");
          }
          System.out.println();
      }
  }
}
