package algorithms_in_java;
import java.util.*;

class IndexedPriorityQueue<T extends Comparable<T>>{
	private int size;
	private List<Entry> nodes; // Entry key will be the key users provide. For example; vertex number in a graph.
	private Map<Integer, Integer> key_to_position; // mapping from key (provided by user) to position in the nodes vector.


	private int parent(int pos){
		return (pos == 0) ? pos : (pos-1)/2;
	}
	private int left(int pos){
        	return (2*pos + 1);
	}
	private int right(int pos){
		return (2*pos + 2);
	}
	
	private void exchange(int a, int b){
		if(a == b) return;
		key_to_position.put(nodes.get(a).key, b);
		key_to_position.put(nodes.get(b).key, a);
		
		Entry temp = nodes.get(a);
		nodes.set(a, nodes.get(b));
		nodes.set(b, temp);
	}
	
	private int sink(int pos){
		boolean stop = false;

		while(left(pos) < size && !stop){
			
			int l = left(pos);
			int r = right(pos);
			
            		int min_index = l;
			if(l < size-1 && nodes.get(l).val.compareTo(nodes.get(r).val) > 0) { 
				min_index = r;
			} 

			if(nodes.get(min_index).val.compareTo(nodes.get(pos).val) < 0) {
				exchange(min_index, pos);
			}
			else {
				min_index = pos;
				stop = true; 
			}
			pos = min_index;
		}
		return pos;
	}
	
	private int swim(int pos){
		while(parent(pos) != pos && nodes.get(parent(pos)).val.compareTo(nodes.get(pos).val) > 0){
            		exchange(pos, parent(pos));
			pos = parent(pos);
		}
		return pos;
	}
	
	private class Entry{
		public int key;
		public T val;
	
		public Entry(int key, T val){
			this.key = key;
			this.val = val;
		}
	};
	public IndexedPriorityQueue(){
		size = 0;
		this.nodes = new ArrayList<Entry>();
		this.key_to_position = new HashMap<Integer, Integer>();
	}
	public IndexedPriorityQueue(Map<Integer, T> nodes){
		this();
		build(nodes);
	}
	
	public void build(Map<Integer, T> nodes){
		for(Map.Entry<Integer, T> node: nodes.entrySet()){
			this.nodes.add(new Entry(node.getKey(), node.getValue()));
			key_to_position.put(node.getKey(), size);
			size++;
		}
		for(int i = ((size/2)-1);i>=0;i--){
			sink(i);
		}
	}
	
	public T top(){
		return nodes.get(0).val;	
	}
	
	public void pop(){
		key_to_position.remove(nodes.get(0).key);
        	exchange(0, size-1);
		size--;
		sink(0);
		nodes.remove(nodes.size()-1);
		
	}
	
	public int push(int key, T val){
		Entry node = this.new Entry(key, val);
		nodes.add(node);
		int pos = swim(size);
		size++;
		key_to_position.put(key, pos);
		return size-1;
	}
	
	public void decrease(int id, T new_val){
		nodes.get(key_to_position.get(id)).val = new_val;
		swim(key_to_position.get(id));
	}
    	public void print(){
		for(Entry node: nodes){
		    System.out.println(node.key + " " + node.val);
		}
		System.out.println();
		for(Map.Entry<Integer, Integer> entry: key_to_position.entrySet()){
		    System.out.println(entry.getKey() + "->" + entry.getValue());
		}
		System.out.println();
	}
	public boolean empty(){
		return (size == 0);
	}
		
}
public class IndexedMinPriorityQueue {

	public static void main(String[] args) {
	    IndexedPriorityQueue<Integer> pq = new IndexedPriorityQueue<>();
	    pq.push(1, 3);
	    pq.push(2, 2);
	    pq.push(3, 15);
	    pq.push(4, 5);
	    pq.push(5, 4);
	    pq.push(6, 45);
	 
	    pq.print();
	    pq.decrease(6, 1);
	    pq.decrease(3, 2);
	    pq.decrease(5, 2);
	    pq.print();
	    System.out.println();
	    

	    while(!pq.empty()){
	        System.out.println(pq.top() + " ");
	        pq.pop(); 
	    }
	    System.out.println("####################################################################");
	    
	    
	    Map<Integer, Integer> nodes = new HashMap<>();
	    nodes.put(1, 3);
	    nodes.put(2, 2);
	    nodes.put(3, 15);
	    nodes.put(4, 5);
	    nodes.put(5, 4);
	    nodes.put(6, 45);
	    
	    for(Map.Entry<Integer, Integer> entry: nodes.entrySet()) {
	    	nodes.put(entry.getKey(), entry.getValue());
	    }
	    IndexedPriorityQueue<Integer> minheap = new IndexedPriorityQueue<>(nodes);
	    minheap.print();
	    minheap.decrease(6, 1);
	    minheap.decrease(3, 2);
	    minheap.decrease(5, 2);
	    minheap.print();
	    System.out.println();
	    
	    
	    while(!minheap.empty()){
	    	System.out.println(minheap.top() + " ");
	        minheap.pop(); 
	    }
	    System.out.println("####################################################################");
	    
	}

}
