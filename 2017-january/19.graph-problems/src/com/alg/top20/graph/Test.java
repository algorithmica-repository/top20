package com.alg.top20.graph;

import java.awt.Adjustable;
import java.util.Random;

public class Test {
	
	public static void testRandomGraph(int n) {
		UndirectedGraph graph1 = new UndirectedGraph(n);
		Random r = new Random(100);
		for(int i = 0; i < n; ++i) {
			int u = r.nextInt(n);
			int v = r.nextInt(n);
			if(u != v)
				graph1.addEdge(u, v);
		}
		graph1.display();
		graph1.traverse2();		
	}
	
	public static void testTraversal(int n) {
		//testcase1: random graph
		UndirectedGraph graph1 = new UndirectedGraph(n);
		Random r = new Random(100);
		for(int i = 0; i < n; ++i) {
			int u = r.nextInt(n);
			int v = r.nextInt(n);
			if(u != v)
				graph1.addEdge(u, v);
		}
		graph1.display();
		graph1.traverse2();
		
		//testcase2: complete graph
		UndirectedGraph graph2 = new UndirectedGraph(n);
		for(int u = 0; u < n-1; ++u) {
			for(int v = u+1; v < n; ++v) {
				graph2.addEdge(u, v);
			}
		}
		graph2.display();
		graph2.traverse2();
	}

	public static void testBipartite(int n) {
		//complete graph
		UndirectedGraph graph1 = new UndirectedGraph(n);
		for(int u = 0; u < n-1; ++u) {
			for(int v = u+1; v < n; ++v) {
				graph1.addEdge(u, v);
			}
		}
		graph1.display();
		System.out.println(graph1.isBipartite());
		
		//cycle graph
		UndirectedGraph graph2 = new UndirectedGraph(n);
		for(int u = 0; u < n; ++u)
			graph2.addEdge(u, (u+1)%n);
		graph2.display();
		System.out.println(graph2.isBipartite());	
	}
	
	public static void testCycle(int n) {
		//complete graph
		UndirectedGraph graph1 = new UndirectedGraph(n);
		for(int u = 0; u < n-1; ++u) {
			for(int v = u+1; v < n; ++v) {
				graph1.addEdge(u, v);
			}
		}
		graph1.display();
		System.out.println(graph1.hasCycle());
		
		//cycle graph
		UndirectedGraph graph2 = new UndirectedGraph(n);
		for(int u = 0; u < n; ++u)
			graph2.addEdge(u, (u+1)%n);
		graph2.display();
		System.out.println(graph2.hasCycle());
		
		//Random graph
		UndirectedGraph graph3 = new UndirectedGraph(n);
		Random r = new Random();
		for(int i = 0; i < 2*n; ++i) {
			int u = r.nextInt(n);
			int v = r.nextInt(n);
			if(u != v)
				graph3.addEdge(u, v);
		}
		graph3.display();
		System.out.println(graph3.hasCycle());		
	}

	public static void testPaths(int n) {
		//Random graph
		UndirectedGraph graph1 = new UndirectedGraph(n);
		Random r = new Random();
		for(int i = 0; i < n; ++i) {
			int u = r.nextInt(n);
			int v = r.nextInt(n);
			if(u != v)
				graph1.addEdge(u, v);
		}
		graph1.display();
		graph1.exploreAllPaths(0, n-1);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		//testRandomGraph(n);
		//testBipartite(n);
		//testCycle(n);
		testPaths(n);
	}	
}
