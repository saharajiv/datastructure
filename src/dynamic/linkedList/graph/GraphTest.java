package dynamic.linkedList.graph;

import java.util.HashMap;
import java.util.Map;

public class GraphTest {

	public static void main(String [] args){
		Graph graphA = new Graph();
		graphA.setDirected(false);
		String vertexA = "A";
		Map<String,Integer> edgesA = new HashMap<>();
		edgesA.put("B", 10);
		edgesA.put("C",4);
		edgesA.put("D", 6);
		String vertexB = "B";
		Map<String,Integer> edgesB = new HashMap<>();
		edgesB.put("D", 12);
		edgesB.put("E",5);
		edgesB.put("F",15);
		String vertexC = "C";
		Map<String,Integer> edgesC = new HashMap<>();
		edgesC.put("G",12);
		edgesC.put("F", 10);
		edgesC.put("H",8);
		graphA.insert(vertexA, edgesA);
		graphA.insert(vertexB, edgesB);
		graphA.insert(vertexC, edgesC);
		graphA.completeGraphFormation();
		for(String label : graphA.traverseNodes("DFS")){
			System.out.print(label+" -> ");
		}
		System.out.println();
		Graph graphB = new Graph();
		graphA.setDirected(true);
		String vertexAA = "AA";
		Map<String,Integer> edgesAA = new HashMap<>();
		edgesAA.put("BB", 10);
		edgesAA.put("CC",4);
		edgesAA.put("DD", 6);
		String vertexBB = "BB";
		Map<String,Integer> edgesBB = new HashMap<>();
		edgesBB.put("DD", 12);
		edgesBB.put("EE",5);
		edgesBB.put("FF",15);
		String vertexCC = "CC";
		Map<String,Integer> edgesCC = new HashMap<>();
		edgesCC.put("AA",4);
		edgesCC.put("GG",12);
		edgesCC.put("FF", 10);
		edgesCC.put("HH",8);
		graphB.insert(vertexAA, edgesAA);
		graphB.insert(vertexBB, edgesBB);
		graphB.insert(vertexCC, edgesCC);
		graphB.completeGraphFormation();
		for(String label : graphB.traverseNodes("DFS")){
			System.out.print(label+" -> ");
		}
		System.out.println();
		Graph graphC = new Graph();
		graphC.setDirected(true);
		String vertex1 = "1";
		Map<String,Integer> edges1 = new HashMap<>();
		edges1.put("2", 10);
		edges1.put("4",4);
		String vertex2 = "2";
		Map<String,Integer> edges2 = new HashMap<>();
		edges2.put("3", 12);
		String vertex3 = "3";
		Map<String,Integer> edges3 = new HashMap<>();
		edges3.put("8",4);
		edges3.put("9",12);
		edges3.put("4", 10);
		String vertex4 = "4";
		Map<String,Integer> edges4 = new HashMap<>();
		edges4.put("5",7);
		String vertex5 = "5";
		Map<String,Integer> edges5 = new HashMap<>();
		edges5.put("6", 9);
		edges5.put("7", 12);
		graphC.insert(vertex1, edges1);
		graphC.insert(vertex2, edges2);
		graphC.insert(vertex3, edges3);
		graphC.insert(vertex4, edges4);
		graphC.insert(vertex5, edges5);
		graphC.completeGraphFormation();
		for(String label : graphC.traverseNodes("BFS")){
			System.out.print(label+" -> ");
		}
		System.out.println();
		graphC.traverseNodesRecursively("DFS");
		
		System.out.println("No. of nodes in the graph C = "+graphC.countOfNodes());
		System.out.println("No. of Leaf nodes in the graph C = "+graphC.countOfLeafNodes());
		
 	}
}
