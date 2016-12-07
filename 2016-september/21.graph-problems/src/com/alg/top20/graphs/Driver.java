package com.alg.top20.graphs;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		IUnweightedGraph graph1 = new SequentialUnweightedGraph(n);
		
		//test case1: random graph
		Random r = new Random(100);
		for(int i = 0; i < Math.sqrt(n); ++i) {
			int u = r.nextInt(n);
			int v = r.nextInt(n);
			if(u != v)
				graph1.addEdge(u, v);
		}
		graph1.display();
		//graph1.traverse_breadth();
		System.out.println(graph1.hasCycle());
		
		//testcase2: complete graph
		IUnweightedGraph graph2 = new SequentialUnweightedGraph(n);
		for(int u = 0; u < n; ++u) {
			for(int v = u+1; v < n; ++v) {
				graph2.addEdge(u, v);
			}
		}
		graph2.display();
		//graph2.traverse_breadth();
		System.out.println(graph2.hasCycle());
		
		//testcase3: disconnected graph
		IUnweightedGraph graph3 = new SequentialUnweightedGraph(n);
		for(int u = 0; u < n/2; ++u) {
			for(int v = u+1; v < n/2; ++v) {
				graph3.addEdge(u, v);
			}
		}
		for(int u = n/2; u < n; ++u) {
			for(int v = u+1; v < n; ++v) {
				graph3.addEdge(u, v);
			}
		}
		graph3.display();
		//graph3.traverse_breadth();
		System.out.println(graph3.hasCycle());
	}

}
