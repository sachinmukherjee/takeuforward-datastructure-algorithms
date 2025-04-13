package com.sachinmukharjee.datastructure.algorithm.graphs.questions;

import java.util.*;

public class TraversalTechniques {

  public List<Integer> dfsOfGraph(int V, List<Integer> adj[]) {
    boolean visited[] = new boolean[V];
    List<Integer> vertexList = new ArrayList<>();
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int i = 0; i < adj.length; i++) {
      List<Integer> edgeArr = adj[i];
      for (int j = 0; j < edgeArr.size(); j++) {
        Integer edge = edgeArr.get(j);
        adjList.get(i).add(edge);
      }
    }

    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (visited[node]) {
        continue;
      }
      visited[node] = true;
      vertexList.add(node);
      for (int neighbourNode : adjList.get(node)) {
        if (!visited[neighbourNode]) {
          stack.push(neighbourNode);
        }
      }
    }
    return vertexList;
  }

  public List<Integer> bfsOfGraph(int V, List<Integer> adj[]) {
    boolean visited[] = new boolean[V];
    List<Integer> vertexList = new ArrayList<>();
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int i = 0; i < adj.length; i++) {
      List<Integer> edgeArr = adj[i];
      for (int j = 0; j < edgeArr.size(); j++) {
        Integer edge = edgeArr.get(j);
        adjList.get(i).add(edge);
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);

    while (!queue.isEmpty()) {
      int node = queue.poll();
      if (visited[node]) {
        continue;
      }
      visited[node] = true;
      vertexList.add(node);
      for (int neighbourNode : adjList.get(node)) {
        if (!visited[neighbourNode]) {
          queue.add(neighbourNode);
        }
      }
    }

    return vertexList;
  }

  public static void main(String[] args) {
    TraversalTechniques traversalTechniques = new TraversalTechniques();
    int V = 5;
    List<Integer>[] adj =
        new List[] {List.of(2, 3, 1), List.of(0), List.of(0, 4), List.of(0), List.of(2)};
    System.out.println(traversalTechniques.bfsOfGraph(V, adj));
    System.out.println(traversalTechniques.dfsOfGraph(V, adj));
  }
}
