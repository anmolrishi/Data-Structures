package graphs;

import java.util.HashMap;

public class GraphUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("G");
		g.addVertex("H");
		g.addVertex("I");
		
		g.addEdge("A", "B");
		g.addEdge("A", "C");
		g.addEdge("B", "G");
		g.addEdge("C", "H");
		g.addEdge("A", "D");
		g.addEdge("D", "I");
		
		
		g.addVertex("X");
		g.addVertex("Y");
		g.addVertex("Z");
		
		g.addEdge("X", "Y");
		g.addEdge("Y", "Z");
		g.addEdge("X", "Z");
		
		
		g.addVertex("O");
		g.addVertex("L");
		
		g.addEdge("O", "L");
		
		
		g.addVertex("ANMOL");
		
		g.print();
		System.out.println();
	//	g.DFS("A", "D");
		g.BFS(0);
		//g.havePath("B","C");
	}

}