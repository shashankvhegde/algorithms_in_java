package algorithms_in_java;

import java.util.*;

class Graph{
	
	private int V;
	private List<Integer>[] graph;
	private boolean[] visited;
	
	private void dfs(int vertex) {
	    visited[vertex] = true;
	    System.out.print(vertex + " ");
	    for(int i = 0;i<graph[vertex].size();i++){
	        if(!visited[graph[vertex].get(i)]){
	            dfs(graph[vertex].get(i));
	        }
	    }
	}
	private void bfs(int vertex) {
	    Deque<Integer> q = new ArrayDeque<>();
	    q.addLast(vertex);
	    
	    visited[vertex] = true;
	    
	    while(!q.isEmpty()){
	        int x = q.getFirst();
	        System.out.print(x + " ");
	        q.removeFirst();
	        
	        for(int i = 0;i<graph[x].size();i++){
	            int w = graph[x].get(i);
	            if(!visited[w]){
	                visited[w] = true;
	                q.addLast(w);
	            }
	        }
	    }
	}
	
	public Graph(int V) {
		this.V = V;
		graph = (ArrayList<Integer>[]) new ArrayList[V];
		for(int i = 0;i<V;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		visited = new boolean[V];		
	}
	
	public void addEdge(int u, int v) {
		graph[u].add(v);
		graph[v].add(u);
	}

	public void dfs(){
		System.out.println("DFS");
		visited = new boolean[V];
		for(int i = 0;i<V;i++){
	        if(!visited[i]){
	            dfs(i);
	        }
	    }
		System.out.println();
	}
	public void bfs() {
		System.out.println("BFS");
		visited = new boolean[V];
	    for(int i = 0;i<V;i++){
	        if(!visited[i]){
	            bfs(i);
	        }
	    }
	    System.out.println();
	}
	public void print(){
	    for(int i = 0;i<V;i++){
	        System.out.print(i + ": ");
	        for(int j = 0;j<graph[i].size();j++){
	            System.out.print(graph[i].get(j) + " ");
	        }
	        System.out.println();
	    }
	}

}

public class GraphTraversal {

	public static void main(String[] args) {
	    int vertices = 8;
	    
	    Graph graph = new Graph(vertices);
	    
	    graph.addEdge(0, 1);
	    graph.addEdge(1, 6);
	    graph.addEdge(6, 7);
	    graph.addEdge(0, 2);
	    graph.addEdge(2, 3);
	    graph.addEdge(2, 4);
	    graph.addEdge(2, 5);
	    graph.addEdge(5, 6);
	    graph.print();
	    
	    graph.dfs();
	    
	    graph.bfs();
	}

}
