package linked_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LinkedListUse {

	public static Node<Integer> takeInput() {
		Scanner s = new Scanner(System.in);
		
		Node<Integer> head=null,tail=null;
		System.out.println("Enter Data");
		int data = s.nextInt();
		while(data!=-1){
			Node<Integer> newNode = new Node<>();
			newNode.setData(data);
			
			if(head==null){
				head=newNode;
				tail=newNode;
			}
			else{
				tail.setNext(newNode);
				tail=newNode;
			}
			System.out.println("Enter Data");
			data = s.nextInt();
		}
		return head;
		
	}
	
	public static void PrintIthElement(Node<Integer> head, int I) {
		Node<Integer> temp=head;
		int i=1;
		while(temp!=null && i<I){
			temp = temp.getNext();
			i++;
		}
		if(i==I){
			System.out.println(temp.getData());
		}
		else{
			System.out.println("UNDER FLOW");
		}
	}
	
	public static Node<Integer> InsertAtIth(Node<Integer> head) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Position");
		int I = s.nextInt();
		Node<Integer> temp=head,InsertNode = new Node<>();
		System.out.println("Enter Data");
		InsertNode.setData(s.nextInt());
		InsertNode.setNext(null);
		Node<Integer> prev = null;
		if(head==null){ //Empty List
			head=InsertNode;
		}
		else if(I==1){
			InsertNode.setNext(head);
			head = InsertNode;
		}
		else{int i=1;
			while(i<I && temp!=null){
				prev=temp;
				temp = temp.getNext();
				i++;
			}
			prev.setNext(InsertNode);
			InsertNode.setNext(temp);
			
		}
		return head;
	}
	
	public static Node<Integer> DeleteIth(Node<Integer> head) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Position");
		int I = s.nextInt();
		
		Node<Integer> temp=head;
		
		
		Node<Integer> prev = null;
		
		if(head==null){ //Empty List
			System.out.println("UNDERFLOW");
		}
		else if(I==0){
			prev = head;
			head = head.getNext();
			prev.setNext(null);
		}
		else{int i=1;
			while(i<=I && temp!=null){
				prev=temp;
				temp = temp.getNext();
				i++;
			}
			prev.setNext(temp.getNext());
			temp.setNext(null);
			
		}
		return head;
	}
	
	public static void PrintLinkedList(Node<Integer> head) {
	//	Node<Integer> temp=head;
		while(head!=null){
			System.out.print(head.getData() + "->"); //WORKS FINE 
			head = head.getNext();						//BECAUSE ONLY LOCAL VARIABLE IS CHANGED
		}
		
	}
	
	
	public static void increment(Node<Integer> head) {
			Node<Integer> temp=head;
			while(temp!=null){
				temp.setData(temp.getData() + 1);
				temp = temp.getNext();
			}
			
		}
	
	public static Node<Integer> RinsertAtI(Node<Integer>head,int i,int num)	
	{
		if(i==0)
		{
			Node<Integer>newNode =  new Node<>();
			newNode.setData(num);
			newNode.setNext(head);
			return newNode;
		} 
		 Node<Integer> smallHead = RinsertAtI(head.getNext(), i-1, num);
		 head.setNext(smallHead);
		 return head;
	}
	
	public static Node<Integer> RDeleteAtI(Node<Integer>head,int i)	
	{
		if(i==0)
		{			
			return head.getNext();
		} 
		 Node<Integer> smallHead = RDeleteAtI(head.getNext(), i-1);
		 head.setNext(smallHead);
		 return head;
	}
	
	public static Node<Integer> MergeSortedLinkedLists(Node<Integer> head1,Node<Integer> head2) {
		Node<Integer> FinalHead=null;
		Node<Integer> temp1=head1, temp2=head2;
		if(head1.getData()<head2.getData()){
			FinalHead = head1;
			temp1 = head1.getNext();
		}
		else{
			FinalHead = head2;
			temp2 = head2.getNext();
		}
		
		Node<Integer> tail = FinalHead;
		while(temp1!=null && temp2!=null){
			if(temp1.getData() < temp2.getData()){
				tail.setNext(temp1);
				tail=temp1; //tail=tail.next;
				temp1=temp1.getNext();
			}
			else{
				tail.setNext(temp2);
				tail=temp2;
				temp2=temp2.getNext();
			}
			
		}
		if(temp1!=null){		
			tail.setNext(temp1);
		}
		else{
			tail.setNext(temp2);
		}
		
		return FinalHead;
		
	}
