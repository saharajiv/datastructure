package dynamic.linkedList.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import dynamic.linkedList.graph.Graph.GraphNode;


/**
 * 
 * @author Rajib
 * 
 * Below is a list of algorithms related to Graph:
 * https://www.youtube.com/watch?v=ddTC4Zovtbc&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j
 *
 */
public class Graph {
		
	private GraphNode start;
	private boolean directed = false;
	private Map<String,List<GraphNode>> tempNodesMap = new HashMap<>();
	private boolean graphCompletionPhase = false;
	private GraphNode searchedNode = null;
	
	public GraphNode addNode(String label){
		GraphNode gNode = new GraphNode(label);
		return gNode;
	}
	
	
	public void insert(String label,Map<String,Integer> neighbouringNodesEdges){
		GraphNode node = null;
		if(!nodeExists(label)){
			node = createNode(label, neighbouringNodesEdges);
			if(start==null){
				start = node;
			}
		}else{
			node = getSearchedNode(label);
			insertData(node,neighbouringNodesEdges);
		}
	}
	
	/*
	 * inserts all the edge information in the vertices on the other side of the vertices which do
	 * not have the edge information. 
	 */
	public void completeGraphFormation(){
		if(directed){
			return;
		}
		graphCompletionPhase= true;
		Set<Entry<String, List<GraphNode>>> entrySet = tempNodesMap.entrySet();
		String label = null;
		Map<String,Integer> edgeMap = null;
		for(Entry<String, List<GraphNode>> entry:entrySet){
			label = entry.getKey();
			edgeMap = new HashMap<>(); 
			for(GraphNode node :entry.getValue()){
				Iterator<GraphNode> neighbouringIterator = node.neighbouringEdges.keySet().iterator();
				while(neighbouringIterator.hasNext()){
					GraphNode key = neighbouringIterator.next();
					if(!key.label.equals(label)){
						continue;
					}
					edgeMap.put(node.label, node.neighbouringEdges.get(key));
				}
			}
			insert(label,edgeMap);
		}
			
				
	}

	private GraphNode createNode(String label, Map<String, Integer> edges) {
		GraphNode node = new GraphNode(label);
		insertData(node,edges);
		return node;
	}

	
	private void insertData(GraphNode node,Map<String, Integer> edges) {
		Map<GraphNode,Integer> neighBouringNodes = new HashMap<>();
		Iterator<Map.Entry<String,Integer>> it = edges.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, Integer> entry = it.next();
			int edgeValue = entry.getValue();
			String edgeLabel = entry.getKey();
			GraphNode childNode = null;
			if(nodeExists(edgeLabel)){
				childNode = getNode(edgeLabel);
			}else{
				childNode = new GraphNode(edgeLabel);
			}
			if(node.neighbouringNodesExist()){
				neighBouringNodes = node.neighbouringEdges;
			}
			neighBouringNodes.put(childNode, edgeValue);
			if(!directed && !graphCompletionPhase){
				if(tempNodesMap.containsKey(edgeLabel)){
					List<GraphNode> list = tempNodesMap.get(edgeLabel);
					list.add(node);
				}else{
					List<GraphNode> list = new ArrayList<>();
					list.add(node);
					tempNodesMap.put(edgeLabel,list);
				}
			}
		}
		/*
		if(!directed){
			if(tempNodesMap.containsKey(node.label)){
				List<GraphNode> nodes = tempNodesMap.get(node.label);
				for(GraphNode gNode:nodes){
					Iterator<GraphNode> neighbouringEdgeIterator = gNode.neighbouringEdges.keySet().iterator();
					while(neighbouringEdgeIterator.hasNext()){
						if(neighbouringEdgeIterator.next().label.equals(gNode.label)){
							neighBouringNodes.put(gNode, gNode.neighbouringEdges.get(node));
						}
					}
					
				}
				tempNodesMap.remove(node.label);
			}
		}*/
		node.insertData(neighBouringNodes);
	}

	
	public GraphNode getNode(String label) {
		GraphNode node ;
		if(start==null){
			return null;
		}else{
			 //node = GraphTraversal.deapthFirstSearch(start,label);
			node = GraphTraversal.breathFirstSearch(start, label);
		}
		return node;
	}

	private boolean nodeExists(String label) {
		if(start!=null){
			GraphNode node = getNode(label);
			if(node!=null){
				searchedNode = node;
				return true;
			}
		}
		searchedNode = null;
		return false;
	
	}
	
	
	
	private GraphNode getSearchedNode(String label){
		if(searchedNode.label.equals(label))
			return searchedNode;
		else
			return null;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public List<String>  traverseNodes(String type){
		List<String> graphList = new ArrayList<>();
		if(type.equalsIgnoreCase("DFS")){
			for(GraphNode node:GraphTraversal.traverseDFS(start)){
				graphList.add(node.label);
			}
		}else{
			for(GraphNode node:GraphTraversal.traverseBFS(start)){
				graphList.add(node.label);
			}
		}
		return graphList;
	}
	
	public void traverseNodesRecursively(String type){
		if(type.equalsIgnoreCase("DFS")){
			System.out.println("Pre-Order traversal");
			GraphTraversal.printDFSPreOrderTraversal(start);
			GraphTraversal.resetVisitedNodes();
			System.out.println("Post-Order traversal");
			GraphTraversal.printDFSPostOrderTraversal(start);
		}
	}
	
	public int countOfNodes(){
		GraphTraversal.resetVisitedNodes();
		return GraphTraversal.getNodeCount(start);
	}
	
	public int countOfLeafNodes(){
		GraphTraversal.resetVisitedNodes();
		return GraphTraversal.getCountOfLeafNodes(start);
	}
	

	class GraphNode{
		String label;
		Map<GraphNode,Integer> neighbouringEdges;
		boolean visited=false;
		
		GraphNode(){}
		
		GraphNode(String label){
			this.label= label;
			neighbouringEdges = new HashMap<>();
		}
		
		public void addEdge(GraphNode neighbouringNode,int edge){
			neighbouringEdges.put(neighbouringNode, edge);
		}
		
		void insertData(Map<GraphNode,Integer> neighbouringNodesEdges){
			neighbouringEdges = neighbouringNodesEdges;
		}
		
		boolean neighbouringNodesExist(){
			if(neighbouringEdges.isEmpty()){
				return false;
			}else
				return true;
		}
		
		public boolean equals(Object e){
			return this.label.equals(((GraphNode)e).label);
		}
		
		public int hashCode(){
			return this.label.hashCode();
		}
		
	}

}

/*
 *Compares Nodes according to the label of the Nodes 
 */
class NodeComparator implements Comparator<GraphNode>{

	@Override
	public int compare(GraphNode o1, GraphNode o2) {
		return o1.label.compareTo(o2.label);
	}
	
}
