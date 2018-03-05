package dynamic.linkedList;

import dynamic.linkedList.LinkedList.Node;

//To be implemented
public class CircularLinkedList implements List{
	Node cHead;
	
	@Override
	public void addNode(Object element) {
		Node p = cHead;
		if(cHead==null){
			//the linked list does not exist. The fist node is being created.
			cHead = new Node(element);
		}else{
			//the circular linked list exists 
			Node next = p;
			while(next.nextNode!=cHead){
				next = next.nextNode; 
			}
			Node newNode = new Node(element);
			next.nextNode = newNode;
			newNode.nextNode=cHead;
		}
		
	}

	@Override
	public boolean deleteNode(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int search(Object element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertAfter(Object afterElement, Object newElement) {
		Node p = cHead;
		if(cHead==null){
			System.out.println("Linked list does not exist. Inserting the new element as the first element");
			cHead = new Node(newElement);
			return;
		}else{
			while(!p.element.equals(afterElement) && p.nextNode!=cHead){
				p = p.nextNode;
			}
			if(p.element.equals(afterElement)){
				Node newNode = new Node(newElement);
				newNode.nextNode = p.nextNode;
				p.nextNode = newNode;
				
			}else{
				System.out.println("The given element, "+afterElement+" could not be traced in the list. New element, "+newElement+" is not inserted");
			}
			
		}
		
	}

	@Override
	public boolean insertAt(int position, Object newElement) {
		Node p = cHead;
		if(cHead==null){
			System.out.println("Linked list does not exist. Inserting the new element as the first element");
			cHead = new Node(newElement);
			return false;
		}else{
			int pos = 1;
			while(pos<position && p.nextNode!=cHead){
				pos++;
				p = p.nextNode;
			}
			//if(p.element.equals(afterElement)){
				Node newNode = new Node(newElement);
				newNode.nextNode = p.nextNode;
				p.nextNode = newNode;
				return true;
				
			//}else{
			//	System.out.println("The given element, "+afterElement+" could not be traced in the list. New element, "+newElement+" is not inserted");
			//}
			
		}
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		
	}

	
	class Node{
		Object element;
		Node nextNode = null;
		
		public Node(){}
		
		public Node(Object element){
			this.element = element;
		}
		
		public boolean equals(Object element){
			if(this.element.toString().equals(element.toString()))
				return true;
			else 
				return false;
		}
		
		void delete(){
			element = null;
			nextNode = null;
		}
	}
	

}
