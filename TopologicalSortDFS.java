package algorithms_in_java;

import java.util.ArrayDeque;
import java.util.Deque;

public class TopologicalSortDFS{
    
	private Digraph digraph;
	Deque<Integer> order;
	
	public TopologicalSortDFS(Digraph digraph) {
		this.digraph = digraph;
		order = new ArrayDeque<>();
	}
	
	private void reversePostOrder(int v, boolean[] visited){

		visited[v] = true;
		for(int neighbor : digraph.getNeighbors(v)){
		    if(!visited[neighbor]){
			reversePostOrder(neighbor, visited);
		    }
		}
		order.addLast(v);

	}
    
	public Deque<Integer> topologicalOrder(){

		int vertices = digraph.getNoVertices();
		boolean[] visited = new boolean[vertices];

		for(int i = 0;i<vertices;i++){
		    if(!visited[i]){
			this.reversePostOrder(i, visited);
		    }
		}
		return order;
	}
    
	public static void main(String[] args) {
		int vertices = 6;
		Digraph digraph = new Digraph(vertices);
		digraph.addEdge(5, 2);
		digraph.addEdge(5, 0);
		digraph.addEdge(4, 0);
		digraph.addEdge(4, 1);
		digraph.addEdge(2, 3);
		digraph.addEdge(3, 1);
		
		TopologicalSortDFS topologicalSort = new TopologicalSortDFS(digraph);
		Deque<Integer> order = topologicalSort.topologicalOrder();
		
		System.out.println("Following is the topological sort");
		while(!order.isEmpty()) {
			System.out.print(order.getLast() + " ");
			order.removeLast();
		}
	}
}


