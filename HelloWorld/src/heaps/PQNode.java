package heaps;

public class PQNode<T> {
	T data;
	int priority;
	
	public PQNode(T data, int priority) {
		this.data = data;
		this.priority = priority;
	}

}
