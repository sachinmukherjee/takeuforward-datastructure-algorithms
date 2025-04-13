package com.sachinmukharjee.datastructure.algorithm.graphs.questions;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

  public int orangesRotting(int[][] grid) {
    int rows = grid.length;
    int columns = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();
    int freshCount = 0;

    // Step 1 Add all the rotten oranges to the queue
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (grid[i][j] == 2) {
          queue.add(new int[] {i, j, 0});
        } else if (grid[i][j] == 1) {
          freshCount++;
        }
      }
    }

    int minitues = 0;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int r = current[0];
      int c = current[1];
      int time = current[2];

      minitues = Math.max(minitues, time);

      for (int[] dir : directions) {

        int nr = r + dir[0];
        int nc = c + dir[1];
        if (nr >= 0 && nr < rows && nc >= 0 && nc < columns && grid[nr][nc] == 1) {
          grid[nr][nc] = 2;
          freshCount--;
          queue.offer(new int[] {nr, nc, time + 1});
        }
      }
    }

    return freshCount == 0 ? minitues : -1;
  }

  public static void main(String[] args) {
    RottenOranges rottenOranges = new RottenOranges();
    int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
    System.out.println(rottenOranges.orangesRotting(grid));
    int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    System.out.println(rottenOranges.orangesRotting(grid1));
    int[][] grid2 = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
    System.out.println(rottenOranges.orangesRotting(grid2));
  }
}
