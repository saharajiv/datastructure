package dynamic.linkedList;

import dynamic.linkedList.Stack.Node;

//Implements the FIFO strategy
public class Queue {
	private Node header;
	private int maxLength;
	
	public Queue(int length){
		maxLength= length;
	}
	
	public boolean enQueue(Object element){
		Node p = header;
		if(isFull()){
			return false;
		}
		//inserts the first element
		else if(header==null){
			header = new Node(element);
		}else{//inserts after the last element
			while(p.next!=null){
				p= p.next;
			}
			Node node = new Node(element);
			p.next= node;
		}
		return true;
	}
	
	
	
	public Object deQueue(){
		Node p = header;
		Object element = null;
		if(isEmpty()){
			return null;
		}else{
			element = header.element;
			header = header.next;
			p.delete();
			p=null;
		}
		return element;
	}
	
	public Object peek(){
		Node p = header;
		Object element = null;
		if(isEmpty()){
			return null;
		}else{
			element = header.element;
		}
		return element;
	}
	
	
	
	
	public boolean isFull(){
		if(length()==maxLength){
			return true;
		}
		return false;
	}
	
	public int length(){
		int length = 0;
		if(!isEmpty()){
			Node p= header;
			while(p!=null){
				p=p.next;
				length++;
			}
		}
		return length;
	}
	
	
	public boolean isEmpty(){
		if(header==null)
			return true;
		else
			return false;
	}
	
	public void printQueue(){
		Node p = header;
		while(p!=null){
			System.out.print(p.element + " -> ");
			p = p.next;
		}
		System.out.println("end");
		
	}	
	
	
	class Node{
		Object element;
		Node next;
		
		Node(Object element){
			this.element= element;
		}
		
		public boolean equals(Object element){
			if(this.element.toString().equals(element.toString())){
				return true;
			}else{
				return false;
			}
		}
		
		public void delete(){
			element = null;
			next = null;
		}
	}

}
