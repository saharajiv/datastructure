package dynamic.linkedList.tree.heap.minheap;

import java.util.Comparator;

import dynamic.linkedList.LinkedList;
import dynamic.linkedList.Queue;


/**
 * 
 * @author Rajib
 *
 *A Binary Heap is a Binary Tree with following properties.
    1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has 
  all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.

    2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum 
   among all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree. 
   Max Binary Heap is similar to Min Heap.
   
   Examples of Min Heap:

            10                      10
         /      \               /       \  
       20        100          15         30  
      /                      /  \        /  \
    30                     40    50    100   40
   
 Operations on Min Heap:
1) getMin()/peek(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).

2) extractMin(): Removes the minimum element from Min Heap. Time Complexity of this Operation is O(Logn) as this 
   operation needs to maintain the heap property (by calling heapify()) after removing root.

3) decreaseKey(): Decreases value of key. Time complexity of this operation is O(Logn). If the decreases key value 
   of a node is greater than parent of the node, then we don’t need to do anything. Otherwise, we need to traverse 
   up to fix the violated heap property.

4) insert(): Inserting a new key takes O(Logn) time. We add a new key at the end of the tree. IF new key is 
   greater than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the 
   violated heap property.

5) delete(): Deleting a key also takes O(Logn) time. We replace the key to be deleted with minus infinite by 
   calling decreaseKey(). After decreaseKey(), the minus infinite value must reach root, so we call extractMin() 
   to remove key.  
   
 
 */
/*
 * This is an implementation of Min Heap. The same can be used for max heap by changing the condition.It is the
 * same as PriorityQueue of Java API
 * 
 * For more info on binay heap:
   http://algorithms.tutorialhorizon.com/binary-min-max-heap/
   
 */
public class BinaryHeap {

	private Node rootNode;
	
	public void insert(Object data){
		insertNode(new Node(data));
	}
	
	
	public Object peek(){
		return rootNode.data;
	}
	
	public Object extractMin(){
		Queue queue = new Queue(100);
		queue.enQueue(rootNode);
		Node lastNode = removeLastNode(queue);
		Object extractedData = rootNode.data;
		//replace the rootNode with the last node retrieved
		rootNode.data = lastNode.data;
		//move the newly placed root-node to the correct position
		heapifyDown(rootNode);
		return extractedData;
	}
	
	/*
	 * returns a linked List containing the elements in the Breath First Traversal order. 
	 */
	public dynamic.linkedList.List iterate(){
		dynamic.linkedList.List list = new LinkedList();
		list = traverseHeap();
		return list;
	}
	
	/*
	 * prints the contents of the heap in the BFS order
	 */
	public void print(){
		dynamic.linkedList.List list = new LinkedList();
		list = traverseHeap();
		list.printList();
	}
	

	public void delete(Object data){
		Node node = new Node(data);
		Node toBeDeleted = null;
		Queue queue = new Queue(100);
		queue.enQueue(rootNode);
		if(rootNode!=null){
			toBeDeleted = search(queue,node);
			//updating the to be deleted node with the minimum integer value possible. This will cause the node to be 
			//bubbled up to the root node. The extractMin() will finally delete it.
			if(toBeDeleted!=null){
				//update(toBeDeleted,Integer.MIN_VALUE);
				toBeDeleted.data= Integer.MIN_VALUE;
				toBeDeleted = new Node(Integer.MIN_VALUE);
				heapifyUp(rootNode, toBeDeleted);
				extractMin();
			}
		}
	}
	
	


	/*
	 * Update a node present in the queue with the given value
	 */
	//test the condition where the new value is greater than the old value.
	public void update(Object oldValue,Object newValue){
		Node node = new Node(oldValue);
		Node toBeUpdated = null;
		Queue queue = new Queue(100);
		queue.enQueue(rootNode);
		if(rootNode!=null){
			toBeUpdated = search(queue,node);
			//updating the to be deleted node with the given value. If the new value is less than the old value
			//the node will be bubbled up. If the new value is equal or greater than the old value,then it's
			//child nodes will be bubbled up.
			if(toBeUpdated!=null){
				//update(toBeUpdated,Integer.MIN_VALUE);
				toBeUpdated.data= newValue;
				Node updated = new Node(newValue);
				Comparable newValueCompare = (Comparable)(newValue);
				if(newValueCompare.compareTo(oldValue)<0){
					heapifyUp(rootNode, updated);
				}else if(newValueCompare.compareTo(oldValue)>0){
					//bubble down the updated node to a position where it is smaller than the child nodes
					heapifyDown(toBeUpdated);
				}
			}
		}
	}
	
	private void insertNode(Node node){
		if(rootNode==null){
			rootNode = node;
		}else{
			Queue queue = new Queue(100);
			queue.enQueue(rootNode);
			insertIntoHeap(node, queue);
			node = new Node(node.data);
			heapifyUp(rootNode, node);
		}
		
	}

	/*
	 * this is essentially the BFS algorithm since we need to search thgough each level and then move to the next 
	 * level. The new node needs to be inserted at the bottom as the child node of the left-most node.   
	 */
	private void insertIntoHeap(Node newNode,Queue queue){
		boolean inserted = false;
		Node currentNode = null;
		while(!queue.isEmpty()){
			currentNode = (Node)queue.deQueue();
			if(currentNode.leftChild==null){
				currentNode.leftChild = newNode;
				inserted = true;
			}else if(currentNode.rightChild==null){
				currentNode.rightChild = newNode;
				inserted = true;
			}
			if(inserted){
				break;
			}
			queue.enQueue(currentNode.leftChild);
			queue.enQueue(currentNode.rightChild);
		}
		return;
	}
	
