package com.sachinmukharjee.datastructure.algorithm.graphs.questions;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCell {

  public int[][] nearest(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] result = new int[row][col];
    boolean[][] visited = new boolean[row][col];
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {
          queue.add(new int[] {i, j});
          visited[i][j] = true;
        }
      }
    }

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int r = current[0];
      int c = current[1];
      for (int[] dir : directions) {
        int newR = r + dir[0];
        int newC = c + dir[1];
        if (newR >= 0 && newR < row && newC >= 0 && newC < col && !visited[newR][newC]) {
          result[newR][newC] = result[r][c] + 1;
          queue.add(new int[] {newR, newC});
          visited[newR][newC] = true;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
      DistanceOfNearestCell distance  = new DistanceOfNearestCell();
      int[][] grid = {{0, 1, 1,0}, {1,1,0,0}, {0,0,1,1}};
      int[][] result = distance.nearest(grid);
      int[][] grid1 = {{0,1},{1,0}};
      int[][] result1 = distance.nearest(grid1);

  }
}
