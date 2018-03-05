package dynamic.linkedList.tree.heap.minheap;

import dynamic.linkedList.List;

public class BinaryHeapTest {
	public static void main(String [] args){
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(14);
		binaryHeap.insert(4);
		binaryHeap.insert(9);
		binaryHeap.insert(5);
		binaryHeap.insert(10);
		binaryHeap.insert(6);
		binaryHeap.insert(2);
		binaryHeap.insert(3);
		binaryHeap.print();
		//binaryHeap.extractMin();
		System.out.println("Updating 3 to 7");
		binaryHeap.update(3, 7);
		binaryHeap.print();
		System.out.println("The smallest no. is "+binaryHeap.peek());
		binaryHeap.delete(10);
		binaryHeap.print();
		
		
	}
	
	
}

class TestNode{
	
	Object data;

	public TestNode(){}
	
	public TestNode(Object data){
		this.data = data;
	}
}
