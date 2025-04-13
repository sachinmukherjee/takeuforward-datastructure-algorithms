package com.sachinmukharjee.datastructure.algorithm.graphs.questions;

public class SurroundedRegion {

  public char[][] fill(char[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    // Step 1 Mark all the O's connected to the border
      // Column
    for (int i = 0; i < n; i++) {
      dfs(mat, i, 0); // left
      dfs(mat, i, m - 1); // right
    }

    //row
    for (int i = 0; i < m; i++) {
      dfs(mat, 0, i); // top
      dfs(mat, n - 1, i); // bottom
    }

    // Step 2 Mark all the remaining O's
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 'O') {
          mat[i][j] = 'X';
        } else if (mat[i][j] == '#') {
          mat[i][j] = 'O';
        }
      }
    }
    return mat;
  }

  private void dfs(char[][] mat, int i, int j) {
    if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] != 'O') {
      return;
    }

    mat[i][j] = '#';
    dfs(mat, i + 1, j);
    dfs(mat, i - 1, j);
    dfs(mat, i, j + 1);
    dfs(mat, i, j - 1);
  }

  public static void main(String[] args) {
    char[][] board = {
      {'X', 'X', 'X', 'X'},
      {'X', 'O', 'O', 'X'},
      {'X', 'X', 'O', 'X'},
      {'X', 'O', 'X', 'X'}
    };

    SurroundedRegion surroundedRegion = new SurroundedRegion();
    char[][] result = surroundedRegion.fill(board);
    for (char[] row : result) {
      System.out.println(java.util.Arrays.toString(row));
    }
  }
}
