package com.alg.top20.graphs;

public class TestGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IGraph  graph1 = new AdjMatrixGraph(4);
		for(int u = 0; u < 4; ++u) {
			for(int v = u+1; v < 4; ++v) {
				graph1.addEdge(u, v);
			}
		}
		IGraph  graph2 = new AdjMatrixGraph(4);
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(0, 3);
		
		graph1.display();
		System.out.println(graph1.hasCycle());
		
		graph2.display();
		System.out.println(graph2.hasCycle());
		
	}

}
