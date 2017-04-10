package com.alg.top20.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraph {
	//List<List<Integer>>
	private int[][] adj_matrix;
	
	public UndirectedGraph(int size) {
		adj_matrix = new int[size][size];
	}
	public void addEdge(int u, int v) {
		adj_matrix[u][v] = adj_matrix[v][u] = 1;
	}
	
	private void auxTraverse1(int u, boolean[] visit) {		
		System.out.println(u);
		visit[u] = true;
		for(int v = 0; v < adj_matrix.length; ++v) {
			if(adj_matrix[u][v] == 1 && visit[v] == false)
				auxTraverse1(v, visit);
		}
	}
	
	//TC:O(V + V^2) O(V^2)    SC:V+V O(V)
	public void traverse1() {
		//to avoid revisiting of vertices
		boolean[] visit = new boolean[adj_matrix.length];
		
		int ncomponent = 1;
		//this allows us to traverse all connected components of given graph
		for(int u = 0; u < adj_matrix.length; ++u) {			
			if(visit[u] == false) {
				System.out.println("Component-" + ncomponent);
				auxTraverse1(u, visit);
				++ncomponent;
			}
		}	
	}
	
	private void auxTraverse2(int u, boolean[] visit) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(u);
		visit[u] = true;
		while (!queue.isEmpty()) {
			Integer current = queue.remove();			
			System.out.println(current);			
			for(int v = 0; v < adj_matrix.length;++v) {
				if(adj_matrix[current][v] == 1 && visit[v] == false) {
					visit[v] = true;
					queue.add(v);
				}					
			}
		}	
	}
	
	//TC:V + V^2 O(V^2)     SC:V+V O(V)
	public void traverse2() {
		//to avoid revisiting of vertices
		boolean[] visit = new boolean[adj_matrix.length];
		
		//this allows us to traverse all connected components of given graph
		int ncomponent = 1;
		for(int u = 0; u < adj_matrix.length; ++u) {
			if(visit[u] == false) {
				System.out.println("Component-" + ncomponent);
				auxTraverse1(u, visit);
				++ncomponent;
			}
		}
		
	}
	
	public void display() {
		for(int u = 0; u < adj_matrix.length; ++u) {
			for(int v = 0; v < adj_matrix.length; ++v) {
				System.out.print(adj_matrix[u][v]);
			}
			System.out.println();
		}
	}
	
	private boolean auxBipartite(int u, int p, int[] visit) {
		visit[u] = p;
		for(int v = 0; v < adj_matrix.length; ++v) {
			if(adj_matrix[u][v] == 1) {
				//if v is not visited then process v
				if(visit[v] == 0) {
					//to break current level of recursion
					if(! auxBipartite(v, p==1?2:1, visit))
						return false;
				}
				// if v already visited then check for conflict
				else {
					if(visit[v] == p) 
						return false;
				}
			}
		}
		return true;
	}
	public boolean isBipartite() {
		int[] visit = new int[adj_matrix.length];
		boolean res = auxBipartite(0, 1, visit);
		if(res) {
			List<Integer> part1 = new ArrayList<Integer>();
			List<Integer> part2 = new ArrayList<Integer>();
			
			for(int i = 0; i < visit.length; ++i) {
				if(visit[i] == 1)
					part1.add(i);
				else
					part2.add(i);
			}
			System.out.println(part1);
			System.out.println(part2);
		}
		return res;
	}
	
	public boolean auxCycle(int u, boolean[] visit) {
		//System.out.println(u);
		visit[u] = true;
		for(int v = 0; v < adj_matrix.length; ++v) {
			if(adj_matrix[u][v] == 1) {
				if(visit[v] == false) {
					if(auxCycle(v, visit)) return true;
				}
				else {
					return true;
				}
			}
		}
		return false;
	}
	public boolean hasCycle() {
		//to avoid revisiting of vertices
		boolean[] visit = new boolean[adj_matrix.length];
		
		//this allows us to traverse all connected components of given graph
		for(int u = 0; u < adj_matrix.length; ++u) {
			if(visit[u] == false)
				if(auxCycle(u, visit)) return true;
		}
		return false;
	}
	
	public void exploreAllPaths(int u, int v) {
		boolean[] visit = new boolean[adj_matrix.length];
		auxAllPaths(u, v, visit,""+u);		
	}	
	private void auxAllPaths(int u, int v, boolean[] visit, String route) {
		if(u == v) {
			System.out.println(route);
			return;
		}
		visit[u] = true;
		for(int w = 0; w < adj_matrix.length; ++w) {
			if(adj_matrix[u][w] == 1 && visit[w] == false) {
					auxAllPaths(w, v, visit,route+"->"+w);
			}
		}
		visit[u] = false;
	}
 	
}
