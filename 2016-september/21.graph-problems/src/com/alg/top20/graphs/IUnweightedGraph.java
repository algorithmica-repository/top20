package com.alg.top20.graphs;

public interface IUnweightedGraph {
	void addEdge(int u, int v);
	void traverse_depth();
	void traverse_breadth();
	boolean hasCycle();
	void display();
}
