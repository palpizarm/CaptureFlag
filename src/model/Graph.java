package model;

import java.util.ArrayList;


public class Graph<T>{
	private ArrayList<Node<T>> nodes;
	
	
	public Graph() {
		nodes= new ArrayList<Node<T>>();
	}
	
	public ArrayList<Node<T>> getNodes() {
		return nodes;
	}
	
	public Node<T> addNode(T pValue) {
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
}
