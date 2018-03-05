package dynamic.linkedList.tree;


/**
 * A red-black tree is a binary search tree with one extra attribute for each node: the colour, which is either red or black. We also need to keep track of the parent of each node, so that a red-black tree's node structure would be:

	struct t_red_black_node {
	    enum { red, black } colour;
	    void *item;
	    struct t_red_black_node *left,
	                     *right,
	                     *parent;
	}
* For the purpose of this discussion, the NULL nodes which terminate the tree are considered to be the leaves and are coloured black.
* Definition of a red-black tree:
* A red-black tree is a binary search tree which has the following red-black properties:
* 	Every node is either red or black.
* 	Every leaf (NULL) is black.
*   The root is coloured black.
* 	If a node is red, then both its children are black. It implies that on any path from the root to a leaf, red nodes must not be adjacent. 
* 	However, any number of black nodes may appear in a sequence.
* 	Every simple path from a node to a descendant leaf contains the same number of black nodes.
*	 
 * https://www.youtube.com/watch?v=L9Z6qdO_nZE
 * 
 **/
public class RedBlackTree {

}
