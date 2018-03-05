package dynamic.linkedList;

public class ListTest {
	
	public static void main(String[] args){
		QueueTest();
	}
	
	
	public static void singleLinkedListTest(){
		LinkedList ll = new LinkedList();
		ll.printList();
		ll.insertAfter(2,12);
		ll.printList();
		ll.addNode(5);
		ll.printList();
		ll.addNode(6);
		ll.printList();
		ll.addNode(9);
		ll.printList();
		ll.addNode(16);
		ll.printList();
		ll.insertAfter(9,15);
		ll.printList();
		ll.insertAfter(14,15);
		ll.printList();
		ll.deleteNode(9);
		System.out.println("After deletion of 9");
		ll.printList();
		System.out.println("After deletion of 16");
		ll.deleteNode(16);
		ll.printList();
		ll.deleteNode(20);
		System.out.println("After deletion of 20");
		ll.printList();
		
		ll.deleteNode(12);
		System.out.println("After deletion of 12");
		ll.printList();

	}
	
	
	public static void doubleLinkedlistTest(){
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.printList();
		dll.insertAfter(2,12);
		System.out.println("printing forward");
		dll.printList();
		System.out.println("Printing backward");
		dll.printListBackWards();
		dll.addNode(5);
		System.out.println("printing forward");
		dll.printList();
		System.out.println("Printing backward");
		dll.printListBackWards();
		dll.addNode(6);
		System.out.println("printing forward");
		dll.printList();
		System.out.println("Printing backward");
		dll.printListBackWards();
		dll.addNode(9);
		System.out.println("printing forward");
		dll.printList();
		System.out.println("Printing backward");
		dll.printListBackWards();
		dll.addNode(16);
		System.out.println("printing forward");
		dll.printList();
		dll.insertAfter(9,15);
		System.out.println("printing forward");
		dll.printList();
		System.out.println("Printing backward");
		dll.printListBackWards();
		dll.insertAfter(14,15);
		System.out.println("printing forward");
		dll.printList();
		System.out.println("Printing backward");
		dll.printListBackWards();
		System.out.println("printing forward");
		System.out.println("After deletion of 9");
		dll.deleteNode(9);
		dll.printList();
		System.out.println("Printing backward");
		dll.printListBackWards();
		System.out.println("printing forward");
		System.out.println("After deletion of 16");
		dll.deleteNode(16);
		System.out.println("printing forward");
		dll.printList();
		System.out.println("Printing backward");
		dll.printListBackWards();
		System.out.println("printing forward");
		System.out.println("After deletion of 20");
		dll.deleteNode(20);
		dll.printList();
		System.out.println("Printing backward");
		dll.printListBackWards();
		dll.deleteNode(12);
		System.out.println("After deletion of 12");
		dll.printList();
		System.out.println("Printing backward");
		dll.printListBackWards();

	}
	
	public static void stackTest(){
		Stack s = new Stack(5);
		boolean pushed= s.push(15);
		System.out.println("Element pushed :" +pushed);
		s.printStack();
		pushed= s.push(10);
		System.out.println("Element pushed :" +pushed);
		s.printStack();
		pushed= s.push(20);
		System.out.println("Element pushed :" +pushed);
		s.printStack();
		pushed= s.push(1);
		System.out.println("Element pushed :" +pushed);
		s.printStack();
		Object element = s.pop();
		System.out.println("Element popped :"+element);
		s.printStack();
		pushed= s.push(25);
		System.out.println("Element pushed :" +pushed);
		s.printStack();
		pushed= s.push(5);
		System.out.println("Element pushed :" +pushed);
		s.printStack();
		pushed= s.push(12);
		System.out.println("Element pushed :" +pushed);
		s.printStack();
		
	}
	
	
	public static void QueueTest(){
		Queue queue = new Queue(5);
		boolean pushed= queue.enQueue(15);
		System.out.println("Element pushed :" +pushed);
		queue.printQueue();
		pushed= queue.enQueue(10);
		System.out.println("Element pushed :" +pushed);
		queue.printQueue();
		pushed= queue.enQueue(20);
		System.out.println("Element pushed :" +pushed);
		queue.printQueue();
		pushed= queue.enQueue(1);
		System.out.println("Element pushed :" +pushed);
		queue.printQueue();
		Object element = queue.deQueue();
		System.out.println("Element popped :"+element);
		queue.printQueue();
		pushed= queue.enQueue(25);
		System.out.println("Element pushed :" +pushed);
		queue.printQueue();
		pushed= queue.enQueue(5);
		System.out.println("Element pushed :" +pushed);
		queue.printQueue();
		pushed= queue.enQueue(12);
		System.out.println("Element pushed :" +pushed);
		queue.printQueue();
		element = queue.deQueue();
		System.out.println("Element popped :"+element);
		queue.printQueue();
		element = queue.deQueue();
		System.out.println("Element popped :"+element);
		queue.printQueue();
		element = queue.deQueue();
		System.out.println("Element popped :"+element);
		queue.printQueue();
		element = queue.deQueue();
		System.out.println("Element popped :"+element);
		queue.printQueue();
		element = queue.deQueue();
		System.out.println("Element popped :"+element);
		queue.printQueue();
		element = queue.deQueue();
		System.out.println("Element popped :"+element);
		queue.printQueue();
		
	}
	
	
	
}
