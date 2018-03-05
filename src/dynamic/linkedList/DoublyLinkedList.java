package dynamic.linkedList;

import dynamic.linkedList.LinkedList.Node;

public class DoublyLinkedList {
	
	Node head;
	
	public void addNode(Object element){
		Node p = head;
		//first node ... linked list does not exist
		if(head==null){
			head = new Node(element);			
		}else{
			//element to be inserted at the end
			while(p.next!=null){
				p = p.next;
			}
			Node newNode = new Node(element);
			p.next = newNode;
			newNode.prev= p;
		}
	}
	
	
	public void insertAfter(Object element,Object newElement){
		Node p = head;
		Node newNode = new Node(newElement);
		if(head==null){
			head=new Node(newElement);
		}else{
			//the to be inserted element is after the first element
				while(!p.equals(element) && p.next!=null){
					p = p.next;
				}
				if(p.next==null){
					if(!p.equals(element)){
						System.out.println("Element "+element.toString() + " not found. Inserting "+newElement+" in the end");
					}//last element of the list
						newNode.prev = p;
						p.next = newNode;				
				}else{
					//the element is in the middle of the list
						newNode.prev = p;
						newNode.next=p.next;
						p.next.prev = newNode;
						p.next=newNode;
				}
		}
	}
	
	public boolean deleteNode(Object element){
		boolean deleted = false;
		Node p = head;
		//Node prevNode = head;
		if(head==null){
			System.out.println("Linked List does not exist");
			return deleted;
		}
		//element to be deleted is the first node
		if(p.equals(element)){
			head = head.next;
			head.prev= null;
			p = null;
			deleted = true;
		}else{
			//element to be deleted is the middle or last element
			while(!p.equals(element) && p.next!=null){
				p = p.next;
			}
			if(p.equals(element)){
				Node next = p.next;
				Node prev = p.prev;
				next.prev= p.prev;
				prev.next= p.next;
				p.delete();
				p = null;
				deleted = true;
			}
		}
		return deleted;
	}
	
	public void printList(){
		Node p = head;
		while(p!=null){
			System.out.print(p.element + " -> ");
			p = p.next;
		}
		System.out.println("end");
		
	}	
	
	
	public void printListBackWards(){
		Node p = head;
		while(p.next!=null){
			p = p.next;
		}
		while(p!=null){
			System.out.print(p.element + " -> ");
			p=p.prev;
		}
		System.out.println("end");
		
	}	
	
	
	class Node{
		Object element;
		Node prev;
		Node next;
		Node(Object element){
			this.element= element;
		}
		
		public boolean equals(Object element){
			if(this.element.toString().equals(element.toString()))
				return true;
			else 
				return false;
		}
		
		void delete(){
			element = null;
			prev=null;
			next = null;
		}
	}
	
}
