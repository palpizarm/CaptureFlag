package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Moving Tree Search algorithm implementations with adjacency list
 * 
 * @param <T> the type of elements in this list
 * 
 * @author pablo
 */
public class MinimunSpanningTree<T> {
	
	Graph<T> aclyclicGraph;
	/*
	 * Constructor
	 */
	public MinimunSpanningTree() {
		aclyclicGraph = new Graph<T>();
	}
	
	@SuppressWarnings("unchecked")
	public void findMinimunSpanningTree(Graph<T> pGraph) {
		ArrayList<Arc<T>> arcs = pGraph.getArcs();
		ArrayList<Node<T>> unvisitedVertex = new ArrayList<Node<T>>(pGraph.getNodes());
		Collections.sort(arcs);
		while(!unvisitedVertex.isEmpty()) {
			Arc<T> arc = arcs.iterator().next();
			T origin = (T) new Node<T>(arc.getOrigin().getValue());
			T destination = (T) new Node<T>(arc.getDestination().getValue());
			Node<T> originVertex  = aclyclicGraph.addNode(origin);
			Node<T> destinationVertex  = aclyclicGraph.addNode(destination);
			aclyclicGraph.addArc(originVertex, destinationVertex, arc.getWeight());
			aclyclicGraph.addArc(destinationVertex, originVertex, arc.getWeight());
		}
		
	}
	
	public Graph<T> getGraph() {
		return aclyclicGraph;
	}
	
}
