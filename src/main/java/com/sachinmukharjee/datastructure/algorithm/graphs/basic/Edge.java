package com.sachinmukharjee.datastructure.algorithm.graphs.basic;

public class Edge {
  private final int target;
  private final int weight;

  public Edge(int target, int weight) {
    this.target = target;
    this.weight = weight;
  }

  public int getTarget() {
    return target;
  }

  public int getWeight() {
    return weight;
  }
}
