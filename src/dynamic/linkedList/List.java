package dynamic.linkedList;

public interface List {

	public void addNode(Object element);
	public boolean deleteNode(Object element);
	public int search(Object element);
	public void insertAfter(Object element,Object newElement);
	public boolean insertAt(int position, Object newElement);
	void sort();
	public void printList();
}
