package com.alg.top20.graphs;

import java.util.LinkedList;
import java.util.Queue;

import com.alg.top20.dset.IDisjointSet;
import com.alg.top20.dset.WeightedUnionCompressionSet;

public class FriendCircles {

	// TC:O(n ^ 2) SC:O(n) ~ n + n
	public static int findFriendCircles1(int[][] in) {
		boolean[] visit = new boolean[in.length];
		int ncircles = 0;
		for(int u = 0; u < in.length; ++u) {
			if(visit[u] == false) {
				auxCircles1(in, visit, u);
				++ncircles;
			}
		}
		return ncircles;
	}

	private static void auxCircles1(int[][] in, boolean[] visit, int u) {
		visit[u] = true;
		for (int w = 0; w < in.length; ++w) {
			if (in[u][w] == 1 && visit[w] == false) {
				auxCircles1(in, visit, w);			
			}
		}
	}

	// use breadth first search
	// TC:O(n ^ 2) SC:O(n)
	public static int findFriendCircles2(int[][] in) {
		boolean[] visit = new boolean[in.length];
		int ncircles = 0;
		for(int u = 0; u < in.length; ++u) {
			if(visit[u] == false) {
				auxCircles2(in, visit, u);
				++ncircles;
			}
		}
		return ncircles;
	}
	private static void auxCircles2(int[][] in, boolean[] visit, int u) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		while (!q.isEmpty()) {
			u = q.remove();
			for (int w = 0; w < in.length; ++w) {
				if (in[u][w] == 1 && visit[w] == false) {
					visit[w] = true;
					q.add(w);
				}
			}
		}
	}
	

	// for dynamic graphs, this is solution is more appropriate
	// TC:O(n ^ 2) SC:O(n)
	public static int findFriendCircles3(int[][] in) {
		IDisjointSet dset = new WeightedUnionCompressionSet(in.length);
		for (int i = 0; i < in.length; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				if (in[i][j] == 1)
					dset.union(i, j);
			}
		}
		return dset.size();
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = GraphUtils.createRandomGraph(n);
		System.out.println(findFriendCircles1(in));
		System.out.println(findFriendCircles2(in));
		System.out.println(findFriendCircles3(in));
	}

}
