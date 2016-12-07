package com.alg.top20.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SequentialUnweightedGraph implements IUnweightedGraph {
	private int[][] matrix;

	public SequentialUnweightedGraph(int n) {
		matrix = new int[n][n];
	}

	@Override
	public void addEdge(int u, int v) {
		matrix[u][v] = 1;
		//matrix[v][u] = 1;
	}

	private void auxDFS(int u, boolean[] visit) {
		// process at vertex u
		System.out.println(u);
		// mark the node as visited
		visit[u] = true;

		// traverse unvisited adjacent vertices
		for (int v = 0; v < matrix.length; ++v) {
			if (matrix[u][v] == 1 && visit[v] == false)
				auxDFS(v, visit);
		}
	}

	//tc:O(v2+v) = O(v2) sc:O(v+v)=O(v)
	@Override
	public void traverse_depth() {
		boolean[] visit = new boolean[matrix.length];

		// traverse each connected component
		for (int u = 0; u < matrix.length; ++u) {
			if (visit[u] == false)
				auxDFS(u, visit);
		}
		// System.out.println(Arrays.toString(visit));
	}

	@Override
	public void display() {
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix.length; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	private void auxBFS(int u, boolean[] visit) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(u);
		visit[u] = true;
		while (!queue.isEmpty()) {
			u = queue.remove();
			// process node u
			System.out.println(u);
			for (int v = 0; v < matrix.length; ++v) {
				if (matrix[u][v] == 1 && visit[v] == false) {
					queue.add(v);
					visit[v] = true;
				}
			}
		}

	}

	//tc:O(v2+v)=O(v2)  sc:O(v+v)=O(v)
	@Override
	public void traverse_breadth() {
		boolean[] visit = new boolean[matrix.length];

		// traverse each connected component
		for (int u = 0; u < matrix.length; ++u) {
			if (visit[u] == false)
				auxBFS(u, visit);
		}
		// System.out.println(Arrays.toString(visit));
	}
	
	private boolean auxCycle(int u, boolean[] visit) {
		// process at vertex u
		//System.out.println(u);
		// mark the node as visited
		visit[u] = true;

		// traverse unvisited adjacent vertices
		for (int v = 0; v < matrix.length; ++v) {
			if (matrix[u][v] == 1) {
				if(visit[v] == false)
					if(auxCycle(v, visit)) return true;
				else
					return true;
			}
		}
		return false;
	}

	//tc:O(v2+v) = O(v2) sc:O(v+v)=O(v)
	@Override
	public boolean hasCycle() {
		boolean[] visit = new boolean[matrix.length];

		// traverse each connected component
		for (int u = 0; u < matrix.length; ++u) {
			if (visit[u] == false)
				if(auxCycle(u, visit)) return true;
		}
		return false;
	}

}
