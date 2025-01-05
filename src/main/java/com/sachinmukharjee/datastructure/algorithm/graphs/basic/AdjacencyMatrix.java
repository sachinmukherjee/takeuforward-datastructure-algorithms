package com.sachinmukharjee.datastructure.algorithm.graphs.basic;

import java.util.Scanner;

public class AdjacencyMatrix {

  public static void main(String[] args) {
    // Taking input
    Scanner scan = new Scanner(System.in);
    int nodes = scan.nextInt();
    int edges = scan.nextInt();

    // adjacent matrix for undirected graph
    int[][] matrix = new int[nodes + 1][nodes + 1];

    // Add the edges to the matrix
    for (int i = 0; i < edges; i++) {
      int u = scan.nextInt();
      int v = scan.nextInt();
      matrix[u][v] = 1;
      matrix[v][u] = 1;
    }

    scan.close();
  }
}
