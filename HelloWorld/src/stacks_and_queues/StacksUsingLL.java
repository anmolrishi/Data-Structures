package stacks_and_queues;

import linked_list.Node;

public class StacksUsingLL<T> {
	
	Node<T> top;
	int size;
	public StacksUsingLL() {
		top=null;
		size=0;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void push(T data) {
		if(top==null){
			top=new Node<T>();
			top.setData(data);
		}
		
	}
	
	public T pop() {
		return null; //return Integer.MIN_VALUE;
	}
}
