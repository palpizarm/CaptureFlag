package model;

import java.util.ArrayList;
import java.util.Stack;



public class Graph<T>{
	private ArrayList<Node<T>> nodes;
	
	
	public Graph() {
		nodes= new ArrayList<Node<T>>();
	}
	
	public ArrayList<Node<T>> getNodes() {
		return nodes;
	}
	
	public Node<T> addNode(T pValue) {
		for (Node<T> node : nodes) {
			if(node.getValue() == pValue) {
				return node;
			}
		}
		Node<T> result = new Node<T>(pValue);
		nodes.add(result);
		return result;
	}

	
	public void addArc(Node<T> pOrigin, Node<T> pDestination, int pWeight) {
		for (int index = 0; index < nodes.size(); index++) {
			if (pOrigin == nodes.get(index)) {
				nodes.get(index).addArc(pDestination,pWeight);
			}
		}
	}
	
	public ArrayList<Arc<T>> getArcs() {
		ArrayList<Arc<T>> arcs = new ArrayList<Arc<T>>();
		for (Node<T> nodeIndex : nodes) {
				arcs.addAll(nodeIndex.getArcs());
		}
		return arcs;
	}
	
	public void clean() {
		nodes.clear();
	}
	
	public ArrayList<Node<T>> inDepthSearch(Node<T> start, Node<T> end) {
		ArrayList<Node<T>> nodesPath = new ArrayList<Node<T>>();
		Stack<Node<T>> nodesVisited = new Stack<Node<T>>(); 
		nodesVisited.push(start);
		while(!nodesVisited.isEmpty()) {
			Node<T> node = nodesVisited.pop();
			nodesPath.add(node);
			if (node == end) break;
			for(Node<T> destination : node.getNodesDestination()) {
				if (!destination.getVisited()) {
					destination.setVisited(true);
					nodesVisited.push(destination);
				}
			}
		}
		return nodesPath;
	}
}