package model;

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
	
	Graph<T> aclyclicGraph = null;
	/*
	 * Constructor
	 */
	public MinimunSpanningTree() {
		aclyclicGraph = new Graph<T>();
	}
	
	@Override
	/**
	 * @param pGraph
	 */
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
			}
		}
		
	}
	
	public Graph<T> getGraph() {
		return aclyclicGraph;
	}

	@Override
	public ArrayList<Node<T>> getPathTo(Node<T> pDestination) throws Exception {
		if (origin == null) {
			throw new Exception("Origin node is null");
		}
		ArrayList<Node<T>> path = new ArrayList<Node<T>>();
		path.add(origin);
		Node<T> nextNode = origin;
		while(nextNode != pDestination) {
			path.add(nextNode.getArcs().get(0).getDestination());
			nextNode = nextNode.getArcs().get(0).getDestination();
		}
		return path;
	}
	
}
