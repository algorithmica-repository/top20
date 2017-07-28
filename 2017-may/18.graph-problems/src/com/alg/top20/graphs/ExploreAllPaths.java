package com.alg.top20.graphs;

public class ExploreAllPaths {

	//TC: O(n!)  SC:O(n) ~ n + n
	public static void exploreAllPaths(int[][] in, int u, int v) {
		boolean[] visit = new boolean[in.length];
		auxPaths(in, visit, u, v, ""+u);
	}
	private static void auxPaths(int[][] in, boolean[] visit, int u, int v, String path) {
		if (u == v) {
			System.out.println(path);
			return;
		}
		visit[u] = true;
		for (int w = 0; w < in.length; ++w) {
			if (in[u][w] == 1 && visit[w] == false) {
				auxPaths(in, visit, w, v, path + "->" + w);
			}
		}
		visit[u] = false;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = GraphUtils.createCompleteGraph(n);
		exploreAllPaths(in, 0, n-1);		
	}

}
