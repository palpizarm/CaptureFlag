package model;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Moving Tree Search algorithm implementations with adjacency list
 * 
 * @param <T> the type of elements in this list
 * 
 * @author pablo
 */
public class MinimunSpanningTree<T> extends algorithmPath<T>{
	
	Graph<T> aclyclicGraph;
	/*
	 * Constructor
	 */
	public MinimunSpanningTree() {
		aclyclicGraph = new Graph<T>();
	}
	
	public void findPath(Graph<T> pGraph) {
		ArrayList<Arc<T>> arcs = pGraph.getArcs();
		ArrayList<Node<T>> unvisitedVertex = new ArrayList<Node<T>>(pGraph.getNodes());
		Collections.sort(arcs);
		Iterator<Arc<T>> iterator = arcs.iterator();
		while(!unvisitedVertex.isEmpty()) {
			Arc<T> arc = iterator.next();
			if (unvisitedVertex.contains(arc.getOrigin())) {
				unvisitedVertex.remove(arc.getOrigin());
				Node<T> originVertex  = aclyclicGraph.addNode(arc.getOrigin().getValue());
				Node<T> destinationVertex  = aclyclicGraph.addNode(arc.getDestination().getValue());
				aclyclicGraph.addArc(originVertex, destinationVertex, arc.getWeight());
				aclyclicGraph.addArc(destinationVertex, originVertex, arc.getWeight());
			}
		}
		
	}
	
	public Graph<T> getGraph() {
		return aclyclicGraph;
	}

	@Override
	public void findPath(Graph<T> pGraph, Node<T> pOrigin) {
		
	}

	@Override
	public ArrayList<Node<T>> getPathTo(Node<T> pDestination) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
