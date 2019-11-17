package controller;

import java.util.ArrayList;

import model.Node;
import model.Point;
import model.Warrior;
import model.algorithmPath;

public class Team {
	private ArrayList<Warrior> warrios = new ArrayList<Warrior>();
	private ArrayList<Node<Point>> path = new ArrayList<Node<Point>>();
	
	
	public Team(ArrayList<Warrior> pWarrios, ArrayList<Node<Point>> pPath ) {
		warrios = pWarrios;
		path = pPath;
	}
	
	public Node<Point> move() {
		Node<Point> nextNode = path.get(0);
		path.remove(0);
		return nextNode;
	}	
}
