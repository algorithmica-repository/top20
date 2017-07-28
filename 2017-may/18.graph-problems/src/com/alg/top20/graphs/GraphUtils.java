package com.alg.top20.graphs;
import java.util.Arrays;
import java.util.Random;


public class GraphUtils {

	public static int[][] createCompleteGraph(int n) {
		int[][] graph = new int[n][n];
		for(int u = 0; u < n; ++u) {
			for(int v = u+1; v < n; ++v) {
				graph[u][v] = graph[v][u] = 1;
			}
			System.out.println(Arrays.toString(graph[u]));
		}
		return graph;
	}
	
	public static int[][] createRandomGraph(int n) {
		int[][] graph = new int[n][n];
		Random r = new Random();
		for(int i = 0; i < n*n; ++i) {
			int u = r.nextInt(n);
			int v = r.nextInt(n);
			if(u != v)
				graph[u][v] = graph[v][u] = 1;
		}
		for(int i = 0; i < n; ++i)
			System.out.println(Arrays.toString(graph[i]));
		return graph;
	}

}
