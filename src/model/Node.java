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

	public boolean getVisited() {
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
	
	public ArrayList<Arc<T>> getArcs() {
		return new ArrayList<Arc<T>>(arcs);
	}
	
	public void addArc(Node<T> pNode, int pWeight) {
		if (pNode != this) {
			arcs.add(new Arc<T>(this, pNode, pWeight));
		}
	}
	
	public Arc<T> getArc(Node<T> pDestination) {
		for (Arc<T> arc : this.arcs)
			if (arc.getDestination() == pDestination)
				return arc;
		return null;
	}
}
