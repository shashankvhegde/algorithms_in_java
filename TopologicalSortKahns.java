package algorithms_in_java;

import java.util.ArrayDeque;
import java.util.Deque;


public class TopologicalSortKahns {

	private Digraph digraph;
	private Deque<Integer> order;
	
	public TopologicalSortKahns(Digraph digraph) {
		this.digraph = digraph;
		order = new ArrayDeque<>();
	}
	
   	public Deque<Integer> topologicalOrder(){
        
		int V = digraph.getNoVertices();
		int[] indegree = new int[V];

		for(int from = 0;from<V;from++) {
			for(int to: digraph.getNeighbors(from)) {
				indegree[to]++;
			}
		}

		Deque<Integer> queue = new ArrayDeque<>();

		for(int vertex = 0; vertex<V;vertex++) {
			if(indegree[vertex] == 0) {
				queue.addLast(vertex);
			}
		}

		while(!queue.isEmpty()) {
			int vertex = queue.getFirst();
			order.addLast(vertex);

			queue.removeFirst();

			for(int neighbor: digraph.getNeighbors(vertex)) {
				indegree[neighbor]--;
				if(indegree[neighbor] == 0) {
					queue.addLast(neighbor);
				}
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
		
		TopologicalSortKahns topologicalSort = new TopologicalSortKahns(digraph);
		Deque<Integer> order = topologicalSort.topologicalOrder();
		
		System.out.println("Following is the topological sort");
		while(!order.isEmpty()) {
			System.out.print(order.getFirst() + " ");
			order.removeFirst();
		}
	}

}
