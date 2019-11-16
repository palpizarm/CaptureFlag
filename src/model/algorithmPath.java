package model;

import java.util.ArrayList;

/**
 * 
 * @author pablo
 *
 */
public abstract class algorithmPath<T> {
	
	
	public abstract void findPath(Graph<T> pGraph, Node<T> pOrigin);
	public abstract ArrayList<Node<T>> getPathTo(Node<T> origin ,Node<T> pDestination);
}
