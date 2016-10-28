package com.alg.top20.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class UndirectedGraph implements Igraph {
	private int[][] matrix;
	private int nvertices;

	public UndirectedGraph(int nvertices) {
		matrix = new int[nvertices][nvertices];
		this.nvertices = nvertices;
	}

	@Override
	public void addEdge(int u, int v) {
		addEdge(u, v, 1);
	}
	
	@Override
	public void addEdge(int u, int v, int w) {
		matrix[u][v] = matrix[v][u] = w;
	}

	// perform subgraph traversal
	private void auxDisplay_depth(int u, boolean[] visit) {
		System.out.println(u);
		visit[u] = true;
		for (int v = 0; v < nvertices; ++v) {
			if (matrix[u][v] == 1 && visit[v] == false)
				auxDisplay_depth(v, visit);
		}
	}

	private void auxDisplay_breadth(int u, boolean[] visit) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		visit[u] = true;
		while (!q.isEmpty()) {
			u = q.remove();
			System.out.println(u);
			for (int v = 0; v < nvertices; ++v) {
				if (matrix[u][v] == 1 && visit[v] == false) {
					q.add(v);
					visit[v] = true;
				}
			}
		}
	}

	private boolean auxCycle(int u, boolean[] visit) {
		visit[u] = true;
		for (int v = u + 1; v < nvertices; ++v) {
			if (matrix[u][v] == 1) {
				if (visit[v] == false) {
					if(auxCycle(v, visit)) return true;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasCycle() {
		boolean[] visit = new boolean[nvertices];
		for (int u = 0; u < nvertices; ++u) {
			if (visit[u] == false)
				if(auxCycle(u, visit)) return true;
		}
		return false;
	}
	
	private boolean auxOddCycle(int u, int[] visit, int color) {
		visit[u] = color;
		for (int v = u + 1; v < nvertices; ++v) {
			if (matrix[u][v] == 1) {
				if (visit[v] == 0) {
					if(auxOddCycle(v, visit,color==1?2:1)) return true;
				} else {
					/*odd cycle check */
					return visit[u] == visit[v];
				}
			}
		}
		return false;
	}

	public boolean hasOddCycle() {
		int[] visit = new int[nvertices];
		boolean result = false;
		for (int u = 0; u < nvertices; ++u) {
			if (visit[u] == 0)
				if(auxOddCycle(u, visit, 1)) {
					result = true;
					break;
				}
		}
		if(result == false) {
			System.out.println(Arrays.toString(visit));
		}
		return result;
	}
	
	private boolean auxHamiltonianCycle(int u, boolean[] visit) {
		visit[u] = true;
		for (int v = 0; v < nvertices; ++v) {
			if (matrix[u][v] == 1) {
				if (visit[v] == false) {
					if(auxHamiltonianCycle(v, visit)) return true;
				} else {
					/*hamiltonian condition check */
					for(int w  = 0; w < nvertices; ++w) {
						if(visit[w] == false) return false;
					}
					return true;
				}
			}
		}
		//allow other path explorations
		visit[u] = false;
		return false;
	}

	public boolean hasHamiltonianCycle() {
		boolean[] visit = new boolean[nvertices];
		Random r = new Random(100);		
		return auxHamiltonianCycle(r.nextInt(nvertices), visit);
	}


	@Override
	public int size() {
		return nvertices;
	}

	public void display() {
		for(int u = 0; u < nvertices; ++u) {
			if(u == 0) System.out.print("\t");
			System.out.print( u + " ");
		}
		System.out.println();
		for (int u = 0; u < nvertices; ++u) {
			System.out.print(u + "\t");
			for (int v = 0; v < nvertices; ++v) {
				System.out.print(matrix[u][v] + " ");
			}
			System.out.println();
		}
	}
	// perform entire graph traversal
	@Override
	public void traverse() {		
		boolean[] visit = new boolean[nvertices];
		for (int u = 0; u < nvertices; ++u) {
			if (visit[u] == false)
				auxDisplay_breadth(u, visit);
		}
	}
	class Edge {
		int start;
		int end;
		int weight;
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		public String toString() {
			return "(" + start +  "," + end + "," + weight + ")";
		}
	}
	
	class Mycomparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}
		
	}
	
	class DisjointSet {
		public void add(int u, int v) {
			
		}
		public boolean hasCycle(int u, int v) {
			return false;
		}
	}
	
	public int findMinCostST() {
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int u = 0; u < nvertices; ++u ){
			for(int v = u +1; v < nvertices; ++v) {
				if(matrix[u][v] != Integer.MAX_VALUE)
					edges.add(new Edge(u,v,matrix[u][v]));
			}
		}
		Collections.sort(edges, new Mycomparator());
		System.out.println(edges);
		
		int stedges  = 0;
		int totcost = 0;
		DisjointSet set = new DisjointSet();
		for(int i = 0; i < edges.size(); ++i) {
			Edge cedge = edges.get(i);
			if(!set.hasCycle(cedge.start, cedge.end)) {
				++stedges;
				set.add(cedge.start, cedge.end);
				totcost += cedge.weight;
			}
			if(stedges == nvertices-1) return totcost;
		}
		return 0;
	}

}
