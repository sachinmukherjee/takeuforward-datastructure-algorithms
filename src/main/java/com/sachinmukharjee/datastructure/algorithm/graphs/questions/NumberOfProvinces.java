package com.sachinmukharjee.datastructure.algorithm.graphs.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOfProvinces {

  public int numProvinces(int[][] adj) {
    List<List<Integer>> adjList = new ArrayList<>();
    int numOfProvinces = 0;
    int v = adj.length;
    boolean[] visited = new boolean[v];
    for (int i = 0; i < adj.length; i++) {
      adjList.add(new ArrayList<>());
      for (int j = 0; j < adj[i].length; j++) {
        if (adj[i][j] == 1) {
          adjList.get(i).add(j);
        }
      }
    }

    for (int i = 0; i < adj.length; i++) {
      if (!visited[i]) {
        numOfProvinces++;
        dsf(i, adjList, visited);
      }
    }

    return numOfProvinces;
  }

  private void dsf(int node, List<List<Integer>> adjList, boolean[] visited) {
    Stack<Integer> stack = new Stack<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      int currentNode = stack.pop();
      if (!visited[currentNode]) {
        visited[currentNode] = true;
        for (int neighbourNode : adjList.get(currentNode)) {
          if (!visited[neighbourNode]) {
            stack.push(neighbourNode);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
    int[][] adj = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
    System.out.println(numberOfProvinces.numProvinces(adj));
  }
}
