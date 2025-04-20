package com.sachinmukharjee.datastructure.algorithm.graphs.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Using Priority Queue
 */
public class DijkstraAlgorithmPQ {

  public int[] shortestPath(List<List<Edge>> adjList, int source) {
    int n = adjList.size();
    int[] dist = new int[n];
    boolean[] visited = new boolean[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[source] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1])); // min heap
    pq.add(new int[] {source, 0});

    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int node = current[0];

      if (visited[node]) {
        continue;
      }
      visited[node] = true;

      for (Edge neighbour : adjList.get(node)) {
        int edge = neighbour.getTarget();
        int weight = neighbour.getWeight();
        if (!visited[edge] && dist[node] + weight < dist[edge]) {
          dist[edge] = dist[node] + weight;
          pq.offer(new int[] {edge, dist[edge]});
        }
      }
    }

    return dist;
  }

  public static void main(String[] args) {}
}
