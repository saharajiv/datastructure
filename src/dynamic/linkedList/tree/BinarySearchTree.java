package dynamic.linkedList.tree;

/**
 * 
 * @author Rajib
 * A binary tree where the left child contains only nodes with values less than the parent node, 
 * and where the right child only contains nodes with values greater than or equal to the parent.
 *
 */
public class BinarySearchTree {
	
	
	
	class Node{
		Object element;
		Node left;
		Node right;
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
			left=null;
			right = null;
		}
	}
	
	
}
