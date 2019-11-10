package controller.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

import model.Arc;
import model.Graph;
import model.Node;

public class Floyd <T>{
	private ArrayList<LinkedList<Node<T>>> tours = new ArrayList<LinkedList<Node<T>>>();
	private ArrayList<Node<T>> nodes = new ArrayList<Node<T>>();
	private ArrayList<LinkedList<Integer>> 	weight = new ArrayList<LinkedList<Integer>>();		
	private int numVertices;
	
	public Floyd(Graph<T> pGraph, Node<T> pNode)
	{					
		nodes = pGraph.getNodes();
		numVertices = nodes.size();
		//create the weight list and the tour list
		for (int vertex = 0; vertex < numVertices; vertex++) {
			tours.add(new LinkedList<Node<T>>());
			weight.add(new LinkedList<Integer>());			
			ArrayList<Node<T>> nodesDestination = nodes.get(vertex).getNodesDestination();
			ArrayList<Arc<T>> arcs = nodes.get(vertex).getArcs();
			for(int subIndex = 0; subIndex < numVertices; subIndex++) {
				if(nodesDestination.contains(nodes.get(vertex))) {
					for(Arc<T>  arc: arcs ) {
						if (arc.getDestination().equals(nodes.get(vertex))) {
							weight.get(vertex).add(arc.getWeight());							
						}
					}					
				}else {
					weight.get(vertex).add(Integer.MAX_VALUE);
				}
				tours.get(vertex).add(nodes.get(subIndex));
			}
			weight.get(vertex).set(vertex, 0);
		}		
	}
	public void calcFloyd()
	{
		
		// Minimum path of a vertex to itself: 0
		for (int index = 0; index < numVertices; index++)
			weight.get(index).set(index , 0 );
		//Perform due calculations and reorganize lists
		for (int k = 0; k < numVertices; k++)
			for (int i = 0; i < numVertices; i++)
				for (int j = 0; j < numVertices; j++)
					if ((weight.get(i).get(k) + weight.get(k).get(j)) < weight.get(i).get(j)) // nuevo mínimo
					{
						weight.get(i).set(j, weight.get(i).get(k) + weight.get(i).get(j));
						tours.get(i).set(k, nodes.get(k));
					}
	}
}


