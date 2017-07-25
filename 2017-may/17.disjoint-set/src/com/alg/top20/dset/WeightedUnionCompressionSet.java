package com.alg.top20.dset;

public class WeightedUnionCompressionSet implements IDisjointSet {
	private int[] parents;
	private int[] weights;
	
	public WeightedUnionCompressionSet(int n) {
		parents = new int[n];
		weights = new int[n];
		for(int i = 0; i < n; ++i) {
			parents[i] = i;
			weights[i] = 1;
		}
	}
	//find by path compression 
	public int find(int x) {
		int  y = x;
		while(parents[x] != x) {
			x = parents[x];
		}
		while(parents[y] != x) {
			int tmp = parents[y];
			parents[y] = x;
			y = tmp;
		}
		return x;
	}
	//union by weights to maintain balanced tree
	public void union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		if(weights[rx] > weights[ry]) {
			parents[ry] = rx;
			weights[rx] += weights[ry];
		} else {
			parents[rx] = ry;
			weights[ry] += weights[rx];
		}
	}
	
	public int size() {
		return parents.length;
	}
	
	public void display() {
		for(int i = 0; i < parents.length; ++i) {
			System.out.print("(" + parents[i] + "," + weights[i] + ")");
		}
		System.out.println();
	}

}
