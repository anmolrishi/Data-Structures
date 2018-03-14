package trees;

import java.util.ArrayList;
import java.util.Scanner;

import stacks_and_queues.QueueUsingLL;

public class NodesAtDistanceK {

	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		Scanner s = new Scanner(System.in);

		System.out.println("Enter Root");

		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode = pendingNodes.dequeue();

			System.out.println("Enter left child of " + currentNode.data);
			int leftData = s.nextInt();
			if(leftData!=-1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftData);
				pendingNodes.enqueue(leftChild);
				currentNode.left = leftChild;
			}

			System.out.println("Enter right child of " + currentNode.data);
			int rightData = s.nextInt();
			if(rightData!=-1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightData);
				pendingNodes.enqueue(rightChild);
				currentNode.right = rightChild;
			}
		}
		return root;
	}

	
	public static ArrayList<Integer> findPathRootToNode(BinaryTreeNode<Integer> root,int num) {
		if(root==null){
			return null;
		}
		ArrayList<Integer> ans = new ArrayList<>();
		if(root.data==num){
			ans.add(root.data);
			return ans;
		}
		
		
		
		ArrayList<Integer> left = findPathRootToNode(root.left, num);
		ArrayList<Integer> right = findPathRootToNode(root.right, num);

		if(left!=null && left.size()!=0)
		{
		left.add(root.data);
		return left;
		}

		if(right!=null && right.size()!=0)
		{right.add(root.data);
		return right;}
		
		return new ArrayList<>();


	}
	
	public static void printPathsRecur(BinaryTreeNode<Integer> root, int path[], int pathLen, int n, int k) 
    {
        if (root == null)
            return;
  
        /* append this node to the path array */
        path[pathLen] = root.data;
        pathLen++;
  
        /* it's a leaf, so print the path that led to here  */
        if (root.left == null && root.right == null){
              printArray(path, pathLen, n, k);
            
        }
           
        else
        {
            /* otherwise try both subtrees */
            printPathsRecur(root.left, path, pathLen, n, k);
            printPathsRecur(root.right, path, pathLen, n, k);
        }
    }
    
    public static void printArray(int ints[], int len, int n, int k) 
    {
        int i=0;
        while(i<len){
        	if(ints[i]==n){
                
                if((i+k)<len){
                    System.out.println(ints[i+k]);
                }
                if((i-k)>0){
                    System.out.println(ints[i-k]);
                }
                
            }
            i++;
        }
        
    }
	
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		// Write your code here
		int[] ans = new int[1000];
		printPathsRecur(root, ans, 0,node,k);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		nodesAtDistanceK(root, 3, 1);
		System.out.println();
		System.out.println();
		BinaryTreeNodeUse.print(root);

	}

}
