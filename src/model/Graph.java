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
	
	public void addArc(Node<T> pOrigin, Node<T> pDestination) {
		for (int index = 0; index < nodes.size(); index++) {
			if (pOrigin == nodes.get(index)) {
				nodes.get(index).addArc(pDestination);
			}
		}
	}
	
	public void clean() {
		nodes.clear();
	}
}
