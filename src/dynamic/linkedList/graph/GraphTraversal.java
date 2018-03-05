package dynamic.linkedList.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import dynamic.linkedList.Queue;
import dynamic.linkedList.Stack;
import dynamic.linkedList.graph.Graph.GraphNode;

public class GraphTraversal {
	
	private static Set<GraphNode> visitedNodes = new HashSet<>();


	public static List<GraphNode> traverseBFS(Graph.GraphNode start) {	
		Queue queue = new Queue(100);
		List<GraphNode> gList = new ArrayList<>();
		queue.enQueue(start);
		while(!queue.isEmpty()){
			GraphNode gNode = (GraphNode)queue.deQueue();
			if(isVisited(gNode)==false){
				gList.add(gNode);
				visitedNodes.add(gNode);
				
			}
			List<GraphNode> childNodes = getUnvisitedChildren(gNode);
			if(childNodes!=null && childNodes.size()>0){
				pushToQueue(queue,childNodes);
			}
			
		}
		resetVisitedNodes();
		return gList;
	}
	
	
	
	public static int getNodeCount(GraphNode node){
		int count = 1;
		if(node!=null && !isVisited(node)){
			visitedNodes.add(node);
			for(GraphNode childNode : getUnvisitedChildren(node)){
				count+=getNodeCount(childNode); 
			}
		}else{
			return 0;
		}
		return count;
	}
	
	
	/*
	 * This will apply to directed graphs only
	 */
	public static int getCountOfLeafNodes(GraphNode node){
		int count = 0;
		if(node==null || isVisited(node))
			return 0;
		visitedNodes.add(node);
		List<GraphNode> childNodes = getUnvisitedChildren(node);
		if(childNodes.size()==0){
			return 1;
		}
		for(GraphNode childNode : childNodes){
			count+=getCountOfLeafNodes(childNode);
		}
		
		return count;
	}


	public static List<GraphNode> traverseDFS(Graph.GraphNode start) {	
		Stack stack = new Stack(100);
		List<GraphNode> gList = new ArrayList<>();
		stack.push(start);
		while(!stack.isEmpty()){
			GraphNode gNode = (GraphNode)stack.peek();
			if(isVisited(gNode)==false){
				gList.add(gNode);
				visitedNodes.add(gNode);
			}
			List<GraphNode> childNodes = getUnvisitedChildren(gNode);
			if(childNodes!=null && childNodes.size()>0){
				pushToStack(stack,childNodes);
				visitedNodes.add(childNodes.get(0));
				gList.add(childNodes.get(0));
			}else{
				stack.pop();
			}
			
		}
		resetVisitedNodes();
		return gList;
	}
	

	private static void pushToStack(Stack stack,List<GraphNode> childNodes) {
		for(GraphNode childNode:childNodes){
			stack.push(childNode);
		}
		
	}
	
	private static void pushToQueue(Queue queue, List<GraphNode> childNodes) {
		for(GraphNode childNode:childNodes){
			queue.enQueue(childNode);
		}
	}
	
	public static GraphNode deapthFirstSearch(GraphNode start,String label) {	
		Stack stack = new Stack(100);
		GraphNode searchNode = null;
		stack.push(start);
		while(!stack.isEmpty()){
			Graph.GraphNode gNode = (Graph.GraphNode)stack.peek();
			if(!isVisited(gNode)){
				if(gNode.label.equals(label)){
					searchNode = gNode;
					break;
				}
				setVisited(gNode);
			}
			List<GraphNode> childNodes = getUnvisitedChildren(gNode);
			if(childNodes!=null && childNodes.size()>0){
				pushToStack(stack,childNodes);
				visitedNodes.add(childNodes.get(0));
				if(childNodes.get(0).label.equals(label)){
					searchNode = childNodes.get(0);
					break;
				}
				setVisited(childNodes.get(0));
			}else{
				stack.pop();
			}
			
		}
		resetVisitedNodes();
		return searchNode;
	}
	
	/*
	 * DFS recursively
	 */
	public static void printDFSPreOrderTraversal(GraphNode node){
		if(node!=null){
			traverseDFSPreOrderRecursively(node);
			System.out.println();
		}else
			System.out.println("There is no node to display in the  Binary tree");
	}
	
	public static void printDFSPostOrderTraversal(GraphNode node){
		if(node!=null){
			traverseDFSPostOrderRecursively(node);
			System.out.println();
		}else
			System.out.println("There is no node to display in the  Binary tree");
	}
	
	
	public static GraphNode breathFirstSearch(GraphNode start,String label) {	
		Queue queue = new Queue(100);
		GraphNode searchNode = null;
		queue.enQueue(start);
		while(!queue.isEmpty()){
			Graph.GraphNode gNode = (Graph.GraphNode)queue.deQueue();
			if(!isVisited(gNode)){
				if(gNode.label.equals(label)){
					searchNode = gNode;
					break;
				}
				setVisited(gNode);
			}
			List<GraphNode> childNodes = getUnvisitedChildren(gNode);
			if(childNodes!=null && childNodes.size()>0){
				pushToQueue(queue, childNodes);
			}
			
		}
		resetVisitedNodes();
		return searchNode;
	}


	private static GraphNode getUnvisitedChild(GraphNode gNode) {
		Iterator<GraphNode> iterator = gNode.neighbouringEdges.keySet().iterator();
		GraphNode unvisitedNode =null;
		while(iterator.hasNext()){
			GraphNode childNode = iterator.next();
			if(isVisited(childNode)==false){
				unvisitedNode = childNode;
				break;
			}
		}
		
		return unvisitedNode;
	}

	private static void setVisited(GraphNode gNode){
		visitedNodes.add(gNode);
	}
	
	private static boolean isVisited(GraphNode gNode){
		return visitedNodes.contains(gNode);
	}
	
	private static List<GraphNode> getUnvisitedChildren(GraphNode gNode) {
		List<GraphNode> unvisitedChildrenlist = new ArrayList<>();
		for(GraphNode childNode:gNode.neighbouringEdges.keySet())
			if(!isVisited(childNode)){
				unvisitedChildrenlist.add(childNode);
			}
		return unvisitedChildrenlist;
	}

	
	private static void traverseDFSPreOrderRecursively(GraphNode node) {
		if(node==null){
			return;
		}
		if(!isVisited(node))
			System.out.println(node.label);
		visitedNodes.add(node);
		List<GraphNode> childNodes = getUnvisitedChildren(node);
		childNodes.sort(new NodeComparator());
		for(GraphNode childNode:childNodes){
			traverseDFSPreOrderRecursively(childNode);
		}
		
	}
	
	private static void traverseDFSPostOrderRecursively(GraphNode node) {
		if(node==null){
			return;
		}
		List<GraphNode> childNodes = getUnvisitedChildren(node);
		childNodes.sort(new NodeComparator());
		for(GraphNode childNode:childNodes){
			traverseDFSPostOrderRecursively(childNode);
		}
		System.out.println(node.label);
		visitedNodes.add(node);
		
	}
	
	
	
	private static void printNode(GraphNode gNode) {
		System.out.println(gNode.label);
	}
	
	public static void resetVisitedNodes() {
		visitedNodes.removeAll(visitedNodes);
		
	}
	
	
}
