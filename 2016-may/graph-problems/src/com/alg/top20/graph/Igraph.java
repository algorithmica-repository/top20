package com.alg.top20.graph;

public interface Igraph {
	void addEdge(int u, int v);
	void addEdge(int u, int v, int w);
	void traverse();
	int size();
	boolean hasCycle();
	void display();
	boolean hasOddCycle();
	boolean hasHamiltonianCycle();
	int findMinCostST();
}
