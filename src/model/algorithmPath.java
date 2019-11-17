package model;

import java.util.ArrayList;

/**
 * 
 * @author pablo
 *
 */
public abstract class algorithmPath<T> {
	
	protected Node<T> origin;
	
	public void setOrigin(Node<T> pOrigin) {
		origin = pOrigin;
	}
	
	public abstract void findPath(Graph<T> pGraph) throws Exception;
	
	public abstract ArrayList<Node<T>> getPathTo(Node<T> pDestination) throws Exception;
}
