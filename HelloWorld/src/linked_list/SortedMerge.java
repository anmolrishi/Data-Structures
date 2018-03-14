package linked_list;

public class SortedMerge {

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
		
		Node<Integer> prev = null;
		while(temp1!=null && temp2!=null){
			if(temp1.getData() < temp2.getData()){
				prev.setNext(temp1);
				prev=temp1;
				temp1=temp1.getNext();
			}
			else{
				prev.setNext(temp2);
				prev=temp2;
				temp2=temp2.getNext();
			}
		}
		return FinalHead;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head1 = LinkedListUse.takeInput();
		Node<Integer> head2 = LinkedListUse.takeInput();
		
		LinkedListUse.PrintLinkedList(MergeSortedLinkedLists(head1, head2));
	}

}