	/*
	 * this algorithm moves the newly inserted node at the end of the heap at a position of the heap, so that it
	 * is lesser than it's child nodes thus fulfilling the heap property. It implements a DFS post order algorithm.
	 */
	private void heapifyUp(Node parent,Node searchNode) {
		if(parent==null){
			return ;
		}
		heapifyUp(parent.leftChild, searchNode);
		heapifyUp(parent.rightChild, searchNode);
		if(parent.leftChild!=null && parent.leftChild.equals(searchNode)){
			if(parent.isGreaterThan(parent.leftChild))
				swap(parent,parent.leftChild);
		}
		if(parent.rightChild!=null && parent.rightChild.equals(searchNode)){
			if(parent.isGreaterThan(parent.rightChild))
				swap(parent,parent.rightChild);
		}
		
	}
	
	
	
	/*
	 * This method moves the newly inserted node in the heap(at the root node position or any other position)
	 * to its correct position by comparing its value to its child nodes.
	 */
	private void heapifyDown(Node parent) {
		if(parent.leftChild==null && parent.rightChild==null){
			return ;
		}
		if(parent.rightChild==null || parent.leftChild.isLessThan(parent.rightChild)){
			swap(parent,parent.leftChild);
			parent = parent.leftChild;
		}else{
			swap(parent,parent.rightChild);
			parent = parent.rightChild;
		}
		heapifyDown(parent);
	}
	
	/*
	 * Implements a BFS search algorithm to search a given node. Returns the searched node if found else 
	 * returns null 
	 */
	private Node search(Queue queue,Node searchNode) {
		Node foundNode = null;
		Node currentNode = (Node)queue.peek();
		if(currentNode.equals(searchNode)){
			foundNode = currentNode;
		}
		while(!queue.isEmpty()){
			currentNode = (Node)queue.deQueue();
			if(currentNode.leftChild != null && currentNode.leftChild.equals(searchNode)){
				foundNode = currentNode.leftChild;
			}else if(currentNode.rightChild != null && currentNode.rightChild.equals(searchNode)){
				foundNode = currentNode.rightChild;
			}
			if(foundNode!=null)
				return foundNode;
			if(currentNode.leftChild!=null)
				queue.enQueue(currentNode.leftChild);
			if(currentNode.rightChild!=null)
				queue.enQueue(currentNode.rightChild);
		
		}
		return null;
	}
	
	/*
	 * Implements a Breadth First Traversal algorithm	
	 */
	private dynamic.linkedList.List traverseHeap() {
		Queue queue = new Queue(100);
		queue.enQueue(rootNode);
		LinkedList list = new LinkedList();
		Node node = (Node)queue.peek();
		if(node!=null)
			list.addNode(node.data);
		while(!queue.isEmpty()){
			Node currentNode = (Node)queue.deQueue();
			if(currentNode.leftChild != null){
				list.addNode(currentNode.leftChild.data);
				queue.enQueue(currentNode.leftChild);
			}
			if(currentNode.rightChild != null){
				list.addNode(currentNode.rightChild.data);
				queue.enQueue(currentNode.rightChild);
			}
		}
		return list;
	}

	
	
	private void swap(Node parent, Node child) {
		Node temp = new Node(parent.data);
		parent.data = child.data;
		child.data = temp.data;
	}

	/*
	 * this algorithm also implements a BFS in order to search for the last node in the heap, searching by each 
	 * level at a time. 
	 */
	private Node removeLastNode(Queue queue) {
		Node prevNode = null;
		Node lastNode = null;
		while(!queue.isEmpty()){
			Node currentNode = (Node)queue.deQueue();
			if(prevNode==null){
				prevNode = currentNode;
			}
			if(currentNode.leftChild==null){
				lastNode = prevNode.rightChild;
				//removing the lastNode
				prevNode.rightChild= null;
				break;
			}else if(currentNode.rightChild==null){
				lastNode = currentNode.leftChild;
				//removing the last node
				currentNode.leftChild= null;
				break;
			}
			queue.enQueue(currentNode.leftChild);
			queue.enQueue(currentNode.rightChild);
			prevNode = currentNode;
		}
		//removeLastNode(queue);
		return lastNode;
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
		
		boolean isLessThan(Node minNode){
			Comparable currentData = (Comparable)this.data;
			Comparable searchData = (Comparable)minNode.data;
			if (searchData != null) {
				int compValue = currentData.compareTo(searchData);
				if(compValue<0){
					return true;
				}
			}
			return false;
		}
		
		public boolean isGreaterThan(Node maxNode) {
			Comparable currentData = (Comparable)this.data;
			Comparable searchData = (Comparable)maxNode.data;
			if (searchData != null) {
				int compValue = currentData.compareTo(searchData);
				if(compValue>0){
					return true;
				}
			}
			return false;
		}
		
		boolean equals(Node searchNode){
			Comparable currentData = (Comparable)this.data;
			Comparable searchData = (Comparable)searchNode.data;
			if (searchNode != null) {
				int compValue = currentData.compareTo(searchData);
				if(compValue==0){
					return true;
				}
			}
			return false;
			
		}
	}
	
	
}
