package controller;

import java.util.ArrayList;

import model.Node;
import model.Point;
import model.Warrior;

public class Team {
	private ArrayList<Warrior> warriors = new ArrayList<Warrior>();
	private ArrayList<Node<Point>> path = new ArrayList<Node<Point>>();
	
	
	public Team(ArrayList<Warrior> pWarrios, ArrayList<Node<Point>> pPath ) {
		warriors = pWarrios;
		path = pPath;
	}
	
	public ArrayList<Warrior> getWarrior() {
		return warriors;
	}
	
	public Node<Point> move() {
		Node<Point> nextNode = path.get(0);
		path.remove(0);
		return nextNode;
	}
}
