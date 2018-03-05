package dynamic.linkedList.tree;

/*
 * A binary tree does not follow any order. Every node has two child nodes.
 * This is the implementation of Binary Search Trees
 */
public class BinaryTree {

	private Node rootNode;
	
	
	public void insert(Object data){
		insertNode(new Node(data));
	}
	
	
	private void insertNode(Node node){
		if(rootNode==null){
			rootNode = node;
		}else{
			insertNode(rootNode,node);
		}
	}
	
	
	private void insertNode(Node currentNode,Node newNode){
		if(newNode.isLessThan(currentNode)){
			if(currentNode.leftChild==null)
				currentNode.leftChild = newNode;
			else
				insertNode(currentNode.leftChild,newNode);
		}else{
			if(currentNode.rightChild==null)
				currentNode.rightChild = newNode ;
			else
				insertNode(currentNode.rightChild, newNode);
		}
	}
	
	//details on the delete process can be found in the site 
	//https://helloacm.com/how-to-delete-a-node-from-a-binary-search-tree/
	//http://www.algolist.net/Data_structures/Binary_search_tree/Removal
	public void delete(Object element){
		Node parentSearchNode = null;
		Node searchNode = new Node(element);
		if(rootNode!=null){
			parentSearchNode = searchNode(rootNode,rootNode, searchNode);
		}
		if(parentSearchNode==null){
			System.out.println("the element "+element.toString()+" not found in the BST");
		}else{
			if(parentSearchNode.leftChild.equals(searchNode)){
				searchNode = parentSearchNode.leftChild;
				if(searchNode.leftChild==null && searchNode.rightChild==null)
					parentSearchNode.leftChild= null;
				else{
					if(searchNode.leftChild==null)
						parentSearchNode.leftChild= searchNode.rightChild;
					else if(searchNode.rightChild==null)
						parentSearchNode.leftChild= searchNode.leftChild;
					else{
						//none of the nodes are null.
						//1.the node to be deleted is the the left child of the parent node. Hence the logic is to 
						//find the maximum value of the left subtree of the tobe deleted node.
						//2.replace the to be deleted node with the maximum value found in step 1. 
						//3. Delete the duplicate original value by iterating the same process from step 1.
						Node maxNode = new Node();
						maxNode = findMaxNode(searchNode,maxNode);
					}
				}
			}
		}
	}
	
	
	/**
	 * Tree Traversal
	 * Depth First Traversals:
		(a) Inorder (leftChild, Root, rightChild) 
		(b) Preorder (Root, leftChild, rightChild) 
		(c) Postorder (leftChild, rightChild, Root) 

		Breadth First or Level Order Traversal : Start from the root node. Travel all the nodes at the same level from leftChild to rightChild.
		descend down to the next level.
	*/
	
	
	


	/**
	 * 	Inorder Traversal:
	
		Algorithm Inorder(tree)
	   		1. Traverse the leftChild subtree, i.e., call Inorder(leftChild-subtree)
	   		2. Visit the root.
	   		3. Traverse the rightChild subtree, i.e., call Inorder(rightChild-subtree)
	 
	**/
	
	public void printInOrderTraversal(){
		if(rootNode!=null){
			traverseInOrder(rootNode);
			System.out.println();
		}else
			System.out.println("There is no node to display in the  Binary tree");
	}
	
	public void printPreOrderTraversal(){
		if(rootNode!=null){
			traversePreOrder(rootNode);
			System.out.println();
		}else
			System.out.println("There is no node to display in the  Binary tree");
	}
	
	public void printPostOrderTraversal(){
		if(rootNode!=null){
			traversePostOrder(rootNode);
			System.out.println();
		}else
			System.out.println("There is no node to display in the  Binary tree");
	}
	
	
	
	private void traverseInOrder(Node root){
		if(root==null)
			return;
		//traverse to the left child
		traverseInOrder(root.leftChild);
		//visiting the root and printing the data.
		System.out.print("\t"+root.data);
		//traverse to the right child
		traverseInOrder(root.rightChild);
		
	}
	
