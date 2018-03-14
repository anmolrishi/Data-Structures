package graphs;

import java.util.ArrayList;
import java.util.HashMap;

import stacks_and_queues.QueueUsingLL;


public class Graph {

	private ArrayList<Vertex> vertices;

	public Graph() {
		vertices = new ArrayList<>();
	}

	public void print(){
		for(Vertex v: vertices){
			v.print();
		}
	}
	
	public void removeEdge(String name1, String name2){

		Vertex first = getVertex(name1);
		Vertex second = getVertex(name2);

		if(first==null||second==null){
			return;
		}

		if(!areAdjacent(first,second)){
			return;
		}

		first.removeEdgeWith(name2);
		second.removeEdgeWith(name1);
	}

	public void removeVertex(String name){

		Vertex v = getVertex(name);
		if(v==null){
			return;
		}

		ArrayList<Vertex> adjacent = v.getAdjacent();
		for(Vertex adj: adjacent){
			adj.removeEdgeWith(name);
		}

		vertices.remove(v);
	}


	public void addVertex(String name){
		// vertex is already present
		if(isVertexPresent(name)){
			return;
		}

		Vertex v = new Vertex(name);
		vertices.add(v);
	}

	public void addEdge(String name1,String name2){
		// check if vertex is already present or not
		Vertex first = getVertex(name1);
		Vertex second = getVertex(name2);

		if(!isVertexPresent(name1)||!isVertexPresent(name2)){
			return;
		}

		if(areAdjacent(first,second)){
			return;
		}

		Edge e = new Edge(first, second);
		first.addEdge(e);
		second.addEdge(e);
	}

	private boolean areAdjacent(Vertex first, Vertex second) {
		if(first.numEdges()<second.numEdges())
			return first.isAdjacent(second.name);
		else
			return second.isAdjacent(first.name);
	}
	private Vertex getVertex(String name) {
		// TODO Auto-generated method stub

		for(Vertex v: vertices)
		{
			if(v.name.equals(name))
			{
				return v;
			}
		}
		return null;
	}

	private boolean isVertexPresent(String name) {

		for(Vertex v: vertices){
			if(v.name.equals(name)){
				return true;
			}
		}
		return false;

	}
	
	public void BFS(int Si){  // breadth first search
	
		
		Vertex first = this.vertices.get(Si);
		if(first==null){
			return;
		}
		
		int i = Si;
		QueueUsingLL<Vertex> queue = new QueueUsingLL<>();
		queue.enqueue(first);
		
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		visited.put(first, true);

		while(!queue.isEmpty()){
			i++;
			Vertex  currentVertex = queue.dequeue();
			System.out.print(currentVertex.name + " ");
			
			ArrayList<Vertex> vertices = new ArrayList<>();
			vertices = currentVertex.getAdjacent();
			for(Vertex v: vertices){

				if(!visited.containsKey(v)){
					visited.put(v, true);
					queue.enqueue(v);
				}
			}
		
		}
		if(i<vertices.size()){
			BFS(i);
		}
		
	}
	
	public ArrayList<ArrayList<Vertex>> returnConnected(int Si,int listI){  // breadth first search

		Vertex first = this.vertices.get(Si);
		if(first==null){
			return null;
		}

		int i = Si;
		QueueUsingLL<Vertex> queue = new QueueUsingLL<>();
		queue.enqueue(first);

		HashMap<Vertex, Boolean> visited = new HashMap<>();
		visited.put(first, true);
		
		ArrayList<ArrayList<Vertex>> ans = new ArrayList<>();
		int j=0;
		while(!queue.isEmpty()){
			i++;
			Vertex  currentVertex = queue.dequeue();
			
			ans.get(listI).get(j++);

			ArrayList<Vertex> vertices = new ArrayList<>();
			vertices = currentVertex.getAdjacent();
			for(Vertex v: vertices){

				if(!visited.containsKey(v)){
					visited.put(v, true);
					queue.enqueue(v);
				}
			}

		}
		if(i<vertices.size()){
			 returnConnected(i, ++listI);
		}
		
			return ans;
		

	}

	public void DFS(String name1,String name2) {
		
		Vertex first  = getVertex(name1);
		Vertex second = getVertex(name2);
		
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		visited.put(first, true);

		DFSExists(first,second,visited);
		

	}
	private void DFSExists(Vertex first, Vertex second, HashMap<Vertex, Boolean> visited) {
		// TODO Auto-generated method stub
		if (areAdjacent(first, second)){
			System.out.println(first.name);
		}
		ArrayList<Vertex> vertices = new ArrayList<>();
		vertices = first.getAdjacent();
		for(Vertex v: vertices){
			if(!visited.containsKey(vertices)){
				visited.put(v, true);
				boolean x = pathExists(v, second, visited);
				if(x==true){
					System.out.println();
				}
			}
		}
	//	return false;
	}
	
	public void havePath(String name1,String name2) {
		Vertex first  = getVertex(name1);
		Vertex second = getVertex(name2);
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		visited.put(first, true);

		boolean ans = pathExists(first,second,visited);
		System.out.println(ans);

	}
	private boolean pathExists(Vertex first, Vertex second, HashMap<Vertex, Boolean> visited) {
		// TODO Auto-generated method stub
		if (areAdjacent(first, second)){
			return true;
		}
		ArrayList<Vertex> vertices = new ArrayList<>();
		vertices = first.getAdjacent();
		for(Vertex v: vertices){
			if(!visited.containsKey(vertices)){
				visited.put(v, true);
				boolean x = pathExists(v, second, visited);
				if(x==true){
					return x;
				}
			}
		}
		return false;
	}
	
//	public boolean havePath(String name1,String name2) {
//		Vertex first = getVertex(name1);
//		Vertex second = getVertex(name2);
//		
//		
//		if(first==null || second==null){
//			return false;
//		}
//		
//		HashMap<Vertex, Boolean> visited = new HashMap<>();
//		visited.put((first, true);
//		
//		return havePath()
//		if(areAdjacent(first, second)){
//			return true;
//		}
//		
//		ArrayList<Vertex> ans = first.getAdjacent();
//		visited.put(first.name,true);
//		
//		for(int i=0;i<ans.size();i++){
//			if(visited.containsKey(second.name) && visited.get(second.name)){
//				visited.remove(second.name);
//				
//				a = havePath(ans.get(i).name, name2,visited);
//				if(!a){
//					return a;
//				}
//				
//			}
//			
//		}
//		return a;
//	}
//
}