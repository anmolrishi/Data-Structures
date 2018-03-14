package trees;

import java.util.Scanner;

import stacks_and_queues.QueueUsingLL;

public class TreeUse {
	
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
	
	public static void printLevelWise(TreeNode<Integer> root) {
		if(root==null){
			return;
		}
		
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		
		String toBePrinted = root.data + ":";
		int i=0;
		while(!pendingNodes.isEmpty() && i<root.children.size()){
			toBePrinted+=pendingNodes.dequeue().data;
			pendingNodes.enqueue(root.children.get(i));
			
			i++;
		}
		System.out.println(toBePrinted);
		
	}

	public static void print(TreeNode<Integer> root) {
		if(root==null){
			return;
		}
		
		String toBePrinted = "";
		
		for(int i=0;i<root.children.size();i++){
			TreeNode<Integer> currentChild = root.children.get(i);
			toBePrinted+=currentChild.data+", ";


		}
		System.out.println(root.data + ":" + toBePrinted );
		
		for(int i=0;i<root.children.size();i++){
			TreeNode<Integer> currentChild = root.children.get(i);
			print(currentChild);
		}
		
		
	}
	
	public static int count(TreeNode<Integer> root) {
		if(root==null){
			return 0;
		}
		int count=0;
		for(int i=0;i<root.children.size();i++){
			count+=count(root.children.get(i));
		}
		
		return count + 1;
	}
	
	public static int Sum(TreeNode<Integer> root) {
		if(root==null){
			return 0;
		}
		int sum=0;
		for(int i=0;i<root.children.size();i++){
			sum+=Sum(root.children.get(i));
		}
		
		return sum+root.data;
	}
	
	public static int Maximum(TreeNode<Integer> root) {
		if(root==null){
			return 0;
		}
		
		int max=Integer.MIN_VALUE;
		
		
		for(int i=0;i<root.children.size();i++){
			if(max < root.children.get(i).data){
				max=root.children.get(i).data;
			}
		}
		
		for(int i=0;i<root.children.size();i++){
			int prevMax=Maximum(root.children.get(i));
			if(max <= prevMax){
				max=prevMax;
			}
		}
		
		if(max<root.data){
			max=root.data;
		}
		return max;

	}
	
//	public static int Largest(TreeNode<Integer> root) {
//		int max=root.data;
//		
//		
//	}
//	
	
	public static int Height(TreeNode<Integer> root) {
		if(root==null){
			return 0;
		}
		
		int maxLevel=0;
		
		
		for(int i=0;i<root.children.size();i++){
			int prevHeight = Height(root.children.get(i));
			if(maxLevel < prevHeight){
				maxLevel=prevHeight;
			}
		}
		
		
		
		return maxLevel+1;
	}
	
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
		
		if(root==null){
			return false;
		}
		if(root.data.equals(x)){
			return true;
		}
		boolean ans[] = new boolean[root.children.size()];
		for(int i=0;i<root.children.size();i++)
		{
			if(root.children.get(i).data.equals(x)){
				return true;
			}

			ans[i] = checkIfContainsX(root.children.get(i), x);

		}

		for(int i=0;i<root.children.size();i++){
			if(ans[i]){
				return true;
			}
		}

			return false;
	}
	
	
	
	public static void printNodesAtDepthK(TreeNode<Integer> root, int k) {
		if(root==null){		//THis is not the base case
			return;
		}
		
		for(TreeNode<Integer> child : root.children){
			printNodesAtDepthK(child, k-1);
		}
		
//		for(int i=0;i<root.children.size();i++){
//			printNodesAtDepthK(root.children.get(i), k-1);
//		}
		
	}
	
	public static int nextLarger(TreeNode<Integer> root, int k) {
		if(root==null)						//THis is not the base case
		{
			return Integer.MAX_VALUE;
		}
		int min=Integer.MAX_VALUE;
		
		if(root.data>k)						//BASE CASE
		{
			min = root.data;

		}
		
		for(int i=0;i<root.children.size();i++)
		{
			int temp=nextLarger(root.children.get(i), k);
			if(temp<min)
			{
				min=temp;
			}
			//nextLarge = nextLarger(root.children.get(i), k);
		}

		return min;
	}
	
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		
		TreeNode<Integer> min = new TreeNode<Integer>(nextLarger(root, n));
		