	private void traversePreOrder(Node root){
		if(root==null)
			return;
		//visiting the root and printing the data.
		System.out.print("\t"+root.data);
		//traverse to the left child
		traversePreOrder(root.leftChild);
		//traverse to the right child
		traversePreOrder(root.rightChild);
		
	}
	
	private void traversePostOrder(Node root){
		if(root==null)
			return;
		//traverse to the left child
		traversePostOrder(root.leftChild);
		//traverse to the right child
		traversePostOrder(root.rightChild);
		//visiting the root and printing the data.
		System.out.print("\t"+root.data);
	}
	
	
	private Node searchNode(Node parentNode,Node currentNode, Node node) {
		if(currentNode.equals(node)){
			return parentNode;
		}else{
			if(node.isLessThan(currentNode)){
				if(node.leftChild !=null)
					searchNode(currentNode,currentNode.leftChild,node);
			}else{
				if(node.rightChild!=null)
					searchNode(currentNode,currentNode.rightChild, node);
			}
		}
		return null;
		
	}
	
		//find the maximum value of the left subtree of the given node.
		private Node findMaxNode(Node searchNode,Node maxNode) {
			if(searchNode.isGreaterThan(maxNode)){
				maxNode = searchNode;
			}
			
			return null;
		}
		
		
		
		public int getCountOfLeafNodes(){
			return getLeafCount(rootNode);
		}
		
		
		/*
		 * Here's the algorithm to get the leaf count
		 * getLeafCount(node)
			1) If node is NULL then return 0.
			2) Else If left and right child nodes are NULL return 1.
			3) Else recursively calculate leaf count of the tree using below formula.
    		Leaf count of a tree = Leaf count of left subtree + Leaf count of right subtree
		 */
		private int getLeafCount(Node node){
			if(node==null)
				return 0;
			else if(node.leftChild==null && node.rightChild==null)
				return 1;
			return getLeafCount(node.leftChild)+getLeafCount(node.rightChild);
		}
		
		
		public int getHeight(){
			return getHeightOfTree(rootNode);
		}
		
		
		private int getHeightOfTree(Node node){
			if(node==null)
				return 0;
			else
				return 1+Math.max(getHeightOfTree(node.leftChild),getHeightOfTree(node.rightChild));
		}
		
		
		public int getNodesCount(){
			return nodeCount(rootNode);
		}
		
		

		private int nodeCount(Node node) {
			if(node==null)
				return 0;
			else
				return 1+nodeCount(node.leftChild)+nodeCount(node.rightChild);
		}
		
		public int sumOfNodes(){
			return nodesSum(rootNode);
		}



		private int nodesSum(Node node) {
			int elementValue = 0;
			if(node==null)
				return 0;
			else
				elementValue = (Integer)node.data;
			return elementValue+nodesSum(node.leftChild)+nodesSum(node.rightChild);
		}



	class Node{
		Object data;
		Node leftChild;
		Node rightChild;
		
		Node(Object data){
			this.data= data;
		}
		
		Node(){
		}
		
		/*public boolean equals(Object data){
			if(this.data.toString().equals(data.toString()))
				return true;
			else 
				return false;
		}*/
		
		void delete(){
			data = null;
			leftChild=null;
			rightChild = null;
		}
		
		boolean isLessThan(Node currentNode){
			int currentdata = (Integer)currentNode.data;
			int newdata = (Integer)this.data;
			if(newdata<=currentdata)
				return true;
			else
				return false;
		}
		
		public boolean isGreaterThan(Node maxNode) {
			int currentdata = (Integer)this.data;
			int newdata = (Integer)maxNode.data;
			
			return false;
		}
		
		boolean equals(Node searchNode){
			int searchData = (Integer)searchNode.data;
			int currentData = (Integer)this.data;
			if(searchData==currentData)
				return true;
			else
				return false;
		}
	}
	
	
}

/**
 *           Type      BST       Heap
Insert    average   log(n)    1
Insert    worst     log(n)    log(n)
Find any  worst     log(n)    n 
Find max  worst     1 (*)     1
Create    worst     n log(n)  n

*/