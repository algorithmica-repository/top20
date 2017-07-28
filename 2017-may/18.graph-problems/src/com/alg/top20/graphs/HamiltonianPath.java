package com.alg.top20.graphs;

public class HamiltonianPath {
	
	//TC:O((n-2)! * n)  SC:O(n)
	public static boolean hasHamiltonianPath(int[][] in, int u, int v) {
		int[] tmp = new int[in.length-2];
		for(int i = 0; i < tmp.length; ++i) {
			if(i != u && i != v)
				`tmp[i] = i;
		}
		do {
			//use the logic of next_permutation here
			boolean res = next_permutation(tmp);
			//fill the logic
			if(isConnected(tmp, u, v, in)) return true;
		} while(res);
	}
	

	//TC: O((n-2)! * n)  SC:O(n) ~ n + n
	public static boolean hasHamiltonianPath1(int[][] in, int u, int v) {
		boolean[] visit = new boolean[in.length];
		return auxHamPath1(in, visit, u, v, ""+u);
	}
	private static boolean auxHamPath1(int[][] in, boolean[] visit, int u,
			int v, String path) {
		if (u == v) {
			for(int w = 0; w < visit.length; ++w) {
				if(w != v && visit[w] == false) return false;
			}
			System.out.println(path);
			return true;
		}
		visit[u] = true;
		for (int w = 0; w < in.length; ++w) {
			if (in[u][w] == 1 && visit[w] == false) {
				if (auxHamPath1(in, visit, w, v, path+"->"+w))
					return true;
			}
		}
		visit[u] = false;
		return false;
	}
	
	//TC: O((n-2)!)  SC:O(n) ~ n + n
	public static boolean hasHamiltonianPath2(int[][] in, int u, int v) {
		boolean[] visit = new boolean[in.length];
		return auxHamPath2(in, visit, u, v, ""+u, 1);
	}
	private static boolean auxHamPath2(int[][] in, boolean[] visit, int u,
			int v, String path, int count) {
		if (u == v) {
			if(count == visit.length) {
				System.out.println(path);
				return true;
			} else
				return false;
		}
		visit[u] = true;
		for (int w = 0; w < in.length; ++w) {
			if (in[u][w] == 1 && visit[w] == false) {
				if (auxHamPath2(in, visit, w, v, path+"->"+w, count+1))
					return true;
			}
		}
		visit[u] = false;
		return false;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = GraphUtils.createRandomGraph(n);
		System.out.println(hasHamiltonianPath2(in, 0, n-1));
	}

}
