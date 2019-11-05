package model;

public class Arc<T> {
	private Node<T> origin;
	private Node<T> destination;
	private int weight;
	
	public Arc(Node<T> pOrigin, Node<T> pDestination, int pWeight) {
		this.origin = pOrigin;
		this.destination = pDestination;
		this.weight = pWeight;
	}

	public Node<T> getOrigin() {
		return origin;
	}

	public void setOrigin(Node<T> origin) {
		this.origin = origin;
	}

	public Node<T> getDestination() {
		return destination;
	}

	public void setDestination(Node<T> destination) {
		this.destination = destination;
	}

	public int getPeso() {
		return weight;
	}

	public void setPeso(int pWeight) {
		this.weight = pWeight;
	}	
}
