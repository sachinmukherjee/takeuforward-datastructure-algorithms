package com.sachinmukharjee.datastructure.algorithm.graphs.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ConnectedComponent {

  final int v;
  final List<List<Integer>> adjList;

  ConnectedComponent(int v) {
    this.v = v;
    adjList = new ArrayList<>();

    for (int i = 0; i < v; i++) {
      adjList.add(i, new ArrayList<>());
    }
  }

  /*
   * Adds an edge to the graph.
   *
   * @param source The source node for the edge.
   * @param destination The destination node for the edge.
   */
  private void addEdge(int source, int destination) {
    adjList.get(source).add(destination);
    adjList.get(destination).add(source);
  }

  /**
   * Performs a depth-first search (DFS) traversal starting from the given node.
   *
   * @param startNode the starting node for the DFS traversal
   * @param graph the graph represented as an adjacency list
   * @param visited a boolean array which keeps track of visited nodes
   */
  private void performDfs(int startNode, List<List<Integer>> graph, boolean[] visited) {
    Stack<Integer> stack = new Stack<>();
    stack.push(startNode);

    while (!stack.isEmpty()) {
      int currentNode = stack.pop();
      // If current node is not visited
      if (!visited[currentNode]) {
        visited[currentNode] = true;
        // for all the neighbour nodes
        for (int neighbourNode : graph.get(currentNode)) {
          if (!visited[neighbourNode]) {
            stack.push(neighbourNode);
          }
        }
      }
    }
  }

  /**
   * Finds the number of connected components in an undirected graph.
   *
   * @param e the number of edges in the graph
   * @param v the number of vertices in the graph
   * @param edges the graph represented as an adjacency list
   * @return the number of connected components in the graph
   */
  public int findNumberOfComponents(int e, int v, List<List<Integer>> edges) {
    boolean[] visited = new boolean[v];
    int components = 0;
    for (int i = 0; i < v; i++) {
      if (!visited[i]) {
        performDfs(i, edges, visited);
        components++;
      }
    }
    return components;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the number of vertices");
    int v = scan.nextInt();
    System.out.println("Enter the number of edges");
    int e = scan.nextInt();

    ConnectedComponent c = new ConnectedComponent(v);
    for (int i = 0; i < e; i++) {
      int edge1 = scan.nextInt();
      int edge2 = scan.nextInt();
      c.addEdge(edge1, edge2);
    }

    int numberOfComponents = c.findNumberOfComponents(e, c.v, c.adjList);
    System.out.println(numberOfComponents);

    scan.close();
  }
}
