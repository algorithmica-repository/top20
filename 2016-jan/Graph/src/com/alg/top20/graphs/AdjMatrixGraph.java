package com.alg.top20.graphs;

public class AdjMatrixGraph implements IGraph {	
	private int[][] matrix;
	
	public AdjMatrixGraph(int v) {
		matrix = new int[v][v];
	}

	@Override
	public void addEdge(int u, int v) {
		matrix[u][v] = matrix[v][u] = 1;
	}
	
	private void auxtraverse(int u, boolean[] visit) {
		visit[u] = true;
		System.out.println("Retrieving content at:" + u);
		for(int v = 0; v < matrix.length; ++v) {
			if(matrix[u][v] == 1 && visit[v] == false)
				auxtraverse(v, visit);
		}
	}

	@Override
	public void traverse() {
		boolean[] visit = new boolean[matrix.length];
		for(int u = 0; u < matrix.length; ++u) {
			if(visit[u] == false) 
				auxtraverse(u, visit);
		}

	}
	
	private boolean auxCycle(int u, boolean[] visit, int parent) {
		visit[u] = true;
		//System.out.println("Retrieving content at:" + u);
		for(int v = 0; v < matrix.length; ++v) {
			if(matrix[u][v] == 1) {
				if(visit[v] == true) {
					if(parent != v) return true;
				}
				else {
					if(auxCycle(v, visit, u) == true) 
						return true;
				}				
			}
		}
		return false;
	}
	public boolean hasCycle() {
		boolean[] visit = new boolean[matrix.length];
		for(int u = 0; u < matrix.length; ++u) {
			if(visit[u] == false) 
				if(auxCycle(u, visit, u)== true) return true;			
		}
		return false;
	}
	
	public void display() {
		for(int u = 0; u < matrix.length; ++u) {
			for(int v = 0; v < matrix.length; ++v) {
				System.out.print(matrix[u][v] + " ");
			}
			System.out.println();
		}
	}

}
