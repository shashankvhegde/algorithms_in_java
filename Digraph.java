package algorithms_in_java;

import java.util.ArrayList;
import java.util.List;

class DirectedEdge{
	private int u;
	private int v;
		
	public DirectedEdge(int u, int v) {
		this.u = u;
		this.v = v;
	}
	public int from() { return u; }
	public int to() { return v; }
}

public class Digraph{
	private int V;
    	private List<DirectedEdge>[] adj;
    
	public Digraph(int V){
		this.V = V;
		this.adj = (ArrayList<DirectedEdge>[]) new ArrayList[V];
		for(int i = 0;i<V;i++){
		    adj[i] = new ArrayList<DirectedEdge>();
		}
	}

	public int getNoVertices() {
		return V;
	}
	public void addEdge(int u, int v) {
		adj[u].add(new DirectedEdge(u, v));
	}

	public List<Integer> getNeighbors(int vertex){
		List<Integer> neighbors = new ArrayList<>();
		for(DirectedEdge edge: adj[vertex]) {
			neighbors.add(edge.to());
		}
		return neighbors;
	}


	public void print(){
	    for(int i = 0;i<V;i++){
		System.out.print(i + ": ");
		for(int j = 0;j<adj[i].size();j++){
		    System.out.print(adj[i].get(j) + " ");
		}
		System.out.println();
	    }
	}

}
