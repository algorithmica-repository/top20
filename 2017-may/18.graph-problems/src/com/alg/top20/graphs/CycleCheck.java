package com.alg.top20.graphs;

import java.util.LinkedList;
import java.util.Queue;

import com.alg.top20.dset.IDisjointSet;
import com.alg.top20.dset.WeightedUnionCompressionSet;

class Pair {
	int current;
	int parent;
	Pair(int current, int parent) {
		this.current = current;
		this.parent = parent;
	}
}
public class CycleCheck {

	// TC:O(n ^ 2) SC:O(n) ~ n + n
	public static boolean hasCycle1(int[][] in) {
		boolean[] visit = new boolean[in.length];
		for(int u = 0; u < in.length; ++u) {
			if(visit[u] == false) {
				if(auxCycle1(in, visit, u, u)) return true;
			}
		}
		return false;
	}

	private static boolean auxCycle1(int[][] in, boolean[] visit, int u, int parent) {
		visit[u] = true;
		for (int w = 0; w < in.length; ++w) {
			if (in[u][w] == 1) {
				if(visit[w] == false) { 
					if(auxCycle1(in, visit, w, u)) return true;
				}
				else {
					//check for same edge or back edge
					if(parent != w)
						return true;
				}
			}
		}
		return false;
	}

	// use breadth first search
	// TC:O(n ^ 2) SC:O(n)
	public static boolean hasCycle2(int[][] in) {
		boolean[] visit = new boolean[in.length];
		for(int u = 0; u < in.length; ++u) {
			if(visit[u] == false) {
				if(auxCycle2(in, visit, u)) return true;
			}
		}
		return false;
	}

	private static boolean auxCycle2(int[][] in, boolean[] visit, int u) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(u, u) );
		visit[u] = true;
		while (!q.isEmpty()) {
			Pair tmp = q.remove();
			for (int w = 0; w < in.length; ++w) {
				if (in[tmp.current][w] == 1) {
					if(visit[w] == false) {
						visit[w] = true;
						q.add(new Pair(w,tmp.current) );
					} else {
						if(w != tmp.parent)
							return true;
					}
				}
			}
		}
		return false;
	}
	

	// for dynamic graphs, this is solution is more appropriate
	// TC:O(n ^ 2) SC:O(n)
	public static boolean hasCycle3(int[][] in) {
		IDisjointSet dset = new WeightedUnionCompressionSet(in.length);
		for (int i = 0; i < in.length; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				if (in[i][j] == 1) {
					if(dset.find(i) == dset.find(j))
						return true;
					else					
						dset.union(i, j);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = GraphUtils.createRandomGraph(n);
		System.out.println(hasCycle1(in));
		System.out.println(hasCycle2(in));
		System.out.println(hasCycle3(in));
	}

}
