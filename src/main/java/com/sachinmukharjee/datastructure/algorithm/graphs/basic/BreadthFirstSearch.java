package com.sachinmukharjee.datastructure.algorithm.graphs.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Assuming Directed Graph
 */
public class BreadthFirstSearch {

  private int nodes;
  private List<Integer>[] adjList;

  public BreadthFirstSearch(int nodes) {
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
   * Performs a breadth-first search (BFS) traversal starting from the given node. It prints the
   * nodes in the order they are visited.
   *
   * @param startNode the starting node for the BFS traversal
   * @param visited a boolean array which keeps track of visited nodes
   */
  public void bfsUtils(int startNode, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<>();
    // Push the starting node
    queue.add(startNode);

    // Loop until the queue is empty
    while (!queue.isEmpty()) {
      // Pop the top node
      int node = queue.poll();
      // If the node is not visited
      if (!visited[node]) {
        // Mark the node as visited
        visited[node] = true;
      }
      System.out.print(node + " ");
      // Iterate over the adjacent nodes
      for (int neighbourNode : adjList[node]) {
        // If the neighbour node is not visited
        if (!visited[neighbourNode]) {
          // Push the neighbour node
          queue.add(neighbourNode);
          // Mark the neighbour node as visited
          visited[neighbourNode] = true;
        }
      }
    }
  }

  /**
   * Performs a breadth-first search (BFS) traversal starting from the given node. It prints the
   * nodes in the order they are visited.
   *
   * @param startNode the starting node for the BFS traversal
   */
  public void bfs(int startNode) {
    boolean[] visited = new boolean[nodes];
    bfsUtils(startNode, visited);
  }

  public static void main(String[] args) {
    BreadthFirstSearch graph = new BreadthFirstSearch(7);

    // Create a sample directed graph
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 5);
    graph.addEdge(3, 6);

    System.out.println("BFS Traversal starting from node 0:");
    graph.bfs(0);
  }
}
