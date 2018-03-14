package trees;

import java.util.Scanner;

import stacks_and_queues.QueueUsingLL;

public class Solution {
	
	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter root");
		int rootData = s.nextInt();
		
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode = pendingNodes.dequeue();
			
			System.out.println("Enter number of children of " + currentNode.data);
			int numChild = s.nextInt();
			
			for(int i=0;i<numChild;i++){
				System.out.println("Enter "+i+"th child of "+currentNode.data);
				int childData = s.nextInt();
				TreeNode<Integer> child = new TreeNode<Integer>(childData);
				pendingNodes.enqueue(child);
				currentNode.children.add(child);
				
			}
		}
		
		return root;
	}
	
	public class Pair<T> {

		// T is generic 
		public T first;
		public T second;


		public T getFirst()
		{
			return first;
		}

		public T getSecond()
		{
			return second;
		}


	}

	
	public static Pair<Integer> secondLargest(TreeNode<Integer>root) 

	{   Solution s= new Solution();    
		// time complexity = number of nodes
		// space complexity = height 
		if(root==null)
		{
			Pair<Integer> ans = s.new Pair<>();
			ans.first = Integer.MIN_VALUE;
			ans.second = Integer.MIN_VALUE;
			return ans;
		}

		Pair<Integer> ans = s.new Pair<>();
		ans.first = root.data;
		ans.second = null;

		for(TreeNode<Integer>child: root.children)
		{
			Pair<Integer>childAns = secondLargest(child);
			if(childAns.first>ans.first)
			{
				if(childAns.second==null||childAns.second<ans.first){
					ans.second = ans.first;
					ans.first = childAns.first;
				}
				else{
					ans.first = childAns.first;
					ans.second = childAns.second;
				}
			}	
			else
			{
				if(ans.second==null||ans.second<childAns.first)
				{
					ans.second = childAns.first;
				}
			}
		}
		return ans;
	}
	
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){


		TreeNode<Integer> sbig = new TreeNode<Integer>(0);
		Pair<Integer> a = secondLargest(root);
		
		sbig.data = a.second;
		return sbig;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = takeInputLevelWise();
		TreeNode<Integer> ans = findSecondLargest(root);
//		System.out.println(nextLarger(root, 10));
		Pair<Integer> p = secondLargest(root);
		System.out.println(p.first);
		System.out.println(p.second);
		System.out.println(ans.data.intValue());

	}

}
