package com.sachinmukharjee.datastructure.algorithm.graphs.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleBFS {


    public boolean hasCycle(int V, List<List<Integer>> adj){
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(bfs(i, visited, adj)){
                    return true;
                }
            }
        }
        return false;

    }


    private boolean bfs(int start, boolean[] visited, List<List<Integer>> adjList) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, -1});
        visited[start] = true;

    while (!queue.isEmpty()) {
        int[] current = queue.poll();
        int node = current[0];
        int parent = current[1];

        for(int neighbour: adjList.get(node)) {
            if(!visited[neighbour]){
                visited[neighbour] = true;
                queue.offer(new int[]{neighbour, node});
            }else if(neighbour != parent){
                return true;
            }
        }
    }
    return false;
  }

    public static void main(String[] args){
        int V = 5;
    List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add undirected edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        // Uncomment the below to add a cycle:
        adj.get(4).add(1);
        adj.get(1).add(4);

        boolean result = new DetectCycleBFS().hasCycle(V, adj);
        System.out.println(result ? "Cycle Detected" : "No Cycle");
    }
}
