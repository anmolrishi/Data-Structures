package stacks_and_queues;

import linked_list.Node;

public class QueueUsingLL<T> {

	private Node<T> front;
	private Node<T> rear;
	private int size;
	
	public QueueUsingLL() {
		front=null;
		rear=null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
		
	}
	
	public Node<T> front() {
		if(isEmpty()){
			return null;
		}
		return front;
	}
	
	public void enqueue(T element) {
		Node<T> insert = new Node<>();
		insert.setData(element);
		insert.setNext(null);
		
		if(isEmpty()){
			front = insert;
			rear = insert;
		}
		
		rear.setNext(insert);
		rear=insert;
		size++;
	}
	
	public T dequeue() {
		Node<T> insert = new Node<>();
		insert.setData(front.getData());
		if(size==1){
			front=null;
			rear=null;
		}
		else{
		front = front.getNext();
		}
		size--;
		return insert.getData();
	}
}
