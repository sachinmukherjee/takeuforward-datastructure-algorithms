package com.sachinmukharjee.datastructure.algorithm.graphs.questions;

/*
* https://www.techiedelight.com/?problem=ConnectivityMatrix

The transitive closure for a digraph G is a digraph G’ with an edge (i, j) corresponding to each directed path from i to j in G. The resultant digraph G’ representation in the form of the adjacency matrix is called the connectivity matrix.

Given a directed graph, return its connectivity matrix. The value of a cell C[i][j] in connectivity matrix C is 1 only if a directed path exists from vertex i to vertex j.

Input: Graph [edges = [(0, 2), (1, 0), (3, 1)], n = 4]
Output: [
	[1, 0, 1, 0],
	[1, 1, 1, 0],
	[0, 0, 1, 0],
	[1, 1, 1, 1]
]

Note that all diagonal elements in the connectivity matrix are 1 since a path exists from every vertex to itself.

Constraints:

• The graph is implemented using an adjacency list.
• The maximum number of nodes in the graph is 100, i.e., 0 <= n < 100, and each node is represented by its numeric value.

*/
public class ConnectivityMatrix {

}
