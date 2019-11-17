package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


/**
 * Dijkstra algorithm implementations with adjacency list
 * 
 * @param <T> the type of elements in this list
 * 
 * @author pablo
 */
public class Dijkstra<T> extends algorithmPath<T>{

	private ArrayList<Node<T>> unvisitedVertices;
	private HashMap<Node<T>, D<T>> shorestPath;
	
	/**
	 * Constructor
	 */ 
	public Dijkstra() {
		unvisitedVertices = new ArrayList<Node<T>>();
		shorestPath = new HashMap<Node<T>,D<T>>();
		origin = null;
	}
	
	/**
	 * Function to get minimum vertex no visited
	 */
	private Node<T> findMinimunVertex() {
		Node<T> minimunVertex = unvisitedVertices.iterator().next();
		for (Node<T> key : shorestPath.keySet()) {
			if (unvisitedVertices.contains(key) && shorestPath.get(key).getWeight() < shorestPath.get(minimunVertex).getWeight()) {
				minimunVertex = key;
			} // end if
		} // end for
		return minimunVertex;
	}
	
	@Override
	/**
	 * @param pGraph 
	 * @throws Exception 
	 */ 
	public void findPath(Graph<T> pGraph) throws Exception {
		if (origin == null) {
			throw new Exception("Origin node is null");
		} else {
			unvisitedVertices.addAll(pGraph.getNodes());
			for (Node<T> vertex : pGraph.getNodes()) {
				shorestPath.put(vertex, new D<T>(Integer.MAX_VALUE));
			}
			shorestPath.get(origin).setPreviousVertex(origin);
			shorestPath.get(origin).setWeight(0);
			unvisitedVertices.remove(origin);
			for (Arc<T> adjacency : origin.getArcs()) {
				shorestPath.get(adjacency.getDestination()).setPreviousVertex(adjacency.getOrigin());
				shorestPath.get(adjacency.getDestination()).setWeight(adjacency.getWeight());
			}
			while (unvisitedVertices.size() != 1) {
				Node<T> minimunVertex = findMinimunVertex();
				unvisitedVertices.remove(minimunVertex);
				for (Node<T> vertex : unvisitedVertices) {
					Arc<T> arcFromMinimun = minimunVertex.getArc(vertex);
					if (arcFromMinimun != null) {
						int weight = shorestPath.get(minimunVertex).getWeight() + arcFromMinimun.getWeight();
						if (shorestPath.get(vertex).getWeight() > weight) {
							shorestPath.get(vertex).setWeight(weight);
							shorestPath.get(vertex).setPreviousVertex(minimunVertex);
						} // end if
					} // end if
				} // end for
			} // end while
		}
	}
	
	/**
	 * Function to get the list of path vertex
	 * 
	 * @param pDestination the end vertex
	 */
	public ArrayList<Node<T>> getPathTo(Node<T> pDestination) {
		Stack<Node<T>> findPath = new Stack<Node<T>>();
		ArrayList<Node<T>> path = new ArrayList<Node<T>>();
		findPath.push(pDestination);
		while (findPath.peek() != origin) {
			findPath.push(shorestPath.get(findPath.peek()).getPreviousVertex());
		}
		while(!findPath.isEmpty()) {
			path.add(findPath.pop());
		}
		return path;
	}
	
}

/**
 * Structure to contains the path 
 * @author pablo
 *
 * @param <T>
 */
class D<T> {
	private Node<T> previousVertex;
	private int weight;
	
	/**
	 * Constructor
	 */
	public D(int pWeight) {
		previousVertex = null;
		weight = pWeight;
	}

	/**
	 * @return the previousVertex
	 */
	public Node<T> getPreviousVertex() {
		return previousVertex;
	}

	/**
	 * @param pPreviousVertex the previousVertex to set
	 */
	public void setPreviousVertex(Node<T> pPreviousVertex) {
		this.previousVertex = pPreviousVertex;
	}

	/**
	 * @return the distanceFromVertex
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param pDistanceFromVertex the distanceFromVertex to set
	 */
	public void setWeight(int pWeight) {
		this.weight = pWeight;
	}
}
