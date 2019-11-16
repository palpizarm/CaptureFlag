package controller;

import java.util.ArrayList;

import model.Node;
import model.Point;
import model.Warrior;
import model.algorithmPath;

public class Team {
	private ArrayList<Warrior> warrios = new ArrayList<Warrior>();
	private ArrayList<Node<Point>> path;
	private algorithmPath pathHandler;
	
	
	public Team(ArrayList<Warrior> pWarrios, algorithmPath pHandler) {
		warrios = pWarrios;
		pathHandler = pHandler;
		
		/*Asignar el primer nodo*/
	}
	
	public Node<Point> move() {
		Node<Point> nextNode = path.get(0);
		path.remove(0);
		return nextNode;
	}	
}
