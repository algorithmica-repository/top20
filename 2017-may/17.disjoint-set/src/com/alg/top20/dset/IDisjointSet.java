package com.alg.top20.dset;

public interface IDisjointSet {
	void union(int x, int y);
	int find(int x);
	int size();
	void display();
}
