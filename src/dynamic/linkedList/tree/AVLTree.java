package dynamic.linkedList.tree;

/**
 * 
 * @author Rajib
 * 
 * A AVL Tree is a self balancing binary tree.In an AVL tree, the heights of the two child subtrees of any node 
 * differ by at most one.It is Height Balanced Tree for that reason.if at any time they differ by more than one, 
 * re-balancing is done to restore this property.
 * 
 *  Lookup, insertion, and deletion all take O(log n) time in both the average and worst cases, where n is the 
 *  number of nodes in the tree prior to the operation. Insertions and deletions may require the tree to be 
 *  re-balanced by one or more tree rotations.
 *
 * AVL trees are often compared with red–black trees because both support the same set of operations and take 
 * O(log n) time for the basic operations. For lookup-intensive applications, AVL trees are faster than 
 * red–black trees because they are more strictly balanced.Similar to red–black trees, AVL trees are 
 * height-balanced. In both, sibling nodes can have hugely differing numbers of descendants.
 *
 * Balance factor: 
 * In a binary tree the balance factor of a node N is defined to be the height difference
 * of its two child subtrees.
 *	
	BalanceFactor(N) := Height(RightSubtree(N)) – Height(LeftSubtree(N))
 * 		
 * Balance factors can be kept up-to-date by knowing the previous balance factors and the change in height – 
 * it is not necessary to know the absolute height. For holding the AVL balance information in the traditional 
 * way, two bits per node are sufficient.
 *
 */

public class AVLTree {

}
