package com.sachinmukharjee.datastructure.algorithm.graphs.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {

  public int[] shortestPath(List<List<Edge>> adjList, int source) {
    int[] dist = new int[adjList.size()];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[source] = 0;

    // Step 1 Flatten the edges
    List<int[]> edges = new ArrayList<>();
    for (int u = 0; u < adjList.size(); u++) {
      for (Edge edge : adjList.get(u)) {
        edges.add(new int[] {u, edge.getTarget(), edge.getWeight()});
      }
    }

    // Step 2 Relax all the edges N-1 times
    for (int i = 0; i < adjList.size() - 1; i++) {
      for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        int weight = edge[2];

        if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
          dist[v] = dist[u] + weight;
        }
      }
    }

    // Step 3 Check for negative weight cycles
    // If after all N-1 times, if we are still able to relax any edge, then there is a negative
    // weight cycle
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      int weight = edge[2];

      if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
        return null;
      }
    }
    return dist;
  }

  public static void main(String[] args) {

  }
}
