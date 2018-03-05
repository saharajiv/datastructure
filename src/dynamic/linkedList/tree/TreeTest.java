package dynamic.linkedList.tree;

public class TreeTest {
	
	public static void main(String[] args){
		BinaryTreeTest();
	}
	
	
	/**
	 *                    9
	 *                5   		12
	 *             2 	7	10		20
	 *           1  4 6	 8		 18	   36
	 */
	public static void BinaryTreeTest(){
		BinaryTree bt = new BinaryTree();
		bt.printInOrderTraversal();
		bt.insert(9);
		bt.printInOrderTraversal();
		bt.insert(12);
		bt.printInOrderTraversal();
		bt.insert(5);
		bt.printInOrderTraversal();
		bt.insert(10);
		bt.printInOrderTraversal();
		bt.insert(20);
		bt.printInOrderTraversal();
		bt.insert(2);	
		bt.insert(7);
		bt.insert(1);
		bt.insert(4);
		bt.insert(6);
		bt.insert(8);
		bt.insert(18);
		bt.insert(36);
		System.out.println(" In order traversal");
		bt.printInOrderTraversal();
		System.out.println(" Pre order traversal");
		bt.printPreOrderTraversal();
		System.out.println(" Post order traversal");
		bt.printPostOrderTraversal();
		System.out.println("No. of leaf nodes "+bt.getCountOfLeafNodes());
		System.out.println("Height of the tree = "+bt.getHeight());
		System.out.println("No. of nodes is "+bt.getNodesCount());
		System.out.println("Sum of all the nodes = "+bt.sumOfNodes());
	}
	
	
	
	
	
}
