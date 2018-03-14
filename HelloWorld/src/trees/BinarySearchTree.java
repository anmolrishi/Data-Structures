package trees;

import java.util.ArrayList;

public class BinarySearchTree {

	
	public BinaryTreeNode<Integer> root;   // is not shared property, therefore not static
	// is private so that no one can change root to null
	int size;

	public void insert(int element){

	root = insert(root,element);
	size++;
	
	}
	private BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root,int element)  
	{
		if(root==null)
		{
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(element);
			return newNode;
		}
		
		if(element>root.data){
			root.right = insert(root.right,element);
		}
		
		else if(root.data==element){
			System.out.println("Already exists");
			
		}
		else{
			root.left  = insert(root.left,element);
		}
		return root;
	}
	
	private void print(BinaryTreeNode<Integer> root)
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
	
	public void print(){
		print(root);
	}
	
	public void delete(int element)
	{
		delete(root,element);
		size--;
	}
	private BinaryTreeNode<Integer> delete(BinaryTreeNode<Integer> root, int element) {
		if(root==null){
			return root;
		}
		
		if(root.data==element){
			if(root.left==null && root.right==null){
				return null;
			}
			else if(root.left==null){
				return root.right;
			}
			else if(root.right==null){
				return root.left;
			}
			
			else{
				root.data = inorderPre(root.left);
				root.left = delete(root.left, root.data);
				
			}
			
			
		}
		
		if(element>root.data){
			root.right = delete(root.right, element);
		}
		else if(element<root.data){
			root.left = delete(root.left, element);
		}
		
		return root;
		
	}
	private Integer inorderPre(BinaryTreeNode<Integer> root) {
		// TODO Auto-generated method stub
		
		while(root.right!=null){
			root = root.right;
		}
		return root.data;
	}
	
	public void BSTLCA(BinaryTreeNode<Integer> root, int one, int two) {
		if(root==null){
			return;
		}
		
		if(one<root.data && two>root.data){
			System.out.println("LCA is " + root.data);
		}
		else if(one<root.data && two<root.data){
			BSTLCA(root.left, one, two);
		}
		else if(one>root.data && two<root.data){
			BSTLCA(root.left, one, two);
		}
		
	}

	public void LowestCommonAncestor(int one,int two) { //For a generic Binary tree.
		ArrayList<Integer> path1 = findPathRootToNode(root, one);
		ArrayList<Integer> path2 = findPathRootToNode(root, two);
		
		for (int i=0;i<path1.size();i++){
			for (int j=0;j<path2.size();j++){
				if(path1.get(i)==path2.get(j)){
					System.out.println(path1.get(i));
					return;
				}
			}				//Start comparing from the end to reduce the time comlexity.
			
		}
	
		
	}
	
	private ArrayList<Integer> findPathRootToNode(BinaryTreeNode<Integer> root,int num) {
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
	
}
