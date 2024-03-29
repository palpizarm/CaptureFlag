package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import model.Arc;
import model.Graph;
import model.Node;

public class Floyd <T> extends algorithmPath<T>{
	
	private ArrayList<LinkedList<Node<T>>> tours = new ArrayList<LinkedList<Node<T>>>();
	private ArrayList<Node<T>> nodes = new ArrayList<Node<T>>();
	private ArrayList<LinkedList<Integer>> 	weight = new ArrayList<LinkedList<Integer>>();		
	private int numVertices;
	Node<T> origin = null;
	
	public Floyd() {					
	}
	
	private void calcFloyd() {
		// Minimum path of a vertex to itself: 0
		//for (int index = 0; index < numVertices; index++)
		//	weight.get(index).set(index , 0 );
		//Perform due calculations and reorganize lists
		for (int i = 0; i < numVertices; i++)
			weight.get(i).set(i, 0);
		for (int k = 0; k < numVertices; k++) {
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					if ((weight.get(i).get(k) + weight.get(k).get(j)) < weight.get(i).get(j) && (weight.get(i).get(k) + weight.get(k).get(j)) >= 0) // nuevo m�nimo
					{
						int num = (weight.get(i).get(k))+(weight.get(k).get(j));
						weight.get(i).set(j, num);
						tours.get(i).set(j,nodes.get(k));
					}
				}
			}
		}
	}
	
	public Stack<Node<T>> getPathTo(Node<T> pOrigin, Node<T> pDestiny) {
		int pathOrigin = 0;
		int pathLastNode = 0;
		Node<T> lastNode = pDestiny;
		Stack<Node<T>> stackNodes = new Stack<Node<T>>();
		//Look for addresses to have an address list reference
		for (int index = 0; index < numVertices; index++) {
			if (tours.get(index).get(index) == pOrigin) {
				pathOrigin = index;
			}
		}
		stackNodes.push(pDestiny);
		boolean routeFound = false;
		do {	
			for (int index = 0; index < numVertices; index++) {
				if (tours.get(index).get(index) == lastNode) {
					pathLastNode = index;
				}	
			}					
			
			if (tours.get(pathOrigin).get(pathLastNode) == lastNode) {
				routeFound = true;
				break;
			}
			stackNodes.push(tours.get(pathOrigin).get(pathLastNode));
			lastNode=tours.get(pathOrigin).get(pathLastNode);
		}while( !routeFound);
		stackNodes.push(pOrigin);	
		return stackNodes;
	}

	@Override
	public void findPath(Graph<T> pGraph) {
		nodes = pGraph.getNodes();
		numVertices = nodes.size();
		//create the weight list and the tour list
		for (int vertex = 0; vertex < numVertices; vertex++) {
			tours.add(new LinkedList<Node<T>>());
			weight.add(new LinkedList<Integer>());			
			ArrayList<Node<T>> nodesDestination = nodes.get(vertex).getNodesDestination();
			ArrayList<Arc<T>> arcs = nodes.get(vertex).getArcs();
			for(int subIndex = 0; subIndex < numVertices; subIndex++) {
				if(nodesDestination.contains(nodes.get(subIndex))) {
					for(Arc<T>  arc: arcs ) {
						if (arc.getDestination().equals(nodes.get(subIndex))) {
							weight.get(vertex).add(arc.getWeight());	
							break;
						}
					}					
				}else {
					weight.get(vertex).add(Integer.MAX_VALUE);
				}
				tours.get(vertex).add(nodes.get(subIndex));
			}
			weight.get(vertex).set(vertex, 0);
		}	
		calcFloyd();
		
	}

	@Override
	public ArrayList<Node<T>> getPathTo(Node<T> pDestination) {
		int pathOrigin = 0;
		int pathLastNode = 0;
		Node<T> lastNode = pDestination;
		Stack<Node<T>> stackNodes = new Stack<Node<T>>();
		ArrayList<Node<T>> path = new ArrayList<Node<T>>();
		//Look for addresses to have an address list reference
		for (int index = 0; index < numVertices; index++) {
			if (tours.get(index).get(index) == origin) {
				pathOrigin = index;
			}
		}
		stackNodes.push(lastNode);
		boolean routeFound = false;
		do {	
			for (int index = 0; index < numVertices; index++) {
				if (tours.get(index).get(index) == lastNode) {
					pathLastNode = index;
				}	
			}					
			
			if (tours.get(pathOrigin).get(pathLastNode) == lastNode) {
				routeFound = true;
				break;
			}
			stackNodes.push(tours.get(pathOrigin).get(pathLastNode));
			lastNode=tours.get(pathOrigin).get(pathLastNode);
		}while( !routeFound);
		stackNodes.push(origin);	
		while(!stackNodes.isEmpty()) {
			path.add(stackNodes.pop());
		}
		return path;
	}

}


