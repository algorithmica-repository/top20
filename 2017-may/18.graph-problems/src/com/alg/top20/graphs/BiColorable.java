package com.alg.top20.graphs;

import java.util.Arrays;

public class BiColorable {

	// TC:O(n ^ 2) SC:O(n) ~ n + n
	public static boolean biColorable1(int[][] in) {
		int[] visit = new int[in.length];
		boolean result = true;
		for(int u = 0; u < in.length; ++u) {
			if(visit[u] == 0) {
				if(!auxBicolorable1(in, visit, u, 1))  {  
					result = false;
					break;
				}
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(visit));
		return result;
	}

	private static boolean auxBicolorable1(int[][] in, int[] visit, int u, int color) {
		visit[u] = color;
		for (int w = 0; w < in.length; ++w) {
			if (in[u][w] == 1) {
				if(visit[w] == 0) { 
					if(!auxBicolorable1(in, visit, w, color==1?2:1)) return false;
				} else {
					if(visit[u] == visit[w])
						return false;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = GraphUtils.createRandomGraph(n);
		System.out.println(biColorable1(in));
	}

}
