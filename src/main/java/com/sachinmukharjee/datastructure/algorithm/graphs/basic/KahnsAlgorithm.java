package com.sachinmukharjee.datastructure.algorithm.graphs.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgorithm {

  public List<Integer> topologicalSort(int V, List<Integer> adj[]) {
    int[] indegree = new int[V];
    // Step 1: Calculate the in-degree of each node
    for (int i = 0; i < V; i++) {
      for (int j : adj[i]) {
        indegree[j]++;
      }
    }

    // Step 2: Add all the nodes with 0 in-degree to the queue
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }

    // Step 3: Process the nodes in the queue
    List<Integer> result = new LinkedList<>();
    while (!queue.isEmpty()) {
      int node = queue.poll();
      result.add(node);
      for (int neighbour : adj[node]) {
        indegree[neighbour]--;
        if (indegree[neighbour] == 0) {
          queue.offer(neighbour);
        }
      }
    }

    // Step 4: Check if there are any nodes left in the graph
    if (result.size() != V) {
      throw new RuntimeException("Graph contains a cycle");
    }
    return result;
  }

  public static void main(String[] args) {
    int V = 6;
    List<Integer>[] adj = new ArrayList[V];
    for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();

    // Add directed edges
    adj[5].add(2);
    adj[5].add(0);
    adj[4].add(0);
    adj[4].add(1);
    adj[2].add(3);
    adj[3].add(1);

    KahnsAlgorithm sorter = new KahnsAlgorithm();
    List<Integer> result = sorter.topologicalSort(V, adj);
    System.out.println("Topological Order: " + result);
  }
}
