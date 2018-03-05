package dynamic.linkedList.tree.forest;


/**
 * 
 * @author Rajib
 * 
 * A forest is an undirected graph, all of whose connected components are trees; in other words, 
 * the graph consists of a disjoint union of trees. Equivalently, a forest is an undirected acyclic graph. 
 * As special cases, an empty graph, a single tree, and the discrete graph on a set of vertices (that is, the graph 
 * with these vertices that has no edges), are examples of forests. Since for every tree V - E = 1, we can easily 
 * count the number of trees that are within a forest by subtracting the difference between total vertices and total 
 * edges. TV - TE = number of trees in a forest.
 *
 *Let's consider is a tree(T) which is a special Graph,satisfying the following conditions:
 *- T is connected and has no cycles
  - T contains no cycles, and adding any edge to T would create a cycle
  - T is connected and has n - 1 edges
  
  If we take the union of a collection of trees (assuming disjoint vertex sets), we form a graph for which each 
  connected component is a tree. That graph is a forest.
 *
 */
public class Forest {
	

}
