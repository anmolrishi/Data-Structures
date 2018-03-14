package graphs;

import java.util.ArrayList;

public class Vertex {

	String name;
	private ArrayList<Edge> edges;

	Vertex(String name){
		this.name = name;
		edges = new ArrayList<>();
	}

	public int numEdges(){
		return edges.size();
	}

	public boolean isAdjacent(String name) {
		for(Edge e: edges){
			if(e.first.name.equals(name)||e.second.name.equals(name)){
				return true;
			}
		}
		return false;
	}

	public void addEdge(Edge e) {
		edges.add(e);

	}

	public void removeEdgeWith(String name1) {
		// TODO Auto-generated method stub
		for(int i=0;i<edges.size();i++){
			Edge e = edges.get(i);
			if(e.second.name.equals(name)||e.first.name.equals(name)){
				edges.remove(i);
				return;
			}

		}
	}

	public ArrayList<Vertex> getAdjacent() {
		ArrayList<Vertex> adjacent = new ArrayList<>();
		for(Edge e: edges){
			if(e.first==this){
				adjacent.add(e.second);
			}
			else{
				adjacent.add(e.first);
			}
		}
		return adjacent;
	}

	public void print() {
		
		System.out.print(this.name+": ");
		
		for(Edge e: edges){
			if(e.first==this){
				System.out.print(e.second.name+",");
			}
			else{
				System.out.print(e.first.name+",");
			}
		}
		System.out.println();
	}
}