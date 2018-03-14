package stacks_and_queues;

public class QueueUseLL {

	public static void reverse(QueueUsingLL<Integer> queue) {
		if(queue.size()<=1){
			return ;
		}
		
		int temp = queue.dequeue();
		reverse(queue);
		
//		while(!queue.isEmpty()){
//			helper.enqueue(queue.dequeue());
//		}
		
		queue.enqueue(temp);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingLL<Integer> queue = new QueueUsingLL<>();
		for(int i=0;i<5;i++){
			queue.enqueue(i);
		}
		reverse(queue);
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}

		
		
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
		
		

	}

}
