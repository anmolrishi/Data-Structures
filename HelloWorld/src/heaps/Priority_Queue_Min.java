package heaps;

import java.util.ArrayList;

public class Priority_Queue_Min<T> {
	private ArrayList<PQNode<T>> heap;
	
	public Priority_Queue_Min() {
		heap = new ArrayList<>();
	}
	
	public int size() {
		return heap.size();
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public T min() {
		if(isEmpty()){
			return null;
		}
		
		return heap.get(0).data;
	}
	
	public void insert(T data,int priority) {
		PQNode<T> newNode = new PQNode<T>(data, priority);
		heap.add(newNode);
		
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2;
		
		PQNode<T> child = heap.get(childIndex);
		PQNode<T> parent = heap.get(parentIndex);
		
		while(childIndex>0){
			if(child.priority > parent.priority){
				break;
			}
			else{
				heap.set(parentIndex, child);
				heap.set(childIndex, parent);
				
				childIndex = parentIndex;			//Updating the indices
				parentIndex = (childIndex-1)/2;
				
				child = heap.get(childIndex);		//Updating node
				parent = heap.get(parentIndex);
			}
		}
	}
	
	public T removeMin() {
		if(isEmpty()){
			return null;
		}
		
		T temp = heap.get(0).data;
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		if(heap.size()>1){
			downHeapify(0);
		}
		
		
		return temp;
	}

	private void downHeapify(int index) {
		int leftChildIndex = 2*index + 1;
		int rightChildIndex = 2*index + 2;
		
		if(leftChildIndex >= heap.size()){
			return;
		}
		int minIndex = index;
		
		if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority){
			minIndex = leftChildIndex;
		}
		if(rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(minIndex).priority){
			minIndex = rightChildIndex;
		}
		
		if(minIndex!=index){
			PQNode<T> temp = heap.get(minIndex);
			heap.set(minIndex, heap.get(index));
			heap.set(index, temp);
			downHeapify(minIndex);
		}
		
	}
	
	
}