//	
//	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
//		// write your code here
//
//	}
	
	public static Node<Integer> mergeSort(Node<Integer> head) {
		if(head.getNext()==null){
			return head;
		}

		int count =0;
		Node<Integer> p=head;
		while(p.getNext()!=null){
			++count;
			p=p.getNext();
		}
		int rev=count/2 + 1;
		Node<Integer> prev=null;
		int i=0;
		p=head;
		while(i<rev){
			prev = p;
			i++;
			p=p.getNext();
		}
		prev.setNext(null);
		
		return MergeSortedLinkedLists(mergeSort(p), mergeSort(head));

	}
	
//	public static Node<Integer> sortEvenOdd(Node<Integer> head){
//		if(head==null)
//		{
//			return head;
//		}
//		
//		
//	}
	
//	public static void mergeSort(int[] input){
//		if(input.length <= 1){
//			return;
//		}
//		int mid = input.length / 2;
//		int part1[] = new int[mid];
//		int part2[] = new int[input.length - mid];
//		for(int i = 0; i < part1.length; i++){
//			part1[i] = input[i];
//			//			k++;
//		}
//		for(int i = 0; i < part2.length; i++ ){
//			part2[i] = input[mid + i];
//		}
//		mergeSort(part1);
//		mergeSort(part2);
//		merge(part1, part2, input);
////		int[] output = merge(part1, part2);
////		for(int i = 0; i < output.length; i++){
////			input[i] = output[i];
// 
////		}
////		
//	}
	
	public static Node<Integer> sortEvenOdd(Node<Integer> head)
	{
	     Node<Integer> p=head,eh=null,oh=null,et=null,ot=null;
	    	   
	     if(p.getData().intValue()%2==0)
	     {
	    	 eh=p;
	    	 et=p;

	     }
	     
	     else
	     {
	    	 oh=p;
	    	 ot=p;
	     }
	     p=p.getNext();

	     while((eh==null || oh==null) && p!=null)
	     {
	    	 if(p.getData().intValue()%2==0){
	    		
	    		 if(eh==null){
	    			 eh=p;
	    			 et=p;
	    		 }
	    		 else{
	    			 et.setNext(p);
	    			 et=p;
	    		 }
	    		 
	    	 }	 
	    	 else if(p.getData().intValue()%2==1)
	    	 {
	    		 if(oh==null){
	    			 oh=p;
	    			 ot=p;
	    		 }
	    		 else{
	    			 ot.setNext(p);
	    			 ot=p;
	    		 }
	    			
	    			
	    		 
	    	 }
	    	 p=p.getNext();
	     }
 

	     while(p!=null)
	     {
	    	 if(p.getData().intValue()%2==0)
	    	 {
	    		 et.setNext(p);
	    		 et=p;

	    	 }
	    	 else
	    	 {
	    		 ot.setNext(p);
	    		 ot=p;

	    	 }
	    	 p=p.getNext();
	     }

	    	 if(et!=null && oh!=null)
	    	 {
	    		 ot.setNext(eh);
	    		 et.setNext(null);
	    	 }
	    	 
	    	 if(eh==null)
	    	 {
	    	 return oh;
	    	 }
	    	 else if(oh==null){
	    		 return eh;
	    	 }
	    	 else{
	    		 return oh;
	    	 }
	     
		}
	
	public static int printMiddel(Node<Integer> head) {
		
		if(head==null || head.getNext()==null){
			return head.getData();
		}
		
	    Node<Integer> slow=head,fast=head;
//	    while(fast.next!=null){
//	    	
//	        fast = fast.next.next;
//	        if(fast==null){
//	        	return slow.data;
//	        }
//	       
//	        slow=slow.next;
//	       
//	    }

	    while(fast.getNext()!=null && fast.getNext().getNext()!=null){

	    	fast = fast.getNext().getNext();
	    	

	    	slow=slow.getNext();

	    }
	    
	    return slow.getData();
	}
	
	public static Node<Integer> reverse_R(Node<Integer> head) {
		if(head.getNext()==null){
		    return head;
		}
		Node<Integer> p=null,nextHead;
		
		p=reverse_R(head.getNext());
		nextHead=p;
		head.setNext(null);
		while(p.getNext()!=null){
		    p=p.getNext();
		}
		p.setNext(head);
		return nextHead;
	}
	
	public static Node<Integer> reverse_I(Node<Integer> head) {
		 Node<Integer> temp=null,prev=null,p=head;
	     while(p != null){
       temp = p.getNext();
       p.setNext(prev);
       prev=p;
       p=temp;
       
           }
           return prev;
	}
	
