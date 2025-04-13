package com.sachinmukharjee.datastructure.algorithm.graphs.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * used DFS
 */
public class TopologicalSort {

  public List<Integer> topologicalSort(int V, List<Integer> adj[]) {
    boolean[] visited = new boolean[V];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, visited, adj, stack);
      }
    }
    List<Integer> topOrder = new ArrayList<>();
    while (!stack.isEmpty()) {
      topOrder.add(stack.pop());
    }
    return topOrder;
  }

  private void dfs(int node, boolean[] visited, List<Integer>[] adj, Stack<Integer> stack) {
    visited[node] = true;
    for (int neighbour : adj[node]) {
      if (!visited[neighbour]) {
        dfs(neighbour, visited, adj, stack);
      }
    }
    stack.push(node);
  }

  public static void main(String[] args) {
    int V = 6;
    List<Integer>[] adj = new ArrayList[V];
    for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();

    // Directed edges
    adj[5].add(2);
    adj[5].add(0);
    adj[4].add(0);
    adj[4].add(1);
    adj[2].add(3);
    adj[3].add(1);

    TopologicalSort ts = new TopologicalSort();
    System.out.println("Topological Sort: " + ts.topologicalSort(V, adj));
  }
}
