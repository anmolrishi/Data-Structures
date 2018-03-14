package trees;

import trees.BinaryTreeNode;

public class BinarySearchTreeUse {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(16);
		tree.print();
		System.out.println();
		tree.insert(10);
		tree.print();
		System.out.println();
		tree.insert(5);
		tree.print();
		System.out.println();
		tree.insert(12);
		tree.print();
		System.out.println();
		tree.insert(11);
		tree.print();
		System.out.println();
		tree.insert(14);
		tree.print();
		System.out.println();
		tree.insert(20);
		tree.print();
		System.out.println();
		tree.insert(18);
		tree.print();
		System.out.println();
		tree.insert(25);
		tree.print();
		System.out.println();
//		tree.delete(12);
//		tree.print();
		
		tree.LowestCommonAncestor(5,14);
	//	tree.BSTLCA(, 5, 14);
	}

}
