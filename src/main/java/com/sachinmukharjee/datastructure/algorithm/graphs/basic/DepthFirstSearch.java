package com.sachinmukharjee.datastructure.algorithm.graphs.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Assuming Directed Graph
 */
public class DepthFirstSearch {

  private int nodes; // Number of nodes
  private List<Integer>[] adjList; // Adjacency list

  public DepthFirstSearch(int nodes) {
    this.nodes = nodes;
    adjList = new ArrayList[nodes];
    for (int i = 0; i < nodes; i++) {
      adjList[i] = new ArrayList<>();
    }
  }

  /**
   * Adds an edge to the graph.
   *
   * @param source The source node for the edge.
   * @param destination The destination node for the edge.
   */
  public void addEdge(int source, int destination) {
    adjList[source].add(destination);
  }

  /**
   * Utility method to perform depth-first search traversal.
   *
   * @param startNode The node from which the traversal starts.
   * @param visited A boolean array which keeps track of visited nodes.
   */
  private void dsfUtils(int startNode, boolean[] visited) {
    Stack<Integer> stack = new Stack<>();
    // Push the starting node
    stack.push(startNode);

    // Loop until the stack is empty
    while (!stack.isEmpty()) {
      // Pop the top node
      int node = stack.pop();
      // If the node is not visited
      if (!visited[node]) {
        // Mark the node as visited
        visited[node] = true;
        // Print the node
        System.out.print(node + " ");
      }

      // Iterate over the adjacent nodes
      for (int neighbourNode : adjList[node]) {
        // If the neighbour node is not visited
        if (!visited[neighbourNode]) {
          // Push the neighbour node
          stack.push(neighbourNode);
        }
      }
    }
  }

  /**
   * Performs a depth-first search (DFS) starting from the given node.
   *
   * @param startNode the starting node for the DFS traversal
   */
  public void dfs(int startNode) {
    boolean[] visited = new boolean[nodes];
    dsfUtils(startNode, visited);
  }

  public static void main(String[] args) {
    DepthFirstSearch graph = new DepthFirstSearch(6);
    // Create a sample graph
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 5);

    System.out.println("DFS traversal starting from vertex 0:");
    graph.dfs(0);
  }
}
