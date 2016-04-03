package com.alg.top20.graphs;

public interface IGraph {
	void addEdge(int u, int v);
	void traverse();
	void display();
	boolean hasCycle();
}