//		if(root==null)						//THis is not the base case
//		{
//			return null;
//		}
//		
//		TreeNode<Integer> min = new TreeNode<Integer>(0);
//		if(root.data.intValue()>n)						//BASE CASE
//		{
//			min.data = root.data;
//
//		}
//		
//		for(int i=0;i<root.children.size();i++){
//			TreeNode<Integer> temp = findNextLargerNode(root.children.get(i), n);
//			if(min!=null && temp!=null){
//				if(min.data>temp.data){
//					min.data=temp.data;
//				}
//			}
//			
//		}
//		
////		for(TreeNode<Integer> child : root.children){
////			TreeNode<Integer> temp = findNextLargerNode(child, n);
////			
////			if(min.data.intValue()>temp.data.intValue()){
////				min=temp;
////			}
////		}
		return min;
	}

	
	public static void preOrderRecursive(TreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		
		System.out.println(root.data);
		for(TreeNode<Integer>child: root.children)
		{
			preOrderRecursive(child);
		}
	}
	
	public static void postOrderRecursive(TreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		for(TreeNode<Integer>child: root.children)
		{
			postOrderRecursive(child);
		}
		System.out.println(root.data);
	}
	
	public static Pair<Integer> secondLargest(TreeNode<Integer>root) 

	{         // time complexity = number of nodes
		// space complexity = height 
		if(root==null)
		{
			Pair<Integer> ans = new Pair<>();
			ans.first = Integer.MIN_VALUE;
			ans.second = Integer.MIN_VALUE;
			return ans;
		}

		Pair<Integer> ans = new Pair<>();
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
	
	public static void replaceWithLevel(TreeNode<Integer> root, int k) {
		if(root==null){
			return;
		}
		
		root.data = k;
		
		for(TreeNode<Integer> child : root.children){
			replaceWithLevel(child, k+1);
		}
	}
	
	public static void replaceWithDepthValue(TreeNode<Integer> root){
		if(root==null){
			return;
		}
		
		replaceWithLevel(root, 0);
		
	}
	
	public static int countLeafNodes(TreeNode<Integer> root){
		if(root==null){
			return 0;
		}
		int c=0;
		if(root.children.size() == 0){
			return 1;
		}
		
		
		for(TreeNode<Integer> child : root.children){
			
				c+=countLeafNodes(child);
			}
		
		return c;

	}
	
	public static int numNodeGreater(TreeNode<Integer> root,int x){

		if(root==null){
			return 0;
		}
		int c=0;
		if(root.data.intValue()>x){
			++c;
		}
		
		for(TreeNode<Integer> child : root.children){
			
			c+=numNodeGreater(child, x);
		}
	
	return c;
	}
	
//	public static int maxSumNodeHelper(TreeNode<Integer> root, int sum) {
//		if(root==null){
//			return 0;
//		}
//		
//		TreeNode<Integer> ans = root;
//		for(TreeNode<Integer> child : root.children){
//			sum+=child.data;
//		}
//		
//		for(TreeNode<Integer> i : root.children){
//			TreeNode<Integer> temp = maxSumNodeHelper(i,i.data);
//			if(temp.data.intValue() > sum){
//				sum = temp.data.intValue();
//				ans = temp;
//			}
//		
//		
//	}
	
	public static returnMaxSumNode maxSumNode(TreeNode<Integer> root){
		if(root==null){
			return null;
		}
		
		returnMaxSumNode ans = new returnMaxSumNode();
		ans.tree = root;
		ans.sum=root.data;
		
		for(TreeNode<Integer> child : root.children){
			ans.sum+=child.data;

		}
		
		for(TreeNode<Integer> i : root.children){
			returnMaxSumNode temp = maxSumNode(i);
			if(temp.sum > ans.sum){
				ans.sum = temp.sum;
				ans.tree = temp.tree;
			}
		}
		return ans;
		
		
	}
	
	
	
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

		if(root1==null && root2==null){
			return true;
		}
		
		if(root1.data==root2.data){
			int i=0,j=0;
			while(i<root1.children.size() && j<root2.children.size()){
				boolean ans = checkIdentical(root1.children.get(i), root2.children.get(j));
				if(!ans){
					return false;
				}
				i++;j++;
			}
			return true;
				
			
		}
		else 
			return false;
	}
	
//public static int countLeafNodes(TreeNode<Integer> root){
//		
//		if(root==null){
//			return 0;
//		}
//		int c=0;
//				
//		for(int i=0;i<root.children.size();i++){
//			if(root.children.get(i).children==null){
//				c++;
//			}
//			
//				c+=countLeafNodes(root.children.get(i));
//			
//			
//		}
//		
//		return c;
//
//		// Write your code here
//
//	}
	
	
	//2 3 6 9 3 1 5 2 11 12 1 10 0 0 0 0
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode<Integer> root = takeInputLevelWise();
//		TreeNode<Integer> root2 = takeInputLevelWise();
	//	System.out.println(checkIdentical(root1, root2));
//		print(root);
//		returnMaxSumNode ans = maxSumNode(root);
		printLevelWise(root);
//		replaceWithDepthValue(root);
		print(root);
//		TreeNode<Integer> ans = findSecondLargest(root);
//		System.out.println(nextLarger(root, 10));
//		Pair<Integer> p = secondLargest(root);
//		System.out.println(p.first);
//		System.out.println(p.second);
//		System.out.println(ans.tree.data.intValue());
		
//		printNodesAtDepthK(root, 1);
//		System.out.println(checkIfContainsX(root, 1200));
//		print(root);
//		printLevelWise(root);
//		System.out.println("Total number of nodes : " + count(root));
//		System.out.println("Sum of all nodes : " + Sum(root));
//		System.out.println("Maximum value : " + Maximum(root));
//		System.out.println("Height of the tree : " + Height(root));
//		System.out.println("Number of leaf nodes : " + countLeafNodes(root));
//		System.out.println("Number of nodes greater than x : " + numNodeGreater(root, 1));

	}

}

class returnMaxSumNode{
	public int sum;
	public TreeNode<Integer> tree;
}