//	public static Node<Integer> ReverseK(Node<Integer> head, int k , int num) {
//		if(head.getNext()!=null && k==1){
//			head.setNext(ReverseK(head.getNext(), num, num));
//			return head;
//		    }
//		else if(head.getNext()==null){
//			return head;
//		}
//		
//		Node<Integer> p=null,nextHead;
//
//		p=ReverseK(head.getNext(),--k,num);
//		
//		nextHead=p;
//		int i=1;
//		head.setNext(null);
//		
//		while(i<k-1 && p.getNext()!=null){
//			p=p.getNext();
//			i++;
//		}
//		head.setNext();
//		p.setNext(head);
//		
//		return nextHead;
//	
//		
//	}
	
	public static Node<Integer> kReverse(Node<Integer> head, int k) {
		
		Node<Integer> prev=null,p=head,next=null;
		
		int i=0;
		while(i<k && p!=null){
			next = p.getNext();
			p.setNext(prev);
			prev=p;
			p=next;
			
			i++;
		}
		
		if(next!=null){
			head.setNext(kReverse(next, k));
		}
		
		return prev;
	}
	
	public static int big(int[] arr) {
		if(arr.length==0){
			return 0;
		}
		
		int big = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++){
			if(big<arr[i]){
				big = arr[i];
			}
		}
		return big;
		
	}
	
	public static void changeLL(Node<Integer> head) {
		// Write your code here
		
		if(head==null){
			return;
		}
		
	
		ArrayList<Integer> arr = new ArrayList<>();

		Node<Integer> temp1=head;

		while(temp1!=null){
			arr.add(temp1.data);
			temp1 = temp1.next;
		}
		
		int[] ans = new int[arr.size()];
		
		for(int i=0;i<arr.size();i++){
			ans[i] = arr.get(i);
		}
		
		int n = big(ans);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		Node<Integer> temp=head;

		while(temp!=null){
			
			if(map.containsKey(temp.data)){
				
				temp.data = ++n;
				
				
			}else if(!map.containsKey(temp.data)){
				map.put(temp.data, 1);
			}else{
				int OldValue = map.get(temp.data);
				map.put(temp.data,OldValue+1);
			}
			
			temp = temp.next;
		}


		
	}
	
	
	
		public static void changeL(Node<Integer> head) {
			// Write your code here
			Node<Integer> head1 = null, tail = null, dup = null;
	        head1 = head;
	 

	        while (head1 != null && head1.next != null) {
	            tail = head1;
	 
	            
	            while (tail.next != null) {
	 
	         
	                if (head1.data == tail.next.data) {
	 
	                    
	                    dup = tail.next;
	                    tail.next = tail.next.next;
	                    System.gc();
	                } else {
	                    tail = tail.next;
	                }
	            }
	            head1 = head1.next;
	        }

		}
	
	
	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		changeLL(head);
//		Node<Integer> head2 = takeInput();
		PrintLinkedList(head);
	//	PrintIthElement(head, 4);
	//	System.out.println(sortEvenOdd(head));
		
		
//	PrintLinkedList(kReverse(head, 3));

	}

}
