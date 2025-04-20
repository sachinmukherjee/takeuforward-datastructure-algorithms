package com.sachinmukharjee.datastructure.algorithm.graphs.basic;

import java.util.Arrays;
import java.util.List;

public class FloydWarshallAlgorithm {

  public int[][] shortestPath(List<List<Edge>> adjList) {
    int[][] dist = new int[adjList.size()][adjList.size()];

    // Step 1. Initialize the distance matrix
    for (int i = 0; i < adjList.size(); i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
      dist[i][i] = 0;
      for (Edge edge : adjList.get(i)) {
        dist[i][edge.getTarget()] = edge.getWeight();
      }
    }

    // Step 2. Apply Floyd-Warshall Algorithm
    for (int k = 0; k < adjList.size(); k++) {
      for (int i = 0; i < adjList.size(); i++) {
        for (int j = 0; j < adjList.size(); j++) {
          // if we can improve the current shortest distance from i to j by passing through an
          // intermediate node k.
          if (dist[i][k] != Integer.MAX_VALUE
              && dist[k][j] != Integer.MAX_VALUE
              && dist[i][k] + dist[k][j] < dist[i][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
          }
        }
      }
    }

    // Step 3. Check for negative weight cycles
    for (int i = 0; i < adjList.size(); i++) {
      if (dist[i][i] < 0) {
        return null;
      }
    }

    return dist;
  }

  public static void main(String[] args) {}
}
