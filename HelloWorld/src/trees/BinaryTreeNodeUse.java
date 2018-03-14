package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import linked_list.Node;
import stacks_and_queues.QueueUsingLL;

public class BinaryTreeNodeUse {


	public static void print(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}

		String toBePrinted = root.data+" : ";
		if(root.left!=null)
		{toBePrinted+=root.left.data+" , ";}

		if(root.right!=null)
		{toBePrinted+=root.right.data;}

		System.out.println(toBePrinted);
		print(root.left);
		print(root.right);
	}

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



	public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {

		if(root==null){
			return null;
		}

		ArrayList<Node<BinaryTreeNode<Integer>>> ans = new ArrayList<>();

		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			int countNodes = pendingNodes.size();
			Node<BinaryTreeNode<Integer>> head = new Node<>();
			while(countNodes>0){
				Node<BinaryTreeNode<Integer>> p= new Node<>();

				BinaryTreeNode<Integer> temp = pendingNodes.dequeue();
				if(head.getData()==null){
					head.setData(temp);
					p.setData(temp);
				}
				else{
					Node<BinaryTreeNode<Integer>> newNode = new Node<>();
					newNode.setData(temp);
					p.setNext(newNode);
					p=newNode;
				}

				if(temp.left!=null){
					pendingNodes.enqueue(temp.left);
				}

				if(temp.right!=null){
					pendingNodes.enqueue(temp.right);
				}
				countNodes--;
			}

			ans.add(head);
		}

		return ans;

	}

	public static void pairSum(ArrayList<Integer> arr1, int num){
		//write your code here
		int[] arr = new int[arr1.size()];
		for (int i=0;i<arr1.size();i++){
			arr[i] = arr1.get(i);
		}

		Arrays.sort(arr);
		for (int i=0;i<arr.length;i++){

			for (int j=i+1;j<arr.length;j++){
				if((arr[i]+arr[j])==num)
				{
					System.out.println(arr[i] + " " + arr[j]);
				}

			}
		}

	}



	public static ArrayList<Integer> array(BinaryTreeNode<Integer> root) {
		if(root == null){
			return null;
		}

		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		ArrayList<Integer> ans = new ArrayList<>();
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){


			int countNodes = pendingNodes.size();

			while(countNodes>0){
				BinaryTreeNode<Integer> print = pendingNodes.dequeue();
				ans.add(print.data);

				if(print.left!=null){
					pendingNodes.enqueue(print.left);

				}
				if(print.right!=null){
					pendingNodes.enqueue(print.right);

				}


				countNodes--;
			}

		}
		return ans;

	}

	public static int sumNodeArrayList(ArrayList<Integer> input,int data) {
		//		if(input.size()==0){
		//			return 0;
		//		}

		int sum=0;

		for (int i=0;i<input.size();i++){
			if(input.get(i)>data){
				sum+=input.get(i);
			}
		}
		return sum;
	}
	public static void once(BinaryTreeNode<Integer> root) {
		ArrayList<Integer> a = array(root);
		replaceWithLargerNodesSum(a,root);
	}

	public static void replaceWithLargerNodesSum(ArrayList<Integer> input,BinaryTreeNode<Integer> root) {
		if(root==null){
			return;
		}

		root.data += sumNodeArrayList(input,root.data);

		replaceWithLargerNodesSum(input,root.left);
		replaceWithLargerNodesSum(input,root.right);

	}

	//	public static BinaryTreeNode<Integer> Duplicate(BinaryTreeNode<Integer> root) {
	//		if(root==null){
	//			return null;
	//		}
	//		
	//		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
	//		BinaryTreeNode<Integer> rootAns = new BinaryTreeNode<Integer>(null),tail = new BinaryTreeNode<Integer>(null);
	//		pendingNodes.enqueue(root);
	//
	//
	//
	//		while(!pendingNodes.isEmpty()){
	//
	//
	//			int countNodes = pendingNodes.size();
	//
	//			while(countNodes>0){
	//				BinaryTreeNode<Integer> print = pendingNodes.dequeue();
	//				if(rootAns.data==null){
	//					rootAns.data = print.data;
	//					tail = rootAns;
	//				}
	//				else{
	//					tail.left = pendingNodes.dequeue();
	//					tail.right = pendingNodes.dequeue();
	//				}
	//				
	//				if(print.left!=null){
	//					pendingNodes.enqueue(print.left);
	//				}
	//				if(print.right!=null){
	//					pendingNodes.enqueue(print.right);
	//				}
	//				countNodes--;
	//			}
	//			tail.left = tail.left.left;
	//			tail.right = tail.right.right;
	//			
	//
	//		}
	//		
	//	}


	public static void printLevelWiseUsingQueues(BinaryTreeNode<Integer> root) {
		if(root == null){
			return;
		}

		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();

		pendingNodes.enqueue(root);



		while(!pendingNodes.isEmpty()){


			int countNodes = pendingNodes.size();

			while(countNodes>0){
				BinaryTreeNode<Integer> print = pendingNodes.dequeue();
				System.out.print(print.data.intValue() + " ");

				if(print.left!=null){
					pendingNodes.enqueue(print.left);

				}
				if(print.right!=null){
					pendingNodes.enqueue(print.right);

				}
				countNodes--;

			}
			System.out.println();
		}

	}



	public static int Height(BinaryTreeNode<Integer> root) {
		if(root==null){
			return 0;
		}

		int maxHeight=0;

		int hLeft = Height(root.left);
		int hRight = Height(root.right);

		if(hLeft>hRight){
			maxHeight=hLeft;
		}else{
			maxHeight=hRight;
		}
		return maxHeight+1;
	}

	public static int height(BinaryTreeNode<Integer> root) {
		return (root==null) ? 0: 1+Math.max(height(root.left), height(root.right));
	}

	public static int Diameter(BinaryTreeNode<Integer> root) {
		if(root==null){
			return 0;
		}

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		int leftDiameter = Diameter(root.left);
		int rightDiameter = Diameter(root.right);

		return Math.max(1+leftHeight+rightHeight, Math.max(leftDiameter, rightDiameter));
	}

	public static BinaryTreeNode<Integer> SearchNode(BinaryTreeNode<Integer> root,int num) {
		if(root==null){
			return null;
		}
		BinaryTreeNode<Integer> ans2=null,ans1=null;

		if(root.data == num){
			return root;
		}
		ans1 = SearchNode(root.left, num);



		ans2 = SearchNode(root.right, num);


		if(ans1!=null && ans1.data==num)
		{
			return ans1;
		}else if(ans2!=null && ans2.data==num)
		{

			return ans2;
		}
		else{
			return null;
		}
	}



	public static BinaryTreeNode<Integer> Mirror(BinaryTreeNode<Integer> root) {
		if(root==null){
			return null;
		}

		BinaryTreeNode<Integer> ans2=null,ans1=null,temp=null;

		ans1=Mirror(root.left);
		ans2=Mirror(root.right);
		temp=ans1;
		root.left=ans2;			//And Not ans1=ans2
		root.right=temp;


		return root;
	}


	//	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
	//		
	//		if(root==null){
	//			return;
	//		}
	//		
	//		if(root.left!=null && root.right==null){
	//			System.out.println(root.left.data);
	//			printNodesWithoutSibling(root.left);
	//		}
	//		else if(root.left==null && root.right!=null){
	//			System.out.println(root.right.data);
	//			printNodesWithoutSibling(root.right);
	//		}
	//		else{
	//			printNodesWithoutSibling(root.left);
	//			printNodesWithoutSibling(root.right);
	//		}
	//
	//	}

	public static int sum(BinaryTreeNode<Integer> root){

		if(root==null){
			return 0;
		}

		int sum=0;

		sum+=sum(root.left) + sum(root.right);



		return sum+root.data.intValue();
	}


	public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root){

		if(root==null){
			return null;
		}

		if(root.left==null && root.right==null){
			root=null;
			return null;
		}
		else if(root.left==null && root.right!=null){
			root.right = removeAllLeaves(root.right);
		}
		else if(root.left!=null && root.right==null){
			root.left = removeAllLeaves(root.left);
		}
		else{
			root.left = removeAllLeaves(root.left);
			root.right = removeAllLeaves(root.right);

		}
		return root;

	}





	public static boolean SearchBST(BinaryTreeNode<Integer> root, int x) {
		if (root==null){
			return false;
		}

		if(x<root.data){
			return SearchBST(root.left, x);
		}
		else if(x>root.data){
			return SearchBST(root.right, x);
		}
		else
			return true;
	}


	public static void PrintBSTinRange(BinaryTreeNode<Integer> root, int k1, int k2) {
		if(root==null){
			return;
		}


		if(k1<root.data && k2>root.data){
			System.out.println(root.data);
			PrintBSTinRange(root.left, k1, k2);
			PrintBSTinRange(root.right, k1, k2);
		}
		else if( k2<root.data){
			PrintBSTinRange(root.left, k1, k2);
		}
		else if(k1>root.data ){
			PrintBSTinRange(root.right, k1, k2);
		}
		else{
			System.out.println("Range is 0");
		}

	}

	public static int Maximum(BinaryTreeNode<Integer> root) {
		if(root==null){
			return 0;
		}

		int max=root.data;

		if(root.left!=null &&max<root.left.data){
			max=root.left.data;
		}
		if(root.right!=null && max<root.right.data){
			max=root.right.data;
		}

		int leftMax = Maximum(root.left);
		if(max <= leftMax){
			max=leftMax;
		}

		int rightMax = Maximum(root.right);
		if(max <= rightMax){
			max=rightMax;
		}




		return max;

	}

	public static int Minimum(BinaryTreeNode<Integer> root) {
		if(root==null){
			return 0;
		}

		int min=root.data;


		if(root.left!=null){
			int leftMin = Minimum(root.left);
			if(min > leftMin){
				min=leftMin;
			}
		}
		if(root.right!=null){
			int rightMin = Minimum(root.right);
			if(min > rightMin){
				min=rightMin;
			}
		}



		return min;

	}

	class CheckBSTReturnType{
		boolean isBST;
		int min;
		int max;
	}

	public static int Largest(BinaryTreeNode<Integer> root) {
		if(root==null){
			return Integer.MIN_VALUE;
		}

		return Math.max(root.data,Math.max(Largest(root.left),Largest(root.right)));
	}

	public static int Smallest(BinaryTreeNode<Integer> root) {
		if(root==null){
			return Integer.MAX_VALUE;
		}

		return Math.min(root.data,Math.min(Smallest(root.left),Smallest(root.right)));
	}




	//	public static CheckBSTReturnType OptimizedCheckBST(BinaryTreeNode<Integer> root) {
	//		if(root==null){
	//			CheckBSTReturnType ans = new CheckBSTReturnType();
	//			ans.isBST = true;
	//			ans.min = Integer.MAX_VALUE;
	//			ans.max = Integer.MIN_VALUE;
	//			return ans;
	//			
	//		}
	//		
	//		CheckBSTReturnType leftAns = OptimizedCheckBST(root.left);
	//		CheckBSTReturnType rightAns = OptimizedCheckBST(root.right);
	//		if(leftAns>r)
	//		
	//		
	//	}

	//	public static BinaryTreeNode<Integer> SearchNode(BinaryTreeNode<Integer> root,int num) {
	//		if(root==null){
	//			return null;
	//		}
	//		BinaryTreeNode<Integer> ans2=null,ans1=null;
	//		
	//			if(root.data == num){
	//				return root;
	//			}
	//			ans1 = SearchNode(root.left, num);
	//		
	//		
	//		
	//			ans2 = SearchNode(root.right, num);
	//		
	//		
	//		if(ans1!=null && ans1.data==num)
	//		{
	//			return ans1;
	//		}else if(ans2!=null && ans2.data==num)
	//		{
	//		
	//			return ans2;
	//		}
	//		else{
	//			return null;
	//		}
	//	}




	public static BinaryTreeNode<Integer> buildTreeFromInPre(int[] in, int[] pre,int inS, int inE, int preS, int preE){

		if(preS>preE){
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(pre[preS]);
		int i=inS;

		while(i<inE && in[i]!=pre[preS]){
			i++;
		}

		int leftInS = inS;
		int leftInE = i-1;

		int leftPreS = preS+1;

		int leftLength = leftInE-leftInS+1;
		int leftPreE = leftPreS + leftLength -1;

		int rightPreS = leftPreE+1;
		int rightPreE = preE;
		int rightInS = i+1;
		int rightInE = inE;


		root.left = buildTreeFromInPre(in, pre,leftInS , leftInE, leftPreS, leftPreE);
		root.right = buildTreeFromInPre(in, pre, rightInS,rightInE , rightPreS, rightPreE);

		return root;

	}

	public static BinaryTreeNode<Integer> buildTreeFromInPost(int[] in, int[] post,int inS, int inE, int postS, int postE){
		if(postS>postE){
			return null;
		}

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(post[postE]);
		int i=inS;

		while(i<inE && in[i]!=post[postE]){
			i++;
		}

		int leftInS = inS;
		int leftInE = i-1;

		int rightInS = i+1;
		int rightInE = inE;

		int leftLength = leftInE-leftInS+1;

		int leftPostS = postS;
		int leftPostE = leftPostS + leftLength - 1;

		int rightPostE = postE-1;
		int rightPostS = leftPostE+1;

		root.left = buildTreeFromInPost(in, post,leftInS , leftInE, leftPostS, leftPostE);
		root.right = buildTreeFromInPost(in, post, rightInS,rightInE , rightPostS, rightPostE);

		return root;
	}











	//		if(root.left!=null && root.right!=null)
	//				{
	//		if(root.left.data.intValue()<root.data.intValue() && root.right.data.intValue()>root.data.intValue())
	//		{
	//			boolean left = checkIfBST(root.left);
	//			boolean right = checkIfBST(root.right);
	//			if (right && left)
	//			{
	//				return true;
	//			}
	//			else 
	//				return false;
	//		}
	//				}
	//		return false;
	//	}

	public static BinaryTreeNode<Integer> returnLevelsLeftToRight(BinaryTreeNode<Integer> root, int h){
		if(root==null) 
			return null;
		BinaryTreeNode<Integer> ans = new BinaryTreeNode<Integer>(0);
		if(h==1) {
			ans = root;
			ans.data = root.data;
			return ans;
		}


		else
		{

			ans.left = returnLevelsLeftToRight(root.left,h-1);
			ans.right = returnLevelsLeftToRight(root.right,h-1);

		} 	
		return ans;
	}

	public static void printLevelWise(BinaryTreeNode<Integer> root)
	{
		int h = height(root);

		for(int i=1;i<=h;i++)
		{
			if(i%2==1){
				printLevelsLeftToRight(root,i);
			}
			else if(i%2==0){
				printLevelsRightToLeft(root,i);
			}

			System.out.println();
		}
	}

	public static void printLevelsLeftToRight(BinaryTreeNode<Integer> root, int h){
		if(root==null) 
			return;

		if(h==1) 
			System.out.print(root.data+" ");

		else
		{

			printLevelsLeftToRight(root.left,h-1);
			printLevelsLeftToRight(root.right,h-1);

		} 	
	}

	public static void printLevelsRightToLeft(BinaryTreeNode<Integer> root, int h)
	{
		if(root==null) 
			return;

		if(h==1) 
			System.out.print(root.data+" ");

		else
		{
			printLevelsRightToLeft(root.right,h-1);
			printLevelsRightToLeft(root.left,h-1);


		} 	
	}

	public static void printZigZag(BinaryTreeNode<Integer> root) {


		printLevelWise(root);	


	}

	public static boolean checkBalanced(BinaryTreeNode<Integer> root){

		if(root==null){
			return true;
		}

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		boolean ans = true;
		int order = rightHeight - leftHeight;
		if(order <=1 && order >=-1){
			ans = checkBalanced(root.left);
			if(!ans){
				return false;
			}
			ans = checkBalanced(root.right);
			if(!ans){
				return false;
			}
			return true;
		}
		else{
			return false;
		}

	}

	public static int printLowestCommonAncestor(BinaryTreeNode<Integer> root, int one, int two) {
		if(root==null){
			return -1;
		}
		int a=-1;
		if(one<root.data && two>root.data){
			return root.data;
		}
		else if(one<root.data && two<root.data){
			a= printLowestCommonAncestor(root.left, one, two);
		}
		else if(one>root.data && two<root.data){
			a= printLowestCommonAncestor(root.left, one, two);
		}
		return a;
	}

	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root==null){
			return;
		}

		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
		newNode.right = root.right;
		newNode.left = root.left;


		//	if(root.left!=null){
		//	BinaryTreeNode<Integer> temp = root.left;
		root.left = newNode;
		//	newNode.left = temp;
		insertDuplicateNode(newNode.left);
		//	}



	}

	//	public static int[] Leaves(BinaryTreeNode<Integer> root,int index) {
	//		if(root==null){
	//			return null;
	//		}
	//		int[] ans = new int[]
	//		if(root.left==null && root.right==null){
	//			return true;
	//		}
	//		else
	//			return false;
	//	}
	//	


	public static ArrayList<Integer> findPathRootToNode(BinaryTreeNode<Integer> root) {
		if(root==null){
			return null;
		}
		ArrayList<Integer> ans = new ArrayList<>();
		//	boolean flag = isLeaf(root);
		//		if(flag){
		//			ans.add(root.data);
		//			return ans;
		//		}



		ArrayList<Integer> left = findPathRootToNode(root.left);
		ArrayList<Integer> right = findPathRootToNode(root.right);

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
	public static boolean checkIfBST(BinaryTreeNode<Integer> root) {
		if(root==null){
			return true;
		}

		//T.C. = n*height


		int largestLeft = Largest(root.left);
		int smallestRight = Smallest(root.right);

		if(largestLeft > root.data || smallestRight < root.data)
		{
			return false;
		}

		return checkIfBST(root.left) && checkIfBST(root.right);

	}	
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		if(root==null){
			return 0;
		}

		int mHeight = Integer.MIN_VALUE;

		if(checkIfBST(root))
		{
			int temp = height(root);
			if(temp>mHeight)
			{
				mHeight = temp;
			}
			return mHeight;
		}
		else
		{int temp1 = largestBSTSubtree(root.left);
		int temp2 = largestBSTSubtree(root.right);

		if(temp1>temp2){
			return temp1;
		}
		else{
			return temp2;
		}

		}

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
	
	
	
	public static int lastLeaf(int h) {
		if(h==0){
			return 0;
		}
		
		
		
	}


	public static ArrayList<Integer> arrayOfLeaves(BinaryTreeNode<Integer> root) {
		if(root == null){
			return null;
		}

		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		ArrayList<Integer> ans = new ArrayList<>();
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){


			int countNodes = pendingNodes.size();

			while(countNodes>0){
				BinaryTreeNode<Integer> print = pendingNodes.dequeue();
				if(print.left==null && print.right==null)
					ans.add(print.data);

				if(print.left!=null){
					pendingNodes.enqueue(print.left);

				}
				if(print.right!=null){
					pendingNodes.enqueue(print.right);

				}


				countNodes--;
			}

		}
		return ans;

	}


	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		if(root==null){
			return;
		}

		ArrayList<Integer> a = arrayOfLeaves(root);
		for(int i=0;i<a.size();i++){
			ArrayList<Integer> ans = findPathRootToNode(root,a.get(i));
			int sum=0;
			for(int j=0;j<ans.size();j++){
				sum+=ans.get(j);
			}

			if(sum==k){
				for(int l=ans.size()-1;l>=0;l--){
					System.out.print(ans.get(l) + " ");
				}
				System.out.println();
			}
		}


	}

	public static int SumNodeGreater(BinaryTreeNode<Integer> root,int x){

		if(root==null){
			return 0;
		}
		int c=0;
		if(root.data.intValue()>x){
			c+=root.data.intValue();
		}


		c+=SumNodeGreater(root.left, x);
		c+=SumNodeGreater(root.right, x);


		return c;
	}

	//	
	//	public static void printPathsRecur(BinaryTreeNode<Integer> root, int path[], int pathLen, int n, int k) 
	//    {
	//        if (root == null)
	//            return;
	//  
	//        /* append this node to the path array */
	//        path[pathLen] = root.data;
	//        pathLen++;
	//  
	//        /* it's a leaf, so print the path that led to here  */
	//        if (root.left == null && root.right == null){
	//              int a = printArray(path, pathLen, n, k);
	//             if(a==1){
	//                 return;
	//             }
	//        }
	//           
	//        else
	//        {
	//            /* otherwise try both subtrees */
	//            printPathsRecur(root.left, path, pathLen, n, k);
	//            printPathsRecur(root.right, path, pathLen, n, k);
	//        }
	//    }
	//    

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
	static ArrayList<Integer> dist = new ArrayList<>();
	static int index =0;

	public static void printArray(int ints[], int len, int n, int k) 
	{
		int i=0;
		while(i<len){
			if(ints[i]==n){

				if((i+k)<len){
					dist.add(ints[i+k]);
					// System.out.println(ints[i+k]);
				}
				if((i-k)>=0){
					dist.add(ints[i-k]);
					//System.out.println(ints[i-k]);
				}

			}
			i++;
		}

	}

	public static void RemoveDuplicates() {

		HashMap<Integer, Integer> map = new HashMap<>();

		for(int a:dist){
			if(!map.containsKey(a)){
				map.put(a, 1);
			}
			else{
				int OldValue = map.get(a);
				map.put(a,OldValue+1);
			}
		}

		for(int a:dist){
			if(map.get(a)==0){
				map.remove(a);
			}
		}

		for(int a:dist){
			if( map.containsKey(a)){
				System.out.println(a);
				map.remove(a);
			}

		}


	}

	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		
		nodesAtDistanceK2(root, node, k);

	}

	public static boolean search(BinaryTreeNode<Integer> root,int num) {
		if(root==null){
			return false;
		}

		boolean ans1=false;
		boolean ans2=false;

		if(root.data.intValue()==num){
			return true;
		}

		if(root.left!=null && root.left.data.intValue() == num){
			return true;
		}
		else{
			ans1 = search(root.left, num);
		}

		if(root.right!=null && root.right.data.intValue() == num){
			return true;
		}
		else{
			ans2 = search(root.right, num);
		}

		return ans1||ans2;
	}

	public static void childKDist(BinaryTreeNode<Integer> root, int dist) {
		if(root==null){
			return;
		}
		if(dist==0){
			System.out.println(root.data.intValue());
			return;
		}	
		childKDist(root.left, dist-1);
		childKDist(root.right, dist-1);
	}

	

	public static int nodesAtDistanceK2(BinaryTreeNode<Integer> root, int node, int k) {
		// Write your code here
		if(root==null){
			return 0;
		}



		if(root.data.intValue()==node){
			childKDist(root, k);
			return k-1;
		}
		if(search(root.left, node)){
			int left = nodesAtDistanceK2(root.left, node, k);
			if(left==0){
				System.out.println(root.data.intValue());
			}
			else if(left<k){
				childKDist(root.right, left-1);
				return left-1;
			}
		}
		else if(search(root.right, node)){
			int right = nodesAtDistanceK2(root.right, node, k);
			if(right==0){
				System.out.println(root.data.intValue());
			}
			else if(right<k){
				childKDist(root.left, right-1);
				return right-1;
			}
		}
		return k-1;
	}
	
	public static long BalancedBinaryTreesOfHeightH(int height) {
		if(height <= 1){
			return 1;
		}
		
		long x1 = BalancedBinaryTreesOfHeightH(height-1) * BalancedBinaryTreesOfHeightH(height-1);
		
		long x2 = BalancedBinaryTreesOfHeightH(height-1) * BalancedBinaryTreesOfHeightH(height-2);
		
		long x3 = BalancedBinaryTreesOfHeightH(height-2) * BalancedBinaryTreesOfHeightH(height-1);
		
		return x1+x2+x3;
		
	}
	
	public static long BalancedBinaryTreesOfHeight(int h) {
		if(h==0 || h==1){
			return 1;
		}
		
		long c1 = BalancedBinaryTreesOfHeight(h-1);
		long c2 = BalancedBinaryTreesOfHeight(h-2);
		
		long ans = c1*c1 + 2*c1*c2;
		
		return ans;
	}
	
	//	public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
	//		// Write your code here
	//		if(root==null){
	//			return false;
	//		}
	//
	//		boolean ans = false;
	//		
	//		ans= 
	//		
	//	}
	//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1 
	//1 2 3 4 5 -1 -1 -1 -1 6 7 10 -1 20 -1 -1 -1 -1 -1 
	//5 6 10 2 3 -1 -1 -1 -1 10 9 -1 -1 -1 -1
	//BST	//8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1 

	//BT	//6 9 5 8 -1 -1 10 -1 -1 -1 -1 

	
	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
		// Write your code here
		ArrayList<Integer> leaves = array(root);
		ArrayList<Integer> ans = findPathRootToNode(root,leaves.get(leaves.size()-1));
		return ans;
	}
	
	public static void main (String[] args){
		// TODO Auto-generated method stub
		//		int[] in = {2,9,4,5,6,7,3};
		//		int[] post = {2,5,4,9,7,3,6};
		//		BinaryTreeNode<Integer> root = buildTreeFromInPost(in, post, 0, in.length-1, 0, post.length-1);

		//		int[] pre = {6,9,2,4,5,3,7};
		//		BinaryTreeNode<Integer> root = buildTreeFromInPre(in, pre, 0, in.length-1, 0, pre.length-1);
		//		System.out.println(sum(root));
//System.out.println(BalancedBinaryTreesOfHeight(5));
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		
		//  	childKDist(root, 1);
		//		System.out.println(search(root, 11));
//		nodesAtDistanceK(root, 3, 1);
		//		printLevelWise(root);

		//		insertDuplicateNode(root);
		//once(root);
		//		rootToLeafPathsSumToK(root, 13);
		//		System.out.println(SumNodeGreater(root,5));
		//		ArrayList<Node<BinaryTreeNode<Integer>>> a = LLForEachLevel(root);
		//		for (int i=0;i<a.size();i++){
		//			
		//			System.out.println(a.get(i));
		//		}
		//		System.out.println(printLowestCommonAncestor(root,1,7));
		//		print(root);

		//		insertDuplicateNode(root);
		//		System.out.println();
				ArrayList<Integer> leaves = longestRootToLeafPath(root);
				for (int i=0;i<leaves.size();i++){
					System.out.println(leaves.get(i));
				}
//				System.out.println(leaves.get(leaves.size()-1));
		//		ArrayList<Integer> a = findPathRootToNode(root, 13);
		//		for (int i=0;i<a.size();i++){
		//			System.out.println(a.get(i));
		//		}
		//		System.out.println(checkBalanced(root));
		//		System.out.println(Minimum(root));
		//		System.out.println(Maximum(root));
		//		System.out.println(checkIfBST(root));
		//		PrintBSTinRange(root, 4, 4);
		System.out.println();
		System.out.println();
		//	print(root);
		//		System.out.println();
		//				printLevelWise(root);
		//	System.out.println(SearchBST(root, 15));
		//		BinaryTreeNode<Integer>ans = removeAllLeaves(root);
		//		print(ans);
		//		System.out.println("Diameter of the Binary tree : " + Diameter(root));
		//		printNodesWithoutSibling(root);
		//		BinaryTreeNode<Integer>ans = Mirror(root);
//		print(root);
		//		System.out.println("Height of the tree : " + Height(root));
		//		BinaryTreeNode<Integer> ans = SearchNode(root, 99);
		//		System.out.println(ans.data);
		//				try{
		//					System.out.println(ans.data);	
		//				}
		//				catch(Exception e){
		//					System.out.println("Not Found");
		//				}
		//				finally{
		//			int k=0;
		//			k++;
		//		}
	}

}
