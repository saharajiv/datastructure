package dynamic.linkedList;




public class LinkedList implements List {
	Node head;
	
	/*
	 * Adds a node to end of the list. Creates the first node if the linked list does not exist
	 */
	@Override
	public void addNode(Object newElement){
		Node p = head;
		if(head==null){
			//the linked list does not exist. The fist node is being created.
			head = new Node(newElement);
		}else{
			//the linked list exists 
			Node next = p;
			while(next.nextNode!=null){
				next = next.nextNode; 
			}
			Node newNode = new Node(newElement);
			next.nextNode = newNode;
		}
	}
	
	
		
	
	
	@Override
	public void insertAfter(Object afterElement,Object newElement){
		Node p = head;
		if(head==null){
			System.out.println("Linked list does not exist. Inserting the new element as the first element");
			head = new Node(newElement);
			return;
		}else{
			while(!p.element.equals(afterElement) && p.nextNode!=null){
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
	public boolean deleteNode(Object element){
		boolean deleted = false;
		Node p = head;
		Node prevNode = head;
		if(head==null){
			System.out.println("Linked List does not exist");
			return deleted;
		}
		//element to be deleted is the first node
		if(p.equals(element)){
			head = head.nextNode;
			p = null;
			deleted = true;
		}else{
			//element to be deleted is the middle or last element
			while(!p.equals(element) && p.nextNode!=null){
				prevNode= p;
				p = p.nextNode;
			}
			if(p.element.equals(element)){
				prevNode.nextNode = p.nextNode;
				p = null;
				deleted = true;
			}
		}
		return deleted;
	}
	
	@Override
	public void printList(){
		Node p = head;
		while(p!=null){
			System.out.print(p.element + " -> ");
			p = p.nextNode;
		}
		System.out.println("end");
		
	}	
	//to be implemented later
	public void printReverse(){
		
	}
	
	@Override
	public int search(Object element){
		int position = 0;
		return position;
	}
	
	
	//to be implemented later
	@Override
	public void sort(){
		
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


	@Override
	public boolean insertAt(int position, Object newElement) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
}


