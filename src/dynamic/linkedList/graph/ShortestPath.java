package dynamic.linkedList.graph;


/**
 * @author Rajib
 * 
 * Shortest path is based on the edge relaxing property.
 * Edge relaxing says that given I know distance between A and B: dist(a,b) and dist between A and C: dist(a, c), 
 * if dist(a, b) + edge(b, c) is less than dist (a, c), then I can relax edge(a c). After relaxing all edges, 
 * we get the shortest path.
 * 
 * This is the implementation of Dijkstra's algorithm. Dijkstra's algorithm is used to find the shortest path
 * between any two nodes
 * 
 *  Dijsstra's algo for calculating the shortest path:
 *  https://www.youtube.com/watch?v=lAXZGERcDf4
 *  https://www.youtube.com/watch?v=qx9sJ3O3JM0
 *  https://www.youtube.com/watch?v=5GT5hYzjNoo
 *  
 *  
 *  Bellman Ford Single shortest path algorithm
 *  https://www.youtube.com/watch?v=-mOEd_3gTK0
 *  https://www.youtube.com/watch?v=05WQNgR4Urk
 *  
 *  
 *  
 *  
 */
public class ShortestPath {

	private Graph graph;
	
	public ShortestPath(){}
	
	public ShortestPath(Graph g){
		this.graph=g;
	}
	
	
	
	
	
	
	
	
}
