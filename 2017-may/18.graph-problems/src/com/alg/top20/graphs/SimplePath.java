package com.alg.top20.graphs;

import java.util.LinkedList;
import java.util.Queue;

import com.alg.top20.dset.IDisjointSet;
import com.alg.top20.dset.WeightedUnionCompressionSet;

public class SimplePath {

	// TC:O(n ^ 2) SC:O(n) ~ n + n
	public static boolean isConnected1(int[][] in, int u, int v) {
		boolean[] visit = new boolean[in.length];
		return auxConnected1(in, visit, u, v);
	}

	private static boolean auxConnected1(int[][] in, boolean[] visit, int u,
			int v) {
		if (u == v)
			return true;
		visit[u] = true;
		for (int w = 0; w < in.length; ++w) {
			if (in[u][w] == 1 && visit[w] == false) {
				if (auxConnected1(in, visit, w, v))
					return true;
			}
		}
		return false;
	}

	// for dynamic graphs, this is solution is more appropriate
	// TC:O(n ^ 2) SC:O(n)
	public static boolean isConnected2(int[][] in, int u, int v) {
		IDisjointSet dset = new WeightedUnionCompressionSet(in.length);
		for (int i = 0; i < in.length; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				if (in[i][j] == 1)
					dset.union(i, j);
			}
		}
		return dset.find(u) == dset.find(v);
	}

	// use breadth first search
	// TC:O(n ^ 2) SC:O(n)
	public static boolean isConnected3(int[][] in, int u, int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		boolean[] visit = new boolean[in.length];
		while (!q.isEmpty()) {
			u = q.remove();
			if (u == v)
				return true;
			for (int w = 0; w < in.length; ++w) {
				if (in[u][w] == 1 && visit[w] == false) {
					visit[w] = true;
					q.add(w);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = GraphUtils.createRandomGraph(n);
		System.out.println(isConnected1(in, 0, n - 1));
		System.out.println(isConnected2(in, 0, n - 1));
		System.out.println(isConnected3(in, 0, n - 1));
	}
}
