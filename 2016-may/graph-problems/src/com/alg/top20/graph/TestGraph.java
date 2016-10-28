package com.alg.top20.graph;

import java.util.Random;

public class TestGraph {

	public static void testGraph1(Igraph graph) {
		for(int u = 0; u < graph.size(); ++u) {
			for(int v = u+1; v < graph.size(); ++v) {
				graph.addEdge(u, v);
			}
		}
		graph.display();
		System.out.println(graph.hasHamiltonianCycle());
	}
	
	public static void testGraph2(Igraph graph) {
		for(int u = 0; u < graph.size()/2; ++u) {
			for(int v = u+1; v < graph.size()/2; ++v) {
				graph.addEdge(u, v);
			}
		}
		
		for(int u = graph.size()/2; u < graph.size(); ++u) {
			for(int v = u+1; v < graph.size(); ++v) {
				graph.addEdge(u, v);
			}
		}
		graph.display();
		System.out.println(graph.hasHamiltonianCycle());
	}
	
	public static void testGraph3(Igraph graph) {
		Random r = new Random(100);
		for(int i = 0; i < Math.sqrt(graph.size()); ++i) {
			int u = r.nextInt(graph.size());
			int v = r.nextInt(graph.size());
			if(u != v)
				graph.addEdge(u, v);
		}
		graph.display();
		System.out.println(graph.hasHamiltonianCycle());
	}
	
	public static void testGraph4(Igraph graph) {
		Random r = new Random(100);
		for(int u = 0; u < graph.size(); ++u) {
			for(int v = u+1; v < graph.size(); ++v) 
				graph.addEdge(u, v, r.nextInt(20) + 1);
		}
		graph.display();
		System.out.println(graph.findMinCostST());
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		testGraph4(new UndirectedGraph(n));
	}

}
