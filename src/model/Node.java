package model;

import java.util.ArrayList;

import model.Arc;

public class Node<T> {
	private T value;
	private ArrayList<Arc<T>> arcs;
	private boolean visited;
	
	public Node(T pValue) {
		this.value = pValue;
		this.arcs = new ArrayList<Arc<T>>();
		this.visited = false;
	}
	
	public T getValue() {
		return this.value; 
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public ArrayList<Node<T>> getNodesDestination() {
		ArrayList<Node<T>> nodesDestination = new ArrayList<Node<T>>();
		for(Arc<T> acr : arcs) {
			nodesDestination.add(acr.getDestination());
		}
		return nodesDestination;
	}
	
	public void addArc(Node<T> pNode) {
		if (pNode != this) {
			arcs.add(new Arc<T>(this, pNode, 1));
		}
	}
}
